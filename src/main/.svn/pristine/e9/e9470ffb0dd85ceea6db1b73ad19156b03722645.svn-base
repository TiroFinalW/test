<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!doctype html>
<%String ctx = request.getContextPath();
    request.getSession().setAttribute("ctx",ctx);
%>
<html>
<head>
    <meta http-equiv="Content-type" content="text/html;charset=utf-8">
    <meta name="viewport" content="width=device-width,initial-scale=1.0,maximum-scale=1.0,minimum-scale=1.0, user-scalable=no">
    <meta name="apple-mobile-web-app-capable" content="yes" />
    <meta name="apple-mobile-web-app-status-bar-style" content="black" />
    <meta name = "format-detection" content = "telephone=no">
    <link rel="stylesheet" href="${ctx}/css/style1.css">
    <title>湖州移动会员积分平台</title>
    <script>
        var s = document.documentElement.clientWidth;
        document.documentElement.style.fontSize = s/25+ "px";
    </script>
</head>

<body>
<div class='back'><img src='${ctx}/images/array.png' alt='goback'><a href="${ctx}/personal/topersonal.do?openid=${user.openid}">返回首页</a></div>
<div class="wrap" id="wrap" style="padding-top: 2rem">
    <div class="coheader">
        <p class="myclear"><img src="${ctx}/images/coin1.png"/> <span>我的桃子</span></p>
        <em>${user.peach}</em>
        <a href="${ctx}/process/store.do?openid=${user.openid}">兑换商城</a>
        <div class="headcoininfo myclear">

        </div>
    </div>
    <div class="detitle myclear">
        <em></em><b>收支明细</b>
    </div>
    <ul class="detail myclear">
        <c:forEach items="${list}" var="var">
            <li>
                <p>
                    <em><c:if test="${var.way==0}">签到一次</c:if><c:if test="${var.way==1}">补签一次</c:if><c:if test="${var.way==3}">抽奖一次</c:if><c:if test="${var.way==4}">图文寻桃</c:if>
                        <c:if test="${var.way==5}">人人转发</c:if><c:if test="${var.way==2}">商品兑换（${var.goods}${var.goodsnum}张）</c:if>
                    </em>
            <span>时间：<fmt:formatDate value="${var.exchangeDate}" pattern="yyyy-MM-dd HH:mm:ss"/></span>
                </p>
            <c:if test="${var.type==1}"><b class="shou">+${var.peach}</b></li></c:if>
            <c:if test="${var.type==0}"><b class="zhi">-${var.peach}</b></li></c:if>
            </li>
        </c:forEach>
    </ul>
</div>
</body>
</html>