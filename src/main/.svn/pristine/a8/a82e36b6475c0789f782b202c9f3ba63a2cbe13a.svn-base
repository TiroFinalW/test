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
    <li><a href="##" id="a_leader_txt">商品管理</a></li>
</ul>
<div class="admin">
    <form method="post" action="${ctx}/goods/goodslist.do" id="beanForm" >
    <div class="panel admin-panel">
        <div class="panel-head"><strong class="icon-reorder"> 商品管理</strong></div>
        <div class="padding border-bottom">
            <ul class="search">
                <li>
                    <a  onclick="window.location.href='${ctx}/goods/toadd.do'" class="button border-green"><span class="icon-trash-o"></span> 添加</a>
                </li>
            </ul>
        </div>
        <table class="table table-hover text-center">
            <tr>
                <th width="120">ID</th>
                <th>商品名称</th>
                <th>商品类型</th>
                <th>消耗桃子</th>
                <th>话费流量券面额</th>
                <th>剩余数量</th>
                <th>每月可兑换数量</th>
                <th>上下架状态</th>
                <th>时间</th>
                <th>操作</th>
            </tr>
            <c:forEach items="${list}" var="var" varStatus="index">
            <tr>
                <td>${index.index+1}</td>
                <td>${var.name}</td>
                <td><c:if test="${var.type==1}">流量券</c:if><c:if test="${var.type==2}">话费券</c:if><c:if test="${var.type==3}">其它券 </c:if></td>
                <td>${var.price}</td>
                <td>${var.value}</td>
                <td>${var.number}</td>
                <td>${var.exchangecount}</td>
                <td><c:if test="${var.status==1}">上架</c:if><c:if test="${var.status!=1}">下架</c:if></td>
                <td><fmt:formatDate value="${var.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                <td><div class="button-group"> <a class="button border-green" href="javascript:void(0)" onclick="update(${var.id})"><span class="icon-trash-o"></span> 修改</a> </div>&nbsp;&nbsp;
                    <div class="button-group"> <a class="button border-red" href="javascript:void(0)" onclick="del(${var.id})"><span class="icon-trash-o"></span> 删除</a> </div></td>
            <tr>
                </c:forEach>
                 <td colspan="8">
                        <%@include file="common/pageing.jsp"%>
                 </td>
        </table>
    </div>
</form>
    </div>
<script type="text/javascript">
    function update(id){
        location.href='${ctx}/goods/toupdate.do?id='+id;
    }
    function del(id){
        if(confirm("您确定要删除吗?")){
            $.ajax({
                type:'get',
                url:'${ctx}/goods/delete.do?id='+id,
                success:function(data){
                    if(data=='success'){
                        alert('删除成功');
                    }
                    if(data=='false'){
                        alert('删除失败');
                    }
                    location.reload()
                }
            })
        }
    }

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

    function DelSelect(){
        var Checkbox=false;
        $("input[name='id[]']").each(function(){
            if (this.checked==true) {
                Checkbox=true;
            }
        });
        if (Checkbox){
            var t=confirm("您确认要删除选中的内容吗？");
            if (t==false) return false;
        }
        else{
            alert("请选择您要删除的内容!");
            return false;
        }
    }

</script>
</body></html>