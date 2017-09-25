<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page language="java" contentType="text/html; charset=utf-8"
        pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <title></title>
    <%@include file="common/common.jsp"%>
    <script src="<%=ctx%>/laydate/laydate.js"></script>
</head>
<body>
<%@include file="common/left.jsp"%>
<ul class="bread">
    <li><a href="${ctx}/usermanager/index.do"  class="icon-home"> 首页</a></li>
    <li><a href="##" id="a_leader_txt">用户兑换</a></li>
</ul>
<div class="admin">
    <form method="post" action="${ctx}/usermanager/processlist.do" id="beanForm" >
        <div class="panel admin-panel">
            <div class="panel-head"><strong class="icon-reorder"> 用户兑换</strong></div>
            <div class="padding border-bottom">
                <ul class="search">
                    <li>
                        <%--<button type="button"  class="button border-green" id="checkall"><span class="icon-check"></span> 全选</button>--%>
                            OPENID: <input type="text" name="openid" value="${query.openid}" class="button"> &nbsp;&nbsp;&nbsp;
                        手机号: <input type="text" name="phone" value="${query.phone}" class="button"> &nbsp;&nbsp;&nbsp;
                        <input placeholder="请输入日期" class="laydate-icon" value="<fmt:formatDate value="${query.startTime}" type="both" pattern="yyyy-MM-dd HH:mm:ss" />" onclick="laydate({istime: true, format: 'YYYY-MM-DD hh:mm:ss'})" name="startTime">&nbsp;
                        至：&nbsp;<input placeholder="请输入日期" class="laydate-icon" value="<fmt:formatDate value="${query.endTime}" type="both" pattern="yyyy-MM-dd HH:mm:ss" />" onclick="laydate({istime: true, format: 'YYYY-MM-DD hh:mm:ss'})" name="endTime">
                        &nbsp;&nbsp;&nbsp;<a class="button border-green" id="chaxun"><span class="icon-trash-o"></span>查询</a><a class="button border-green" id="export"><span class="icon-trash-o"></span>导出</a>

                    </li>
                </ul>
            </div>
            <table class="table table-hover text-center">
                <tr>
                    <th width="120">ID</th>
                    <th>OPENID</th>
                    <th>手机号</th>
                    <th>物品名</th>
                    <th>物品数量</th>
                    <th>获得方式</th>
                    <th>消耗桃子</th>
                    <th>兑换时间</th>
                </tr>
                <c:forEach items="${list}" var="var" varStatus="index">
                <tr>
                    <td>${index.index+1}</td>
                    <td>${var.openid}</td>
                    <td>${var.phone}</td>
                    <td>${var.goodsname}</td>
                    <td>${var.goodsnum}</td>
                    <td><c:if test="${var.gettype==0}">桃子兑换</c:if><c:if test="${var.gettype==1}">抽奖</c:if> </td>
                    <td>${var.costpeach}</td>
                    <td><fmt:formatDate value="${var.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                <tr>
                    </c:forEach>
                    <td colspan="8">
                        <%@include file="common/pageing.jsp"%>
                    </td>
                </tr>
            </table>
        </div>
    </form>
</div>
<form action="${ctx}/usermanager/exportprocess.do" method="post" id="exportform">
    <input type="hidden" name="openid" value="${query.openid}" class="button">
    <input type="hidden" name="phone" value="${query.phone}" class="button">
    <input type="hidden" name="startTime" value="<fmt:formatDate value="${query.startTime}" type="both" pattern="yyyy-MM-dd HH:mm:ss" />">
    <input type="hidden" name="endTime" value="<fmt:formatDate value="${query.endTime}" type="both" pattern="yyyy-MM-dd HH:mm:ss" />">
</form>
<script type="text/javascript">

    $(document).ready(function() {
        $("#chaxun").click(function() {
            $("#beanForm").submit();
        })
        $("#export").click(function() {
            $("#exportform").submit();
        })
    })

</script>
</body></html>