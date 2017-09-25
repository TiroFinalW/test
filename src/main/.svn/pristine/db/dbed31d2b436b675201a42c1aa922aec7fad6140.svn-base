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
    <script type="text/javascript">
        $(document).ready(function(){
            $("#chaxun").click(function(){
                $("#beanForm").submit();
            })
        })
    </script>
</head>
<body>
<%@include file="common/left.jsp"%>
<ul class="bread">
    <li><a href="${ctx}/usermanager/index.do"  class="icon-home"> 首页</a></li>
    <li><a href="##" id="a_leader_txt">签到寻桃数据</a></li>
</ul>
<div class="admin">
    <form method="post" action="${ctx}/usermanager/signinfo.do" id="beanForm" >
        <div class="panel admin-panel">
            <div class="panel-head"><strong class="icon-reorder"> 签到寻桃数据</strong></div>
            <div class="padding border-bottom">
            </div>
            <table class="table table-hover text-center">
                <tr>
                    <th>上线至今总用户数</th>
                    <th>上线至今签到人数</th>
                    <th>上线至今签到次数</th>
                    <th>上线至今寻桃人数</th>
                    <th>上线至今寻桃次数</th>
                </tr>
                <tr>
                    <td>${alluser}</td>
                    <td>${allsignuser}</td>
                    <td>${signtimes}</td>
                    <td>${peachuser}</td>
                    <td>${peachtimes}</td>
                </tr>
            </table>
        </div>
            <div style="height: 100px">

            </div>
        <div class="panel admin-panel">
            <div class="padding border-bottom">
            <input placeholder="请输入日期" class="laydate-icon" value="${startTime}"  onclick="laydate({istime: true, format: 'YYYY-MM-DD hh:mm:ss'})" name="startTime">&nbsp;
            至：&nbsp;<input placeholder="请输入日期" class="laydate-icon" value="${endTime}" onclick="laydate({istime: true, format: 'YYYY-MM-DD hh:mm:ss'})" name="endTime">
            &nbsp;&nbsp;&nbsp;<a class="button border-green" id="chaxun"><span class="icon-trash-o"></span>查询</a>
                </div>
            <table class="table table-hover text-center">
                <tr>
                    <th>某时间段签到人数</th>
                    <th>某时间段签到次数</th>
                    <th>某时间段寻桃人数</th>
                    <th>某时间段寻桃次数</th>
                </tr>
                <tr>
                    <td>${queryallsignuser}</td>
                    <td>${querysigntimes}</td>
                    <td>${querypeachuser}</td>
                    <td>${querypeachtimes}</td>
                </tr>
            </table>
        </div>
    </form>
</div>
</body></html>