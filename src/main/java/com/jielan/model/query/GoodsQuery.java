package com.jielan.model.query;

import java.util.Date;

/**
 * Created by wang on 2016/12/16.
 */
public class GoodsQuery extends PageQuery{
    private int id;
    private String name;//商品名称
    private String image;//列表页图片
    private Integer value ;  //话费券流量券面额
    private double price;//消耗的桃子
    private Integer type;//商品类型 1话费券,2流量券 3其他
    private int sort;//排序
    private String rule;//兑换规则
    private int number; //商品数量
    private Integer status; //状态1 上架 0下架
    private Date createTime;

    private String shop;//消费门店

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public String getRule() {
        return rule;
    }

    public void setRule(String rule) {
        this.rule = rule;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getShop() {
        return shop;
    }

    public void setShop(String shop) {
        this.shop = shop;
    }
}
