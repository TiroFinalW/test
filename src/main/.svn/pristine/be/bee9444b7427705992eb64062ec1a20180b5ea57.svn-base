package com.jielan.service.impl;

import com.jielan.dao.NoticeMapper;
import com.jielan.model.Notice;
import com.jielan.model.query.NoticeQuery;
import com.jielan.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by wang on 2016/12/26.
 */
@Service
@Transactional
public class NoticeServiceImpl implements NoticeService {
    @Autowired
    private NoticeMapper mapper;
    public List<Notice> selectNotice(NoticeQuery query) {
        query.setRecordcount(mapper.countNotice(query));
        List<Notice> list = mapper.selectNotice(query);
        return list;
    }

    public void addNotice(Notice notice) throws Exception{
        mapper.addNotice(notice);
    }

    public void updateNotice(Notice notice) throws Exception{
        mapper.updateNotice(notice);
    }

    public void deleteNotice(int id) throws Exception{
        mapper.deleteNotice(id);
    }

    public Notice selectById(int id) {
        return mapper.selectById(id);
    }

}
