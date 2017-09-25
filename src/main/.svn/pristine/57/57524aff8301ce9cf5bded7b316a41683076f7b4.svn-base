package com.jielan.controller.user;

import com.alibaba.fastjson.JSONObject;
import com.jielan.model.*;
import com.jielan.model.query.*;
import com.jielan.service.*;
import com.jielan.util.DateUtil;
import com.jielan.util.EmojiFilter;
import com.jielan.util.HttpUtil;
import com.jielan.util.WeChatUtil;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.*;

/**
 * Created by wang on 2016/12/12.
 * 用户中心页面
 */
@RequestMapping("personal")
@Controller
public class PersonalController {

    @Autowired
    private UserService userService;

    @Autowired
    private ActivityService activityService;

    @Autowired
    private SignService signService;

    @Autowired
    private NoticeService noticeService;

    @Autowired
    private MyGoodsService myGoodsService;

    @Autowired
    private PeachRecordService peachRecordService;
    /**
        登陆
        state参数  0未绑定手机 -1未获取到openid 1已经绑定
     */
    @RequestMapping("/login")
    @ResponseBody
    public ModelAndView login(HttpServletRequest req) {
        ModelAndView mv = new ModelAndView();
        //根据openid 判断用户有没有绑定
        String openid = req.getParameter("openid");
        if(openid==null||openid==""){
            mv.addObject("state",-1);
        }else{
            //查询本地用户
            User user = userService.selectByOpenid(openid);
            try{
                if(user==null){
                    if(!("").equals(WeChatUtil.getPhone(openid))) {
                        System.out.println(("").equals(WeChatUtil.getPhone(openid)));
                        //接口查询已经绑定手机  本地库添加用户信息
                        User newuser = new User();
                        newuser.setOpenid(openid);
                        newuser.setPhone(WeChatUtil.getPhone(openid));
                        newuser.setWx_image(WeChatUtil.getUserInfo(openid).getString("headimgurl")); //头像
                        newuser.setWx_name(EmojiFilter.filterEmoji(WeChatUtil.getUserInfo(openid).getString("nickname")));   //昵称
                        userService.addUser(newuser);
                        mv.addObject("user",newuser);
                        mv.addObject("state",1);//已绑定
                    }else{
                        System.out.println("未绑定");
                        mv.addObject("openid",openid);
                        mv.addObject("state",0);//未绑定
                    }
                }else {
                    //本地有用户 但是在后台那修改了手机 本地没更新 则更新本地用户手机
                    if(WeChatUtil.getPhone(openid)!=null&&!WeChatUtil.getPhone(openid).equals(user.getPhone())) {
                        user.setPhone(WeChatUtil.getPhone(openid));
                        userService.updateUser(user);
                    }
                    mv.addObject("user",user);
                    mv.addObject("state",1);//已绑定
                }
            }catch (Exception e){
                e.printStackTrace();
                mv.addObject("state",-2);//系统异常
            };
        }

        mv.setViewName("user/personal");
        return mv;
    }

