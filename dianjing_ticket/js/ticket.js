var vTicketHome=true,vTicketWinner=false,vTicketPhone=false,vTicketSuccess=false,vTicketError=false,vTicketOrder=false;
var vTicketHomeX=3;
var vTicketPhoneX=0;
var vTicketOrderX=0;
var vTicketWinnerX=0;
var nowPage,allPage;
var allWinningMessage;
var ip=58+"."+20+"."+27+"."+16+":"+8080;
function reset_ticketHome(x){
    $(".ticketHomeAllFocus").hide();
    $(".ticketHome").children().eq(x).children().eq(1).show();
}
var myreg=/^[1][3,4,5,7,8][0-9]{9}$/;
function subPhone(x){
    $.ajax({
        type:"GET",
        dataType:"json",
        url:"http://"+ip+"/hncj_api_v2/store/game/v3.1/user/ticket",
        data:{
            "userId":userId_mg,
            // "userId":123,
            "phoneNum":x
        },
        success:function(msg){
            if(msg.code==1){
                vTicketPhone=false;
                vTicketSuccess=true;
                $(".ticketPhone").hide();
                $(".ticketSuccess").show();
            }else {

            }

        },
        error:function (msg) {

        }
    });
}
document.onkeydown=function(e) {
    e = window.event || e;
    /**
     * 37 左键盘
     * 38 上键盘
     * 39 右键盘
     * 40 下键盘
     * 13 回车键
     */

    switch (e.keyCode) {
        case 37:
            if(vTicketHome){
                vTicketHomeX--;
                if(vTicketHomeX<=0){
                    vTicketHomeX=0;
                }
                reset_ticketHome(vTicketHomeX);
            }else if(vTicketOrder){
                vTicketOrderX=0;
                $(".ticketOrderD1").children(".ticketOrderi2").show();
                $(".ticketOrderD2").children(".ticketOrderi2").hide();
            }else if(vTicketWinner){
                vTicketWinnerX=0;
                $(".ticketWinner_left").css({"transform":"scale(1.7,1.7)"});
                $(".ticketWinner_right").css({"transform":"scale(1.3,1.3)"});
            }
            break;
        case 38:
            if(vTicketHome){
                if(vTicketHomeX==2||vTicketHomeX==3){
                    vTicketHomeX=0
                }else if(vTicketHomeX==4){
                    vTicketHomeX=1
                }
                reset_ticketHome(vTicketHomeX);
             }else if(vTicketPhone){
                vTicketPhoneX=0;
                $(".ticketPhoneimg").css({"top":"1.03rem"});
            }
            break;
        case 39:
            if(vTicketHome){
                vTicketHomeX++;
                if(vTicketHomeX>=4){
                    vTicketHomeX=4;
                }
                reset_ticketHome(vTicketHomeX);
            }else if(vTicketOrder){
                vTicketOrderX=0;
                $(".ticketOrderD2").children(".ticketOrderi2").show();
                $(".ticketOrderD1").children(".ticketOrderi2").hide();
            }else if(vTicketWinner){
                vTicketWinnerX=1;
                $(".ticketWinner_left").css({"transform":"scale(1.3,1.3)"});
                $(".ticketWinner_right").css({"transform":"scale(1.7,1.7)"});
            }
            break;
        case 40:
            if(vTicketHome){
                if(vTicketHomeX==0){
                    vTicketHomeX=2
                }else if(vTicketHomeX=1){
                    vTicketHomeX=4
                }
                reset_ticketHome(vTicketHomeX);
             }else if(vTicketPhone){
                vTicketPhoneX=1;
                $(".ticketPhoneimg").css({"top":"1.8rem"});
            }
            break;
        case 13:
            if(vTicketHome){
                if(vTicketHomeX==0){
                    $(".contentRule").attr("src","images/home/introduce.png")
                }else if(vTicketHomeX==1){
                    $(".contentRule").attr("src","images/home/rule.png")
                }else if(vTicketHomeX==2){
                    vTicketHome=false;
                    vTicketWinner=true;
                    $(".ticketHome").hide();
                    $(".ticketWinner").show();
                    getSubPhoneList();
                }else if(vTicketHomeX==3){
                    authenticationGetUrl("","",20,"YYS.8.0.0.Y28.0.HNLT.0.0_Pre_Release",20,1,"d34cc6f39bf242e18248b944bf3cbff0");
                }else if(vTicketHomeX==4){
                    var url=window.location.href;
                    window.location.href="http://"+ip+"/dianjing/index.html?html="+url;
                }
            }else if(vTicketPhone){
                if(vTicketPhoneX==1){
                    var phoneNum=$(".ticketPhoneipt").html().toString();
                    console.log("ticket phoneNum:"+phoneNum);
                    if(!myreg.test(phoneNum)){
                        alert("请输入正确的手机号码");
                    }else{
                        subPhone(phoneNum);
                    }
                }
            }else if(vTicketSuccess){
                history.go(0);
            }else if(vTicketError){
                history.go(0);
            }else  if(vTicketOrder){
                if(vTicketOrderX==0){
                    window.location.href='http://'+ip+'/dianjing/order.html'
                }else {
                    history.go(0);
                }
            }else if(vTicketWinner){
                if(vTicketWinnerX==0){
                    nowPage--;
                    if(nowPage<=0){
                       nowPage=allPage;
                    }
                }else if(vTicketWinnerX==1){
                    nowPage++;
                    if(nowPage>allPage){
                        nowPage=1;
                    }
                }
                allWinningAnimate();
            }
            break;
    }
}
//鉴权
function authenticationGetUrl(typeCode,contentId,UrlFromsource,version,authFromsource,isGetUrl,serviceId) {
    // alert(userId_mg);
    // alert(userToken_mg);
    // alert(userIp_mg);
    // alert(appVersion_mg);
    // alert(userMacAddress_mg);
    console.log("userId_mg:"+userId_mg+"userToken_mg:"+userToken_mg+"userIp_mg:"+userIp_mg+"appVersion_mg:"+appVersion_mg+"userMacAddress_mg:"+userMacAddress_mg);
    $.ajax({
        type:"GET",
        dataType:"json",
        // url:"http://"+ip +port,
        url:"http://"+ip+"/hnmgGaming_pay/hnmg/saveUserInfo",
        data:{
            "typeCode":typeCode,
            'contentId':contentId,
            'userId':userId_mg,
            // 'userId':"073199999918A@tv",

            'UrlFromsource':UrlFromsource,
            'userToken':userToken_mg,
            // 'usertoken':"37A@tv81091820028089171121529101",

            'mac':userMacAddress_mg,
            // 'mac':"BC-20-BA-EA-76-38",

            // 'version':appVersion_mg,
            'version':version,
            'authFromsource':authFromsource,
            'isGetUrl':isGetUrl,
            'serviceId':serviceId

        },
        success:function(msg){
            console.log("playVideoUrl"+JSON.stringify(msg));
            if(msg.data.authInfo.result==1){
                //未订购
                vTicketHome=false;
                vTicketOrder=true;
                $(".ticketOrder").show();
                console.log("authentication Success1:"+JSON.stringify(msg));
            }else if(msg.data.authInfo.result==0){
                getIsSubPhone();
                console.log("authentication Success0:"+JSON.stringify(msg));
            }else{
                console.log("authentication SuccessOther:"+JSON.stringify(msg));
            }

        },
        error:function (msg) {
            console.log("authentication Error:"+JSON.stringify(msg));
        }
    })

}
//验证改用户是都已经填写手机号
function getIsSubPhone(){
    $.ajax({
        type:"GET",
        dataType:"json",
        // url:"http://"+ip +port,
        url:"http://"+ip+"/hncj_api_v2/store/game/v3.1/user/SelectTicket",
        data:{
            // userId:"123"
            userId:userId_mg
        },
        success:function (msg) {
            if(msg.code==18){
            //未填写手机号
                vTicketHome=false;
                vTicketPhone=true;
                $(".ticketHome").hide();
                $(".ticketPhone").show();
            }else if(msg.code==15){
            //    填写手机号
                vTicketHome=false;
                vTicketError=true;
                $(".ticketHome").hide();
                $(".ticketError").show();
            }
        }
    })
}

