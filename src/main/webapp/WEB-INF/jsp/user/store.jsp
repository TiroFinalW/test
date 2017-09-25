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
    <script src="${ctx}/js/jQueryRotate.2.2.js"></script>
    <script type="text/javascript" src="${ctx}/js/store.js"></script>
    <title>湖州移动会员积分平台</title>
    <script>
        var s = document.documentElement.clientWidth;
        document.documentElement.style.fontSize = s/25+ "px";
    </script>
</head>
<body>
<div class='back'><img src='${ctx}/images/array.png' alt='goback'><a href="${ctx}/personal/topersonal.do?openid=${openid}">返回首页</a></div>
<div class="wrap wrap3">
    <div class="store" style="padding-top:2rem">
        <div class="store_head">
            <div class="store_title">兑换商城</div>
        </div>
        <div class="store_body">
            <c:forEach items="${goodslist}" var="var">
                <div class="store_body2">
                    <img src="${ctx}/${var.image}" class="exchange_img1">
                    <div class="exchange_info1">${var.name}</div>
                    <div class="exchange_info2"><img src="${ctx}/images/coin_a.png" class="coin_a">${var.price}<a class="exchange_btn" onclick="location.href='${ctx}/process/toexchange.do?goodsid=${var.id}&&openid=${openid}'">兑换</a></div>
                </div>
            </c:forEach>
        </div>
    </div>
    <div class="game">
        <div class="game_head">
            <div class="game_title">幸运抽奖</div>
        </div>
        <div class="game_info">5个桃，抽一次，以小博大，拼的就是人品</div>
        <div class="game_body">
            <img src="${ctx}/images/zhuanpan.png" class="mes"/>
            <div class="zhizhen">
                <img src="${ctx}/images/zhizhen.png" id="zhuan"/>
            </div>
        </div>
    </div>
</div>
<input type="hidden" id="openid" value="${openid}">
<div class="popup_tip">
    <div class="kuang_tip"></div>
</div>
</body>
</html>