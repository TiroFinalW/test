package com.jielan.service.impl;

import com.jielan.dao.InfoMapper;
import com.jielan.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by wang on 2017/2/22.
 */
@Service
public class InfoServiceImpl implements InfoService{

    @Autowired
    private InfoMapper infoMapper;

    public int countUser() {
        return infoMapper.countUser();
    }

    public int countSignUser(String startTime, String endTime) {
        return infoMapper.countSignUser(startTime,endTime);
    }

    public int countSignTimes(String startTime, String endTime) {
        return infoMapper.countSignTimes(startTime,endTime);
    }

    public int countFindPeachUser(String startTime, String endTime) {
        return infoMapper.countFindPeachUser(startTime,endTime);
    }

    public int countFindPeach(String startTime, String endTime) {
        return infoMapper.countFindPeach(startTime,endTime);
    }
}
