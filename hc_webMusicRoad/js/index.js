var userInfor;
console.log("urlurlurlurlurlwindex"+window.location.href);
var redEnvelopesTime=0;/*控制领红包入口是否显示 0 隐藏 1 显示*/
var offLineTime=1555084801000;
// var offLineTime=1554825600000;
function isHide() {
    if(redEnvelopesTime==1){
        $(".redEnvelopesEntrance").show();
    }else {
        $(".redEnvelopesEntrance").hide();
    }
}
function startStyleHomePage() {
    $(".weekSignIn0").css({transform:"scale(1,1)"});
    $(".weekSignIn_img3").hide();
    $(".buttonTop3_2").hide();
    $(".buttonBottom1_2").hide();
    $(".buttonBottom2_2").hide();
    $(".buttonBottom3_2").hide();
    $(".buttonBottom4_2").hide();
}
function resetStyleHomePage(x) {
    startStyleHomePage();
    console.log("222222222222:"+x);
    if(x<14){
        $(".weekSignIn").children().eq(x).css({transform: "scale(1.2,1.2)"});
        $(".weekSignIn").children().eq(x).children(".weekSignIn_img3").show();
    }else if(x==14){
        $(".buttonTop3").children().eq(1).show();
        $(".buttonTop3").css({transform: "scale(1.2,1.2)"});
    }else if(x>14){
        $(".weekSignIn").children().eq(x+2).children().eq(1).show();
    }
}
var frameX=0;
var hasplayVideo=0;
/*
0 当前焦点在主页面
1 当前焦点在签到成功的拦截页
2 当前焦点在挽留页
3 当前焦点在领红包页
4 当前焦点在活动结束提示页
*/
var focusX=0;
var rememberFocus;
var backFocus=0;
var offLineFrameX=0;
function resetOffLineFrameStyle(){
    if(offLineFrameX==0){
        $(".offLineFrameD1").children().eq(1).show();
        $(".offLineFrameD2").children().eq(1).hide();
    }else if(offLineFrameX==1){
        $(".offLineFrameD2").children().eq(1).show();
        $(".offLineFrameD1").children().eq(1).hide();
    }
}
document.onkeydown=function (e) {
    e=window.event||e;
    if(offLineTime < Date.parse(new Date())){
        switch(e.keyCode){
            case 37:
                if (frameX==3){

                } else if (frameX==4){
                    if(offLineFrameX==1){
                        offLineFrameX=0;
                    }
                    resetOffLineFrameStyle();
                }
                break;
            case 38:
                break;
            case 39:
                if (frameX==3){

                } else if (frameX==4){
                    if(offLineFrameX==0){
                        offLineFrameX=1;
                    }
                    resetOffLineFrameStyle();
                }
                break;
            case 40:
                break;
            case 13:
                if (frameX==3){
                    $(".getRedEnvelopes").hide();
                    frameX=4;
                    $(".offLineFrame").show();
                } else if (frameX==4){
                    if(offLineFrameX==0){
                        window.location.href="http://"+ip_local+"/prize.html";
                    }else if (offLineFrameX==1){
                        $(".offLineFrame").hide();
                        $(".getRedEnvelopes").show();
                        frameX=3;
                    }
                }
                break;
        }
    }else {
        switch(e.keyCode){
            case 37:
                if(frameX==0){
                    if(0<focusX && focusX<7){
                        focusX--
                    }else if (focusX==7){
                        focusX=2
                    } else if (focusX==8){
                        focusX=1
                    } else if (focusX==9 || focusX==10 ||focusX==13 || focusX==16 || focusX==17 || focusX==18){
                        focusX--
                    } else if (focusX==11){
                        focusX=7
                    } else if (focusX==12){
                        focusX=6
                    }else if (focusX==14){
                        focusX=9
                    } else if (focusX==15){
                        focusX=5
                    } else if (focusX==19){
                        console.log("come in focusX9");
                        focusX=13;
                    }
                    resetStyleHomePage(focusX);
                }else if(frameX==2){
                    if(backFocus==1){
                        backFocus=0;
                        $(".goBackButton1_3").show();
                        $(".goBackButton2_2").hide();
                    }
                }
                break;
            case 38:
                if(frameX==0){
                    if(focusX==0||focusX==8||focusX==9||focusX==10||focusX==19){
                        rememberFocus=focusX;
                        focusX=14
                    }else if (focusX>0 &&focusX<5){
                        focusX--
                    } else if (focusX>4&&focusX<8){
                        focusX++
                    }else if (focusX==15 ||focusX==16){
                        focusX=12
                    }  else if (focusX==13){
                        focusX=10
                    } else if (focusX==17) {
                        focusX=13
                    }else if (focusX==18) {
                        if(redEnvelopesTime==1){
                            focusX=19
                        }else {
                            focusX=13
                        }
                    } else if (focusX==12 ||focusX==11){
                        focusX--
                    }
                    resetStyleHomePage(focusX);
                }
                break;
            case 39:
                if(frameX==0){
                    if (focusX==0||focusX==8||focusX==9||focusX==3||focusX==4||focusX==5||focusX==15||focusX==16|focusX==17){
                        focusX++
                    } else if (focusX==1){
                        focusX=8
                    } else if (focusX==2){
                        focusX=7
                    } else if (focusX==7){
                        focusX=11
                    } else if (focusX==6){
                        focusX=12
                    } else if (focusX==11||focusX==12){
                        focusX=13
                    }else if (focusX==10){
                        if(redEnvelopesTime==1){
                            focusX=19
                        }else {
                            focusX=13
                        }
                    }else if (focusX==13){
                        if(redEnvelopesTime==1){
                            focusX=19
                        }else {
                            focusX=13
                        }
                    }
                    resetStyleHomePage(focusX);
                }else if(frameX==2){
                    if(backFocus==0){
                        backFocus=1;
                        $(".goBackButton1_3").hide();
                        $(".goBackButton2_2").show();
                    }
                }
                break;
            case 40:
                if(frameX==0){
                    if (focusX<4){
                        focusX++
                    }else if (focusX>5 && focusX<9){
                        focusX--
                    } else if (focusX>8&&focusX<12){
                        focusX++
                    }else if (focusX==12||focusX==4||focusX==5){
                        focusX=15
                    }else if (focusX==13){
                        focusX=17
                    }else if (focusX==14){
                        focusX=rememberFocus;
                    }else if (focusX==19){
                        focusX=18
                    }
                    resetStyleHomePage(focusX);
                }
                break;
            case 13:
                if(frameX==0){
                    if(focusX<userInfor.data.daySign.weekSign){
                        window.location.href="http://"+ip_local+"/weekSignIn.html?week=" + (parseInt(focusX)+1)+"&cursor="+focusX;
                    }else if(focusX>userInfor.data.daySign.weekSign-1 && focusX<14){
                        frame.hasAttend("不能开启未来的宝箱哦~");
                    }else if(focusX==17){
                        window.location.href="http://"+ip_local+"/myPrize.html?cursor="+focusX;
                    }else if(focusX==15){
                        window.location.href="http://"+ip_local+"/guess.html?cursor="+focusX;
                    }else if(focusX==16){
                        window.location.href="http://"+ip_local+"/prize.html?cursor="+focusX;
                    }else if(focusX==18){
                        window.location.href="http://"+ip_local+"/rule.html?cursor="+focusX;
                    }else if(focusX==14){
                        $(".goBack").show();
                        frameX=2;
                        backFocus=0;
                        if(userInfor.data.user.level==3 || userInfor.data.user.level==4){
                            $(".goBackMusic").show();
                            $(".goBackButton1_1").show();
                            $(".goBackButton1_3").show();
                            $(".goBackOrder").hide();
                            $(".goBackButton1_2").hide();
                            $(".goBackButton2_2").hide();
                        }else {
                            $(".goBackOrder").show();
                            $(".goBackButton1_2").show();
                            $(".goBackButton1_3").show();
                            $(".goBackMusic").hide();
                            $(".goBackButton1_1").hide();
                            $(".goBackButton2_2").hide();
                        }
                    }else if(focusX==19){
                        $(".getRedEnvelopes").show();
                        frameX=3;
                    }
                }else if(frameX==1){
                    if(userInfor.data.user.level==4||userInfor.data.user.level==3){
                        window.location.href="http://"+ip_local+"/weekSignIn.html?week=" + (parseInt(focusX)+1)+"&cursor="+focusX;
                    }else {
                        android.goToActivity("com.zte9.music.activity.PayActivityNoteWeb");
                    }
                }else if(frameX==2){
                    if(backFocus==0){
                        if(userInfor.data.user.level==3 || userInfor.data.user.level==4){
                            statistics(9);
                            goSubject();
                        }else {
                            statistics(8);
                            orderPage();
                        }
                    }else {
                        exitPage();
                    }
                }else if(frameX==3){
                    $(".getRedEnvelopes").hide();
                    frameX=0;
                }
                break;
        }
    }

};
window.onload=function () {
    statistics(1);
    getUserInfor();
};
function doBackPressed() {
    if(offLineTime < Date.parse(new Date())){
        if (frameX==3){
            $(".getRedEnvelopes").hide();
            frameX=4;
            $(".offLineFrame").show();
        } else if (frameX==4){
            exitPage();
        }
    }else {
        if(frameX==0){
            $(".goBack").show();
            frameX=2;
            backFocus=0;
            $(".goBackMusic").show();
            $(".goBackButton1_1").show();
            $(".goBackButton1_3").show();
            $(".goBackOrder").hide();
            $(".goBackButton1_2").hide();
            $(".goBackButton2_2").hide();
            if(userInfor.data.user.level==3 || userInfor.data.user.level==4){
                $(".goBackMusic").show();
                $(".goBackButton1_1").show();
                $(".goBackButton1_3").show();
                $(".goBackOrder").hide();
                $(".goBackButton1_2").hide();
                $(".goBackButton2_2").hide();
            }else {
                $(".goBackOrder").show();
                $(".goBackButton1_2").show();
                $(".goBackButton1_3").show();
                $(".goBackMusic").hide();
                $(".goBackButton1_1").hide();
                $(".goBackButton2_2").hide();
            }
        }else if(frameX==1){
            $(".signIn").hide();
            frameX=0;
            var nowWeek = userInfor.data.daySign.weekSign;
            window.location.href="http://"+ip_local+"/weekSignIn.html?week=" + nowWeek+"&cursor="+focusX;
        }else if(frameX==2){
            $(".goBack").hide();
            frameX=0;
        }else if(frameX==3){
            $(".getRedEnvelopes").hide();
            frameX=0;
        }
    }

}
// 获取光标位置
function getCursor() {
    var url=window.location.href;
    // alert(url);
    if(url.indexOf("cursor=")==-1){
        focusX=userInfor.data.daySign.weekSign-1;
    }else{
        url=url.split("cursor=")[1];
        if(url.indexOf("&")==-1){
            focusX=parseInt(url);
        }else {
            focusX=parseInt(url.split("&")[0]);
        }
    }
    resetStyleHomePage(focusX);
}
function getUserInfor() {
    var datas={
        "userId": userId,
        "contentCode": contentCode,
        "userToken": token,
        "mac": mac,
        "fromSource":fromSource,
        "version":version
    };
    $.ajax({
        type:"POST",
        dataType:"json",
        contentType:'application/json;charset=UTF-8',
        // url:"http://192.168.0.72:8080/sign/period",
        url:"http://"+ip+"/sign/main",
        data:JSON.stringify(datas),
        success:function (msg) {
            console.log("homePage signIn"+ msg);
            console.log("homePage signIn"+ JSON.stringify(msg));
            if(msg.code==0){
                console.log(msg.data.daySign.weekSign);
                // localStorage.setItem("nowWeek",weekSign);
                userInfor=msg;
                getCursor();
                $(".buttonTop1 p").html(msg.data.user.musicBean);
                // console.log(localStorage.getItem("nowWeek"));
                if(msg.data.user.level==4){
                    $(".buttonTop2").attr("src",'images/homepage/lv3.png')
                }else if(msg.data.user.level==3 || msg.data.user.level==2){
                    $(".buttonTop2").attr("src",'images/homepage/lv2.png')
                }else {
                    $(".buttonTop2").attr("src",'images/homepage/lv1.png')
                }
                if(offLineTime < Date.parse(new Date())){
                    console.log("activity end 2019/4/12");
                    frameX=4;
                    $(".offLineFrame").show();
                    resetOffLineFrameStyle();
                }else{
                    if(msg.data.daySign.isSign == 1){
                        //    当天签到成功
                        statistics(0);
                        $(".signIn").show();
                        frameX=1;
                        $(".signInTxt").html(msg.data.daySign.musicBean);
                        //会员等级(1--非会员,2--芒果会员，3--音乐会员，4--双会员)
                        if(msg.data.user.level==4||msg.data.user.level==3){
                            $(".signInBean").show();
                            $(".sureButton").show();
                        }else {
                            $(".signInOrder_hc").show();
                            $(".orderButton").show();
                        }
                    }else {
                        //    当天已签到或签到失败
                    }
                }

                $(".Notice").html(msg.data.activity.description);
                console.log("1111111111111111"+focusX);
                for(var i=0;i<msg.data.daySign.weekSign;i++){
                    $(".weekSignIn").children(".weekSignIn0").eq(i).children('.weekSignIn_img1').hide();
                    $(".weekSignIn").children(".weekSignIn0").eq(i).children('.weekSignIn_img2').show();
                }
                // for (var i=msg.data.currentWeek;i<14;i++) {
                for (var i=msg.data.daySign.weekSign;i<14;i++) {
                    $(".weekSignIn").children(".weekSignIn0").eq(i).children('.weekSignIn_img2').hide();
                    $(".weekSignIn").children(".weekSignIn0").eq(i).children('.weekSignIn_img1').show();
                }
                for(var integra in msg.data.signList){
                    if(msg.data.signList[integra].signState==1){
                        $(".weekSignIn").children(".weekSignIn0").eq(integra).children('.weekSignIn_img5').show();
                    }else if(msg.data.signList[integra].signState==2){
                        $(".weekSignIn").children(".weekSignIn0").eq(integra).children('.weekSignIn_img4').show();
                    }
                }
               /* if(msg.data.daySign.weekSign==11 || msg.data.daySign.weekSign==14){*/
                    redEnvelopesTime=1;
                    isHide();
                    isGetRedEnvelopes();
              /*  }else {
                    redEnvelopesTime=0;
                    isHide();
                }*/
                console.log("redEnvelopesTimeredEnvelopesTime:" + redEnvelopesTime);
            }else{
                // getUserInfor()
            }
        },
        error:function(){
            console.log("homePage signInError" + JSON.stringify(msg));
        }
    })
}

/*查询是否有红包领取资格*/
function isGetRedEnvelopes(){
    $.ajax({
        type:"GET",
        dataType:"json",
        contentType:'application/json;charset=UTF-8',
        url:"http://"+ip+"/red_package/tip/query",
        data:{
            'userId': userId,
            'week':userInfor.data.daySign.weekSign
        },
        success:function (msg) {
            console.log("isGetRedEnvelopes success"+JSON.stringify(msg));
            if(msg.code==0){
                if(msg.data.hasValidRedPackage==false){
                    console.log("set bg noget");
                    $(".getRedEnvelopes").css({"backgroundImage":"url(images/redEnvelopes/noget.png)"})
                }else {
                    console.log("set bg get");
                    $(".getRedEnvelopes").css({"backgroundImage":"url(images/redEnvelopes/get.png)"})
                    if(msg.data.todayTips<4){
                        frame.hasAttend("恭喜您获得现金红包奖励，请点击右侧红包按钮根据提示领取~")
                    }
                }
            }
        },
        error:function (msg) {
            console.log("isGetRedEnvelopes error"+JSON.stringify(msg))
        }
    })
}