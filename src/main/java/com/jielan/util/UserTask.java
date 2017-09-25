package com.jielan.util;

import com.jielan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by wang
 */
public class UserTask {

    @Autowired
    private UserService userService;
    /**
     * 今年六月以后每月月初用户桃子清0
     */
    public void clearUserPeach(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Log.info("进入定时任务");
        try {
            Date date = sdf.parse("2017-05-31 23:59:59");
            if(new Date().getTime()>=date.getTime()){
                userService.clearPeach();
                Log.info("桃子清零成功"+sdf.format(new Date()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
