var bridge;
var userToken_mg,userId_mg,userIp_mg,appVersion_mg,userMacAddress_mg;
var model_mg,versionCode_mg,versionName_mg,release_mg;
var currentdate;

// 测试ip   15测试16现网
var ip = "10.61.5.60:8080/hnmgGame_api";
var webPageIp = "10.61.2.117:8080/hnmg_gaming";

// 公网ip
// var ip=115+"."+28+"."+228+"."+74+":"+5522+"/hnmgGaming_api";
// var ip_local=115+"."+28+"."+228+"."+74+":"+5522;
function setupWebViewJavascriptBridge(callback) {
    bridge = window.WebViewJavascriptBridge || window.WKWebViewJavascriptBridge;
    if (bridge) {
        return callback(bridge);
    }
    var callbacks = window.WVJBCallbacks || window.WKWVJBCallbacks;
    if (callbacks) {
        return callbacks.push(callback);
    }
    window.WVJBCallbacks = window.WKWVJBCallbacks = [callback];
    if (window.WKWebViewJavascriptBridge) {
        window.webkit.messageHandlers.iOS_Native_InjectJavascript.postMessage(null)
    } else {
        var WVJBIframe = document.createElement('iframe');
        WVJBIframe.style.display = 'none';
        WVJBIframe.src = 'https://__bridge_loaded__';
        document.documentElement.appendChild(WVJBIframe);
        setTimeout(function () {
            document.documentElement.removeChild(WVJBIframe)
        }, 0)
    }
}

setupWebViewJavascriptBridge(function (bridge) {
    bridge.registerHandler('echoHandler', function (data, responseCallback) {
        console.log("echoHandler :"+data);
        responseCallback(data)
    })
    bridge.registerHandler('jsRcvResponseTest', function (data, responseCallback) {
        bridge.callHandler('javaEchoToJs', {foo: 'bar'}, function (response) {
            if (response && response.foo == 'bar') {
                responseCallback("Response from JS")
            } else {
                responseCallback("Failed")
            }
        })
    })
    //bridge.hasNativeMethod('javaEchoToJs',function(b){
    //   alert(b===true)
    //})
})



function jumpAndroidCallH5TestActivity() {
    console.log('onclick   jumpActivityHandler');
    bridge.callHandler('jumpActivityHandler', {
        "packageName": "com.zte9.esports",
        "activityName": "com.zte9.webclient.activity.AndroidCallH5TestActivity",
        "flag": 1,
    }, function (response) {
        console.log('result:' + response)
    })
}
;(function getUserInfo() {
    console.log('onclick   userInfoBridgeHandler');
    bridge.callHandler('userInfoBridgeHandler', 'from web', function (response) {
        console.log('userinfo:' + response);
        var response1=JSON.parse(response);
        userId_mg=response1.userId;
        userToken_mg=response1.userToken;
        userIp_mg=response1.userIp;
        appVersion_mg=response1.appVersion;
        userMacAddress_mg=response1.userMacAddress;
        userMacAddress_mg=userMacAddress_mg.replace(/:/g,"-");
        // alert(userId_mg);
        return userId_mg;
    })
}());

// alert("idasda0000:" + userToken_mg);
;(function deviceInfoBridgeHandler() {
    console.log('onclick   deviceInfoBridgeHandler');
    bridge.callHandler('deviceInfoBridgeHandler', 'from web', function (response) {
        console.log('deviceInfoBridgeHandler:' + response);
        var response1=JSON.parse(response);
        model_mg=response1.model;
        versionCode_mg=response1.versionCode;
        versionName_mg=response1.versionName;
        release_mg=response1.release;

    })

}());
// alert("idasda:" + userId_mg);
function playVideo(url) {
    console.log('onclick   playVideoBridgeHandler');
    bridge.callHandler('playVideoBridgeHandler', url, function (response) {
        console.log('result:' + response)

    })
}
function playVideoList(data) {
    console.log('onclick   playVideoListBridgeHandler');
    // alert("before");
    bridge.callHandler('playVideoListBridgeHandler', data, function (response) {
        console.log('result:' + response);
        console.log(data);
    })
    // alert("after");
}
function jumpActivity() {
    console.log('onclick   jumpActivityHandler');
    bridge.callHandler('jumpActivityHandler', {
        "packageName": "com.zte9.eduhost",
        "activityName": "com.zte9.testapp.activity.SplashActivity",
        "flag": 1
    }, function (response) {
        console.log('result:' + response)
    })
}

