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
    <meta name="msapplication-tap-highlight" content="no"/>
    <link rel="stylesheet" href="${ctx}/css/style.css">
    <script type="text/javascript" src="${ctx}/js/jquery-1.10.1.min.js"></script>
    <title>湖州移动会员积分平台</title>
    <script>
        var s = document.documentElement.clientWidth;
        document.documentElement.style.fontSize = s/25+ "px";

        window.onload=function(){;
            var state=${state};
            if(state==1){
                location.href="<%=ctx%>/personal/topersonal.do?openid=${user.openid}"
            }
            if(state==-1){
                alert("没有获取到openid，请重新进入页面")
            }
            if(state==0){
                $(".popup_confirm").show();
                $(".kuang_confirm").show();
                $(".confirm2").click(function(){
                    location.href="http://service.jielanwx.com/hz_checkmobile/huzhou_index.jsp?toUserName=gh_c9e42f4d6ef5&openid=${openid}";
                });
                $(".confirm3").click(function(){
                  //  $(".popup_confirm").hide();
                });
            }
            if(state==-2){
                alert("系统异常！")
            }
            <%--$.ajax({--%>
                <%--url:'${ctx}/personal/userpeach.do?openid=${user.openid}',--%>
                <%--type:'post',--%>
                <%--success:function(data){--%>
                    <%--$(".mypeach3").html(data)--%>
                <%--}--%>
            <%--})--%>
            <%--$.ajax({--%>
                <%--url:'${ctx}/personal/usersignlist.do?openid=${user.openid}',--%>
                <%--type:'post',--%>
                <%--success:function(data){--%>
                    <%--var newdata=eval("("+data+")");--%>
                    <%--var html="";--%>
                    <%--$.each($.parseJSON(newdata),function(index,value){--%>
                        <%--html+='<div>'+--%>
                        <%--"<div class='"+value.class1+"'>"+"+"+value.peach+"</div>"+--%>
                                <%--"<div class='"+value.class2+"'>"+value.date+"</div>"+--%>
                              <%--"</div>"--%>
                    <%--})--%>
                    <%--$(".circle").html(html)--%>
                <%--}--%>
            <%--})--%>
        }

    </script>
</head>

<body>
<div class="wrap" id="wrap">
    <div class="news">
        <img src="${ctx}/images/laba.png" alt="通知通知" class="news_img">
        <ul class="news_li">
        <c:forEach items="${noticelist}" var="var">
            <li><a href="javascript:;">${var.content}</a></li>
        </c:forEach>
            <li><a href="javascript:;"></a></li>
        </ul>
        <ul class="swap"></ul>
    </div>
    <img src="${ctx}/images/head.png" alt="head_picture" class="head_pic">
    <div class="head">
        <div class="photo">
            <img class="photo" src="${headimgurl}"/>
        </div>
        <div class="info">
            <div class="name">${nickname}</div>
            <div class="tel">${user.phone}<img src="${ctx}/images/pen.png" alt="pen" class="pen"></div>
        </div>
        <div class="rule rule2">桃子规则</div>
    </div>
    <a href="${ctx}/sign/tosign.do?openid=${user.openid}">
    <div class="circle">
        <c:forEach items="${list}" var="var">
            <div>
                <div class="${var.class1}">+${var.peach}</div>
                <div class="${var.class2}">${var.date}</div>
            </div>
        </c:forEach>
    </div>
    </a>
    <div class="mypeach">
        <img src="${ctx}/images/coin.png" alt="coins" class="mypeach1">
        <div class="mypeach2">我的桃子</div>
        <img src="${ctx}/images/array.png" alt="array" class="mypeach4">
        <a href="${ctx}/personal/mypeach.do?openid=${user.openid}"><div class="mypeach3">${user.peach}</div></a>
    </div>
    <div class="app">
        <div><div style="background-image: url(${ctx}/images/app1.png);background-size: 100% 100%;" class="app_img app1"></div>
            <div class="app_text">兑换商城</div>
        </div>
        <div><div style="background-image: url(${ctx}/images/app2.png);background-size: 100% 100%;" class="app_img app2"></div>
            <div class="app_text">兑换记录</div>
        </div>
        <div><div style="background-image: url(${ctx}/images/app3.png);background-size: 100% 100%;" class="app_img app3"></div>
            <div class="app_text">任务中心</div>
        </div>
        <div><div style="background-image: url(${ctx}/images/app4.png);background-size: 100% 100%;" class="app_img app4"></div>
            <div class="app_text">我的乐园</div>
        </div>
    </div>
    <div class="task">
        <div class="task_heading">
            <div class="task_title">任务中心</div>
        </div>
        <div class="task_body">
            <c:forEach items="${actlist}" var="var">
                <div><a href="${var.activityurl}&openid=${user.openid}"><img src="${ctx}/${var.imgurl}" class="task_img task1"></a>
                </div>
            </c:forEach>
        </div>
    </div>
</div>
<div class="popup_confirm">
    <div class="kuang_confirm">
        <div class="confirm1">绑定手机号</div>
        <div class="confirm_flex">
            <div class="confirm2">确定</div>
            <div class="confirm3">取消</div>
        </div>
    </div>
</div>
<input type="hidden" value="${user.openid}">
<script>
    /*点击更改绑定号码，如果已绑定过跳转至原有手机绑定页面，否则先弹框提示，用户确认后再跳转到原有绑定页面*/
    $(".tel").click(function(){
            $(".popup_confirm").show();
            $(".kuang_confirm").show();
            $(".confirm2").click(function(){
                location.href="http://service.jielanwx.com/hz_checkmobile/huzhou_index.jsp?toUserName=gh_c9e42f4d6ef5&openid=${user.openid}";
            });
            $(".confirm3").click(function(){
                $(".popup_confirm").hide();
            });
    });
    function b(){
        t = parseInt(x.css('top'));
        y.css('top','1.7rem');
        x.animate({top: t - li_h + 'px'},'slow');	//li_h为每个li的高度
        if(Math.abs(t) == h-li_h){ //li_h为每个li的高度
            y.animate({top:'0px'},'slow');
            z=x;
            x=y;
            y=z;
        }
        setTimeout(b,1000);//滚动间隔时间 现在是1秒
    }
    var li_h=document.getElementsByTagName("li")[0].clientHeight;
    $('.swap').html($('.news_li').html());
    x = $('.news_li');
    y = $('.swap');
    h = $('.news_li li').length * li_h; //19为每个li的高度
    setTimeout(b,1000);//滚动间隔时间 现在是1秒
    $(".rule").on("click",function(){
        location.href="<%=ctx%>/personal/rule.do";
    });
    $(".app1").on("click",function(){
        location.href="<%=ctx%>/process/store.do?openid=${user.openid}"
    });
    $(".app2").on("click",function(){
        location.href="<%=ctx%>/personal/myrecord.do?openid=${user.openid}";
    });
    $(".app3").on("click",function(){
        location.href="<%=ctx%>/personal/activitycenter.do?openid=${user.openid}";
    });
</script>
</body>
</html>