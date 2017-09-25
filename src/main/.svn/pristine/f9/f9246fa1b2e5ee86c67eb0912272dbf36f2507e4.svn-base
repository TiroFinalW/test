package com.jielan.service.impl;

import com.jielan.dao.MyGoodsMapper;
import com.jielan.model.MyGoods;
import com.jielan.model.query.MyGoodsQuery;
import com.jielan.service.MyGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wang on 2016/12/30.
 */
@Service
public class MyGoodsServiceImpl implements MyGoodsService{

    @Autowired
    private MyGoodsMapper myGoodsMapper;

    public void addMyGoods(MyGoods myGoods) throws Exception {
        myGoodsMapper.addMyGoods(myGoods);
    }

    public List<MyGoods> selectMyGoods(MyGoodsQuery query) {
        query.setRecordcount(myGoodsMapper.countMyGoods(query));
        return myGoodsMapper.selectMyGoods(query);
    }

    public List<MyGoods> selectMyGoodsByOpenid(String openid) {
        return myGoodsMapper.selectMyGoodsByOpenid(openid);
    }

    public List<MyGoods> exportMyGoods(MyGoodsQuery query) {
        return myGoodsMapper.exportMyGoods(query);
    }

    public int countExchange(MyGoodsQuery query) {
        return myGoodsMapper.countExchange(query);
    }

    public int countMyGoodsTime(MyGoodsQuery query) {
        return myGoodsMapper.countMyGoodsTime(query);
    }


}
