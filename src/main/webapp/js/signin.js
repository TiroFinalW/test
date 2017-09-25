$(function(){
//日历生成

    var oUl = document.getElementById('list');
    var time1 = new Date();					//获取系统时间
    var year = time1.getFullYear();			//获取当前年
    var month = time1.getMonth() + 1;		//获取当前月
    var data = time1.getDate();				//获取当前日
    var time2 = new Date(year,month-1,1).getDay(); //设置当前月第一天时间

    function showDate(obj,year,month){
        var data1 = new Date();
        var nowDate = data1.getDate();
        var data = data1.getDate();
        var time2 = new Date(year,month-1,1).getDay();
        var days = 0; //存放每月的天数
        if(!obj.btn){//只动态生成一次
            for(var i=0;i<42;i++){
                var li = document.createElement('li');
                obj.appendChild(li);
            }
            obj.btn = true;
        }

        //设置标题当前日期
        var p1 = document.getElementById("p1");
        if(month ==  data1.getMonth()+1){
            p1.innerHTML = '<span>'+ year +'</span>-<em>'+ month +'</em>-<strong>' + data1.getDate()+'</strong>';
        }
        else{
            p1.innerHTML = '<span>'+ year +'</span>-<em>'+ month +'</em>-<strong>' + 1 +'</strong>';
        }

        //每次进入先清空里面的日期
        //var aUl=document.getElementById('list');
        var aLi = obj.getElementsByTagName('li');
        for(var i=0;i<aLi.length;i++){
            aLi[i].innerHTML = '';
        }

        //判断每个月的天数
        if(month == 2){
            if(year % 4 ==0 && year % 100 != 0 ){//判断是否为闰年
                days = 29;
            }else{
                if(year % 400 == 0){
                    days = 29;
                }else{
                    days = 28;
                }

            }
        }else if(month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12){
            //月份为：1,3,5,7,8,10,12 时，为大月.则天数为31；
            days= 31;
        }else{
            //其他月份，天数为：30.
            days= 30;
        };

        //设置当前月第一天时间
        data1.setFullYear(year);
        data1.setMonth(month-1);
        data1.setDate(1);
        var p1 = document.getElementById("p1");
        var strong = parseInt(p1.getElementsByTagName('strong')[0].innerHTML);

        switch(data1.getDay()){  //当月的1号对应的是星期几
            case 0:

                for(var j=(days+data1.getDay());j<aLi.length;j++){
//					aLi[j].innerHTML = j - (days+data1.getDay()) + 1;
                    aLi[j].className = "other";
                }
                for(var k=0;k<data1.getDay()+7;k++){
//					aLi[k].innerHTML = new Date(year, month-1, -data1.getDay() -7 + 1 + k).getDate();
                    aLi[k].className = "other";
                }
                for(var i=0;i<days;i++){
                    datanum(aLi,strong,i,6);
                }
                break;
            case 1:
                for(var i=0;i<days;i++){
                    datanum(aLi,strong,i,0);
                }
                for(var j=(days+data1.getDay());j<aLi.length;j++){
//					aLi[j].innerHTML = j - (days+data1.getDay()) + 1;
                    aLi[j].className = "other";
                }

                for(var k=0;k<data1.getDay();k++){
//					aLi[k].innerHTML = new Date(year, month-1, -data1.getDay() + 1 + k).getDate();
                    aLi[k].className = "other";
                }
                break;
            case 2:
                for(var i=0;i<days;i++){
                    datanum(aLi,strong,i,1);
                }
                for(var j=(days+data1.getDay());j<aLi.length;j++){
//					aLi[j].innerHTML = j - (days+data1.getDay()) + 1;
                    aLi[j].className = "other";
                }

                for(var k=0;k<data1.getDay();k++){
//					aLi[k].innerHTML = new Date(year, month-1, -data1.getDay() + 1 + k).getDate();
                    aLi[k].className = "other";
                }
                break;
            case 3:
                for(var i=0;i<days;i++){
                    datanum(aLi,strong,i,2);
                }
                for(var j=(days+data1.getDay());j<aLi.length;j++){
//					aLi[j].innerHTML = j - (days+data1.getDay()) + 1;
                    aLi[j].className = "other";
                }

                for(var k=0;k<data1.getDay();k++){
//					aLi[k].innerHTML = new Date(year, month-1, -data1.getDay() + 1 + k).getDate();
                    aLi[k].className = "other";
                }
                break;
            case 4:
                for(var i=0;i<days;i++){
                    datanum(aLi,strong,i,3);
                }
                for(var j=(days+data1.getDay());j<aLi.length;j++){
//					aLi[j].innerHTML = j - (days+data1.getDay()) + 1;
                    aLi[j].className = "other";
                }

                for(var k=0;k<data1.getDay();k++){
//					aLi[k].innerHTML = new Date(year, month-1, -data1.getDay() + 1 + k).getDate();
                    aLi[k].className = "other";
                }
                break;
            case 5:
                for(var i=0;i<days;i++){
                    datanum(aLi,strong,i,4);
                }
                for(var j=(days+data1.getDay());j<aLi.length;j++){
//					aLi[j].innerHTML = j - (days+data1.getDay()) + 1;
                    aLi[j].className = "other";
                }

                for(var k=0;k<data1.getDay();k++){
//					aLi[k].innerHTML = new Date(year, month-1, -data1.getDay() + 1 + k).getDate();
                    aLi[k].className = "other";
                }
                break;
            case 6:
                for(var i=0;i<days;i++){
                    datanum(aLi,strong,i,5);
                }
                for(var j=(days+data1.getDay());j<aLi.length;j++){
//					aLi[j].innerHTML = j - (days+data1.getDay()) + 1;
                    aLi[j].className = "other";
                }
                for(var k=0;k<data1.getDay();k++){
//					aLi[k].innerHTML = new Date(year, month-1, -data1.getDay() + 1 + k).getDate();
                    aLi[k].className = "other";
                }
                break;
        }
        //签到日历表
        var yueYue=document.getElementById('p1').getElementsByTagName('em')[0].innerHTML;
        var oll=document.getElementById('list').getElementsByTagName('li');
        var tt=document.getElementById('siginTime').getElementsByTagName('input');
        var atr=[];
        var nowDay=new Date();
        var month=nowDay.getMonth()+1;
        var dday=nowDay.getDate();
        if(month==yueYue){
            for(var n=0;n<oll.length;n++){
                if(parseInt(oll[n].innerHTML)==parseInt(dday)){
                    oll[n].className='now';
                }
            }
        }
        for(var i=0;i<tt.length;i++){
            atr=[];
            var sss=tt[i].value.split('-');
            atr.push(sss[0]);
            atr.push(sss[1]);
            atr.push(sss[2]);
            if(parseInt(yueYue)==parseInt(atr[0])){
                for(var n=0;n<oll.length;n++){
                    if(parseInt(oll[n].innerHTML)==parseInt(atr[1])){
                        if(parseInt(atr[2])==0){
                            oll[n].className='past';
                        }
                        if(parseInt(atr[2])==1){
                            oll[n].className='again';
                        }
                    }
                }
            }
        }
    };
    showDate(oUl,year,month);

    //设置当前日期颜色
    function datanum(obj1,obj2,num1,num2){//设置当前日期颜色
        if(num1 == obj2-1){
            obj1[num1+num2].className = "";
        }else if(num1 > obj2-1){
            obj1[num1+num2].className = "";
        }else{
            obj1[num1+num2].className = "signed";
        }
        obj1[num1+num2].innerHTML = num1+1;
    }




//		$('#list li:eq(9)').addClass('again');
    //$(".calendar ul li").eq(data + time2-1).addClass("now");//设置当前天位置

    //点击向左切换时间
    $('.btnL').click(function(){
        var p1 = document.getElementById("p1");
        var span = parseInt(p1.getElementsByTagName('span')[0].innerHTML);
        var em = parseInt(p1.getElementsByTagName('em')[0].innerHTML);
        em--;
        if(em < 1){
            em = 12;
            span--;
        }
        showDate(oUl,span,em);
    });

    //点击向右切换时间
    $('.btnR').click(function(){
        var p1 = document.getElementById("p1");
        var span = parseInt(p1.getElementsByTagName('span')[0].innerHTML);
        var em = parseInt(p1.getElementsByTagName('em')[0].innerHTML);
        em++;
        if(em > 12){
            em = 1;
            span++;
        }
        showDate(oUl,span,em);
    });


    //提示框一律点击退出
    $(".popup_tip").click(function(){
        $(this).hide();
    });
    //点击补签
    $(".bu2").on("click",function(){
        var buqian_num = parseInt($("#buqian_num").text());
        var peach_num = parseFloat($("#peach_num").text());
        var openid = $("#openid").val();
        if(buqian_num>0){
            $(".popup_mask").show();
            $(".kuang_buqian1").show();
            $(".buqian1_2").click(function(){
                $.ajax({
                    url:'./retroactive.do',
                    type:'get',
                    data:{"type":"card","openid":openid},
                    dataType:'json',
                    success:function(data) {
                        if(data=="0"){
                            //不需要补签
                            $(".kuang_tip").text("您不需要补签！");
                            $(".popup_tip").show();
                        }
                        if(data=="3"){
                            //补签卡不够
                            $(".kuang_tip").text("你的补签卡不够补签！");
                            $(".popup_tip").show();
                        }
                        if(data=="4"){
                            //补签卡不够
                            $(".kuang_tip").text("桃子不够咯，加油签到吧！");
                            $(".popup_tip").show();
                        }
                        if(data=="1"){
                            $(".kuang_tip").text("补签成功!");
                            $(".popup_tip").show();
                        }
                    }
                })
                $(".popup_mask").hide();
            });
            $(".buqian1_3").click(function(){
                $(".popup_mask").hide();
            });
        }
        else {
            if(peach_num>=10){
                $(".popup_mask").show();
                $(".kuang_buqian2").show();
                $(".buqian2_2").click(function(){
                    $(".popup_mask").hide();
                    $(".popup_tip").show();
                    $.ajax({
                        url:'./retroactive.do',
                        type:'get',
                        data:{"type":"peach","openid":openid},
                        dataType:'json',
                        success:function(data) {
                            if(data=="0"){
                                //不需要补签
                                $(".kuang_tip").text("您不需要补签！");
                                $(".popup_tip").show();
                            }
                            if(data=="3"){
                                //补签卡不够
                                $(".kuang_tip").text("你的补签卡不够补签！");
                                $(".popup_tip").show();
                            }
                            if(data=="1"){
                                $(".kuang_tip").text("补签成功!");
                                $(".popup_tip").show();
                            }
                            if(data=="4"){
                                //补签卡不够
                                $(".kuang_tip").text("桃子不够咯，加油签到吧！");
                                $(".popup_tip").show();
                            }
                        }
                    })
                });
                $(".buqian2_3").click(function(){
                    $(".popup_mask").hide();
                });
            }
            else {
                $(".kuang_tip").text("桃子不够咯，加油签到吧！");
                $(".popup_tip").show();
            }
        }

    });
});