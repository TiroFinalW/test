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
<script type="text/javascript">
    $(document).ready(function(){
        $("#sub").click(function (){
            var sort=$("#sort").val();
            var ex = /^\d+$/;
            if (!ex.test(sort)) {
                alert("请输入正整数")
                return false;
            }
            $( ".form-x" ).submit();
        })
    })

</script>
<body>
<%@include file="common/left.jsp"%>
<ul class="bread">
    <li><a href="${ctx}/usermanager/index.do"  class="icon-home"> 首页</a></li>
    <li><a href="${ctx}/notice/noticelist.do" id="a_leader_txt">公告管理</a></li>
</ul>
<div class="admin">
    <div class="panel admin-panel">
        <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span><c:if test="${notice==null}">添加公告</c:if><c:if test="${notice!=null}">修改公告</c:if></strong></div>
        <div class="body-content">
            <c:if test="${notice==null}"> <form method="post" class="form-x" action="${ctx}/notice/doadd.do" > </c:if>
            <c:if test="${notice!=null}"> <form method="post" class="form-x" action="${ctx}/notice/doupdate.do"> </c:if>
                <div class="form-group">
                    <div class="label">
                        <label>公告内容：</label>
                    </div>
                    <div class="field">
                        <input type="text" class="input w50" value="${notice.content}" id="content" name="content" data-validate="required:请填写公告内容" />
                        <div class="tips"></div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="label">
                        <label>状态：</label>
                    </div>
                    <div class="field">
                        <select name="status" class="input">
                            <option value="1" <c:if test="${notice.status==1}">selected='selected'</c:if>>显示</option>
                            <option value="0"<c:if test="${notice.status!=1}">selected='selected'</c:if>>不显示</option>
                        </select>
                        <div class="tips"></div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="label">
                        <label>排序序号：</label>
                    </div>
                    <div class="field">
                        <input type="text" class="input w50"  id="sort" name="sort" value="${notice.sort}" style=" height:90px;" data-validate="required:请填排序序号" >
                        <div class="tips"></div>
                    </div>
                </div>

                <div class="form-group">
                    <div class="label">
                        <label></label>
                    </div>
                    <div class="field">
                        <c:if test="${notice!=null}"><input type="hidden" name="id" value="${notice.id}"></c:if>
                        <a class="button bg-main icon-check-square-o" id="sub"> 提交</a>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
</body></html>