package com.jielan.service.impl;

import com.jielan.dao.PeachRecordMapper;
import com.jielan.dao.SignMapper;
import com.jielan.dao.UserMapper;
import com.jielan.model.PeachRecord;
import com.jielan.model.SignRecord;
import com.jielan.model.User;
import com.jielan.model.query.SignRecordQuery;
import com.jielan.service.SignService;
import com.jielan.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by wang on 2016/12/20.
 * 签到记录
 */
@Service
@Transactional
public class SignServiceImpl implements SignService{

    @Autowired
    private SignMapper signMapper;
    @Autowired
    private PeachRecordMapper peachMapper;
    @Autowired
    private UserMapper userMapper;

    public List<SignRecord> selectSignRecord(SignRecordQuery query) {
        return signMapper.selectSignRecord(query);
    }

    public void addSign(SignRecord record, User user, PeachRecord precord) throws Exception {
        signMapper.addSignRecord(record);
        peachMapper.addPeachRecord(precord);
        userMapper.updateUser(user);
    }

    public List<SignRecord> selectUserSignRecord(String openid) {
        return signMapper.selectUserSignRecord(openid);
    }

    public void retroactive(SignRecord record, User user, PeachRecord precord) throws Exception {

        precord.setOpenid(user.getOpenid());

        signMapper.addRetroactive(record);

        SignRecordQuery query  = new SignRecordQuery();
        query.setOpenid(user.getOpenid());
        query.setOrderby("signtime desc");
        List<SignRecord> list = signMapper.selectSignRecord(query);
        int signcount = maxsign(list);
        user.setSigin_count(signcount);
        peachMapper.addPeachRecord(precord);
        userMapper.updateUser(user);
    }

    public List<SignRecord> selectSignRecordPage(SignRecordQuery query) {
        query.setRecordcount(signMapper.countSignRecord(query));
        return signMapper.selectSignRecordPage(query);
    }

    public List<SignRecord> exportSignRecord(SignRecordQuery query) {
        return signMapper.exportSignRecord(query);
    }


    /**
     * 重新计算用户连续签到次数
     *用于获取最大连续签到次数的方法 传入集合必须是日期排序desc
     * 从集合第一个开始算（最晚日期） 和当天比天数差
     * 如果是<=1 最晚签到日期是昨天或者今天，则区间是可以从最晚日期开始算,return  计算后的值
     * 如果>1 说明最起码有两天以上没签了 return 0
     *
     */
    public static int maxsign(List<SignRecord> list){
        String today = DateUtil.getDay();//今天日期
        long num=0;
        if(list!=null&&list.size()>1){
            String lastday =   DateUtil.getStringDay(list.get(0).getSigntime());
            num = DateUtil.getDaySub(lastday,today);
            System.out.println("最后一天和今天"+num);

            if(num>=0&&num<=1){  //最近签到是今天或者昨天
                int count = 1;
                for(int i=0;i<list.size()-1;i++){
                    String dayafter = DateUtil.getStringDay(list.get(i).getSigntime());
                    String daybefore = DateUtil.getStringDay(list.get(i+1).getSigntime());
                    if(DateUtil.getDaySub(daybefore,dayafter)==1){//相邻签到记录日期是否连续
                        count++;
                    }else {
                        break;
                    }
                }
                return  count;
            }

        }else if(list!=null&&list.size()==1){

            if(num>=0&&num<=1){
                return 1;       //就签了一天 昨天或者今天签到
            }else{
                return 0;
            }

        }else {
            return 0;       //没签到过
        }
        return 0;
    }
}
