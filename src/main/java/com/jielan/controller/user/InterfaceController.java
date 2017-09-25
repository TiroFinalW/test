package com.jielan.controller.user;

import com.alibaba.fastjson.JSONObject;
import com.jielan.model.PeachRecord;
import com.jielan.model.User;
import com.jielan.service.PeachRecordService;
import com.jielan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by wang on 2017/1/5.
 * 人人转发接口
 */
@Controller
@RequestMapping("interface")
public class InterfaceController {

    @Autowired
    private PeachRecordService recordService;

    @Autowired
    private UserService userService;

    @RequestMapping("/sharepeach")
    @ResponseBody
    public String interAddPeach(HttpServletRequest request){
        JSONObject obj = new JSONObject();
        String openid = request.getParameter("openid");
        String peach = request.getParameter("peach");
        try{
            User user = userService.selectByOpenid(openid);
            if(user==null){
                obj.put("result",400); //没有用户
            }else{
                PeachRecord record = new PeachRecord();
                record.setOpenid(openid);
                record.setType(1);
                record.setWay(5);
                record.setPeach(Double.parseDouble(peach));
                record.setRemainPeach(user.getPeach()+Double.parseDouble(peach));
                user.setPeach(user.getPeach()+Double.parseDouble(peach));
                recordService.expense(record,user,null);
                obj.put("result",200);//添加成功
            }
        }catch (Exception e){
            e.printStackTrace();
            obj.put("result",500); //系统异常
        }finally {
            return obj.toJSONString();
        }
    }
}
