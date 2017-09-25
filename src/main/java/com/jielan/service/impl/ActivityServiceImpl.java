package com.jielan.service.impl;

import com.jielan.dao.*;
import com.jielan.model.*;
import com.jielan.model.query.ActivityQuery;
import com.jielan.model.query.CheckPwdQuery;
import com.jielan.model.query.PassWordQuery;
import com.jielan.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by wang on 2016/12/15.
 */
@Service
@Transactional
public class ActivityServiceImpl implements ActivityService{
    @Autowired
    private ActivityMapper mapper;
    @Resource
    private PassWordMapper passWordMapper;
    @Autowired
    private CheckPwdMapper checkPwdMapper;
    @Autowired
    private PeachRecordMapper peachRecordMapper;
    @Autowired
    private UserMapper userMapper;

    public void addActivity(Activity activity) throws Exception{
        mapper.addActivity(activity);
    }

    public void updateActivity(Activity activity) throws Exception{
        mapper.updateActivity(activity);
    }

    public List<Activity> selectActivity(ActivityQuery query) {
        int count = mapper.countActivity(query);
        query.setRecordcount(count);
        return mapper.selectActivity(query);
    }

    public Activity selectById(Integer id) {
        return mapper.selectById(id);
    }

    public void deleteActivity(Integer id)throws Exception  {
        mapper.deleteActivity(id);
    }

    /**
     *条件查询图文寻桃密码
     */
    public List<PassWord> selectPassWord(PassWordQuery query) {
        query.setRecordcount(passWordMapper.countPassWord(query));
        List<PassWord> list = passWordMapper.selectPassWord(query);
        return list;
    }

    /**
     * 生成图文寻桃密码
     */
    public void addPassWord(PassWord passWord)throws Exception{
        passWordMapper.addPassWord(passWord);
    }

    /**
     *用户图文寻桃记录添加
     */
    public void addCheckPwd(CheckPwd pwd) throws Exception {
         checkPwdMapper.addCheckPwd(pwd);
    }

    /**
     *用户图文寻桃记录
     */
    public List<CheckPwd> selectCheckPwd(CheckPwdQuery query) {
        return checkPwdMapper.selectCheckPwd(query);
    }

    /**
     *图文寻桃成功
     */
    public void dofindPeach(CheckPwd checkPwd, PeachRecord record, User user) throws Exception {
        checkPwd.setOpenid(user.getOpenid());
        checkPwd.setCreateTime(new Date());
        user.setPeach(user.getPeach());
        record.setRemainPeach(user.getPeach());
        userMapper.updateUser(user);
        record.setType(1);
        record.setWay(4);//图文寻桃
        peachRecordMapper.addPeachRecord(record);
        checkPwdMapper.addCheckPwd(checkPwd);
    }


}
