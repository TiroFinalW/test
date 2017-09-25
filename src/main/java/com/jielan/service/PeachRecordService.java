package com.jielan.service;

import com.jielan.model.Goods;
import com.jielan.model.MyGoods;
import com.jielan.model.PeachRecord;
import com.jielan.model.User;
import com.jielan.model.query.PeachRecordQuery;

import java.util.List;

/**
 * Created by wang on 2016/12/22.
 */
public interface PeachRecordService {
    public List<PeachRecord> selectPeachRecord(PeachRecordQuery query);
    public void addPeachRecord(PeachRecord record)throws Exception;
    public void updatePeachRecord(PeachRecord record)throws Exception;
    public void expense(PeachRecord record,User user, MyGoods myGoods)throws Exception;
    public void exchange(PeachRecord record, User user, Goods goods, MyGoods myGoods)throws Exception;
}