function getSubPhoneList() {
    $.ajax({
        type:"GET",
        dataType:"json",
        // url:"http://"+ip +port,
        url:"http://"+ip+"/hncj_api_v2/store/game/v3.1/user/SelectOctober",
        data:{},
        success:function (msg) {
            allWinningMessage=msg.data;
            console.log(allWinningMessage);
            allPage=Math.ceil(allWinningMessage.length/6);
            nowPage=1;
            if(msg.data.length<=6){
                $(".ticketWinner_content").html("");
                for(var x in msg.data){
                    var list="<div style='height:0.35rem;margin-top: 0.11rem;overflow: hidden;line-height: 0.35rem;font-size: 0.2rem'><p style='width:2.7rem;margin-left:0.4rem;float:left;height:0.35rem'>"+allWinningMessage[x].userId+"</p><p style='width:2.83rem;float:left;height:0.35rem'>"+allWinningMessage[x].phoneNum+"</p><p style='width:1.4rem;float:left;height:0.35rem'>"+allWinningMessage[x].createDateTime+"</p></div>"
                    $(".ticketWinner_content").append(list);
                }
            }else {
                for(var x=0;x<6;x++){
                    var list="<div style='height: 0.35rem;margin-top: 0.11rem;overflow: hidden;line-height: 0.35rem;font-size: 0.2rem'><p style='width:2.7rem;margin-left:0.4rem;float:left;height:0.35rem'>"+allWinningMessage[x].userId+"</p><p style='width:2.83rem;float:left;height:0.35rem'>"+allWinningMessage[x].phoneNum+"</p><p style='width:1.4rem;float:left;height:0.35rem'>"+allWinningMessage[x].createDateTime+"</p></div>"
                    $(".ticketWinner_content").append(list);
                    // alert(data1[integra].integralRanking);
                    // alert(lis1);
                }
            }
        }
    })
}

