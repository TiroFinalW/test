package com.jielan.controller.backstage;

import com.jielan.model.MyGoods;
import com.jielan.model.SignRecord;
import com.jielan.model.query.MyGoodsQuery;
import com.jielan.model.query.SignRecordQuery;
import com.jielan.service.InfoService;
import com.jielan.service.MyGoodsService;
import com.jielan.service.SignService;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by wang on 2016/12/12.
 *
 *后台  用户相关（查看用户记录，数据s）
 */
@RequestMapping("usermanager")
@Controller
public class UserManagerController {

    @Autowired
    private MyGoodsService myGoodsService;

    @Autowired
    private SignService signService;

    @Autowired
    private InfoService infoService;

    @RequestMapping("/tologin")
    public String toLogin(){
        return "manager/login";
    }

    @RequestMapping("/dologin")
    public String doLogin(HttpServletRequest request){
        String username=request.getParameter("username").trim();
        String password=request.getParameter("password").trim();
        if(("huzhouqiandao2017".equals(username)&&"hzqd123".equals(password))||("huzhouyidong2017".equals(username)&&"hzyd123".equals(password))){
            request.getSession().setAttribute("UserInfo",username);
            return "manager/index";
        }else{
            return "redirect:/usermanager/tologin.do";
        }
    }


    @RequestMapping("/index")
    public String toIndex(){
        System.out.println("controller执行");
        return"manager/index";
    }

    /**
     *用户签到记录
     */
    @RequestMapping("/signlist")
    public String signList(SignRecordQuery query, ModelMap map){
        query.setPagesize(50);
        query.setOrderby("signtime desc");
        List<SignRecord> list = signService.selectSignRecordPage(query);//分页
        map.put("list",list);
        map.put("query",query);
        return"manager/signlist";
    }

    /**
     * 用户兑换记录
     */
    @RequestMapping("/processlist")
    public String processlist(MyGoodsQuery query,ModelMap map){
        query.setPagesize(50);
        List<MyGoods> list = myGoodsService.selectMyGoods(query);//分页
        map.put("list",list);
        map.put("query",query);
        return"manager/processlist";
    }

    /**
     * 签到数据展示
     * @param request
     * @return
     */
    @RequestMapping("/signinfo")
    public String signInfo(HttpServletRequest request,ModelMap map){
        String startTime = request.getParameter("startTime");
        String endTime = request.getParameter("endTime");

        int alluser = infoService.countUser();//总用户人数
        int allsignuser = infoService.countSignUser(null,null);//总签到过的人数
        int signtimes = infoService.countSignTimes(null,null);//总签到次数
        int peachuser = infoService.countFindPeachUser(null,null);//总寻桃人数
        int peachtimes = infoService.countFindPeach(null,null);//总寻桃次数

        int queryallsignuser = infoService.countSignUser(startTime,endTime);
        int querysigntimes = infoService.countSignTimes(startTime,endTime);
        int querypeachuser = infoService.countFindPeachUser(startTime,null);
        int querypeachtimes = infoService.countFindPeach(startTime,null);

        map.put("alluser",alluser);
        map.put("allsignuser",allsignuser);
        map.put("signtimes",signtimes);
        map.put("peachuser",peachuser);
        map.put("peachtimes",peachtimes);

        map.put("queryallsignuser",queryallsignuser);
        map.put("querysigntimes",querysigntimes);
        map.put("querypeachuser",querypeachuser);
        map.put("querypeachtimes",querypeachtimes);

        map.put("startTime",startTime);
        map.put("endTime",endTime);
        return "manager/signinfo";
    }


    @RequestMapping("/exportsign")
    public void exportsign(SignRecordQuery query, HttpServletRequest request, HttpServletResponse httpResponse){
        String[] title = new String[] {"OPENID","手机号","签到类型","获得桃子","签到时间"};
        List<SignRecord> list = signService.exportSignRecord(query);
        try {
            httpResponse.setContentType("application/vnd.ms-excel");
            httpResponse.setHeader("Content-Disposition", "attachment; filename=\"" + new String("用户签到.xls".getBytes("utf-8"), "iso8859-1") + "\"");

            WritableWorkbook wwb = Workbook.createWorkbook(httpResponse.getOutputStream());

            WritableSheet ws = wwb.createSheet("sheet1", 0);

            int columnCount = title.length;
            for (int i = 0; i < columnCount; i++) {
                Label lab = new Label(i, 0, title[i]);
                try {
                    ws.addCell(lab);
                } catch (RowsExceededException e) {
                    throw new RuntimeException(e);
                } catch (WriteException e) {
                    throw new RuntimeException(e);
                }
            }
            for (int i = 0; i < list.size(); i++) {
                ws.addCell(new Label(0, i+1, list.get(i).getOpenid()));
                ws.addCell(new Label(1, i+1, list.get(i).getPhone()));
                ws.addCell(new Label(2, i+1, list.get(i).getType()==0?"签到":"补签"));
                ws.addCell(new Label(3, i+1, list.get(i).getPeach()+""));
                ws.addCell(new Label(4, i+1, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(list.get(i).getSigntime())));
            }
            wwb.write();
            wwb.close();
        } catch (RowsExceededException e) {
        } catch (WriteException e) {
        } catch (Exception e) {
        }

    }
    @RequestMapping("/exportprocess")
    public void exportprocess(MyGoodsQuery query, HttpServletRequest request, HttpServletResponse httpResponse){
        String[] title = new String[] {"OPENID","手机号","物品名","数量","获得方式","消耗桃子","兑换时间"};
        List<MyGoods> list=myGoodsService.exportMyGoods(query);
        try {
            httpResponse.setContentType("application/vnd.ms-excel");
            httpResponse.setHeader("Content-Disposition", "attachment; filename=\"" + new String("兑换商品.xls".getBytes("utf-8"), "iso8859-1") + "\"");

            WritableWorkbook wwb = Workbook.createWorkbook(httpResponse.getOutputStream());

            WritableSheet ws = wwb.createSheet("sheet1", 0);

            int columnCount = title.length;
            for (int i = 0; i < columnCount; i++) {
                Label lab = new Label(i, 0, title[i]);
                try {
                    ws.addCell(lab);
                } catch (RowsExceededException e) {
                    throw new RuntimeException(e);
                } catch (WriteException e) {
                    throw new RuntimeException(e);
                }
            }
            for (int i = 0; i < list.size(); i++) {
                ws.addCell(new Label(0, i+1, list.get(i).getOpenid()));
                ws.addCell(new Label(1, i+1, list.get(i).getPhone()));
                ws.addCell(new Label(2, i+1, list.get(i).getGoodsname()));
                ws.addCell(new Label(3, i+1, list.get(i).getGoodsnum()+""));
                ws.addCell(new Label(4, i+1, list.get(i).getGettype()==0?"兑换":"抽奖"));
                ws.addCell(new Label(5, i+1, list.get(i).getCostpeach()+""));
                ws.addCell(new Label(6, i+1, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(list.get(i).getCreateTime())));
            }
            wwb.write();
            wwb.close();
        } catch (RowsExceededException e) {
        } catch (WriteException e) {
        } catch (Exception e) {
        }
    }
}