function checkPackageExits() {
    console.log('onclick   packageExistsBridgeHandler');
    bridge.callHandler('packageExistsBridgeHandler', 'com.zte9.eduhost', function (response) {
        console.log('com.zte9.eduhost exits:' + response)
    })
}

//返回上一步（能记录上一步操作状态）
function newURl(url) {
    bridge.callHandler('newURlBridgeHandler',url, function (response) {
        console.log("newURlBridgeHandler:" + response);
    })
}
function exit() {
    console.log('onclick   exitWebBridgeHandler');
    bridge.callHandler('exitWebBridgeHandler',"goBack", function (response) {
        console.log(' exitWebBridgeHandler:' + response)
    })
}
//下载并启动apk
function installPackageAndLaunch(packageName,url) {
    console.log('onclick   packageInstallAndLaunchBridge');
    bridge.callHandler('packageInstallAndLaunchBridge', {
        "packageName": packageName,
        "activity": "com.zte9.plugindemo.MainActivity",
        "downloadUrl":url,
        "data": ""

    }, function (response) {
    })
}
// 小窗口播放
function windowPlayVideo(scient) {
    console.log('onclick   windowPlayVideoHandler');
    bridge.callHandler('windowPlayVideoHandler', scient, function (response) {

    })
}
//暂停播放
function windowStopPlayVideo() {
    console.log('onclick   stopPlayVideoHandler');
    bridge.callHandler('stopPlayVideoHandler', 'stopPlayVideo', function (response) {
    })
}

//订购统计
function statisticsOrder() {
    console.log('onclick   orderExitBridgeHandler');
    bridge.callHandler('orderExitBridgeHandler','orderExitBridgeHandler',function (response){

    })
}

function getDeviceInfo() {

    bridge.callHandler('deviceInfoBridgeHandler', 'deviceInfoBridgeHandler', function (response) {
        console.log("getDeviceInfo:" + response);
    })
}

function goback() {

    bridge.callHandler('webGoBackBridgeHandler', 'data', function (response) {
        console.log("webGoBackBridgeHandler:" + response);
    })
}

/*//外部推荐位跳转
setupWebViewJavascriptBridge(function (bridge) {
    bridge.registerHandler("gameHandler", function (data) {
        // alert("gameHandler:" + data);
        data=JSON.parse(data);
        console.log("data.type1:"+data.type);
        if(data.type==1){
            console.log("data.type1");
            windowStopPlayVideo();
            window.location.href = data.jumpUrl;

        }else if (data.type==2){
            console.log("data.type2");
            windowStopPlayVideo();
            // J("ztlist.html?recomId=" + data.id);
            function newURl() {
                bridge.callHandler('newURlBridgeHandler', "http://"+ ip_local +"/dianjing/ztlist.html?recomId=" + data.id, function (response) {
                    console.log("newURlBridgeHandler:" + response);
                })
            }
            newURl();
        }else if (data.type==3){
            console.log("data.type3");
            windowStopPlayVideo();
            playVideo({
                "musicName":data.musicName,
                "playerName":data.playerName,
                "typeCode":data.typeCode,
                "contentId":data.contentId,
                "serviceId":data.serviceId,
                "checkAutho":data.checkAutho,//0表示播放几十秒后检查是否是会员，如果不是则跳订购，1表示不检查
            });
        }else if (data.type==4){
            console.log("data.type4");
            windowStopPlayVideo();
            installPackageAndLaunch(data.packageName,data.url)
        }else if (data.type==5){
            windowStopPlayVideo();
            function newURl() {
                bridge.callHandler('newURlBridgeHandler', "http://"+ ip_local +"/dianjing/ztlist.html?recomId=" + data.id + "recomId=1", function (response) {
                    console.log("newURlBridgeHandler:" + response);
                })
            }
            newURl();
        }
    })
})*/


