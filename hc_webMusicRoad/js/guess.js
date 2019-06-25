var guessFocus=0;
var guessBeanFocus=3;
var guessFrame=0;
var userInfor;
var recordList;
var topX=0;
var page;
var optionNum;
var hasBet;
console.log("urlurlurlurlurlguess"+window.location.href);
//0 无弹框  1 竞猜押豆  2 竞猜规则  3 竞猜记录 4 订购
var obj={};
obj.setStyle=function(x){
        $(".answer > div :nth-child(2)").hide();
        $(".answer").children().eq(x).children().eq(1).show();
        $(".answer > div").css({transform:"scale(1,1)"});
        $(".answer").children().eq(x).css({transform:"scale(1.2,1.2)"});

};
obj.setBeanStyle=function(x){
    if(x==3){
        $(".guessFrameBack").show();
        $(".guessFrame > div :nth-child(2)").hide();
        $(".guessFrame > div").css({transform:"scale(1,1)"});
    }else {
        $(".guessFrameBack").hide();
        $(".guessFrame > div :nth-child(2)").hide();
        $(".guessFrame").children().eq(x).children().eq(1).show();
        $(".guessFrame > div").css({transform:"scale(1,1)"});
        $(".guessFrame").children().eq(x).css({transform:"scale(1.2,1.2)"});
    }
};

