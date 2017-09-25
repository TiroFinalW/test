package com.jielan.dao;

import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * Created by wang on 2017/1/18.
 * 发券用（无视）
 */
public interface SendMsgMapper {
    @Select("select * from msguser")
    public List<Map<String,Object>> sendUser();
    @Select("select * from quan")
    public List<Map<String,String>> sendQuan();
}