//首页小窗口轮播
function carouselFigureBridgeHandler(msg) {
    console.log('onclick   carouselFigureBridgeHandler');
    console.log("carouselFigureBridgeHandler  "+JSON.stringify(msg));
    bridge.callHandler('carouselFigureBridgeHandler', msg, function (response) {
        console.log('result:' + response)
    })
}
//暂停
function stopPlayVideoHandler() {
    console.log('onclick   stopPlayVideoHandler');
    bridge.callHandler('stopPlayVideoHandler',"stopPlayVideoHandler", function (response) {
        console.log('result:' + response)
    })
}
//拦截页
function showRecommend(){
    bridge.callHandler('showRecommendBridgeHandler', 'data', function (response) {
        console.log("showRecommendBridgeHandler:" + response);
    })
}
//跳转订购
setupWebViewJavascriptBridge(function (bridge) {
    bridge.registerHandler("jumpOrder", function (data) {
        console.log("jumpOrder html stop1");
        stopPlayVideoHandler();
        console.log("jumpOrder html stop2");
        window.location.href="http://"+ip_local+"/dianjing/order.html"

    })
})
/*获取class类名*/
function getElementClass(obj,index) {
    var cla=obj.attr("class");
    if(cla.indexOf(" ") == -1){
        return cla;
    }else {
        return (cla.split(/\s+/))[index];
    }
}

//获取当前时间 年月日
function getNowFormatDate() {
    var date = new Date();
    var seperator1 = "-";
    var seperator2 = ":";
    var month = date.getMonth() + 1;
    var strDate = date.getDate();
    var year=date.getFullYear();
    var hours=date.getHours();
    var minutes=date.getMinutes();
    var seconds=(date.getSeconds()<10)?"0"+date.getSeconds():date.getSeconds();
    if (month >= 1 && month <= 9) {
        month = "0" + month;
    }
    if (strDate >= 0 && strDate <= 9) {
        strDate = "0" + strDate;
    }
    var currentdate = year + seperator1 + month + seperator1 + strDate
        + " " + hours + seperator2 + minutes
        + seperator2 + seconds;
    console.log("currentdate:"+currentdate);
}

//获取首页视频轮播当前播放第几个
function getVideoNum() {
        bridge.callHandler('carouseFigureIndexBridgeHandler', 'from web', function (response) {
            console.log('carouseFigureIndexBridgeHandler:' + response);
            playVideo(list[response]);
            // alert(list);
            // alert(response);
        })

}
//首页轮播，无缝连接播放进度
function fullPlayVideoBridgeHandler() {
        bridge.callHandler('fullPlayVideoBridgeHandler', 'from web', function (response) {
            console.log('fullPlayVideoBridgeHandler:' + response);
        })

}
/*翻页*/
function rollAnimate(boxHeight,boxNum,focus,time,ele,isUP) {
    /*
    boxHeight:每页的高度 init 单位 rem；
    boxNum：每页的数量 init；
    focus：当前焦点位置 init；
    allHeight：主题区域的实际高度 init；
    time：动画时间 init
    isUP: 传 0 向上移动
          传 1 向下移动
     */
    // if(isUP==0){
    //     if(focus % boxNum  != 0){
    var top = -((Math.ceil((focus+1)/boxNum)-1) * boxHeight) + "rem";
    ele.stop().animate({top:top},time);
    // }
    // }else if(isUP==1){
    //     if(focus % boxNum == 0){
    //         var top = -((Math.ceil((focus+1)/boxNum)-1) * boxHeight) + "rem";
    //         console.log(top);
    //         ele.stop().animate({top:top},time);
    //     }
    // }
}
/*标题滚动轮播*/
var settime;
function textScroll(boxWidth,moveEle,spead,resetEle) {
    /*
    spead:像素值  init
    boxWidth: 容器大小 init
    * */
    clearInterval(settime);
    for (var i=0;i<resetEle.length;i++) {
        resetEle.eq(i).css({left:0});
    }
    var lef;
    var actualWid = moveEle.width();
    function setInterFun() {
        lef = parseInt(moveEle.position().left);
        settime = setInterval(function () {
            lef=lef+spead;
            if( lef < actualWid){
                moveEle.css({left:-lef +"px"})
            }else {
                clearInterval(settime);
                moveEle.css({left:0});
                /*
                连续滚动播报
                moveEle.css({left:-boxWidth+"px"});
                setInterFun();
                */
            }
        },40);
    }
    if(actualWid > boxWidth){
        setInterFun();
    }
}

