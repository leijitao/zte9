var frameX=0,focusX=0,topX=0;
var page;
console.log("urlurlurlurlurlmy"+window.location.href);
window.onload=function(){
    obj.getMyPrizeInfor();
    statistics(5);
    getCursor();
};
var cursor;
var isBind;//0 未绑定手机号  1 已绑定
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
            if(frameX==1){
                if (topX>0){
                    topX--
                }
                obj.resetKeyStyle(topX);
            }
            break;
        case 38:
            if(frameX==1){
                if(topX==12){
                    topX=11
                }else {
                    if (topX>2){
                        topX-=3;
                    }
                }
                obj.resetKeyStyle(topX);
            }
            break;
        case 39:
            if(frameX==1){
                if (topX<12){
                    topX++;
                }
                obj.resetKeyStyle(topX);
            }
            break;
        case 40:
            if(frameX==1){
                if (topX<9){
                    topX+=3;
                }else {
                    topX=12;
                }
                obj.resetKeyStyle(topX);
            }
            break;
        case 13:
            if(frameX==0){
                frameX=1;
                $(".modifyPhone").show();
                obj.resetKeyStyle(topX);
            }else{
                if (topX<9){
                    $(".newPhoneNum").html($(".newPhoneNum").html() + (topX+1))
                }else if (topX==9){
                    $(".newPhoneNum").html($(".newPhoneNum").html() + 0)
                }else if (topX==10){
                    $(".newPhoneNum").html("")
                }else if (topX==11){
                    var num = $('.newPhoneNum').html();
                    num = num.substring(0, num.length - 1);
                    $('.newPhoneNum').html(num);
                }else if (topX==12){
                    obj.submitPhone();
                }
            } 
            break;
    }
};
function doBackPressed() {
    if(frameX==0){
        if(){

        }
        window.location.href="http://"+ip_local+"/index.html?cursor="+cursor;
    }else {
        $(".modifyPhone").hide();
        frameX=0;
    }
}
var obj=[];
obj.getMyPrizeInfor=function () {
    var datas = {
        "userAuth":{
            "userId": userId,
            "contentCode": contentCode,
            "userToken": token,
            "mac": mac,
            "fromSource":fromSource,
            "version":version
        },
        "awardType":"2"
    };
    $.ajax({
        type: "POST",
        dataType: "json",
        contentType: 'application/json;charset=UTF-8',
        // url:"http://192.168.0.72:8080/sign/period",
        url: "http://"+ip+"/award/record",
        data: JSON.stringify(datas),
        success:function (msg) {
            console.log("getMyPrizeInforSuccess"+JSON.stringify(msg));
            if(msg.code==0){
                var level=msg.data.memberShip.userLevel;
                if(msg.data.hasOwnProperty("list")&&msg.data.user.phoneNumber!=null){
                    page=Math.ceil(msg.data.list.length/6);
                }else {
                    page=1
                }
                if(level==1){
                    $(".myPrizeVipLv").children().eq(0).show();
                }else if(level==4){
                    $(".myPrizeVipLv").children().eq(2).show();
                }else {
                    $(".myPrizeVipLv").children().eq(1).show();
                }
                $(".myPrizeBeanNum").html(msg.data.user.musicBean);
                if(msg.data.user.hasOwnProperty("phoneNumber")&&msg.data.user.phoneNumber!=null){
                    $(".myPrizePhoneNum").html(msg.data.user.phoneNumber);
                    $(".myPrizeModifyButton").children().eq(1).show();
                    isBind=1;
                }else {
                    isBind=0
                    $(".myPrizePhoneNum").html("请绑定手机号");
                    $(".myPrizeModifyButton").children().eq(0).show();
                }
                $(".myPrizeRecordArea > div").html("");
                for(var x in msg.data.list){
                    if(msg.data.list[x].relatedPlate==0){
                        msg.data.list[x].relatedPlate="周签宝箱奖励"
                    }else {
                        msg.data.list[x].relatedPlate="礼品兑换"
                    }
                    var lists="<div><p style='width: 3.4rem;float:left'>"
                    +msg.data.list[x].updateTime
                    +"</p><p style='width: 3.4rem;float:left'>"+msg.data.list[x].awardTitle
                    +"</p><p style='width: 2.4rem;float:left'>"+msg.data.list[x].relatedPlate
                    +"</p></div>";
                    $(".myPrizeRecordArea > div").append(lists);
                }
            }
        },
        error:function (msg) {
            console.log("getMyPrizeInforError"+JSON.stringify(msg));
        }
    })
};
obj.submitPhone=function () {
    var myreg=/^[1][3,4,5,7,8][0-9]{9}$/;
    if(!(myreg.test($(".newPhoneNum").html()))){
        $(".remindPhone").show();
    }else {
        $(".remindPhone").hide();
        var datas = {
            "userAuth":{
                "userId": userId,
                "contentCode": contentCode,
                "userToken": token,
                "mac": mac,
                "fromSource":fromSource,
                "version":version
            },
            "user":{
                "phoneNumber":$(".newPhoneNum").html()
            }
        };
        $.ajax({
            type: "POST",
            dataType: "json",
            contentType: 'application/json;charset=UTF-8',
            url: "http://"+ip+"/user/update",
            data: JSON.stringify(datas),
            success: function (msg) {
                console.log("submitPhoneSuccess"+JSON.stringify(msg));
                if(msg.code==0){
                    // obj.getMyPrizeInfor();
                    $(".modifyPhone").hide();
                    frameX=0;
                    obj.getMyPrizeInfor();
                    if (isBind==0){
                        frame.hasAttend("手机号绑定成功");
                    }else {
                        frame.hasAttend("手机号修改成功");
                    }
                }
            },
            error:function (msg) {
                console.log("submitPhoneError"+JSON.stringify(msg));
            }
        })
    }
};
obj.recordAnimate=function (x) {
    $(".myPrizeRecordArea > div").animate({"top":-x*3+"rem"})
};
var style=[
    {
        "top":"1.38rem",
        "left":"5.35rem"
    },{
        "top":"1.38rem",
        "left":"5.98rem"
    },{
        "top":"1.38rem",
        "left":"6.61rem"
    },{
        "top":"2.01rem",
        "left":"5.35rem"
    },{
        "top":"2.01rem",
        "left":"5.98rem"
    },{
        "top":"2.01rem",
        "left":"6.61rem"
    },{
        "top":"2.64rem",
        "left":"5.35rem"
    },{
        "top":"2.64rem",
        "left":"5.98rem"
    },{
        "top":"2.64rem",
        "left":"6.61rem"
    },{
        "top":"3.27rem",
        "left":"5.35rem"
    },{
        "top":"3.27rem",
        "left":"5.98rem"
    },{
        "top":"3.27rem",
        "left":"6.61rem"
    }
]
obj.resetKeyStyle=function (x) {
    if(x<12){
        $(".submitButton").children().eq(1).hide();
        $(".modifyPhoneKeyFocus").css({top:style[x].top,left:style[x].left,display:"block"})
    }else {
        $(".modifyPhoneKeyFocus").hide();
        $(".submitButton").children().eq(1).show();
    }
}