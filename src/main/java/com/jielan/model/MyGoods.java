package com.jielan.model;

import java.util.Date;

/**
 * Created by wang on 2016/12/30.
 */
public class MyGoods {
    private int id;
    private String openid;
    private String phone;
    private int goodsid;
    private String goodsname; //商品名
    private int gettype;  //获得方式 0 兑换  1 抽奖
    private double costpeach; //消耗桃子
    private Date createTime;
    private int goodsnum;  //商品数量

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGoodsname() {
        return goodsname;
    }

    public void setGoodsname(String goodsname) {
        this.goodsname = goodsname;
    }

    public int getGettype() {
        return gettype;
    }

    public void setGettype(int gettype) {
        this.gettype = gettype;
    }

    public double getCostpeach() {
        return costpeach;
    }

    public void setCostpeach(double costpeach) {
        this.costpeach = costpeach;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getGoodsnum() {
        return goodsnum;
    }

    public void setGoodsnum(int goodsnum) {
        this.goodsnum = goodsnum;
    }

    public int getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(int goodsid) {
        this.goodsid = goodsid;
    }
}
