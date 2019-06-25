var focusX=2;
var frameX=0;
var getPrizeFocus=0;
var userInfor;
console.log("urlurlurlurlurlweek"+window.location.href);
var cursor;
function getCursor() {
    var url=window.location.href;
    if(url.indexOf("cursor=")==-1){

    }else{
        url=url.split("cursor=")[1]
        if(url.indexOf("&")==-1){
            cursor=url
        }else {
            cursor=url.split("&")[0]
        }
    }
}
document.onkeydown=function (e) {
    e=window.event||e;
    switch (e.keyCode) {
        case 37:
            if(frameX==0){
                if(2<focusX && focusX<9){
                    focusX--;
                }else if(focusX==1){
                    focusX=0;
                }
                weekSign_resetStyle(focusX);
            }else if(frameX==1){
                if(getPrizeFocus==2){
                    getPrizeFocus=1;
                }
                getPrizeResetStyle(getPrizeFocus);
            }
            break;
        case  38:
            if(frameX==0){
                if(focusX==2){
                    focusX=0;
                }else if(focusX>2 && focusX<9){
                    focusX=1;
                }
                weekSign_resetStyle(focusX);
            }else if(frameX==1){
                if(getPrizeFocus==2 || getPrizeFocus==1){
                    getPrizeFocus=0;
                }
                getPrizeResetStyle(getPrizeFocus);
            }
            break;
        case 39:
            if(frameX==0){
                if(1<focusX && focusX<8){
                    focusX++;
                }else if(focusX==0){
                    focusX=1;
                }
                weekSign_resetStyle(focusX);
            }else if(frameX==1){
                if(getPrizeFocus==1){
                    getPrizeFocus=2;
                }
                getPrizeResetStyle(getPrizeFocus);
            }
            break;
        case  40:
            if(frameX==0){
                if(focusX==0){
                    focusX=2;
                }else if(focusX==1){
                    focusX=3;
                }
                weekSign_resetStyle(focusX);
            }else if(frameX==1){
                if(getPrizeFocus==0){
                    getPrizeFocus=1;
                }
                getPrizeResetStyle(getPrizeFocus);
            }
            break;
        case 13:
            if(frameX==0) {
                if (focusX==0) {
                    window.location.href = "http://"+ip_local+"/guess.html"
                } else if (focusX==1) {
                    window.location.href = "http://"+ip_local+"/prize.html"
                } else {
                    if(userInfor.data.signList[focusX - 2].signState == 0){
                        frame.hasAttend("还未到签到时间哦~");
                    }else if (userInfor.data.signList[focusX - 2].signState == 1){
                        frame.hasAttend("您已经签到过了~");
                    } else if (userInfor.data.signList[focusX - 2].signState == 2){
                        frame.hasAttend("您已经补签过了~");
                    } else if (userInfor.data.signList[focusX - 2].signState == 3){

                    } else if (userInfor.data.signList[focusX - 2].signState == 4){
                        if (userInfor.data.user.replenishSign > 0){
                            //可以补签
                            supplementSign(userInfor.data.signList[focusX - 2].signDate);
                        }else if (userInfor.data.user.replenishSign == 0) {
                            //补签机会不足

                            if (userInfor.data.user.level == 1 || userInfor.data.user.level == 2) {
                                $(".noSignChance_jumpOrder").show();
                                frameX=2;
                                $(".noSignChance_jumpOrder").children().eq(1).show();
                                $(".noSignChance_jumpOrder").children().eq(0).hide();
                            }else {
                                frame.hasAttend("您的签到机会不足");
                            }
                        }
                    }
                }
            }else if(frameX==1){
                if(getPrizeFocus==1){
                //    提交手机号
                    submitPhone();
                }else if(getPrizeFocus==2){
                    getPrizeFocus=0;
                    $(".getPrizePhoneNum").val("");
                    getPrizeResetStyle(getPrizeFocus);
                }
            }else if(frameX==2){
                statistics(8);
                orderPage()
            }
            break;
        // case mkeyEvent.KEY_DELETE:
        //     if(getPrizeFocus == 0 && frameX==1) {
        //         var num = $('.getPrizePhoneNum').val();
        //         num = num.substring(0, num.length - 1);
        //         $('.getPrizePhoneNum').val(num);
        //     }
        //     break;
        // default:
        //     if(getPrizeFocus == 0 && frameX==1) {
        //         var num = $('.getPrizePhoneNum').val();
        //         if(!isNaN(key_code)) {
        //             $('.getPrizePhoneNum').val(num + "" + key_code);
        //         }
        //     }
        //     break;
    }
};
function doBackPressed() {
        if(frameX==0){
            window.location.href="http://"+ip_local+"/index.html?cursor="+cursor;
        }else if(frameX==1){
            if(getPrizeFocus==0){
                var num = $('.getPrizePhoneNum').val();
                num = num.substring(0, num.length - 1);
                $('.getPrizePhoneNum').val(num);
            }else {
                frameX=0;
                $(".getPrize").hide();
                $(".getPrizePhoneNum").blur();
            }

        }else if(frameX==2){
            frameX=0;
            $(".noSignChance_jumpOrder").hide();
        }
}
function startStyle() {
    $(".weekSignIn_day_guess").children().eq(1).hide();
    $(".weekSignIn_day_prize").children().eq(1).hide();
    $(".hideFocus").hide();
    $(".weekSignIn_dayTop").children().css({transform:"scale(1,1)"});
    $(".weekSignInConDay").children().css({transform:"scale(1,1)"});
    // $(".weekSignIn_dayBottom").children().eq(1).hide();
}
function weekSign_resetStyle(x) {
    if(focusX==0 || focusX==1){
        startStyle();
        $(".weekSignIn_dayTop").children().eq(x).children().eq(1).show();
        $(".weekSignIn_dayTop").children().eq(x).css({transform:"scale(1.2,1.2)"});
    }else if(focusX>1 && focusX<9){
        startStyle();
        $(".weekSignInConDay").children().eq(x-2).children().eq(4).show();
        $(".weekSignInConDay").children().eq(x-2).css({transform:"scale(1.2,1.2)"});
    }
        // else if(focusX==9){
    //     startStyle();
    //     $(".weekSignIn_dayBottom").children().eq(1).show();
    // }
}
window.onload=function () {
    getInfor_week();
    weekSign_resetStyle(focusX);
    statistics(2);
    getCursor();
};

