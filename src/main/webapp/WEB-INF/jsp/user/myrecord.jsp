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
    <link rel="stylesheet" href="${ctx}/css/style.css">
    <title>湖州移动会员积分平台</title>
    <script>
        var s = document.documentElement.clientWidth;
        document.documentElement.style.fontSize = s/25+ "px";
    </script>
</head>

<body>
<div class='back'><img src='${ctx}/images/array.png' alt='goback'><a href="${ctx}/personal/topersonal.do?openid=${openid}">返回首页</a></div>
<div class="rewrap" id="rewrap" style="padding-top: 2rem">
    <ul class="record">
        <c:forEach items="${list}" var="var">
            <li class="movie">
                <p><fmt:formatDate value="${var.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></p>
                <div class="recontent myclear">
                    <img class="relogo" src="${ctx}/images/movie.png"/>
                    <div class="top myclear">
                        <em>${var.goodsname}</em>
                        <img class="recoin" src="${ctx}/images/moviecoin.png"/>
                        <strong>${var.costpeach}</strong>
                        <b>${var.goodsnum}张</b>
                    </div>
                </div>
            </li>
        </c:forEach>
    </ul>

</div>



</body>
</html>