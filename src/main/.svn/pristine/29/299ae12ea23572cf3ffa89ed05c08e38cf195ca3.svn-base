package com.jielan.dao;

import com.jielan.model.MyGoods;
import com.jielan.model.query.MyGoodsQuery;

import java.util.List;

/**
 * Created by wang on 2016/12/30.
 */
public interface MyGoodsMapper {
    public void addMyGoods(MyGoods myGoods) throws Exception;
    public List<MyGoods> selectMyGoods(MyGoodsQuery query);
    public List<MyGoods> selectMyGoodsByOpenid(String openid);
    public int countMyGoods(MyGoodsQuery query);
    public List<MyGoods> exportMyGoods(MyGoodsQuery query);
    public int countExchange(MyGoodsQuery query);
    public int countMyGoodsTime(MyGoodsQuery query);
}