function allWinningAnimate(){
    $(".ticketWinner_content").html("");
    console.log(nowPage);
    if(nowPage<allPage){
        for(var x=6*nowPage-6;x<6*nowPage;x++){
            var list="<div style='height: 0.35rem;margin-top: 0.11rem;overflow: hidden;line-height: 0.35rem;font-size: 0.2rem'><p style='width:2.7rem;margin-left:0.4rem;float:left;height:0.35rem'>"+allWinningMessage[x].userId+"</p><p style='width:2.83rem;float:left;height:0.35rem'>"+allWinningMessage[x].phoneNum+"</p><p style='width:1.4rem;float:left;height:0.35rem'>"+allWinningMessage[x].createDateTime+"</p></div>"
            $(".ticketWinner_content").append(list);
        }
    }else{
        for(var x=6*nowPage-6;x<allWinningMessage.length;x++){
            var list="<div style='height: 0.35rem;margin-top: 0.11rem;overflow: hidden;line-height: 0.35rem;font-size: 0.2rem'><p style='width:2.7rem;margin-left:0.4rem;float:left;height:0.35rem'>"+allWinningMessage[x].userId+"</p><p style='width:2.83rem;float:left;height:0.35rem'>"+allWinningMessage[x].phoneNum+"</p><p style='width:1.4rem;float:left;height:0.35rem'>"+allWinningMessage[x].createDateTime+"</p></div>"
            $(".ticketWinner_content").append(list);
        }
    }
}


setupWebViewJavascriptBridge(function (bridge) {
    bridge.registerHandler('keyEventHandler', function (data, responseCallback) {
        console.log("keyEventHandler :" + data);
        if (data == 4) {
            if(vTicketHome){
                var url=window.location.href;
                window.location.href="http://"+ip+"/dianjing/index.html?html="+url;
            }else {
                history.go(0);
            }
        }else if(data==7||data==8||data==9||data==10||data==11||data==12||data==13||data==14||data==15||data==16){
            if(vTicketPhone){
                if(vTicketPhoneX==0) {
                    if ($(".ticketPhoneipt").html().length >= 11) {
                        var phoneNumHtml = $(".ticketPhoneipt").html()
                    } else {
                        var phoneNumHtml = $(".ticketPhoneipt").html() + (data - 7);
                    }
                    $(".ticketPhoneipt").html(phoneNumHtml);
                }
            }
        }else if(data==67){
            if(vTicketPhone){
                var phoneNumHtml=$(".ticketPhoneipt").html().toString();
                phoneNumHtml=phoneNumHtml.substring(0,phoneNumHtml.length-1);
                $(".ticketPhoneipt").html(phoneNumHtml)
            }
        }
    })
})