package com.jielan.controller.user;

import com.jielan.model.*;
import com.jielan.model.core.ReturnBean;
import com.jielan.model.query.GoodsQuery;
import com.jielan.model.query.MyGoodsQuery;
import com.jielan.service.GoodsService;
import com.jielan.service.MyGoodsService;
import com.jielan.service.PeachRecordService;
import com.jielan.service.UserService;
import com.jielan.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by wang on 2016/12/12.
 * 兑换相关
 */
@RequestMapping("process")
@Controller
public class ProcessController {

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private UserService userService;

    @Autowired
    private PeachRecordService peachRecordService;

    @Autowired
    private MyGoodsService myGoodsService;
    /**
     *兑换商城首页和抽奖
     */
    @RequestMapping("/store")
    public String processlist(HttpServletRequest request,ModelMap map) {
        String openid = request.getParameter("openid");
        GoodsQuery query = new GoodsQuery();
        query.setStatus(1);
        List<Goods> goodsList = goodsService.selectGoods(query);
        map.put("goodslist", goodsList);
        map.put("openid",openid);
        return "user/store";
    }

    /**
     *商品兑换页面
     */
    @RequestMapping("/toexchange")
    public String toExchangeGoods(HttpServletRequest request,ModelMap map){
        String openid = request.getParameter("openid");
        int goodsid = Integer.parseInt(request.getParameter("goodsid"));
        User user = userService.selectByOpenid(openid);
        Goods goods = goodsService.selectById(goodsid);
        map.put("goods",goods);
        map.put("openid",openid);
        map.put("user",user);
        if(goods.getType()==1||goods.getType()==2){
            return "user/converhuafei";
        }else if(goods.getType()==3) {
            return "user/converquan";
        }else {
            return null;
        }
    }

    /**
     *商品兑换
     */
    @RequestMapping("/doexchange")
    @ResponseBody
    public synchronized ReturnBean doExchangeGoods(HttpServletRequest request){
        String openid = request.getParameter("openid");
        int goodsid = Integer.parseInt(request.getParameter("goodsid"));
        User user = userService.selectByOpenid(openid);
        int num = Integer.parseInt(request.getParameter("num"));//兑换数量
      //  double sum = Double.parseDouble(request.getParameter("sum"));//消耗的桃子
        Goods goods = goodsService.selectById(goodsid);
        double sum = num*goods.getPrice();
        ReturnBean returnBean=null;
        //每个商品有兑换次数限制
        MyGoodsQuery query = new MyGoodsQuery();
        query.setOpenid(openid);
        query.setGettype(0);
        query.setGoodsid(goodsid);
        query.setStartTime(DateUtil.fomatDate(new SimpleDateFormat("yyyy-MM").format(new Date())+"-01"));
        int exchange = myGoodsService.countExchange(query); //查询用户这个月兑换了几次
       // int exchange = 0;
        //System.out.println(exchange+"****"+goods.getExchangecount());

        try{
       //     Thread.sleep(10000);
            if(exchange==goods.getExchangecount()){
                returnBean = new ReturnBean("3","该商品您本月无法再兑换咯，请下个月再来吧"); //超过最多兑换次数
            }else if((exchange+num)>goods.getExchangecount()){
                returnBean = new ReturnBean("3","该商品您还可以兑换"+(goods.getExchangecount()-exchange)+"个，请修改数量"); //超过最多兑换次数
            }else{
                if(goods.getNumber()<num){
                    return new ReturnBean("2","该商品余量不足"); //商品余量不足
                }else {
                    if(user.getPeach()<sum){
                        returnBean = new ReturnBean("0","桃子数量不足");//桃子数量不足
                    }else{
                        //兑换扣桃子 添加纪录
                        PeachRecord record=new PeachRecord();
                        record.setWay(2);//方式：兑换
                        record.setPeach(sum);//消耗桃子
                        record.setType(0);//支出
                        record.setGoods(goods.getName());//商品名
                        record.setGoodsnum(num);//兑换数量
                        record.setRemainPeach(user.getPeach()-sum);
                        record.setOpenid(openid);

                        user.setPeach(user.getPeach()-sum);//用户扣桃子
                        goods.setNumber(goods.getNumber()-num);

                        MyGoods myGoods = new MyGoods();
                        myGoods.setOpenid(openid);
                        myGoods.setGettype(0);
                        myGoods.setCostpeach(sum);
                        myGoods.setGoodsnum(num);
                        myGoods.setGoodsname(goods.getName());
                        myGoods.setGoodsid(goods.getId());
                        peachRecordService.exchange(record,user,goods,myGoods);//添加纪录 修改数据
                        returnBean = new ReturnBean("1","兑换成功"); //兑换成功
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
          //  return new ReturnBean("500","系统异常");
        };
        return returnBean;
    }

    /**
     *幸运抽奖
     */
    @RequestMapping("/luckdraw")
    @ResponseBody
    public String luckDraw(HttpServletRequest request){
        String openid = request.getParameter("openid");
        User user = userService.selectByOpenid(openid);
        double peach = user.getPeach();
        int random = (int) (Math.random()*100);
        String prize = "";
        //奖品生成
        if(random>=0&&random<2){
            prize = "50M流量券"; //2%
        }else if(random>=2&&random<32){
            prize="补签卡" ;      //30%
        }else if(random>=32&&random<37){
            prize="10M流量券" ;      //5%
        }else if(random>=37&&random<47){
            prize="5个桃子";      //10%
        }else if(random>=47&&random<57){
            prize="手厅充20返5元话费返充券";
        }else{
            prize="谢谢";
        }

        if("手厅充20返5元话费返充券".equals(prize)){  //每个人每个月这个券最多给10张
            MyGoodsQuery myGoodsQuery = new MyGoodsQuery();
            myGoodsQuery.setOpenid(openid);
            myGoodsQuery.setGettype(1);
            myGoodsQuery.setGoodsname("手厅充20返5元话费返充券");
            myGoodsQuery.setStartTime(DateUtil.fomatDate(new SimpleDateFormat("yyyy-MM").format(new Date())+"-01"));
            int count = myGoodsService.countMyGoodsTime(myGoodsQuery);
            if(count>=10){
            prize="谢谢";
            }
        }

        if(peach<5){
            return "您的桃子不足";
        }else{
            try{
                //桃子添加一条记录
                PeachRecord record = new PeachRecord();
                record.setType(0);//支出
                record.setWay(3);
                record.setPeach(5.0);
                record.setRemainPeach(peach-5.0);
                record.setPrize(prize);
                record.setOpenid(openid);


                user.setPeach(peach-5.0);//抽一次扣5桃
                if(prize.equals("补签卡")){
                    user.setRetroactiveCard(user.getRetroactiveCard()+1);//补签卡加1
                }
                if(prize.equals("5个桃子")) {
                    record.setRemainPeach(user.getPeach()+5.0);
                    user.setPeach(user.getPeach()+5.0); //-5桃 +5桃 不变s
                }
                // 记录到我的物品表
                    MyGoods myGoods = new MyGoods();
                    myGoods.setOpenid(openid);
                    myGoods.setGettype(1);
                    myGoods.setCostpeach(5.0);
                    myGoods.setGoodsnum(1);
                    myGoods.setGoodsname(prize);
                    peachRecordService.expense(record, user,myGoods);//更新数据

                return prize;
            }
            catch (Exception e) {
                e.printStackTrace();
                return "系统异常";
            }
        }
    }
}
