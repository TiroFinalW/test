package com.jielan.service;

import org.apache.ibatis.annotations.Param;

/**
 * Created by wang on 2017/2/22.
 * 签到数据
 */
public interface InfoService {
    public int countUser();
    public int countSignUser(String startTime,String endTime);
    public int countSignTimes( String startTime,String endTime);
    public int countFindPeachUser( String startTime,String endTime);
    public int countFindPeach(String startTime,String endTime);
}
