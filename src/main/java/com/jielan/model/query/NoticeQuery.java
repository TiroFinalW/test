package com.jielan.model.query;

import java.util.Date;

/**
 * Created by wang on 2016/12/26.
 */
public class NoticeQuery extends PageQuery {
    private int id;
    private String content;//内容
    private Date createTime;
    private Integer status;//状态 1显示 0不显示
    private int sort; //排序

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }
}
