package com.jielan.service.impl;

import com.jielan.dao.GoodsMapper;
import com.jielan.model.Goods;
import com.jielan.model.query.GoodsQuery;
import com.jielan.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by wang on 2016/12/16.
 */
@Service
@Transactional
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsMapper mapper;
    public void addGoods(Goods goods) throws Exception {
        mapper.addGoods(goods);
    }

    public void updateGoods(Goods goods) throws Exception {
        mapper.updateGoods(goods);
    }
    //根据id查询
    public Goods selectById(int id) {
        return mapper.selectById(id);
    }
    //按条件查询商品
    public List<Goods> selectGoods(GoodsQuery query) {
        int count = mapper.countGoods(query);
        query.setRecordcount(count);
        return mapper.selectGoods(query);
    }

    public void deleteGoods(int id) throws Exception {
        mapper.deleteGoods(id);
    }
}
