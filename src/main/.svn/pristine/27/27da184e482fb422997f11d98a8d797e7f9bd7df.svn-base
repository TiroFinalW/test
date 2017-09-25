package com.jielan.controller.user;

import com.jielan.model.PeachRecord;
import com.jielan.model.SignRecord;
import com.jielan.model.User;
import com.jielan.model.query.SignRecordQuery;
import com.jielan.service.PeachRecordService;
import com.jielan.service.SignService;
import com.jielan.service.UserService;
import com.jielan.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by wang on 2016/12/12.
 * 签到相关
 */
@RequestMapping("sign")
@Controller
public class SignController {

    @Autowired
    private SignService signService;

    @Autowired
    private PeachRecordService peachRecordService;

    @Autowired
    private UserService userService;

    /**
     *去签到页面
     */
    @RequestMapping("/tosign")
    public String toSign(HttpServletRequest request, ModelMap map){
        String openid = request.getParameter("openid");
        int status = 0;//今日未签到
        //签到数据列表
        List<SignRecord> list = signService.selectUserSignRecord(openid);


        //今日是否签到
        User user = userService.selectByOpenid(openid);
        //判断今天是否签到
        if(user.getSiginDate()!=null&&DateUtil.getDaySub(DateUtil.getDay(),DateUtil.getStringDay(user.getSiginDate()))==0){
            status=1;//已签到
        }
        map.put("user",user);
        map.put("list",list);
        map.put("status",status);
        map.put("openid",openid);
        return "user/sign";
    }

