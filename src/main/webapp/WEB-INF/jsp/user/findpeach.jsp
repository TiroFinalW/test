<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
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
    <script type="text/javascript" src="${ctx}/js/search.js"></script>
    <title>湖州移动会员积分平台</title>
    <script>
        var s = document.documentElement.clientWidth;
        document.documentElement.style.fontSize = s/25+ "px";
    </script>
</head>
<body>
<div class='back'><img src='${ctx}/images/array.png' alt='goback'><a href="${ctx}/personal/topersonal.do?openid=${user.openid}">返回首页</a></div>
<div class="wrap wrap4" style="padding-top: 2rem">
    <img src="${ctx}/images/search_head.png" alt="search_img" class="search_img">
    <div class="peach_num peach_num1"  style="padding-top: 2rem"><span id="peach_num">${user.peach}</span>个</div>
    <img src="${ctx}/images/search_title.png" >
    <div class="search_game">
        <div class="search_info">
            每天发送的图文里藏着寻桃密码，随机额外获赠桃子，去找出来吧！
        </div>
        <input type="text" class="code" id="password" maxlength="5" placeholder="请输入寻桃密码">
        <input type="button" value="确定" class="sure">
    </div>
    <div class="search_rule">
        偷偷告诉你：<br>
        1、输入正确的密码，就能随机获赠1~2个不等的桃子哦！<br>
        2、密码藏在湖州移动官微每天推送的文章里。<br>
        3、速度要快哦，当日公布的密码，到了次日中午12点就自动失效咯~
    </div>
</div>
<div class="popup_tip">
    <div class="kuang_tip"></div>
</div>
<input type="hidden" id="openid" value="${user.openid}">
<script>
    var h=document.documentElement.clientHeight||document.body.clientHeight;
    document.getElementsByClassName("wrap")[0].style.height=h+"px";
</script>
</body>
</html>