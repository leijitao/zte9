var frameX=0;
var exchangeSubmitPhomeFrameX=0;
var prizeFocus=0;
var obj={};
var userInfor;
window.onload=function(){
    statistics(4);
    getCursor();
}
var cursor;
function getCursor() {
    var url=window.location.href;
    if(url.indexOf("cursor=")==-1){
        cursor=10000;
    }else{
        url=url.split("cursor=")[1];
        if(url.indexOf("&")==-1){
            cursor=url
        }else {
            cursor=url.split("&")[0]
        }
    }
}
obj.resetStyle=function(x){
    $(".prizeShowFocus").hide();
    $(".prizeOrder").hide();
    if(prizeFocus<10){
       $(".prizeShow").children().eq(x).children(".prizeShowFocus").show();
    }else {
        $(".prizeOrder").show();
    }
};
obj.exchangeSubmitPhomeFrameStyle=function(){
    if(exchangeSubmitPhomeFrameX==0){
        $(".exchangeSubmitPhomeFrame input").focus();
        $(".exchangeSubmitPhome").children().eq(1).hide();
        $(".exchangeClearPhome").children().eq(1).hide();
    }else if(exchangeSubmitPhomeFrameX==1){
        $(".exchangeSubmitPhomeFrame input").blur();
        $(".exchangeSubmitPhome").children().eq(1).show();
        $(".exchangeClearPhome").children().eq(1).hide();
    }else if(exchangeSubmitPhomeFrameX==2){
        $(".exchangeSubmitPhomeFrame input").blur();
        $(".exchangeSubmitPhome").children().eq(1).hide();
        $(".exchangeClearPhome").children().eq(1).show();
    }
};
obj.resetStyle(prizeFocus);