window.onload=function(){
    obj.setStyle(guessFocus);
    obj.getInfor();
    statistics(3);
    getCursor();
};
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
            if(guessFrame==0){
                if(guessFocus>0 && guessFocus<optionNum){
                    guessFocus--;
                }else if(guessFocus==4){
                    guessFocus=optionNum-1;
                }
                obj.setStyle(guessFocus);
            }else if(guessFrame==1){
                guessBeanFocus--;
                if(guessBeanFocus<=0){
                    guessBeanFocus=0;
                }
                obj.setBeanStyle(guessBeanFocus);
            }else if(guessFrame==3){
                if(topX>0){
                    topX--;
                }
                obj.recordAnimate(topX);
            }
            break;
        case 38:
            if(guessFrame==0){
                if(guessFocus>=0 && guessFocus<optionNum){
                    guessFocus=4
                } else if(guessFocus>3 && guessFocus<6){
                    guessFocus++;
                }
                obj.setStyle(guessFocus);
            }else if(guessFrame==3){
                if(topX>0){
                    topX--;
                }
                obj.recordAnimate(topX);
            }else if (guessFrame==1){
                guessBeanFocus=1;
                obj.setBeanStyle(guessBeanFocus);
            }
            break;
        case 39:
            if(guessFrame==0){
                if(guessFocus>=0 && guessFocus<optionNum-1){
                    guessFocus++;
                }else if(guessFocus==optionNum-1){
                    guessFocus=4
                }
                obj.setStyle(guessFocus);
            }else if(guessFrame==1){
                guessBeanFocus++;
                if(guessBeanFocus>=2){
                    guessBeanFocus=2;
                }
                obj.setBeanStyle(guessBeanFocus);
            }else if(guessFrame==3){
                if(topX<page-1){
                    topX++;
                }
                obj.recordAnimate(topX);
            }
            break;
        case 40:
            if(guessFrame==0){
                if(guessFocus>4 && guessFocus<=6){
                    guessFocus--;
                }else if(guessFocus==4){
                    guessFocus=optionNum-1
                }
                obj.setStyle(guessFocus);
            }else if(guessFrame==3){
                if(topX<page-1){
                    topX++;
                }
                obj.recordAnimate(topX);
            }else if (guessFrame==1){
                guessBeanFocus=3;
                obj.setBeanStyle(guessBeanFocus);
            }
            break;
        case 13:
            if(guessFrame==0){
                if(guessFocus>=0 && guessFocus<optionNum){
                    if(hasBet==true){
                        frame.hasAttend("您已参加今日竞猜，请勿重复参加")
                    }else {
                        guessFrame=1;
                        $(".guessFrame").show();
                        obj.setBeanStyle(guessBeanFocus);
                    }
                }else if(guessFocus==6){
                    guessFrame=2;
                    $(".guessRuleFrame").show();
                }else if(guessFocus==4){
                    statistics(9);
                    goSubject();
                }else if(guessFocus==5){
                    obj.guessRecord();
                }
            }else if(guessFrame==1){
                if(guessBeanFocus<3){
                    if((guessBeanFocus+1)*10>parseInt(userInfor.data.user.musicBean)){
                        //会员等级（1--非会员,2--芒果会员，3--音乐会员，4--双会员）
                        if(userInfor.data.memberShip.level==4||userInfor.data.memberShip.level==3){
                            frame.hasAttend("您的音乐的数量不足~");
                        }else{
                            guessFrame=4;
                            $(".guessFrame").hide();
                            $(".noGuess").show();
                            $(".noGuess").children().eq(0).hide();
                            $(".noGuess").children().eq(1).show();
                        }
                    }else {
                        console.log("weekSignInsubmitAnswer");
                        obj.submitAnswer(userInfor.data.options[guessFocus].id,guessBeanFocus+1);
                    }
                }else {
                    guessFrame=0;
                    $(".guessFrame").hide();
                }
            }else if(guessFrame==2){
                guessFrame=0;
                $(".guessRuleFrame").hide();
            }else if(guessFrame==3){
                guessFrame=0;
                $(".guessRecordFrame").hide();
            }else if(guessFrame==4){
                //    欢唱订购
                statistics(8);
                orderPage();
            }
            break;
    }
};
function doBackPressed(){
    if(guessFrame==2){
        guessFrame=0;
        $(".guessRuleFrame").hide();
    }else  if(guessFrame==1){
        guessFrame=0;
        $(".guessFrame").hide();
    }else if(guessFrame==0){
        if(isNaN(parseInt(cursor))){
            window.location.href="http://"+ip_local+"/index.html";
        }else {
            window.location.href="http://"+ip_local+"/index.html?cursor="+cursor;
        }

    }else if(guessFrame==3){
        guessFrame=0;
        $(".guessRecordFrame").hide();
    }else if(guessFrame==4){
        guessFrame=0;
        $(".noGuess").hide();
    }
}
obj.getInfor=function () {
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
        url: "http://"+ip+"/quiz/main",
        data: JSON.stringify(datas),
        success: function (msg) {
            console.log("getGuessInforSuccess"+JSON.stringify(msg));
            if(msg.code==0){
                userInfor=msg;
                hasBet=msg.data.hasBet;
                $(".guessBg").attr("src","http://"+ ip+ "/"+ msg.data.bgUrl);
                if(msg.data.title==undefined){
                    $(".guessAnswer_new").html("");
                }else {
                    $(".guessAnswer_new").html(msg.data.title);
                }
                $(".guessAnswer_new").css({backgroundSize:"100% 100%"});
                if(msg.data.titleOfYesterday==undefined||msg.data.optionOfYesterday==undefined){
                    $(".guessQuestion_old").html("");
                    $(".guessAnswer_old").html("");
                }else {
                    $(".guessQuestion_old").html("昨日问题："+msg.data.titleOfYesterday);
                    $(".guessAnswer_old").html("答案："+msg.data.optionOfYesterday);
                }
                optionNum=msg.data.options.length;
                if(optionNum==2){
                    $(".answerA p").html(msg.data.options[0].opt);
                    $(".answerB p").html(msg.data.options[1].opt);
                }else if(optionNum==3){
                    $(".answerA p").html(msg.data.options[0].opt);
                    $(".answerB p").html(msg.data.options[1].opt);
                    $(".answerC p").html(msg.data.options[2].opt);
                }else {
                    $(".answerA p").html(msg.data.options[0].opt);
                    $(".answerB p").html(msg.data.options[1].opt);
                    $(".answerC p").html(msg.data.options[2].opt);
                    $(".answerD p").html(msg.data.options[3].opt);
                }
                if(msg.data.winInYesterday==undefined){
                    $(".winPrizeNum").html("0");
                }else{
                    $(".winPrizeNum").html(msg.data.winInYesterday);
                }
                if(msg.data.beansInPool==undefined){
                    $(".beanNumNow").html("0");
                }else {
                    $(".beanNumNow").html(msg.data.beansInPool);
                }

            }
        },
        error: function (msg) {
            console.log("getGuessInforError"+JSON.stringify(msg));
        }
    })
}
obj.submitAnswer=function (x,y) {
    console.log("weekSignInsubmitAnswerFun");
    var datas={
        "userId":userId,
        "optId":x,
        "betFactor":y
    };
    $.ajax({
        type: "POST",
        dataType: "json",
        contentType: 'application/json;charset=UTF-8',
        url:"http://"+ip+"/quiz/bet",
        // url: "http://192.168.0.72:9090/sign/main",
        data: JSON.stringify(datas),
        success:function (msg) {
            console.log("submitAnswerSuccess"+JSON.stringify(msg));
            if(msg.code==0){
                frame.hasAttend("竞猜成功");
                guessFrame=0;
                $(".guessFrame").hide();
                obj.getInfor();
                hasBet=true;
            }
        },
        error:function (msg) {
            console.log("submitAnswerError"+JSON.stringify(msg));
            frame.hasAttend("竞猜失败");
        }
    })
}

