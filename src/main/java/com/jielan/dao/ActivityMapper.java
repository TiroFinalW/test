package com.jielan.dao;

import com.jielan.model.Activity;
import com.jielan.model.query.ActivityQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by wang on 2016/12/15.
 * 活动
 */
@Repository
public interface ActivityMapper {

    public void addActivity(Activity activity);

    public void updateActivity(Activity activity);

    public List<Activity> selectActivity(ActivityQuery query);

    public Activity selectById(Integer id);

    public void deleteActivity(Integer id);

    public int countActivity(ActivityQuery query);
}
