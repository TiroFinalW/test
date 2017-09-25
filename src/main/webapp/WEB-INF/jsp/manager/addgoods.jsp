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
       //     var rule=$("#rule").val().replace(/\n/g,'<br/>');
       //     $("#rule").val(rule);
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
    <li><a href="${ctx}/goods/goodslist.do" id="a_leader_txt">活动管理</a></li>
</ul>
<div class="admin">
    <div class="panel admin-panel">
        <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span><c:if test="${goods==null}">添加商品</c:if><c:if test="${goods!=null}">修改商品</c:if></strong></div>
        <div class="body-content">
            <c:if test="${goods==null}"> <form method="post" class="form-x" action="${ctx}/goods/doadd.do" enctype="multipart/form-data"> </c:if>
            <c:if test="${goods!=null}"> <form method="post" class="form-x" action="${ctx}/goods/doupdate.do" enctype="multipart/form-data"> </c:if>
                <div class="form-group">
                    <div class="label">
                        <label>商品名称：</label>
                    </div>
                    <div class="field">
                        <input type="text" class="input w50" value="${goods.name}" id="name" name="name" data-validate="required:请填写商品名称" />
                        <div class="tips"></div>
                    </div>
                </div>
                    <div class="form-group">
                        <div class="label">
                            <label>商品类型：</label>
                        </div>
                        <div class="field">
                            <select name="type" class="input">
                                <option value="1" <c:if test="${goods.type==1}">selected='selected'</c:if>>流量券</option>
                                <option value="2"<c:if test="${goods.type==2}">selected='selected'</c:if>>话费券</option>
                                <option value="3"<c:if test="${goods.type==3}">selected='selected'</c:if>>其他券</option>
                            </select>
                            <div class="tips"></div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="label">
                            <label>流量券/话费券面额：</label>
                        </div>
                        <div class="field">
                            <input type="text" class="input w50" value="${goods.value}" id="value" name="value"  onchange="if(/\D/.test(this.value)){alert('只能输入数字');this.value='';}" data-validate="required:请填写商品面额"/>
                            <div class="tips"></div>（流量券/话费券需填写 ）
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="label">
                            <label>商品价格：</label>
                        </div>
                        <div class="field">
                            <input type="text" class="input w50" <c:if test="${goods!=null}">value="${goods.price}"</c:if> <c:if test="${goods==null}">value="0"</c:if> id="price" name="price" data-validate="required:请填写商品价格" onchange="if(/\D/.test(this.value)){alert('只能输入数字');this.value='';}"/>
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
                <c:if test="${goods!=null}">
                    <div class="form-group">
                        <div class="label">
                            <label></label>
                        </div>
                        <div class="field">
                            <img src="${ctx}/${goods.image}" id="imgshow" style="height: 150px;width:150px">
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
                            <option value="1" <c:if test="${goods.status==1}">selected='selected'</c:if>>上架</option>
                            <option value="0"<c:if test="${goods.status!=1}">selected='selected'</c:if>>下架</option>
                        </select>
                        <div class="tips"></div>
                    </div>
                </div>
                    <div class="form-group">
                        <div class="label">
                            <label>商品数量：</label>
                        </div>
                        <div class="field">
                            <input type="text" class="input w50" value="${goods.number}" id="number" name="number" data-validate="required:请填写商品数量" onchange="if(/\D/.test(this.value)){alert('只能输入数字');this.value='';}" />
                            <div class="tips"></div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="label">
                            <label>每月可兑换数量：</label>
                        </div>
                        <div class="field">
                            <input type="text" class="input w50" value="${goods.exchangecount}" id="exchangecount" name="exchangecount" data-validate="required:请填写可兑换数量" onchange="if(/\D/.test(this.value)){alert('只能输入数字');this.value='';}" />
                            <div class="tips"></div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="label">
                            <label>兑换规则：</label>
                        </div>
                        <div class="field">
                            <textarea class="input" id="rule" name="rule" style="height:300px; border:1px solid #ddd;">${goods.rule}</textarea>
<%--                            <input type="text" class="input w50" value="${goods.rule}" id="rule" name="rule" data-validate="required:请填写兑换规则" />--%>
                            <div class="tips"></div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="label">
                            <label>序号：</label>
                        </div>
                        <div class="field">
                            <input type="text" class="input w50" value="${goods.sort}" id="sort" name="sort" data-validate="required:请填写序号" onchange="if(/\D/.test(this.value)){alert('只能输入数字');this.value='';}" />
                            <div class="tips"></div>
                        </div>
                    </div>

                <div class="form-group">
                    <div class="label">
                        <label></label>
                    </div>
                    <div class="field">
                        <input type="hidden" name="id" value="${goods.id}">
                        <a class="button bg-main icon-check-square-o" id="sub"> 提交</a>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
</body></html>