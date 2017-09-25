package com.jielan.dao;

import com.jielan.model.Notice;
import com.jielan.model.query.NoticeQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by wang on 2016/12/26.
 */
@Repository
public interface NoticeMapper {
    public List<Notice> selectNotice(NoticeQuery query);
    public void addNotice(Notice notice);
    public void updateNotice(Notice notice);
    public void deleteNotice(int id);
    public int countNotice(NoticeQuery query);
    public Notice selectById(int id);
}
