<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!doctype html>
<%String ctx = request.getContextPath();
    request.getSession().setAttribute("ctx",ctx);
%>
<html lang="en">
<head>
    <meta http-equiv="Content-type" content="text/html;charset=utf-8">
    <meta name="viewport" content="width=device-width,initial-scale=1.0,maximum-scale=1.0,minimum-scale=1.0, user-scalable=no">
    <meta name="apple-mobile-web-app-capable" content="yes" />
    <meta name="apple-mobile-web-app-status-bar-style" content="black" />
    <meta name = "format-detection" content = "telephone=no">
    <meta name="msapplication-tap-highlight" content="no"/>
    <link rel="stylesheet" href="${ctx}/css/style.css">
    <script type="text/javascript" src="${ctx}/js/jquery-1.10.1.min.js"></script>
    <script type="text/javascript" src="${ctx}/js/signin.js"></script>
    <title>湖州移动会员积分平台</title>
    <script>
        $(document).ready(function(){
            $("#signin_today").click(function(){
                $("#signin_today").attr("disabled","true")
            })
        })
        var s = document.documentElement.clientWidth;
        document.documentElement.style.fontSize = s/25+ "px";
    </script>
</head>
<body>
<div class='back'><img src='${ctx}/images/array.png' alt='goback'><a href="${ctx}/personal/topersonal.do?openid=${user.openid}">返回首页</a></div>
<div class="wrap wrap1" style="padding-top: 2rem">
    <img src="${ctx}/images/signin_head.png" alt="head_image" class="head_img">
    <div class="peach_num" style="padding-top: 2rem"><span id="peach_num"><fmt:formatNumber type="number" value="${user.peach} " maxFractionDigits="2"/></span>个</div>
    <div class="signin_info" style="padding-top: 2rem">您已连续签到${user.sigin_count}天，明天签到可获得${user.nextpeach}个桃</div>
    <c:if test="${status==0}"><button onclick="window.location.href='${ctx}/sign/dosign.do?openid=${user.openid}'" class="signin_today" id="signin_today">今日签到+1</button></c:if>
    <c:if test="${status==1}"><button class="signin_today" style="background-color: rgb(204, 204, 204);">明日签到+1</button></c:if>
    <div class="calendar">
        <div class="cal_head">
            <div class="cal_title">签到日历</div>
        </div>
        <div class="cal_body">
            <div class="calendar_h">
                <a href="javascript:;" class="btnL"><img src="${ctx}/images/left.png"/></a>
                <p id="p1">2016-3-21</p>
                <a href="javascript:;" class="btnR"><img src="${ctx}/images/right.png"/></a>
            </div>
            <ul id="list">

            </ul>
        </div>
        <div class="buqian">
            <div class="bu1">我有<span id="buqian_num">${user.retroactiveCard}</span>张补签卡</div>
            <div class="bu2">补签</div>
        </div>
    </div>
</div>
<div class="popup_mask">
    <div class="kuang_buqian1">
        <div class="buqian1_1">此次补签将消耗一张补签卡</div>
        <div class="flex">
            <div class="buqian1_2">确定</div>
            <div class="buqian1_3">取消</div>
        </div>
    </div>
    <div class="kuang_buqian2">
        <div class="buqian2_1">消耗10个桃补签一次</div>
        <div class="flex">
            <div class="buqian2_2">确定</div>
            <div class="buqian2_3">取消</div>
        </div>
    </div>
</div>
<div class="popup_tip">
    <div class="kuang_tip"></div>
</div>
<div id="siginTime" style="display: none;" >
    <c:forEach items="${list}" var="var">
        <input  value="<fmt:formatDate value='${var.signtime}' pattern='MM-dd'/>-${var.type }">
    </c:forEach>
</div>
<input type="hidden" id="openid" value="${user.openid}"/>
</body>
</html>