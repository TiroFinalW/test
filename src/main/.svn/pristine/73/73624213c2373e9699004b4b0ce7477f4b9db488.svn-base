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
</head>
<body>
<%@include file="common/left.jsp"%>
<ul class="bread">
    <li><a href="${ctx}/usermanager/index.do"  class="icon-home"> 首页</a></li>
    <li><a href="##" id="a_leader_txt">图文寻桃</a></li>
</ul>
<div class="admin">
    <form method="post" action="${ctx}/activity/passwordlist.do" id="beanForm" >
        <div class="panel admin-panel">
            <div class="panel-head"><strong class="icon-reorder"> 图文寻桃</strong></div>
            <div class="padding border-bottom">
                <ul class="search">
                    <li>
                        <%--<button type="button"  class="button border-green" id="checkall"><span class="icon-check"></span> 全选</button>--%>
                        <a class="button border-green"><span class="icon-trash-o"></span>生成密码</a>
                    </li>
                </ul>
            </div>
            <table class="table table-hover text-center">
                <tr>
                    <th width="120">ID</th>
                    <th>密码</th>
                    <th>有效时间</th>
                    <th>失效时间</th>
                </tr>
                <c:forEach items="${list}" var="var" varStatus="index">
                <tr>
                    <td>${index.index+1}</td>
                    <td>${var.password}</td>
                    <td><fmt:formatDate value="${var.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                    <td><fmt:formatDate value="${var.deadTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
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
<script type="text/javascript">
    $(".border-green").click(function () {
        $.ajax({
            url:'<%=ctx%>/activity/createPwd.do',
            dataType:'json',
            type:'post',
            success:function (data) {
                if(data=='success'){
                    alert("生成成功")
                }
                if(data=="false"){
                    alert("生成失败")
                }
                window.location.href='<%=ctx%>/activity/passwordlist.do'
            }
        })
    })

    $("#checkall").click(function(){
        $("input[name='id[]']").each(function(){
            if (this.checked) {
                this.checked = false;
            }
            else {
                this.checked = true;
            }
        });
    })


</script>
</body></html>