package com.jielan.model;

import com.alibaba.fastjson.annotation.JSONField;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;
import java.sql.Timestamp;

/**
 * Created by wang on 2016/12/19.
 * 桃子收支明细记录
 */
public class PeachRecord {
    private int id;
    private String openid;
    private int type;   //收支类型 0:支出 1;获得
    private int way; //方式 0.签到  1.补签 2.兑换商品 3.抽奖  4.图文寻桃 5.人人转发
    private double peach;//消耗或者获得桃子数量
    private String goods; //兑换的商品名称 （兑换商品用字段）
    private int goodsnum;//兑换数量 （兑换商品用字段）
    private String prize;//抽奖奖品
    private double remainPeach;//剩余用户桃子
    private int remainCard;//剩余补签卡数量
    private Timestamp exchangeDate;//兑换时间

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getWay() {
        return way;
    }

    public void setWay(int way) {
        this.way = way;
    }

    public double getPeach() {
        return peach;
    }

    public void setPeach(double peach) {
        this.peach = peach;
    }

    public String getGoods() {
        return goods;
    }

    public void setGoods(String goods) {
        this.goods = goods;
    }

    public int getGoodsnum() {
        return goodsnum;
    }

    public void setGoodsnum(int goodsnum) {
        this.goodsnum = goodsnum;
    }

    public String getPrize() {
        return prize;
    }

    public void setPrize(String prize) {
        this.prize = prize;
    }

    public double getRemainPeach() {
        return remainPeach;
    }

    public void setRemainPeach(double remainPeach) {
        this.remainPeach = remainPeach;
    }

    public int getRemainCard() {
        return remainCard;
    }

    public void setRemainCard(int remainCard) {
        this.remainCard = remainCard;
    }

//    public Date getExchangeDate() {
//        return exchangeDate;
//    }
//
//    public void setExchangeDate(Date exchangeDate) {
//        this.exchangeDate = exchangeDate;
//    }

    public Timestamp getExchangeDate() {
        return exchangeDate;
    }

    public void setExchangeDate(Timestamp exchangeDate) {
        this.exchangeDate = exchangeDate;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }
}