document.onkeydown=function (e) {
    e=window.event||e;
    switch(e.keyCode){
        case 37:
            if(frameX==0){
                if(prizeFocus>0){
                    prizeFocus--;
                }
                obj.resetStyle(prizeFocus);
            }else if(frameX==1){
                 if(exchangeSubmitPhomeFrameX==2){
                     exchangeSubmitPhomeFrameX=1;
                     obj.exchangeSubmitPhomeFrameStyle()
                 }
            }
            break;
        case 38:
            if(frameX==0){
                if(prizeFocus>4){
                    prizeFocus-=5;
                }else {
                    prizeFocus=0
                }
                obj.resetStyle(prizeFocus);
            }else if(frameX==1){
                exchangeSubmitPhomeFrameX=0;
                obj.exchangeSubmitPhomeFrameStyle()
            }
            break;
        case 39:
            if(frameX==0){
                if(prizeFocus<10){
                    prizeFocus++;
                }
                obj.resetStyle(prizeFocus);
            }else if(frameX==1){
                if(exchangeSubmitPhomeFrameX==1){
                    exchangeSubmitPhomeFrameX=2;
                    obj.exchangeSubmitPhomeFrameStyle()
                }
            }
            break;
        case 40:
            if(frameX==0){
                if(prizeFocus<6){
                    prizeFocus+=5;
                }else {
                    prizeFocus=10
                }
                obj.resetStyle(prizeFocus);
            }else if(frameX==1){
                if(exchangeSubmitPhomeFrameX==0){
                    exchangeSubmitPhomeFrameX=1
                    obj.exchangeSubmitPhomeFrameStyle();
                }

            }
            break;
        case 13:
            if(frameX==0){
                if(prizeFocus==10){
                    //会员等级(1--非会员,2--芒果会员，3--音乐会员，4--双会员)
                   if(userInfor.data.user.level==4||userInfor.data.user.level==3){
                        frame.hasAttend("您已订购全部包月，无需订购哦~")
                    }else {
                        statistics(8);
                       orderPage();
                    }
                }else {
                    if(userInfor.data.user.musicBean>=userInfor.data.awards[prizeFocus].musicBean && userInfor.data.awards[prizeFocus].amount>0){
                       $(".exchangeSubmitPhomeFrame").show();
                        frameX=1;
                        $(".exchangeSubmitPhomeFramePrizePic").attr("src","http://"+ip+userInfor.data.awards[prizeFocus].picUrl);
                       $(".exchangeSubmitPhomeFrame input").val("");
                       if(userInfor.data.user.hasOwnProperty("phoneNumber")&&userInfor.data.user.phoneNumber!=null){
                           $(".exchangeSubmitPhomeFrame input").val(userInfor.data.user.phoneNumber);
                           exchangeSubmitPhomeFrameX=1;
                       }
                        obj.exchangeSubmitPhomeFrameStyle();
                    }else {
                        frameX=2;
                        $(".notExchange").show();
                    }
                }
            }else if(frameX==1){
                if(exchangeSubmitPhomeFrameX==1){
                    obj.getPrizeSubmitPhone(userInfor.data.awards[prizeFocus].id,$(".exchangeSubmitPhomeFrame input").val());
                }else if(exchangeSubmitPhomeFrameX==2){
                    exchangeSubmitPhomeFrameX=0;
                    $(".exchangeSubmitPhomeFrame input").val("");
                    obj.exchangeSubmitPhomeFrameStyle();
                }
            }else if(frameX==2){
                frameX=0;
                $(".notExchange").hide();
                // window.location.href="http://"+ip_local+"/prize.html"
            }else if(frameX==3){
                frameX=0;
                $(".ExchangeSuccess").hide();
                window.location.href="http://"+ip_local+"/prize.html"
            }
            break;
        // case mkeyEvent.KEY_DELETE:
        //     if(exchangeSubmitPhomeFrameX == 0 && frameX==1) {
        //         var num = $('.exchangeSubmitPhomeFrame input').val();
        //         num = num.substring(0, num.length - 1);
        //         $('.exchangeSubmitPhomeFrame input').val(num);
        //     }
        //     break;
        // default:
        //     if(exchangeSubmitPhomeFrameX == 0 && frameX==1) {
        //         var num = $('.exchangeSubmitPhomeFrame input').val();
        //         if(!isNaN(key_code)) {
        //             $('.exchangeSubmitPhomeFrame input').val(num + "" + key_code);
        //         }
        //     }
        //     break;

    }
};
function doBackPressed(){
    if(frameX==0){
        if(cursor==10000){
            window.location.href="http://"+ip_local+"/index.html";
        }else {
            window.location.href="http://"+ip_local+"/index.html?cursor="+cursor;
        }
    }else if(frameX==1){
        if(exchangeSubmitPhomeFrameX==0){
            var num = $('.exchangeSubmitPhomeFrame input').val();
            num = num.substring(0, num.length - 1);
            $('.exchangeSubmitPhomeFrame input').val(num);
        }else {
            frameX=0;
            $(".exchangeSubmitPhomeFrame").hide();
        }
    }else if(frameX==2){
        frameX=0;
        $(".notExchange").hide();
    }else if(frameX==3){
        frameX=0;
        $(".ExchangeSuccess").hide();
        window.location.href="http://"+ip_local+"/prize.html"
    }
}
obj.getPrizeInfor=function () {
    var datas={
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
        url:"http://"+ip+"/award/list",
        // url: "http://192.168.0.72:9090/award/list",
        data: JSON.stringify(datas),
        success:function (msg) {
            console.log("getPrizeInforSuccess"+JSON.stringify(msg));
            if(msg.code==0){
                userInfor=msg;
                $(".musicBeanNum").html(msg.data.user.musicBean);
                $(".winAwardNoticeArea").html("");
                for(var integra in msg.data.records){
                    var infor="<p>恭喜"+msg.data.records[integra].phoneNumber.substring(0,3)+"****"+
                        msg.data.records[integra].phoneNumber.substring(7,11)+"兑换了"+msg.data.records[integra].awardTitle+"</p>";
                    $(".winAwardNoticeArea").append(infor);
                }
                obj.RollingInformation(msg.data.records.length-1);
                for(var integra in msg.data.awards){
                   $(".prizeShow").children().eq(integra).children().eq(0).attr("src","http://"+ip+msg.data.awards[integra].picUrl);
                   $(".prizeShow").children().eq(integra).children().eq(1).html(msg.data.awards[integra].musicBean);
                   $(".prizeShow").children().eq(integra).children().eq(2).html(msg.data.awards[integra].amount);
                }
                if(msg.data.user.level==1){
                    //会员等级(1--非会员,2--芒果会员，3--音乐会员，4--双会员)
                    $(".vipLv").children().eq(0).show();
                    $(".vipLv").children().eq(1).hide();
                    $(".vipLv").children().eq(2).hide();
                }else if(msg.data.user.level==4){
                    $(".vipLv").children().eq(0).hide();
                    $(".vipLv").children().eq(1).hide();
                    $(".vipLv").children().eq(2).show();
                }else {
                    $(".vipLv").children().eq(0).hide();
                    $(".vipLv").children().eq(1).show();
                    $(".vipLv").children().eq(2).hide();
                }
           }
        },
        error:function (msg) {
            console.log("getPrizeInforError"+JSON.stringify(msg));
        }
    })
}
obj.getPrizeInfor();
obj.getPrizeSubmitPhone=function (awardId,phone) {
    var myreg=/^[1][3,4,5,7,8][0-9]{9}$/;
    if(!(myreg.test(phone))){
        $(".validatePhone").show();
    }else {
        $(".validatePhone").hide();
        var datas={
            "userAuth":{
                "userId": userId,
                "contentCode": contentCode,
                "userToken": token,
                "mac": mac,
                "fromSource":fromSource,
                "version":version
            },
            "awardId":awardId,
            "awardAmount":"1",
            "phoneNumber":phone
        };
        $.ajax({
            type: "POST",
            dataType: "json",
            contentType: 'application/json;charset=UTF-8',
            url:"http://"+ip+"/award/exchange",
            // url: "http://192.168.0.72:9090/award/list",
            data: JSON.stringify(datas),
            success:function (msg) {
                console.log("getPrizeSubmitPhoneSuccess"+JSON.stringify(msg));
                if(msg.code==0){
                    $(".ExchangeSuccess").show();
                    frameX=3;
                }else {
                    $(".notExchange").show();
                    frameX=2;
                }
            },error:function (msg) {
                console.log("getPrizeSubmitPhoneError" + JSON.stringify(msg));
                $(".notExchange").show();
                frameX=2;
            }
        })
    }
};
obj.RollingInformation=function (length) {
    var x=0;
    setInterval(function () {
        x++;
        if(x>length){
            $(".winAwardNoticeArea").css({top:"0.6rem"});
            x=0;
        }
        $(".winAwardNoticeArea").animate({top:-x*0.6+"rem"});
    },2000)

}