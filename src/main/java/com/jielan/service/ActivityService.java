package com.jielan.service;

import com.jielan.model.*;
import com.jielan.model.query.ActivityQuery;
import com.jielan.model.query.CheckPwdQuery;
import com.jielan.model.query.PassWordQuery;

import java.util.List;

/**
 * Created by wang on 2016/12/15.
 */
public interface ActivityService {

    public void addActivity(Activity activity) throws Exception;

    public void updateActivity(Activity activity) throws Exception;

    public List<Activity> selectActivity(ActivityQuery query);

    public Activity selectById(Integer id);

    public void deleteActivity(Integer id) throws Exception;

    public List<PassWord> selectPassWord(PassWordQuery query);

    public void addPassWord(PassWord passWord)throws Exception;

    public void addCheckPwd(CheckPwd pwd)throws Exception;

    public List<CheckPwd> selectCheckPwd(CheckPwdQuery query);

    public void dofindPeach(CheckPwd checkPwd, PeachRecord record,User user)throws Exception;

}
