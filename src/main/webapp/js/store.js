/**
 * Created by Administrator on 2016/12/16.
 */
$(function () {
  //  var peach_num=10;/*桃子数量,后台获取*/
  //  var buqian_num=3;/*补签卡数量，后台获取*/
 //   console.log("桃子数："+peach_num);
//    console.log("补签数："+buqian_num);
    //提示框一律点击退出
    $(".popup_tip").click(function(){
        $(this).hide();
    });
    /*大转盘*/
    var onOff = true;

    var rotateFunc = function (awards, angle, text) {
        $('#zhuan').stopRotate();
        $("#zhuan").rotate({
            angle: 0,
            duration: 4000,
            animateTo: angle + 3600,
            callback: function () {
                $('.kuang_tip').html(text);
                $(".popup_tip").show();
                onOff = true;
            }
        });
    };
    var openid='';
    $("#zhuan").rotate({
        bind: {
            click: function () {
                if (!onOff) {
                    return;
                }
                onOff = false;
                $.ajax({
                    type:'GET',
                    url:'./luckdraw.do?openid='+$("#openid").val(),
                    dataType:'json',
                    success:function(data) {
                        if(data=='50M流量券'){
                            rotateFunc(4, 300, '恭喜您，获得一张50M流量券！');
                        }
                        if(data=='补签卡'){
                            rotateFunc(5, 360, '恭喜您，获得一张补签卡！');
                        }
                        if(data=='10M流量券'){
                            rotateFunc(3, 240, '恭喜您，获得一张10M流量券！');
                        }
                        if(data=='手厅充20返5元话费返充券'){
                            rotateFunc(2, 180, '恭喜你抽中“手厅充20元返5元话费返充券”一张！当月至“浙江移动手机营业厅”APP成功充值20元话费，次月月底前可返充获赠5元话费券奖励。！');
                        }
                        if(data=='5个桃子'){
                            rotateFunc(0, 60, '恭喜您，获得5个桃子！');
                        }
                        if(data=='谢谢'){
                            rotateFunc(1, 120, '加油！换个姿势再转一次吧！！');
                        }
                        if(data=='您的桃子不足'){
                            $('.kuang_tip').html("桃子不够咯，加油签到吧！");
                            $(".popup_tip").show();
                            onOff=true;
                        }
                        if(data=='系统异常'){
                            $('.kuang_tip').html("系统异常！");
                            $(".popup_tip").show();
                            onOff=true;
                        }
                    }
                })
                // if(peach_num<5){
                //     $('.kuang_tip').html("桃子不够咯，加油签到吧！");
                //     $(".popup_tip").show();
                //     onOff=true;
                // }
                // else {
                //     peach_num -= 5;
                //     console.log("消耗后桃子数：" + peach_num);
                //     var data = [0, 1, 2, 3, 4];
                //     data = data[Math.floor(Math.random() * data.length)];
                //     if (data == 0) {
                //         rotateFunc(0, 36, '恭喜您，获得5个桃子！');
                //         peach_num += 5;
                //         console.log("获得后桃子数：" + peach_num);
                //     }
                //     if (data == 1) {
                //         rotateFunc(1, 108, '谢谢参与！');
                //     }
                //     if (data == 2) {
                //         rotateFunc(2, 180, '恭喜您，获得一张10M流量券！');
                //     }
                //     if (data == 3) {
                //         rotateFunc(3, 250, '恭喜您，获得一张50M流量券！');
                //     }
                //     if (data == 4) {
                //         rotateFunc(4, 324, '恭喜您，获得一张补签卡！');
                //         buqian_num += 1;
                //         console.log("获得后补签数：" + buqian_num);
                //     }
                // }
            }
        }

    });
});