<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
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
    <link rel="stylesheet" href="${ctx}/css/style1.css">
    <script src="${ctx}/js/jquery-1.10.1.min.js"></script>
    <title>湖州移动会员积分平台</title>
    <script>
        var s = document.documentElement.clientWidth;
        document.documentElement.style.fontSize = s/25+ "px";
    </script>
    <script>
        window.onload=function(){
            var close=document.getElementById("close");
            var chongzhi=document.getElementById("chongzhi");
            var confirm=document.getElementById("confirm");
            var close1=document.getElementById("close1");
            var mask1=document.getElementById("mask1");
            var mask2=document.getElementById("mask2");
            chongzhi.onclick=function(){
                mask1.style.display="block";
            }
            close.onclick=function(){
                mask1.style.display="none";
            }
            close1.onclick=function(){
                mask2.style.display="none";
            }
            var rule = $("#rule").text();
            $("#rule").html(rule.replace(/\n/g,'<br/>'))

            var flag=false;
            confirm.onclick=function(){
                if(flag){  //防止重复点击
                    return false;
                }
                flag=true;
                var sum =$(".feiright p").text();
                var num =$("#quantity").val() ;
                $.ajax({
                    url:'${ctx}/process/doexchange.do?openid=${openid}&goodsid=${goods.id}',
                    type:'get',
                    dataType:'json',
                    data:{'sum':sum,'num':num},
                    success:function (data) {
                        if(data.returnCode!="1"){
                            alert(data.returnMsg)
                            flag=false;
                        }
                        if(data.returnCode=="1"){
                            mask2.style.display="block";
                            mask1.style.display="none";
                            flag=false;
                        }
                    },
                    error:function(){
                        alert("系统异常")
                        flag=false;
                    }
                })
            }

            var text1=$(".special em ").eq(0).text();
            var text2=$(".special em ").eq(1).text();
            $("#feiright p").text(text1)

//            $("input").click(function(){
//                var flag=$('input[name="radio"]:checked ').val();
//                if(flag==1){
//                    $("#feiright p").text(text1)
//                }else{
//                    $("#feiright p").text(text2)
//                }
//
//            });
        };
        function numAdd(){
            var quantity = document.getElementById("quantity").value;//数量
            //var singlePrice=$(".special em").text();
            var text1=$(".special em ").eq(0).text();
            var text2=$(".special em ").eq(1).text();

            var flag=$('input[name="radio"]:checked ').val();
            if(flag==1){
                var singlePrice=text1;//单价
                var num_add = parseInt(quantity)+1;//数量+1
                var price=parseFloat(num_add)*parseFloat(singlePrice);//改变价格
                if(quantity==""){
                    num_add = 1;
                }
                document.getElementById("quantity").value=num_add;
                $(".feiright p").text(price);
            }else{
                var singlePrice=text2;//单价
                var num_add = parseInt(quantity)+1;//数量+1
                var price=parseFloat(num_add)*parseFloat(singlePrice);//改变价格
                if(quantity==""){
                    num_add = 1;
                }
                document.getElementById("quantity").value=num_add;
                $(".feiright p").text(price);
            }

        }
        function numDec(){
            //var quantity = document.getElementById("quantity").value;
            //var num_dec = parseInt(quantity)-1;
            //if(num_dec>0){
            //	document.getElementById("quantity").value=num_dec;
            //}
            var quantity = document.getElementById("quantity").value;
            //var singlePrice=$(".special em").text();
            var text1=$(".special em ").eq(0).text();
            var text2=$(".special em ").eq(1).text();

            var flag=$('input[name="radio"]:checked ').val();
            if(flag==1){
                var num_dec = parseInt(quantity)-1;
                var singlePrice=text1;
                if(num_dec>0){
                    document.getElementById("quantity").value=num_dec;
                    //$("#mask1 .feiright p").text(parseInt(num_dec)*parseInt(singlePrice));
                    $(".feiright p").text(parseFloat(num_dec)*parseFloat(singlePrice));
                }
            }else{
                var num_dec = parseInt(quantity)-1;
                var singlePrice=text2;
                if(num_dec>0){
                    document.getElementById("quantity").value=num_dec;
                    //$("#mask1 .feiright p").text(parseInt(num_dec)*parseInt(singlePrice));
                    $(".feiright p").text(parseFloat(num_dec)*parseFloat(singlePrice));
                }
            }
        }
        $(document).ready(function() {
            $("#quantity").change(function () {
                var singlePrice=$(".special em ").eq(0).text();
                var num = $("#quantity").val();
                if (num <= 0) {
                    num = 1;
                    $("#quantity").val(num);
                }
                $(".feiright p").text(parseFloat(num) * parseFloat(singlePrice));
            })
        })
    </script>
</head>

<body>
<div class='back'><img src='${ctx}/images/array.png' alt='goback'><a href="${ctx}/personal/topersonal.do?openid=${user.openid}">返回首页</a></div>
<div class="wrap" id="wrap" style="padding-top: 2rem">
    <div class="num myclear">
        <p>充值号码<em>${user.phone}</em></p>
    </div>
    <div class="size myclear">
        <p>充值面额</p>
    </div>

    <ul class="sizelist myclear">
        <li class="special">
            <img class="statue" src="${ctx}/images/special.png"/>
            <c:if test="${goods.type==2}"><p><b>${goods.value}</b>元</p></c:if><c:if test="${goods.type==1}"><p><b>${goods.value}</b>MB</p></c:if>
            <img src="${ctx}/images/charcoin.png"/>
            <em>${goods.price}</em>
        </li>
        <li class="rest">商品余量：${goods.number}份</li>
    </ul>

    <a class="recharge" id="chongzhi" href="javascript:;">确认兑换</a>

    <div class="feifooter">
        <p>温馨提示</p>
        <ul>
            <li id="rule">${goods.rule}</li>
        </ul>
    </div>
</div>



<!-- 选择数量及支付方式弹窗 -->
<div class="mask1" id="mask1" style="display:none" >
    <div class="mk1">
        <p class="way myclear"><em>选择数量及支付方式</em><a id="close" href="javascript:;"><img src="${ctx}/images/symbol1.png"/></a></p>
        <div class="mk1cont">
            <div class="buynum myclear">
                <em>购买数量</em>
                <p class="sa myclear">
                    <b class="sub" onclick="numDec()"></b>
                    <input type="text" id="quantity" value="1" />
                    <b class="add" onclick="numAdd()"></b>
                </p>
            </div>

            <div class="choseway myclear">
                <p>支付方式</p>
                <div class="feileft">
                    <div class="choice">
                        <label class="radio" id="radio1">桃子<input type="radio"  name="radio" value="1" checked><i></i></label>
                    </div>
                </div>
                <div class="feiright" id="feiright">
                    <p></p>
                </div>

                <div class=""></div>
            </div>
        </div>
        <a class="duihuan" id="confirm" href="javascript:;" >确认兑换</a>
    </div>
</div>

<!-- 兑换成功弹窗 -->
<div class="mask2" id="mask2" style="display:none" >
    <div class="mk2">
        <p class="way myclear"><em>选择数量及支付方式</em><a id="close1" href="javascript:;"><img src="${ctx}/images/symbol1.png"/></a></p>
        <div class="mk2cont">
            您已成功兑换${goods.name}，每月15日前的兑换奖励将于本月底前发放，每月15日后的兑换奖励将于次月底前发放。
        </div>
        <a class="continue" href="${ctx}/process/store.do?openid=${openid}" >去商城继续逛</a>
    </div>
</div>
</body>
</html>