var frame=0;
//0 无弹框 1 活动规则  2 获得优惠券  3 实物奖品   4  提交手机号成功
var baseFocus=0,vipFrameFocus=0,awardFrameFocus=0;
var ip=58+"."+20+"."+27+"."+16+":"+8080+"/hnGaming_lottery";
var ip_local=58+"."+20+"."+27+"."+16+":"+8080;
// var ip=192+"."+168+"."+0+"."+72+":"+7070;
var myreg=/^[1][3,4,5,7,8][0-9]{9}$/;
document.onkeydown=function (e) {
    e=e || window.event;
    switch(e.keyCode){
        case 37:
            if(frame==0){
                if(baseFocus>0){
                    baseFocus=0
                }
                obj.resetBaseStyle(baseFocus);
            }else if(frame==2){
                if(vipFrameFocus==1){
                    vipFrameFocus=0;
                }
                obj.resetVipFrameStyle(vipFrameFocus);
            }else if(frame==3){
                if(awardFrameFocus==1){
                    awardFrameFocus=0
                }else if(awardFrameFocus==3){
                    awardFrameFocus=2
                }
                obj.resetAwardFrameStyle(awardFrameFocus);
            }
            break;
        case 38:
            if(frame==0){
                if(baseFocus<3){
                    baseFocus++
                }
                obj.resetBaseStyle(baseFocus);
            }else if(frame==3){
                if(awardFrameFocus==2){
                    awardFrameFocus=0
                }else if(awardFrameFocus==3){
                    awardFrameFocus=1
                }
                obj.resetAwardFrameStyle(awardFrameFocus);
            }
            break;
        case 39:
            if(frame==0){
                if(baseFocus==0){
                    baseFocus=1
                }
                obj.resetBaseStyle(baseFocus);
            }else if(frame==2){
                if(vipFrameFocus==0){
                    vipFrameFocus=1;
                }
                obj.resetVipFrameStyle(vipFrameFocus);
            }else if(frame==3){
                if(awardFrameFocus==0){
                    awardFrameFocus=1
                }else if(awardFrameFocus==2){
                    awardFrameFocus=3
                }
                obj.resetAwardFrameStyle(awardFrameFocus);
            }
            break;
        case 40:
            if(frame==0){
                if(baseFocus>0){
                    baseFocus--;
                }
                obj.resetBaseStyle(baseFocus);
            }else if(frame==3){
                if(awardFrameFocus==0){
                    awardFrameFocus=2
                }else if(awardFrameFocus==1){
                    awardFrameFocus=3
                }
                obj.resetAwardFrameStyle(awardFrameFocus);
            }
            break;
        case 13:
            if (frame==0){
                if(baseFocus==0){
                    obj.getUserInfor();
                }else if(baseFocus==1){
                    window.location.href="http://"+ip_local+"/dianjing/index.html?html="+ window.location.href;
                }else if(baseFocus==2){
                    obj.getUserInfor();
                }else if(baseFocus==3){
                    $(".ruleFrame").fadeIn(600);
                    frame=1;
                }
            } else if(frame==1){
                $(".ruleFrame").fadeOut(600);
                frame=0;
            } else if(frame==2){
                if(vipFrameFocus==0){
                    window.location.href="http://"+ip_local+"/dianjing/order.html"
                }else if(vipFrameFocus==1){
                    $(".vipFrame").fadeOut(600);
                    frame=0;
                }
            } else if(frame==3){
                if(awardFrameFocus==1){
                    awardFrameFocus=0;
                    obj.resetAwardFrameStyle(awardFrameFocus);
                    $(".awardFramePhone").html("");
                }else if(awardFrameFocus==2){
                    obj.submitPhone();
                }else if(awardFrameFocus==3){
                    $(".awardFrame").fadeOut(600);
                    frame=0;
                }
            } else if(frame==4){
                window.location.href="http://"+ip_local+"/dianjing/index.html?html="+ window.location.href;
            }
            break;
    }
};
setupWebViewJavascriptBridge(function (bridge) {
    bridge.registerHandler('keyEventHandler', function (data,responseCallback) {
        var datas=parseInt(data);
        // alert(datas);
        if(datas==4){
            if(frame==0){
                window.location.href="http://"+ip_local+"/dianjing/index.html?html="+ window.location.href;
            }else if(frame==1){
                $(".ruleFrame").fadeOut(600);
                frame=0;
            }else if(frame==2){
                $(".vipFrame").fadeOut(600);
                frame=0;
            }else if(frame==3){
                if(awardFrameFocus==0){
                    var html=$(".awardFramePhone").html();
                    if(html=="请输入手机号码"){

                    }else {
                        html=html.slice(0,-1);
                        $(".awardFramePhone").html(html);
                    }
                }else {
                    $(".awardFrame").fadeOut(600);
                    frame=0;
                }
            }else if(frame==4){
                window.location.href="http://"+ip_local+"/dianjing/index.html?html="+ window.location.href;
            }
            responseCallback("true");
        }else if(6<datas && datas<17){
            var html=$(".awardFramePhone").html();
            if(frame==3 && awardFrameFocus==0){
                if(html.length<14){
                    if(html=="请输入手机号码"){
                        $(".awardFramePhone").html(datas-7);
                    }else {
                        $(".awardFramePhone").html(html+(datas-7));
                    }
                }
            }
        }else if(datas==23){
        //    enter

        }


    });

});

