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
            var filename=$("#image1").val();
            if(filename!=''&&filename!=null){
                var str = filename.substring(filename.indexOf('.')+1);
                if(str!=""&&str !="jpeg" && str !="JPEG" && str !="BMP" && str !="bmp" && str !="PNG" && str !="png" && str !="jpg" && str !="JPG"){
                    alert("图片的格式只能为 jpg、jpeg、bmp、png!");
                    return false;
                }
            }
            if(($("#image1").val()==''||$("#image1").val()==null)&&($("#imgshow").attr("src")==''||$("#imgshow").attr("src")==null)){
                alert("请选择图片")
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
    <li><a href="${ctx}/activity/activitylist.do" id="a_leader_txt">活动管理</a></li>
</ul>
<div class="admin">
<div class="panel admin-panel">
    <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span><c:if test="${activity==null}">添加活动</c:if><c:if test="${activity!=null}">修改活动</c:if></strong></div>
    <div class="body-content">
        <c:if test="${activity==null}"> <form method="post" class="form-x" action="${ctx}/activity/doadd.do" enctype="multipart/form-data"> </c:if>
        <c:if test="${activity!=null}"> <form method="post" class="form-x" action="${ctx}/activity/doupdate.do" enctype="multipart/form-data"> </c:if>
            <div class="form-group">
                <div class="label">
                    <label>活动名称：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" value="${activity.name}" id="name" name="name" data-validate="required:请填写活动名称" />
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>图片：</label>
                </div>
                <div class="field">
                    <input type="file" class="button bg-blue margin-left" id="image1" name="file" style="float:left;">
                    <div class="tipss">图片尺寸：500*300</div>
                </div>
            </div>
                <c:if test="${activity!=null}">
                <div class="form-group">
                    <div class="label">
                        <label></label>
                    </div>
                    <div class="field">
                        <img src="${ctx}/${activity.imgurl}" id="imgshow" style="height: 150px;width:150px">
                        <div class="tips"></div>
                    </div>
                 </div>
                </c:if>
                <div class="form-group">
                    <div class="label">
                        <label>状态：</label>
                    </div>
                    <div class="field">
                        <select name="status" class="input">
                            <option value="1" <c:if test="${activity.status==1}">selected='selected'</c:if>>上线</option>
                            <option value="0"<c:if test="${activity.status!=1}">selected='selected'</c:if>>下线</option>
                        </select>
                        <div class="tips"></div>
                    </div>
                </div>
            <div class="form-group">
                <div class="label">
                    <label>活动链接：</label>
                </div>
                <div class="field">
                    <input type="text" class="input" id="activityurl" name="activityurl" value="${activity.activityurl}" style=" height:90px;" data-validate="required:请填写活动链接" >
                    <div class="tips"></div>
                </div>
            </div>

            <div class="form-group">
                <div class="label">
                    <label></label>
                </div>
                <div class="field">
                    <input type="hidden" name="id" value="${activity.id}">
                    <a class="button bg-main icon-check-square-o" id="sub"> 提交</a>
                </div>
            </div>
        </form>
    </div>
</div>
</div>
</body></html>