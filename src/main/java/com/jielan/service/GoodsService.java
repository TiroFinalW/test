package com.jielan.service;

import com.jielan.model.Goods;
import com.jielan.model.query.GoodsQuery;

import java.util.List;

/**
 * Created by wang on 2016/12/16.
 * 商品
 */
public interface GoodsService {
    public void addGoods(Goods goods) throws Exception;
    public void updateGoods(Goods goods) throws Exception;
    //根据id查询
    public Goods selectById(int id);
    //按条件查询商品
    public List<Goods> selectGoods(GoodsQuery query);
    public void deleteGoods(int id) throws Exception;
}
