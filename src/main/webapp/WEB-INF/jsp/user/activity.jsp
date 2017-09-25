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
<div class='back' style="z-index:50"><img src='${ctx}/images/array.png' alt='goback'><a href="${ctx}/personal/topersonal.do?openid=${openid}">返回首页</a></div>
<div class="wrap wrap_task" style="padding-top:2rem">
    <ul class="tasklist">
        <c:forEach items="${list}" var="var">
            <li><c:if test="${var.status==1}">
                <a href="${var.activityurl}&openid=${openid}"><img style="height:10rem" src="${ctx}/${var.imgurl}"/></a>
                <a href="javascript:;" class="now">进行中</a></c:if>

                <c:if test="${var.status==0}">
                    <a><img src="${ctx}/${var.imgurl}?openid=${openid}"/></a>
                    <a href="javascript:;" class="end">已结束</a>
                </c:if>
            </li>
        </c:forEach>
    </ul>
</div>
</body>
</html>