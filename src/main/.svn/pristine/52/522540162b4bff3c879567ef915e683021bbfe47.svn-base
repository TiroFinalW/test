package com.jielan.dao;

import com.jielan.model.SignRecord;
import com.jielan.model.query.SignRecordQuery;

import java.util.List;

/**
 * Created by wang on 2016/12/20.
 */
public interface SignMapper {

    public List<SignRecord> selectSignRecord(SignRecordQuery query);
    public void addSignRecord(SignRecord record);
    public List<SignRecord> selectUserSignRecord(String openid);
    public void addRetroactive(SignRecord record);
    public int countSignRecord(SignRecordQuery query);
    public List<SignRecord> selectSignRecordPage(SignRecordQuery query);
    public List<SignRecord> exportSignRecord(SignRecordQuery query);
}
