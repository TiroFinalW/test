package com.jielan.controller.backstage;

import com.jielan.model.Goods;
import com.jielan.model.query.GoodsQuery;
import com.jielan.service.GoodsService;
import com.jielan.util.FileuploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by wang on 2016/12/12.
 * 后台  商品相关
 */
@RequestMapping("goods")
@Controller
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    /**
     *商品查询 展示i
     */
    @RequestMapping("/goodslist")
    public String goodslist(GoodsQuery query, ModelMap map){
        List<Goods> list = goodsService.selectGoods(query);
        map.put("list",list);
        map.put("query",query);
        return "manager/goodslist";
    }

    /**
     *到添加商品页面
     */
    @RequestMapping("/toadd")
    public String toaddGoods(){
        return "manager/addgoods";
    }


    /**
     * 添加商品
     * @return
     */
    @RequestMapping("/doadd")
    public String addGoods( @RequestParam("file") MultipartFile file, HttpServletRequest req){
        Goods goods = new Goods();
        goods.setNumber(Integer.parseInt(req.getParameter("number")));
        goods.setStatus(Integer.parseInt(req.getParameter("status")));
        goods.setName(req.getParameter("name"));
        goods.setValue(Integer.parseInt(req.getParameter("value")));
        goods.setPrice(Double.parseDouble(req.getParameter("price")));
        goods.setRule(req.getParameter("rule"));
        goods.setSort(Integer.parseInt(req.getParameter("sort")));
        goods.setType(Integer.parseInt(req.getParameter("type")));
        goods.setExchangecount(Integer.parseInt(req.getParameter("exchangecount")));
        try {
            if(!file.isEmpty()) {
                String imgurl = FileuploadUtil.fileUpload(req, file);
                goods.setImage(imgurl);
            }
            goodsService.addGoods(goods);
        } catch (Exception e) {
            e.printStackTrace();
            return "false";
        }
        return "redirect:/goods/goodslist.do";
    }

    /**
     *去修改商品页面
     */
    @RequestMapping("/toupdate")
    public String toUpdate(HttpServletRequest req,ModelMap map){
        int id =Integer.parseInt(req.getParameter("id")) ;
        Goods goods = goodsService.selectById(id);
        map.put("goods",goods);
        return "manager/addgoods";
    }

    /**
     * 修改商品
     * @return
     */
    @RequestMapping("/doupdate")
    public String doUpdate(@RequestParam("file") MultipartFile file, HttpServletRequest req){
        Goods goods = new Goods();
        goods.setId(Integer.parseInt(req.getParameter("id")));
        goods.setNumber(Integer.parseInt(req.getParameter("number")));
        goods.setStatus(Integer.parseInt(req.getParameter("status")));
        goods.setName(req.getParameter("name"));
        goods.setValue(Integer.parseInt(req.getParameter("value")));
        goods.setPrice(Double.parseDouble(req.getParameter("price")));
        goods.setRule(req.getParameter("rule"));
        goods.setSort(Integer.parseInt(req.getParameter("sort")));
        goods.setType(Integer.parseInt(req.getParameter("type")));
        goods.setExchangecount(Integer.parseInt(req.getParameter("exchangecount")));
        try {
            if(!file.isEmpty()){
                String imgurl = FileuploadUtil.fileUpload(req, file);
                goods.setImage(imgurl);
            }
            goodsService.updateGoods(goods);
        } catch (Exception e) {
            e.printStackTrace();
            return "false";
        }
        return "redirect:/goods/goodslist.do";
    }

    @RequestMapping("/delete")
    @ResponseBody
    public String deleteGoods(HttpServletRequest req,ModelMap map){
        int id =Integer.parseInt(req.getParameter("id")) ;
        try {
            goodsService.deleteGoods(id);
        } catch (Exception e) {
            e.printStackTrace();
            return "false";
        }
        return "success";
    }
}