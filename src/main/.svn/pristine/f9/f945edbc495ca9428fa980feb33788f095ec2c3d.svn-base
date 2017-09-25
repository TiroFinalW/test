package com.jielan.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

/**
 * Created by wang on 2017/2/22.
 */
public interface InfoMapper {

    //统计所有用户
    @Select("SELECT COUNT(*) FROM tb_hz_sign_user")
    public int countUser();

    //查询所有签到过的用户
    //@Select("SELECT COUNT(*) FROM tb_hz_sign_user where siginDate>=#{startTime} and siginDate<=#{endTime} and siginDate is not null")
    @SelectProvider(type=InfoMapperSql.class,method="countSignUser")
    public int countSignUser(@Param("startTime") String startTime, @Param("endTime")String endTime);

    //查询签到次数
    //@Select("SELECT COUNT(*) FROM tb_hz_sign_signrecord where signtime>=#{startTime} and signtime<=#{endTime}")
    @SelectProvider(type=InfoMapperSql.class,method="countSignTimes")
    public int countSignTimes(@Param("startTime") String startTime, @Param("endTime")String endTime);

    //查询寻桃人数
    //@Select("SELECT COUNT(DISTINCT openid) FROM tb_hz_sign_checkpwd where createTime>=#{startTime} and createTime<=#{endTime}")
    @SelectProvider(type=InfoMapperSql.class,method="countFindPeachUser")
    public int countFindPeachUser(@Param("startTime") String startTime, @Param("endTime")String endTime);

    //查询寻桃次数
    //@Select("SELECT COUNT(*) FROM tb_hz_sign_checkpwd where createTime>=#{startTime} and createTime<=#{endTime}")
    @SelectProvider(type=InfoMapperSql.class,method="countFindPeach")
    public int countFindPeach(@Param("startTime") String startTime, @Param("endTime")String endTime);
}