    /**
     * 登陆后  用户中心
     */
    @RequestMapping("/topersonal")
    public String toPersonal(ModelMap map,HttpServletRequest req){
        String openid = req.getParameter("openid");
        try {
        User user = userService.selectByOpenid(openid);
        String today = DateUtil.getDay();
         if(user!=null&&user.getSiginDate()!=null){
             String lastsign = DateUtil.getStringDay(user.getSiginDate());
             if(DateUtil.getDaySub(lastsign,today)>1){  //最后一次签到日期和今天差距一天以上  重置连续最大签到天数
                 user.setSigin_count(0);  //重置
                 userService.updateUser(user);
             }
        }
        //任务中心
        ActivityQuery actquery = new ActivityQuery();
        actquery.setStatus(1);
        List<Activity> actlist = activityService.selectActivity(actquery);
        //公告列表
        NoticeQuery noticequery = new NoticeQuery();
        noticequery.setStatus(1);
        noticequery.setOrderby("sort asc");
        List<Notice> noticelist = noticeService.selectNotice(noticequery);

            map.put("headimgurl",WeChatUtil.getUserInfo(openid).getString("headimgurl"));
            map.put("nickname",WeChatUtil.getUserInfo(openid).getString("nickname"));
            map.put("user",user);
            map.put("noticelist",noticelist);
            map.put("actlist",actlist);
            map.put("openid",openid);
            map.put("list",signList(user));//首页签到列表
            map.put("state",5);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "user/personal";
    }
    /**
     * 任务中心
     */
    @RequestMapping("/activitycenter")
    public String activityCenter(HttpServletRequest request,ModelMap map){
        map.put("openid",request.getParameter("openid"));
        ActivityQuery query = new ActivityQuery();
        List<Activity> list = activityService.selectActivity(query);
        map.put("list",list);
        return "user/activity";
    }
    /**
     *我的桃子
     */
    @RequestMapping("/mypeach")
    public String myPeach(HttpServletRequest request,ModelMap map){
        String openid = request.getParameter("openid");
        User user = userService.selectByOpenid(openid);
        PeachRecordQuery peachRecordQuery = new PeachRecordQuery();
        peachRecordQuery.setOpenid(openid);
        peachRecordQuery.setOrderby("exchangeDate desc");
        List<PeachRecord> list = peachRecordService.selectPeachRecord(peachRecordQuery);
        map.put("list",list);
        map.put("user",user);
        return "user/mypeach";
    }
    /**
     *兑换记录
     */
    @RequestMapping("/myrecord")
    public String myRecord(HttpServletRequest request,ModelMap map){
        String openid = request.getParameter("openid");
        List<MyGoods> list = myGoodsService.selectMyGoodsByOpenid(openid);
        map.put("list",list);
        return "user/myrecord";
    }

    /**兑换规则
     */
    @RequestMapping("/rule")
    public String rule(){
        return "user/rule";
    }

/*    @RequestMapping("/userpeach")
    @ResponseBody
    public double getUserPeach(HttpServletRequest request){
        User user = userService.selectByOpenid(request.getParameter("openid"));
        return user.getPeach();
    }

    @RequestMapping("/usersignlist")
    @ResponseBody
    public String signList(HttpServletRequest request){
        return JSONObject.toJSONString(signList(userService.selectByOpenid(request.getParameter("openid"))));
    }*/


    /**
     *生成首页的签到记录列表
     */
    public  List<JSONObject> signList(User user){
        String month = DateUtil.getMonth();
        String nextmonth = DateUtil.getNextMonth();
        String year = DateUtil.getYear();

        List<String> arr1 = Arrays.asList(new String[]{month+"-01", month+"-02", month+"-03", month+"-04", month+"-05", month+"-06", month+"-07"});
        List<String> arr2 = Arrays.asList(new String[]{month+"-08",month+"-09",month+"-10",month+"-11",month+"-12",month+"-13",month+"-14"});
        List<String> arr3= Arrays.asList(new String[]{month+"-15",month+"-16",month+"-17",month+"-18",month+"-19",month+"-20",month+"-21"});
        List<String> arr4 = Arrays.asList(new String[]{month+"-22",month+"-23",month+"-24",month+"-25",month+"-26",month+"-27",month+"-28"});
        List<String> arr5= null;
        int num = DateUtil.getMaxDay();
        if(num==31){
            arr5 = Arrays.asList(new String[]{month+"-29",month+"-30",month+"-31",nextmonth+"-01",nextmonth+"-02",nextmonth+"-03",nextmonth+"-04"});
        }else if(num==30){
            arr5 =Arrays.asList( new String[]{month+"-29",month+"-30",nextmonth+"-01",nextmonth+"-02",nextmonth+"-03",nextmonth+"-04",nextmonth+"-05"});
        }else if(num==29){
            arr5 = Arrays.asList(new String[]{month+"-29",nextmonth+"-01",nextmonth+"-02",nextmonth+"-03",nextmonth+"-04",nextmonth+"-05",nextmonth+"-06"});
        }

        String today = DateUtil.getDay2(); // MM-dd
        SignRecordQuery query = new SignRecordQuery();
        query.setOpenid(user.getOpenid());
        query.setOrderby("signtime asc");

        List<String> compareArr = null; //遍历集合 和签到记录 对比 是否是相同日期

        if(arr1.contains(today)){
            query.setStartTime(DateUtil.fomatDate1(year+"-"+month+"-01 00:00:00"));
            query.setEndTime(DateUtil.fomatDate1(year+"-"+month+"-08 00:00:00"));
            compareArr = arr1;
        }
        if(arr2.contains(today)){
            query.setStartTime(DateUtil.fomatDate1(year+"-"+month+"-08 00:00:00"));
            query.setEndTime(DateUtil.fomatDate1(year+"-"+month+"-15 00:00:00"));
            compareArr = arr2;
        }
        if(arr3.contains(today)){
            query.setStartTime(DateUtil.fomatDate1(year+"-"+month+"-15 00:00:00"));
            query.setEndTime(DateUtil.fomatDate1(year+"-"+month+"-22 00:00:00"));
            compareArr = arr3;
        }
        if(arr4.contains(today)){
            query.setStartTime(DateUtil.fomatDate1(year+"-"+month+"-22 00:00:00"));
            query.setEndTime(DateUtil.fomatDate1(year+"-"+month+"-28 23:59:59"));
            compareArr = arr4;
        }
        if(arr5!=null&&arr5.contains(today)){  //这个区间 其实只要查到月底就行
            query.setStartTime(DateUtil.fomatDate1(year+"-"+month+"-29 00:00:00"));
            query.setEndTime(DateUtil.fomatDate1(year+"-"+month+"-"+num+" 23:59:59"));
            compareArr = arr5;
        }
        List<SignRecord> signRecordList = signService.selectSignRecord(query);//这个区间内的签到记录
        List<JSONObject> list = new ArrayList<JSONObject>();//用于存展示数据的

        boolean flag = true;//相同且是签到记录最后一条的标志
        int j=0;
        for(String date:compareArr){
            boolean flag1= true;  //判断这一天 有没有签到过的标志
            if(flag){
            for(int i=0;i<signRecordList.size();i++){
               if(date.equals(DateUtil.getMMddDay(signRecordList.get(i).getSigntime()))){ //签到记录日子和这个日子符合 添加
                    JSONObject obj = new JSONObject();
                    obj.put("date",date);
                    obj.put("class1","icon icon2_a");
                    obj.put("class2","date date_a");
                    obj.put("peach",signRecordList.get(i).getPeach());
                   list.add(obj);
                   flag1=false;
                   if(i==(signRecordList.size()-1)){
                       flag=false;//相同且是签到记录最后一条 说明后面没有了
                   }
                   break;
                }
//                if(date.equals(DateUtil.getMMddDay(signRecordList.get(i).getSigntime()))&&i==(signRecordList.size()-1)){
//                    flag=false;
//                    break;
//                }
            }
            }
            if(flag1&&flag){
                JSONObject obj = new JSONObject();
                obj.put("date",date);
                obj.put("class1","icon");
                obj.put("class2","date");
                obj.put("peach",0.0);
                list.add(obj);
            }
            if((!flag)&&j>list.size()-1&&j<=(compareArr.size()-1)){

                //算今后几天的如果一直签到能得到的桃子
                JSONObject obj = new JSONObject();
                obj.put("date",date);
                obj.put("class1","icon");
                obj.put("class2","date");
                obj.put("peach", futurePeach(date,month,user));
                list.add(obj);
            }
            j++;
        }
        return list;
    }


    /**
     *计算将来某天 应该会得到的桃子 将来某天连续签到次数=用户最大签到次数+（某天-用户最近天数）
     */
    public double futurePeach(String date,String month,User user){
        //传入的只有日期 处理
        if("12".equals(month)&&(date.equals("01-01")||date.equals("01-02")||date.equals("01-03")||date.equals("01-04"))){
            date = DateUtil.getNextYear()+"-"+date;
        }else{
            date = DateUtil.getYear()+"-"+date;
        }

        int maxday = user.getSigin_count();
        //获取最近登录时间和某天的差的天数
        long betweendays = DateUtil.getDaySub(DateUtil.getStringDay(user.getSiginDate()),date);
        System.out.println(date);
        System.out.println("差"+(maxday+betweendays));
        if((maxday+betweendays)<10){
            return 1;
        }else if((maxday+betweendays)>=10&&maxday<20){
            return 1.1;
        } else if((maxday+betweendays)>=20&&maxday<30){
            return 1.1;
        }else if((maxday+betweendays)>=30){
            return  1.3;
        }else{
            return 0;
        }
    }
}