/*获取url内的参数*/
/*
parameter 携带参数的 key
* */
function getUrlParameter(parameter) {
    var url=window.location.href;
    var variable;
    if(url.indexOf(parameter)!=-1) {
        url = url.split(parameter)[1];
        if (url.indexOf("&") != -1) {
            variable = url.split("&")[0];
        } else {
            variable = url;
        }
        return variable;
    }
}
var allTeamList={};
function getAllTeamList() {
    /*获取所有队伍信息，并转化为key val的形式*/
    $.ajax({
        type:"GET",
        dataType:"json",
        url:"http://"+ip+"/common/teams",
        success:function(msg){
            console.log("getAllTeamList success"+":"+JSON.stringify(msg));
            var list=msg.data;
            for(var i=0;i<list.length;i++){
                allTeamList[list[i].id]=list[i];
            }
        },
        error:function (msg) {
            console.log("getAllTeamList error:"+JSON.stringify(msg));
        }
    });
}
function getAllGameList() {
    /*获取队伍所属游戏名称*/
    $.ajax({
        type:"GET",
        dataType:"json",
        url:"http://"+ip+"/common/teams",
        success:function(msg){
            console.log("getAllTeamList success"+":"+JSON.stringify(msg));
            var list=msg.data;
            for(var i=0;i<list.length;i++){
                allTeamList[list[i].id]=list[i];
            }
        },
        error:function (msg) {
            console.log("getAllTeamList error:"+JSON.stringify(msg));
        }
    })
}
function jump_ZtList_playVideo(data) {
    /*1是音乐(单个视频列表) 2是第三方apk 3是当地ktv广告位 4单个音乐（全屏播放） 5自己的activity（活动）
     6 专题列表  7 单个专题 */
    if(data.activityType==1){
        // newURl("http://"+webPageIp+"/allEvents.html?typeCode="+data.typeCode);
        window.location.href="http://"+webPageIp+"/allEvents.html?typeCode="+data.typeCode;
    }else if(data.activityType==2){

    }else if(data.activityType==3){

    }else if(data.activityType==4){
        playVideo(JSON.stringify(data));
    }else if(data.activityType==5){

    }else if(data.activityType==7){
        if(data.recomType ==1){
            newURl("http://"+webPageIp+"/gameClass.html?id="+data.id);
            window.location.href="http://"+webPageIp+"/gameClass.html?id="+data.id;
        }else if(data.recomType==2){
            newURl("http://"+webPageIp+"/gameMatch.html?id="+data.id);
            window.location.href="http://"+webPageIp+"/gameMatch.html?id="+data.id;
        }
    }else if(data.activityType==6){
        newURl("http://"+webPageIp+"/videoTopics.html?id="+data.id);
        window.location.href="http://"+webPageIp+"/videoTopics.html?id="+data.id;
    }
}


//鉴权级取串
// isGetUrl 判断是否请求 取串 1 是  其他否
// typeCode  获取是否免费用到
// contentId  内容编号 取串鉴权都要用到
// userId 用户编号 鉴权 保存用户信息用到
// type  取串用到  1中兴 2华为
// UrlFromsource  取串用到
// usertoken 用户token  鉴权用到
// mac   鉴权用到
// version  鉴权用到
// authFromsource  鉴权用到

function authenticationGetUrl(typeCode,contentId,UrlFromsource,version,authFromsource,isGetUrl,serviceId) {
    console.log("userId_mg:"+userId_mg+"userToken_mg:"+userToken_mg+"userIp_mg:"+userIp_mg+"appVersion_mg:"+appVersion_mg+"userMacAddress_mg:"+userMacAddress_mg);
    $.ajax({

        type:"GET",
        dataType:"json",
        // url:"http://"+ip +port,
        url:"http://" + ip_local + "/hnmgGaming_pay/hnmg/saveUserInfo",
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
                order();
                // "javascript:"+ fun1;
                console.log("authentication Success1:"+JSON.stringify(msg));
            }else if(msg.data.authInfo.result==0){

                $('.orderPrompt').css({display:"block"});
                $('.orderPromptText').html("您已订购该包月");
                setTimeout(function(){
                    $('.orderPrompt').css({display:"none"});
                },2000);

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
// 76c94dd28ab94576adc48c7ef093caaf


//统计

function category_zte(typeCode,statisticsId,pageName){
    var datas={
        'model':model_mg,
        'version':appVersion_mg,
        'release':release_mg,
        'mac':userMacAddress_mg,
        'versionCode':versionCode_mg,
        'versionName':versionName_mg,
        'userId':userId_mg,
        'statisticsCode':typeCode,
        "statisticsId":statisticsId,
        'pageName':pageName
    };
    $.ajax({
        type:"GET",
        dataType:"json",
        url:"http://"+ ip + "/stat/music/category",
        data:JSON.stringify(datas),
        success:function(msg){
            console.log("statistics_zte success:"+JSON.stringify(msg));
            // alert("msg.code:"+msg.code);
        },
        error:function (msg) {
            console.log("statistics_zte success:"+JSON.stringify(msg));
        }
    })
}

