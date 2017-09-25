/**
 * Created by Administrator on 2016/12/16.
 */
$(function(){
    var click=false;
    //提示框一律点击退出
    $(".popup_tip").click(function(){
        $(this).hide();
    });
    $(".code").on("input",function(){
        if($(this).val()!=""){
        click=true;
        $(".sure").css({"background-color":"#fdfa00","color":"#f86161"});}
        else {
            click=false;
            $(".sure").css({"background-color":"#ccc","color":"#fff"});}
    });
    $(".sure").on("click",function(){
        if(!click) return;
        var openid = $("#openid").val();
        var password = $("#password").val();
        $("#password").val("");
        $.ajax({
            url:'./dofindpeach.do',
            type:'post',
            dataType:'json',
            data:{"openid":openid,"password":password},
            success:function(data) {
                var json =eval(("("+data+")"));
                if(json.status=="0"){
                    $(".kuang_tip").text("密码错误或已过期");
                    $(".popup_tip").show();
                }
                if(json.status=="3"){
                    $(".kuang_tip").text("您已经使用过该密码");
                    $(".popup_tip").show();
                }
                if(json.status=="2"){
                    $(".kuang_tip").text("密码错误或已过期");
                    $(".popup_tip").show();
                }
                if(json.status=="1"){
                    var peach = json.peach;
                    var userpeach = json.userpeach;
                    $(".kuang_tip").text("恭喜你获得"+peach+"个桃子");
                    $("#peach_num").text(userpeach);
                    $(".popup_tip").show();
                }
            },
            error:function(){
                alert("系统异常")
            }
        })
    });
});