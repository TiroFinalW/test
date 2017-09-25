package com.jielan.dao;

import com.jielan.model.Goods;
import com.jielan.model.query.GoodsQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by wang on 2016/12/16.
 * 商品
 */
@Repository
public interface GoodsMapper {
    public void addGoods(Goods goods);
    public void updateGoods(Goods goods);
    //根据id查询
    public Goods selectById(int id);
    //按条件查询商品
    public List<Goods> selectGoods(GoodsQuery query);
    public void deleteGoods(int id);
    //按条件查询数量
    public int countGoods(GoodsQuery query);
}
