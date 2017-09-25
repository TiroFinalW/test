package com.jielan.service.impl;

import com.jielan.dao.UserMapper;
import com.jielan.model.User;
import com.jielan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by wang on 2016/12/13.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper dao;

    /**
     * 添加用户
     * @param user
     */
    public void addUser(User user)throws Exception{
        dao.addUser(user);
    }

    public void updateUser(User user)throws Exception {
        dao.updateUser(user);
    }

    /**
     * 根据openid查用户信息
     */
    public User selectByOpenid(String openid) {
        return dao.selectByOpenid(openid);
    }

    public void clearPeach() throws Exception {
        dao.clearPeach();
    }
}