function getInfor_week() {
    var week ;
    var url=window.location.href;
    url=url.split("week=")[1];
    if(url.indexOf("&")==-1){
        week = parseInt(url) ;
    }else {
        week = parseInt(url.split("&")[0]);
    }
    console.log("weekweekweek"+week);
    console.log("weekweekweek"+ window.location.href);
    var datas = {
        "userId": userId,
        "contentCode": contentCode,
        "userToken": token,
        "mac": mac,
        "fromSource":fromSource,
        "version":version
    };
    $.ajax({
        type: "POST",
        dataType: "json",
        contentType: 'application/json;charset=UTF-8',
        // url:"http://192.168.0.72:8080/sign/period",
        url: "http://"+ip+"/sign/week/" + week,
        data: JSON.stringify(datas),
        success: function (msg) {
            console.log("weekSignIn" + JSON.stringify(msg));
            if(msg.code==0){
                console.log("weekSignIn" + JSON.stringify(msg));
                userInfor=msg;
                $(".weekSignIn_day_beanNum").html(msg.data.user.musicBean);
                $(".weekSignIn_day_chanceNum").html(msg.data.user.replenishSign);
                $(".weekSignInBg").attr("src","http://"+ip+ "/"+ msg.data.activity.picUrl);
                for (var integra in msg.data.signList) {
                    //（ 0---未签，1---已签，2---已补签，3,---当日（未签），4.漏签）
                    if (msg.data.signList[integra].signState == 0) {
                        $(".weekSignInConDay").children().eq(integra).children().eq(0).show();
                    } else if (msg.data.signList[integra].signState == 1) {
                        $(".weekSignInConDay").children().eq(integra).children().eq(3).show();
                    } else if (msg.data.signList[integra].signState == 2) {
                        $(".weekSignInConDay").children().eq(integra).children().eq(2).show();
                    } else if (msg.data.signList[integra].signState == 4) {
                        $(".weekSignInConDay").children().eq(integra).children().eq(1).show();
                    }
                }
                if(msg.data.lottery.winState===2){
                    // 0---还未抽奖， 1---已参与抽奖，2---中奖，3---未中奖
                    WinPrize(msg);
                }
            }
        },
        error: function (msg) {
            console.log("weekSignIn" + JSON.stringify(msg));
        }
    });
}

