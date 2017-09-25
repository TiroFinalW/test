package com.jielan.model;

import java.util.Date;

/**
 * Created by wang on 2016/12/28.
 * 图文寻桃 用户密码记录
 */
public class CheckPwd {
    private int id;
    private String openid;
    private String password;
    private Date createTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
