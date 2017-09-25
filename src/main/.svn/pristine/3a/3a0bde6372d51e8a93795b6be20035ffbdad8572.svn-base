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
    <li><a href="##" id="a_leader_txt">活动管理</a></li>
</ul>
<div class="admin">
    <form method="post" action="${ctx}/activity/activitylist.do" id="beanForm" >
        <div class="panel admin-panel">
            <div class="panel-head"><strong class="icon-reorder"> 活动管理</strong></div>
                 <div class="padding border-bottom">
                        <ul class="search">
                            <li>
                                <%--<button type="button"  class="button border-green" id="checkall"><span class="icon-check"></span> 全选</button>--%>
                                <a  onclick="window.location.href='${ctx}/activity/toadd.do'" class="button border-green"><span class="icon-trash-o"></span> 添加</a>
                            </li>
                        </ul>
                    </div>
            <table class="table table-hover text-center">
                <tr>
                    <th width="120">ID</th>
                    <th>活动名称</th>
                    <th>图片地址</th>
                    <th>跳转页面</th>
                    <th>上下线状态</th>
                    <th>创建日期</th>
                    <th width="15%">操作</th>
                </tr>
                <c:forEach items="${list}" var="var" varStatus="index">
                    <tr>
                    <td>${index.index+1}</td>
                    <td>${var.name}</td>
                    <td>${var.imgurl}</td>
                    <td>${var.activityurl}</td>
                    <td><c:if test="${var.status==1}">上线</c:if><c:if test="${var.status!=1}">下线</c:if></td>
                    <td><fmt:formatDate value="${var.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                    <td><div class="button-group"> <a class="button border-green" href="javascript:void(0)" onclick="update(${var.id})"><span class="icon-trash-o"></span> 修改</a> </div>&nbsp;&nbsp;
                        <div class="button-group"> <a class="button border-red" href="javascript:void(0)" onclick="del(${var.id})"><span class="icon-trash-o"></span> 删除</a> </div></td>
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
    function update(id){
        location.href='${ctx}/activity/toupdate.do?id='+id;
    }
    function del(id){
        if(confirm("您确定要删除吗?")){
            $.ajax({
                type:'get',
                url:'${ctx}/activity/delete.do?id='+id,
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