function supplementSign(x) {
    // var x=new Date(x);
    // var Y = x.getFullYear() + '-';
    // var M = (x.getMonth()+1 < 10 ? '0'+(x.getMonth()+1) : x.getMonth()+1) + '-';
    // var D = x.getDate();
    // var date=Y+M+D;
    console.log(x);
    var datas={
        "userAuth":{
            "userId": userId,
            "contentCode": contentCode,
            "userToken": token,
            "mac": mac,
            "fromSource":fromSource,
            "version":version
        },
        "weekInPeriod":"",
        "dayInweek":"",
        "signDate":x
    }
    $.ajax({
        type: "POST",
        dataType: "json",
        contentType: 'application/json;charset=UTF-8',
        // url:"http://192.168.0.72:8080/sign/period",
        url: "http://"+ip+"/sign/replenish",
        data: JSON.stringify(datas),
        success:function (msg) {
            console.log("supplementSignSuccess:"+JSON.stringify(msg));
            if(msg.code==0){
                var lefts=['0.28rem','1.94rem','3.6rem','5.26rem','6.92rem','8.58rem','10.24rem'];
                $(".rewardBeanNum").html("+"+msg.data.daySign.musicBean);
                $(".rewardBeanNum").css({opacity:"1",top:"1.47rem",left:lefts[focusX-2]});
                $(".rewardBeanNum").animate({top:"0.6rem",opacity:"0"},1000);
                getInfor_week();
            }
        },
        error:function (msg) {
            console.log("supplementSignError:"+JSON.stringify(msg));
        }
    })
}
function WinPrize(msg) {
    $(".getPrize").show();
    $(".getPrizeImg").attr("src","http://"+ip+msg.data.lottery.award.picUrl);
    frameX=1;
    if(msg.data.user.hasOwnProperty("phoneNumber") && msg.data.user.phoneNumber != null){
        getPrizeFocus=1;
        $(".getPrizePhoneNum").val(msg.data.user.phoneNumber);
    }else {
        getPrizeFocus=0;
    }
    getPrizeResetStyle(getPrizeFocus);
}
function getPrizeResetStyle(getPrizeFocus) {
    if(getPrizeFocus==0){
        $(".getPrizePhoneNum").focus();
        $(".getPrizeSubmit").children().eq(1).hide();
        $(".getPrizeClear").children().eq(1).hide();
    }else if(getPrizeFocus==1){
        $(".getPrizePhoneNum").blur();
        $(".getPrizeSubmit").children().eq(1).show();
        $(".getPrizeClear").children().eq(1).hide();
    }else if(getPrizeFocus==2){
        $(".getPrizePhoneNum").blur();
        $(".getPrizeSubmit").children().eq(1).hide();
        $(".getPrizeClear").children().eq(1).show();
    }
}
function submitPhone() {
    var myreg=/^[1][3,4,5,7,8][0-9]{9}$/;
    if(!(myreg.test($(".getPrizePhoneNum").val()))){
        $(".getPrizeTxt").show();
    }else {
        $(".getPrizeTxt").hide();
        var datas = {
            "userAuth": {
                "userId": userId,
                "contentCode": contentCode,
                "userToken": token,
                "mac": mac,
                "fromSource":fromSource,
                "version":version
            },
            "user": {
                "phoneNumber": $(".getPrizePhoneNum").val()
            }
        };
        $.ajax({
            type: "POST",
            dataType: "json",
            contentType: 'application/json;charset=UTF-8',
            // url:"http://192.168.0.72:8080/sign/period",
            url: "http://"+ip+"/user/update",
            data: JSON.stringify(datas),
            success: function (msg) {
                console.log("submitPhone:" + JSON.stringify(msg));
                if (msg.code == 0) {
                    $(".getPrize").hide();
                    frame = 0;
                }
            },
            error: function (msg) {

            }
        })
    }
}