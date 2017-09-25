package com.jielan.controller.backstage;

import com.jielan.model.Notice;
import com.jielan.model.query.NoticeQuery;
import com.jielan.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by wang on 2016/12/26.
 * 公告管理
 */
@Controller
@RequestMapping("notice")
public class NoticeController {

    @Autowired
    private NoticeService noticeService;

    @RequestMapping("/noticelist")
    public String noticeList(NoticeQuery query,ModelMap map){
        List<Notice> list = noticeService.selectNotice(query);
        map.put("list",list);
        map.put("query",query);
        return "manager/noticelist";
    }
    @RequestMapping("/toadd")
    public String toAddNotice(){
        return "manager/addnotice";
    }

    /**
     * 添加活动
     * @return
     */
    @RequestMapping("/doadd")
    public String addActivity(Notice notice){
        try {
            noticeService.addNotice(notice);
        } catch (Exception e) {
            e.printStackTrace();
            return "false";
        }
        return "redirect:/notice/noticelist.do";
    }

    /**
     *去修改活动页面
     */
    @RequestMapping("/toupdate")
    public String toUpdate(HttpServletRequest req, ModelMap map){
        int id =Integer.parseInt(req.getParameter("id")) ;
        Notice notice = noticeService.selectById(id);
        map.put("notice",notice);
        return "manager/addnotice";
    }

    /**
     * 修改活动
     * @return
     */
    @RequestMapping("/doupdate")
    public String doUpdate(Notice notice,HttpServletRequest req){
        try {
            noticeService.updateNotice(notice);
        } catch (Exception e) {
            e.printStackTrace();
            return "false";
        }
        return "redirect:/notice/noticelist.do";
    }

    @RequestMapping("/delete")
    @ResponseBody
    public String deleteActivity(HttpServletRequest req,ModelMap map){
        int id =Integer.parseInt(req.getParameter("id")) ;
        try {
            noticeService.deleteNotice(id);
        } catch (Exception e) {
            e.printStackTrace();
            return "false";
        }
        return "success";
    }
}
