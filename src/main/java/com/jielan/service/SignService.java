package com.jielan.service;

import com.jielan.model.PeachRecord;
import com.jielan.model.SignRecord;
import com.jielan.model.User;
import com.jielan.model.query.SignRecordQuery;

import java.util.List;

/**
 * Created by wang on 2016/12/20.
 * 签到记录
 */
public interface SignService {
    public List<SignRecord> selectSignRecord(SignRecordQuery query);
    public void addSign(SignRecord record, User user, PeachRecord precord)throws Exception;
    public List<SignRecord> selectUserSignRecord(String openid);
    public void retroactive(SignRecord record, User user, PeachRecord precord)throws Exception;
    public List<SignRecord> selectSignRecordPage(SignRecordQuery query);
    public List<SignRecord> exportSignRecord(SignRecordQuery query);
}
