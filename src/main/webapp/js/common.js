/**
 * Created by Administrator on 2017/1/4.
 */
$(function(){
    var back="<div class='back'><img src='../images/array.png' alt='goback'></div>";
    $(".wrap,.rewrap,.quanwrap").before(back);
    $(".back").click(function(){
        window.location.href=""
    });
})