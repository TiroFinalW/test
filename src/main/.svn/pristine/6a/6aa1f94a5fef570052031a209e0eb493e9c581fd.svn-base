package com.jielan.service.impl;

import com.jielan.dao.GoodsMapper;
import com.jielan.dao.MyGoodsMapper;
import com.jielan.dao.PeachRecordMapper;
import com.jielan.dao.UserMapper;
import com.jielan.model.Goods;
import com.jielan.model.MyGoods;
import com.jielan.model.PeachRecord;
import com.jielan.model.User;
import com.jielan.model.query.PeachRecordQuery;
import com.jielan.service.PeachRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by wang on 2016/12/22.
 */
@Service
@Transactional
public class PeachRecordServiceImpl implements PeachRecordService{

    @Autowired
    private PeachRecordMapper peachRecordMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private GoodsMapper goodsMapper;
    @Autowired
    private MyGoodsMapper myGoodsMapper;

    public List<PeachRecord> selectPeachRecord(PeachRecordQuery query) {
        List<PeachRecord> list = peachRecordMapper.selectPeachRecord(query);
        return list;
    }

    public void addPeachRecord(PeachRecord record) throws Exception {
        peachRecordMapper.addPeachRecord(record);
    }

    public void updatePeachRecord(PeachRecord record) throws Exception {
        peachRecordMapper.addPeachRecord(record);
    }

    /**
     *抽奖(桃子消费)
     */
    public void expense(PeachRecord record,User user, MyGoods myGoods) throws Exception {
        if (myGoods!=null) {
            myGoodsMapper.addMyGoods(myGoods);
        }
        peachRecordMapper.addPeachRecord(record);
        userMapper.updateUser(user);
    }

    /**
     *兑换(桃子消费)
     */
    public void exchange(PeachRecord record, User user, Goods goods, MyGoods myGoods) throws Exception {
        peachRecordMapper.addPeachRecord(record);
        userMapper.updateUser(user);
        goodsMapper.updateGoods(goods);
        myGoodsMapper.addMyGoods(myGoods);
    }
}
