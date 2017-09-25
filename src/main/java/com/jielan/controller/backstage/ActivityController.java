package com.jielan.controller.backstage;

import com.jielan.model.Activity;
import com.jielan.model.PassWord;
import com.jielan.model.query.ActivityQuery;
import com.jielan.model.query.PassWordQuery;
import com.jielan.service.ActivityService;
import com.jielan.util.DateUtil;
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
 * 后台  活动相关 ...
 */
@RequestMapping("activity")
@Controller
public class ActivityController {

    @Autowired
    private ActivityService activityService;

    /**
     * 活动列表
     */
    @RequestMapping("/activitylist")
    public String activityList(ActivityQuery query, ModelMap map){
        List<Activity> list = activityService.selectActivity(query);
        map.put("query",query);
        map.put("list",list);
        return "manager/activitylist";
    }

    /**
     * 去添加活动页面
     */
    @RequestMapping("/toadd")
    public String toAddActivity(){
        return "manager/addactivity";
    }

    /**
     * 添加活动
     * @return
     */
    @RequestMapping("/doadd")
    public String addActivity( @RequestParam("file") MultipartFile file,HttpServletRequest req){
        Activity activity = new Activity();
        activity.setName(req.getParameter("name"));
        activity.setActivityurl(req.getParameter("activityurl"));
        activity.setStatus(Integer.parseInt(req.getParameter("status")));
        try {
            if(!file.isEmpty()) {
                String imgurl = FileuploadUtil.fileUpload(req, file);
                activity.setImgurl(imgurl);
            }
            activityService.addActivity(activity);
        } catch (Exception e) {
            e.printStackTrace();
            return "false";
        }
        return "redirect:/activity/activitylist.do";
    }

    /**
     *去修改活动页面
     */
    @RequestMapping("/toupdate")
    public String toUpdate(HttpServletRequest req,ModelMap map){
        int id =Integer.parseInt(req.getParameter("id")) ;
        Activity activity = activityService.selectById(id);
        map.put("activity",activity);
        return "manager/addactivity";
    }

    /**
     * 修改活动
     * @return 1
     */
    @RequestMapping("/doupdate")
    public String doUpdate(@RequestParam("file") MultipartFile file, HttpServletRequest req){
        Activity activity = new Activity();
        activity.setName(req.getParameter("name"));
        activity.setActivityurl(req.getParameter("activityurl"));
        activity.setStatus(Integer.parseInt(req.getParameter("status")));
        activity.setId(Integer.parseInt(req.getParameter("id")));
        try {
            if(!file.isEmpty()){
                String imgurl = FileuploadUtil.fileUpload(req, file);
                activity.setImgurl(imgurl);
            }
            activityService.updateActivity(activity);
        } catch (Exception e) {
            e.printStackTrace();
            return "false";
        }
        return "redirect:/activity/activitylist.do";
    }

    @RequestMapping("/delete")
    @ResponseBody
    public String deleteActivity(HttpServletRequest req,ModelMap map){
        int id =Integer.parseInt(req.getParameter("id")) ;
        try {
            activityService.deleteActivity(id);
        } catch (Exception e) {
            e.printStackTrace();
            return "false";
        }
        return "success";
    }

    @RequestMapping("/passwordlist")
    public String passwordList(PassWordQuery query,ModelMap map) {
        query.setPagesize(50);
        List<PassWord> list = activityService.selectPassWord(query);
        map.put("list",list);
        map.put("query",query);
        return "manager/passwordlist";
    }
    /**
     * 图文寻桃活动 生成密码
     */
    @RequestMapping("/createPwd")
    @ResponseBody
    public String createPwd(){

        PassWordQuery query = new PassWordQuery();
        query.setOrderby("createTime desc");//排序方式
        List<PassWord> list = activityService.selectPassWord(query);
        PassWord passWord = new PassWord();
        if(list==null||list.size()==0){
            String createTime = DateUtil.getDay()+" 00:00:00";
            String deadTime = DateUtil.getAfterDayDate(DateUtil.getDay(),"1")+" 12:00:00";
            passWord.setCreateTime(DateUtil.fomatDate1(createTime));
            passWord.setDeadTime(DateUtil.fomatDate1(deadTime));
        }else {
            String lastcreateTime=DateUtil.getStringDay(list.get(0).getCreateTime());
            String createTime = DateUtil.getAfterDayDate(lastcreateTime,"1")+" 00:00:00";
            String deadTime = DateUtil.getAfterDayDate(lastcreateTime,"2")+" 12:00:00";
            passWord.setCreateTime(DateUtil.fomatDate1(createTime));
            passWord.setDeadTime(DateUtil.fomatDate1(deadTime));
        }
        try {
            for(int j=0;j<3;j++){  //每日三条密码
                StringBuilder pwd = new StringBuilder();
                for(int i=0;i<5;i++){
                    int num = (int)(Math.random()*10);
                    pwd.append(num);
                }
                passWord.setPassword(pwd.toString());
                activityService.addPassWord(passWord);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "false";
        }
        return "success";
    }
}