obj.guessRecord=function () {
    guessFrame=3;
    $(".guessRecordFrame").show();
    $(".guessRecordArea > div").html("");
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
        url:"http://"+ip+"/quiz/result",
        // url: "http://192.168.0.72:9090/sign/main",
        data:JSON.stringify(datas),
        success:function (msg) {
            console.log("guessRecordSuccess"+JSON.stringify(msg));
            if(msg.code==0){
                if(msg.data.hasOwnProperty("quizList")&&msg.data.quizList!=null){
                    page=Math.ceil(msg.data.quizList.length/6);
                }else {
                    page=1
                }
                $(".guessRecordFrameBeanNum").html(msg.data.user.musicBean);
                $(".guessRecordFrameGuessNum").html(msg.data.totalNum);
                $(".guessRecordFrameWinNum").html(msg.data.winNum);
                $(".guessRecordFrameGetBean").html(msg.data.totalBeanChange);
                if(msg.data.membership.userLevel==1){
                // （1--非会员,2--芒果会员，3--音乐会员，4--双会员）
                   $(".guessRecordVipLv img").hide();
                    $(".guessRecordVipLv").children().eq(1).show();
                }else if(msg.data.membership.userLevel==4){
                    $(".guessRecordVipLv img").hide();
                    $(".guessRecordVipLv").children().eq(3).show();
                }else {
                    $(".guessRecordVipLv img").hide();
                    $(".guessRecordVipLv").children().eq(3).show();
                }
                recordList=msg;
                for(var i in recordList.data.quizList){
                    if(recordList.data.quizList[i].isRight==true){
                        recordList.data.quizList[i].isRight="胜";
                    }else if(recordList.data.quizList[i].isRight==false){
                        recordList.data.quizList[i].isRight="负";
                    }else {
                        recordList.data.quizList[i].isRight="待揭晓";
                    }
                    if(recordList.data.quizList[i].rightOption==undefined){
                        recordList.data.quizList[i].rightOption="待揭晓";
                    }
                    if(recordList.data.quizList[i].perBeanChange==undefined){
                        recordList.data.quizList[i].perBeanChange="待揭晓";
                    }
                    var text= "<div><p style='width: 3.4rem;overflow:hidden;text-align: center'>"+recordList.data.quizList[i].quizDate.substring(0,10)
                    +"</p><p style='width: 3.4rem;overflow:hidden;text-align: center'>"+recordList.data.quizList[i].isRight
                    +"</p><p style='width: 3.4rem;overflow:hidden;text-align: center'>"+recordList.data.quizList[i].perBeanChange
                    +"</p></div>";
                    $(".guessRecordArea > div").append(text);
                }
            }
        },
        error:function (msg) {
            console.log("guessRecordError"+JSON.stringify(msg));
        }
    })
};
obj.recordAnimate=function (x) {
    $(".guessRecordArea > div").animate({"top":-x*3+"rem"})
};