    /**
     *签到
     */
    @RequestMapping("/dosign")
    public String doSign(HttpServletRequest request,ModelMap map){
        double getpeach = 0; //应该获得的桃子
        String openid = request.getParameter("openid");
        User user = userService.selectByOpenid(openid);
        int status=0;
        //判断时间 是否是周末 或者节日
        if(DateUtil.dayCheck(new Date())==2){ //是节假日
            getpeach = 3.0;
        }else if(DateUtil.dayCheck(new Date())==1){ //是周末
            getpeach=2.0;
        }else{
            getpeach= user.getNextpeach();
        }

        if(DateUtil.hourCheck(6,8)){
            getpeach = getpeach*2;
        }

        //设置下次签到桃子数
        if((user.getSigin_count()+1)<10){
            user.setNextpeach(1.0) ;
        } else if ((user.getSigin_count()+1)>=10&&(user.getSigin_count()+1)<20) {
            user.setNextpeach(1.1) ;
        }else if ((user.getSigin_count()+1)>=20&&(user.getSigin_count()+1)<30){
            user.setNextpeach(1.2) ;
        }else {
            user.setNextpeach(1.3) ;
        }
        //判断今天是否签到
        if(user.getSiginDate()!=null&&(DateUtil.getDaySub(DateUtil.getDay()  ,   DateUtil.getStringDay(user.getSiginDate()))==0)){
            status=1;//已签到
        }else {
            try {
                //Thread.sleep(10000);
                //签到记录
                SignRecord srecord = new SignRecord();
                srecord.setPeach(getpeach);
                srecord.setType(0);
                srecord.setOpenid(openid);
                srecord.setSigntime(new Date());
                //桃子收支记录
                PeachRecord peachRecord = new PeachRecord();
                peachRecord.setType(1);//收支类型 0:支出 1;获得
                peachRecord.setWay(0);//方式 0.签到  1.补签
                peachRecord.setPeach(getpeach);
                peachRecord.setRemainPeach(user.getPeach()+getpeach);//剩余桃子
                peachRecord.setOpenid(openid);

                user.setPeach(user.getPeach()+getpeach);//加桃子
                user.setSiginDate(new Date());
                user.setSigin_count(user.getSigin_count()+1);

                signService.addSign(srecord,user,peachRecord);
                status=1;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        //签到数据列表
        List<SignRecord> list = signService.selectUserSignRecord(openid);
        map.put("list",list);
        map.put("status",status);//已签到
        map.put("user",user);

        //签到记录展示

        return "user/sign";
    }

    /**
     * 补签
     */

    @RequestMapping("/retroactive")
    @ResponseBody
    public String retroactive(HttpServletRequest request){
        String openid = request.getParameter("openid");
        String type=request.getParameter("type");
        User user = userService.selectByOpenid(openid);
        SignRecordQuery signquery = new SignRecordQuery();
        signquery.setOpenid(openid);
        signquery.setOrderby("signtime desc");
        List<SignRecord> list =  signService.selectSignRecord(signquery);
        String status ="";
        System.out.println("需要补签的时间"+signoffDate(list));
        if(signoffDate(list)==null){ //计算需要补签的日期
            status="0";  //不需要补签
        }else {

            SignRecord signRecord = new SignRecord();
            signRecord.setOpenid(openid);
            signRecord.setType(1); //方式 补签
            signRecord.setSigntime(signoffDate(list)); //补签日期

            PeachRecord peachRecord = new PeachRecord();

            if("card".equals(type)){   //用补签卡的方式
                if(user.getRetroactiveCard()==0){
                    status= "3"; //补签卡不够
                }else{

                    //更新数据
                    user.setRetroactiveCard(user.getRetroactiveCard()-1);
                    user.setPeach(user.getPeach()+1.0);

                    signRecord.setPeach(1.0);

                    peachRecord.setRemainPeach(user.getPeach());
                    peachRecord.setRemainCard(user.getRetroactiveCard());
                    peachRecord.setType(1);//获得桃子
                    peachRecord.setPeach(1.0);//获得桃子数量
                    peachRecord.setWay(1);//获得方式  补签

                    try {
                        signService.retroactive(signRecord,user,peachRecord);  //补签卡补签给1桃
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    status= "1"; //补签成功
                }
            }

            if("peach".equals(type)){//使用桃子的方式
                if(user.getPeach()<10){
                    status= "4"; //桃子不够
                }else{
                    //更新数据
                    user.setPeach(user.getPeach()-10.0);

                    signRecord.setPeach(0);

                    peachRecord.setRemainPeach(user.getPeach());
                    peachRecord.setRemainCard(user.getRetroactiveCard());
                    peachRecord.setType(0);//支出桃子
                    peachRecord.setPeach(10.0);//支出桃子数量
                    peachRecord.setWay(1);//支出方式  补签

                    try {
                        signService.retroactive(signRecord,user,peachRecord);  //桃子补签不给桃 扣10个桃子
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    status= "1"; //补签成功
                }
            }
        }
        return  status;
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

    /**
     *计算补签日期
     * 规则：补签为最近没签到的一天
     * 假如今天昨天都没签 点补签 就算昨天
     *
     */
    public static Date signoffDate(List<SignRecord> list){
        String today = DateUtil.getDay();//今天日期
        long num=0;
        if(list!=null&&list.size()==1){

            String lastday =   DateUtil.getStringDay(list.get(0).getSigntime());
            num = DateUtil.getDaySub(lastday,today);
            if(num>=0&&num<=1){
                return new Date(list.get(0).getSigntime().getTime()-1000*24*60*60);//今天的前一天
            }else {
                return null;
            }

        }else if(list!=null&&list.size()>1){

            String lastday =   DateUtil.getStringDay(list.get(0).getSigntime());
            num = DateUtil.getDaySub(lastday,today); //今天和最晚签到一天的差值
            if(num>=0&&num<=1){  //最近签到是今天
                for(int i=0;i<list.size()-1;i++){
                    String dayafter = DateUtil.getStringDay(list.get(i).getSigntime());
                    String daybefore = DateUtil.getStringDay(list.get(i+1).getSigntime());
                    if(DateUtil.getDaySub(daybefore,dayafter)>1){//相邻签到记录日期不连续
                        return new Date(list.get(i).getSigntime().getTime()-1000*24*60*60); // 连续签到区间最早一天的前一天
                    }
                }
                return null; //签到记录全是连续的 不用补签
            }else {
                return new Date(new Date().getTime()-1000*24*60*60);//今天的前一天
            }

        }else {
            return null; //从来没签到 不需要补签
        }
    }

   /* public static Date signoffDate(List<SignRecord> list){
        String today = DateUtil.getDay();//今天日期
        long num=0;
        if(list!=null&&list.size()==1){

            String lastday =   DateUtil.getStringDay(list.get(0).getSigntime());
            num = DateUtil.getDaySub(lastday,today);
            if(num>=0&&num<=1){
                return new Date(list.get(0).getSigntime().getTime()-1000*24*60*60);//今天的前一天
            }else {
                return null;
            }

        }else if(list!=null&&list.size()>1){

            String lastday =   DateUtil.getStringDay(list.get(0).getSigntime());
            num = DateUtil.getDaySub(lastday,today); //今天和最晚签到一天的差值
            if(num>=0&&num<=1){  //最近签到是今天或者昨天
                for(int i=0;i<list.size()-1;i++){
                    String dayafter = DateUtil.getStringDay(list.get(i).getSigntime());
                    String daybefore = DateUtil.getStringDay(list.get(i+1).getSigntime());
                    if(DateUtil.getDaySub(daybefore,dayafter)>1){//相邻签到记录日期不连续
                        return new Date(list.get(i).getSigntime().getTime()-1000*24*60*60); // 连续签到区间最早一天的前一天
                    }
                }
                return null; //签到记录全是连续的 不用补签
            }else {
                return new Date(list.get(0).getSigntime().getTime()-1000*24*60*60);//今天的前一天
            }

        }else {
            return null; //从来没签到 不需要补签
        }
    }*/
}
