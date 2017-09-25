package com.jielan.dao;

import com.jielan.model.PeachRecord;
import com.jielan.model.query.PeachRecordQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by wang on 2016/12/22.
 */

@Repository
public interface PeachRecordMapper {
    public void addPeachRecord(PeachRecord record);
    public void updatePeachRecord(PeachRecord record);
    public List<PeachRecord> selectPeachRecord(PeachRecordQuery query);
}
