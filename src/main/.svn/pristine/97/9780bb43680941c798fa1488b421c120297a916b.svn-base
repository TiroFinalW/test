package com.jielan.controller.user;

import com.alibaba.fastjson.JSONObject;
import com.jielan.model.CheckPwd;
import com.jielan.model.PassWord;
import com.jielan.model.PeachRecord;
import com.jielan.model.User;
import com.jielan.model.query.CheckPwdQuery;
import com.jielan.model.query.PassWordQuery;
import com.jielan.service.ActivityService;
import com.jielan.service.UserService;
import com.jielan.util.DateUtil;
import com.jielan.util.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wang on 2016/12/27.
 * 首页活动
 */
@Controller
@RequestMapping("useractivity")
public class UserActivityController {

    @Autowired
    private ActivityService activityService;
    @Autowired
    private UserService userService;

    /**
     *图文寻桃
     */
    @RequestMapping("/tofindpeach")
    public String tofindPeach(HttpServletRequest request,ModelMap map){
        String openid = request.getParameter("openid");
        User user = userService.selectByOpenid(openid);
        map.put("user",user);
        return "user/findpeach";
    }

    /**
     *寻桃 时效今日0点 到次日18点
     */
    @RequestMapping("/dofindpeach")
    @ResponseBody
    public String dofindPeach(HttpServletRequest request,ModelMap map){
        Map<String,String > result = new HashMap<String,String >();
        String openid = request.getParameter("openid");
        String password = request.getParameter("password");


            //查询这个时间段的密码
            PassWordQuery pwdquery = new PassWordQuery();
            pwdquery.setToday(new Date());
            List<PassWord> passWordList = activityService.selectPassWord(pwdquery);
            //查询这个密码有没有用过
            CheckPwdQuery query = new CheckPwdQuery();
            query.setOpenid(openid);
            query.setPassword(password);
            query.setStartTime(DateUtil.fomatDate1(DateUtil.getDay()+" 00:00:00"));//查询区间 今天
            query.setEndTime(DateUtil.fomatDate1(DateUtil.getDay()+" 23:59:59"));
            List<CheckPwd> checkPwdList = activityService.selectCheckPwd(query);

            if(passWordList!=null&&passWordList.size()>0){
                if(checkPwdList!=null&&checkPwdList.size()>0){
                    map.put("status","3"); //用过该密码
                }else {
                    boolean flag=true;
                    for(PassWord pwd:passWordList){
                        if(password.equals(pwd.getPassword())){
                            double peach= (int)(Math.random()*2+1); //随机一到两个桃子
                            CheckPwd checkPwd = new CheckPwd();
                            checkPwd.setPassword(password);
                            PeachRecord record = new PeachRecord();
                            record.setPeach(peach);
                            record.setOpenid(openid);
                            User user = userService.selectByOpenid(openid);
                            user.setPeach(user.getPeach()+peach); //更新用户桃子
                            try {
                                activityService.dofindPeach(checkPwd,record,user); //添加一条记录
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            map.put("status","1");
                            map.put("peach",peach);//没用过 则添加一条记录 修改用户桃子
                            map.put("userpeach",user.getPeach());
                            flag=false;
                            break;
                        }
                    }
                    if(flag){
                        map.put("status","2");//密码错误
                    }

                }
            }else{
                map.put("status","0");
            }
        return JSONObject.toJSONString(map);
    }
}
