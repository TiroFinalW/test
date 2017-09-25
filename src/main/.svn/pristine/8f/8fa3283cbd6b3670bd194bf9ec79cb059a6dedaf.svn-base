<%@page language="java" contentType="text/html; charset=utf-8"
        pageEncoding="utf-8"%>
<div class="header bg-main">
    <div class="logo margin-big-left fadein-top">
        <h1><img src="${ctx}/images/y.jpg" class="radius-circle rotate-hover" height="50" alt="" />后台管理中心</h1>
    </div>
    <div class="head-l"><a class="button button-little bg-green" href="" target="_blank"><span class="icon-home"></span> 前台首页</a> &nbsp;&nbsp;<a href="##" class="button button-little bg-blue"><span class="icon-wrench"></span> 清除缓存</a> &nbsp;&nbsp;<a class="button button-little bg-red" href="login.html"><span class="icon-power-off"></span> 退出登录</a> </div>
</div>
<div class="leftnav">
    <div class="leftnav-title"><strong><span class="icon-list"></span>菜单列表</strong></div>
    <h2><span class="icon-user"></span>用户管理</h2>
    <ul style="display:block">
        <li><a href="${ctx}/usermanager/signinfo.do" ><span class="icon-caret-right"></span>签到寻桃数据</a></li>
    </ul>
    <h2><span class="icon-user"></span>用户管理</h2>
    <ul style="display:block">
        <li><a href="${ctx}/usermanager/signlist.do" ><span class="icon-caret-right"></span>用户签到查询</a></li>
        <li><a href="${ctx}/usermanager/processlist.do" ><span class="icon-caret-right"></span>用户兑换查询</a></li>
    </ul>
    <h2><span class="icon-pencil-square-o"></span>栏目管理</h2>
    <ul style="display:block">
        <li><a href="${ctx}/goods/goodslist.do" ><span class="icon-caret-right"></span>商品管理</a></li>
        <li><a href="${ctx}/activity/activitylist.do" ><span class="icon-caret-right"></span>活动列表</a></li>
        <li><a href="${ctx}/notice/noticelist.do" ><span class="icon-caret-right"></span>公告管理</a></li>
    </ul>
    <h2><span class="icon-pencil-square-o"></span>活动管理</h2>
    <ul style="display:block">
        <li><a href="${ctx}/activity/passwordlist.do" ><span class="icon-caret-right"></span>图文寻桃活动</a></li>
    </ul>
</div>
<script type="text/javascript">
    $(function(){
        $(".leftnav h2").click(function(){
            $(this).next().slideToggle(200);
            $(this).toggleClass("on");
        })
        $(".leftnav ul li a").click(function(){
            $("#a_leader_txt").text($(this).text());
            $(".leftnav ul li a").removeClass("on");
            $(this).addClass("on");
        })
    });

    function toPage(a){
        var url = a;
        $("iframe").attr("src",url);
    }
</script>
