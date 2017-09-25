package com.jielan.dao;

import org.springframework.util.StringUtils;

/**
 * Created by wang on 2017/2/22.
 */
public class InfoMapperSql {

    public String countSignUser(String startTime,String endTime){
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT COUNT(DISTINCT(openid)) FROM tb_hz_sign_signrecord where 1=1 ");
        if(!StringUtils.isEmpty(startTime)){
            sb.append("AND signtime>=#{startTime}");
        }
        if(!StringUtils.isEmpty(endTime)){
            sb.append("AND signtime<=#{endTime}");
        }
        return  sb.toString();
    }

    public String countSignTimes(String startTime,String endTime){
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT COUNT(*) FROM tb_hz_sign_signrecord where 1=1 ");
        if(!StringUtils.isEmpty(startTime)){
            sb.append("AND signtime>=#{startTime}");
        }
        if(!StringUtils.isEmpty(endTime)){
            sb.append("AND signtime<=#{endTime}");
        }
        return  sb.toString();
    }
    public String countFindPeachUser(String startTime,String endTime){
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT COUNT(DISTINCT openid) FROM tb_hz_sign_checkpwd where 1=1 ");
        if(!StringUtils.isEmpty(startTime)){
            sb.append("AND createTime>=#{startTime}");
        }
        if(!StringUtils.isEmpty(endTime)){
            sb.append("AND createTime<=#{endTime}");
        }
        return  sb.toString();
    }

    public String countFindPeach(String startTime,String endTime){
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT COUNT(*) FROM tb_hz_sign_checkpwd where 1=1 ");
        if(!StringUtils.isEmpty(startTime)){
            sb.append("AND createTime>=#{startTime}");
        }
        if(!StringUtils.isEmpty(endTime)){
            sb.append("AND createTime<=#{endTime}");
        }
        return  sb.toString();
    }
}