var obj={};
obj.resetBaseStyle=function (x) {
    $(".base img").hide();
    $(".base").children().eq(x).show();
};
obj.resetAwardFrameStyle=function (x) {
    if(x==0){
        $(".awardFrame img").hide();
        $(".awardFramePrizeImg").show();
    }else {
        $(".awardFrame img").hide();
        $(".awardFramePrizeImg").show();
        $(".awardFrame").children().eq(x).show();
    }

};
obj.resetVipFrameStyle=function (x) {
    $(".vipFrame img").hide();
    $(".vipFrame").children().eq(x).show();
};
obj.submitPhone=function () {
    var phone=$(".awardFramePhone").html();
    if(!(myreg.test(phone))){
        $(".awardFrameTxt").show();
    }else {
        var datas={
            "userId":userId_mg,
            "phoneNumber":phone,
        };
        $.ajax({
            type:"POST",
            dataType:"json",
            contentType:'application/json;charset=UTF-8',
            // url:"http://192.168.0.72:8080/sign/period",
            url:"http://"+ip+"/user/bind",
            data:JSON.stringify(datas),
            success:function (msg) {
                console.log("bindPhoneSuccess"+JSON.stringify(msg));
                if(msg.code==0){
                    $(".submitSuccessFrame").fadeIn(600);
                    frame=4;
                }
            },
            error:function (msg) {
                console.log("bindPhoneError"+JSON.stringify(msg));
            }
        })
    }
};
obj.getUserInfor=function () {
    console.log("getUserInfor before");
    var datas={
        "typeCode":"",
        "contentId":"",
        "userId":userId_mg,
        "UrlFromsource":20,
        "userToken":userToken_mg,
        "mac":userMacAddress_mg,
        "version":"YYS.5.0.9.Y28.0.HNLT.0.0_zhong9dianjin",
        "authFromsource":20,
        "isGetUrl":1,
        "serviceId":"d34cc6f39bf242e18248b944bf3cbff0"
    };
    $.ajax({
        type:"POST",
        dataType:"json",
        contentType:'application/json;charset=UTF-8',
        // url:"http://192.168.0.72:8080/sign/period",
        url:"http://"+ip+"/lottery/do",
        data:JSON.stringify(datas),
        success:function (msg) {
        //    msg.code  0  首次抽奖，并返回抽奖结果  -1已抽过奖，返回抽奖记录
            console.log("getUserInforSuccess"+JSON.stringify(msg));
            if(msg.data.awardType==0){
            //    包月
                $(".vipFrame").fadeIn(600);
                obj.resetVipFrameStyle(vipFrameFocus);
                frame=2;
            }else {
                $(".awardFrame").fadeIn(600);
                awardFrameFocus=0;
                obj.resetAwardFrameStyle(awardFrameFocus);
                frame=3;
                $(".awardFramePrizeImg").attr("src","http://"+ ip + msg.data.picUrl);
                if($(".awardFramePhone").html()==""){
                    $(".awardFramePhone").html("请输入手机号码");
                }
            }
        },
        error:function (msg) {
            console.log("getUserInforError"+JSON.stringify(msg));
        }
    })
};
obj.statistics=function () {
    console.log("activity statistics");
    $.ajax({
        type:"GET",
        dataType:"json",
        url:"http://"+ip+"/statistics/do",
        data:{
            userId: userId_mg,
            pageId:1
        },
        success:function (msg) {
              console.log("statistics success"+JSON.stringify(msg));
        },
        error:function (msg) {
            console.log("statistics error"+JSON.stringify(msg));
        }
    })
};
 var setTime=function () {
     setTimeout(function () {
         if (userId_mg == undefined) {
             setTime();
         } else {
             obj.statistics();
         }
     },3000);
 }
setTime();