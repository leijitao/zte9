var bridge;
var userToken_mg;
var userId_mg;
var userIp_mg;
var appVersion_mg;
var userMacAddress_mg;
var videoNum;
var VipResult;
var palyVideoUrl716;

var model_mg;
var versionCode_mg;
var versionName_mg;
var release_mg;
var currentdate;

var click_goback=true;
// 测试ip
var ip=183+"."+234+"."+214+"."+6+":"+8082+"/gdydGaming_api";
var ip_local=183+"."+234+"."+214+"."+6+":"+8082;
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

//外部推荐位跳转
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
})


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
//获取当前时间 年月日
function getNowFormatDate() {
    var date = new Date();
    var seperator1 = "-";
    var seperator2 = ":";
    var month = date.getMonth() + 1;
    var strDate = date.getDate();
    if (month >= 1 && month <= 9) {
        month = "0" + month;
    }
    if (strDate >= 0 && strDate <= 9) {
        strDate = "0" + strDate;
    }
    currentdate = date.getFullYear() + seperator1 + month + seperator1 + strDate
        + " " + date.getHours() + seperator2 + date.getMinutes()
        + seperator2 + date.getSeconds();
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

//获取播放地址
// function getVideoUrl(contentId) {
//     $.ajax({
//         type:"GET",
//         dataType:"json",
//         // url:"http://"+ip +"/hnmg/hnmgOrderMonthly",
//         url:"http://58.20.27.16:8088/hnmgGaming_pay/hnmg/hnmgOrderMonthly",
//         data:{
//             "contentId":contentId,
//         },
//         success:function(msg){
//
//
//         },
//         error:function (msg) {
//             alert(msg);
//             console.log("order:"+msg);
//
//         }
//     })
// }

//鉴权
function authenticationGetUrl(method) {
    $.ajax({
        type:"GET",
        dataType:"json",
        url:"http://" + ip_local + "/gzmobile/pay/auth",
        data:{
            'userId':userId_mg

        },
        success:function(msg){
            console.log("playVideoUrl"+JSON.stringify(msg));
            if(msg.status==0){
                if(msg.result==1){
                    $('.orderPrompt').css({display:"block"});
                    $('.orderPromptText').html("您已订购该包月");
                    setTimeout(function(){
                        $('.orderPrompt').css({display:"none"});
                    },2000);
                    console.log("authentication Success0:"+JSON.stringify(msg));
                }else if(msg.result==0){
                    //支付中
                    $('.orderPrompt').css({display:"block"});
                    $('.orderPromptText').html("支付中：请根据短信提示完成支付");
                    setTimeout(function(){
                        $('.orderPrompt').css({display:"none"});
                    },2000);
                    console.log("authentication Success1:"+JSON.stringify(msg));
                }else if(msg.result==2){
                    //未订购or支付失败
                    method;
                    console.log("authentication Success1:"+JSON.stringify(msg));
                }
            }else{
                console.log("authentication SuccessOther:"+JSON.stringify(msg));
            }

        },
        error:function (msg) {
            console.log("authentication Error:"+JSON.stringify(msg));
        }
    })
}
//  订购
function order(phone,method) {
    $.ajax({
        type:"GET",
        dataType:"json",
        url:"http://"+ip_local+"/gzmobile/pay/payment",
        data:{
            'userId':userId_mg,
            'userArea':"",//非必需
            'payType':userToken_mg,//1、话费支付 2、第三方支付，暂不支持 3、微信支付  4、积分，暂不支持  5、支付宝
            'orderType':"1",//1：按时段订购 2：按次订购
            'autoSub':"1",//0：不自动续订，1：自动续订
            'userPhone':phone
        },
        success:function(msg){
            console.log("ordermsg success:"+ JSON.stringify(msg));
            if(msg.code==0){
                method;
                // if (msg.status==0){
                //     $('.orderPrompt').css({display:"block"});
                //     $('.orderPromptText').html("订购成功");
                //     setTimeout(function(){
                //         $('.orderPrompt').css({display:"none"});
                //     },2000);
                //     backActivityPage();
                // }else{
                //     $('.orderPrompt').css({display:"block"});
                //     $('.orderPromptText').html("订购失败，请稍后重试");
                //     setTimeout(function(){
                //         $('.orderPrompt').css({display:"none"});
                //     },5000);
                // }
            }else {
                $('.orderPrompt').css({display:"block"});
                $('.orderPromptText').html("订购失败，请稍后重试");
                setTimeout(function(){
                    $('.orderPrompt').css({display:"none"});
                },3000);
            }
        },
        error:function (msg) {
            console.log("ordermsg error:"+ JSON.stringify(msg));
            $('.orderPrompt').css({display:"block"});
            $('.orderPromptText').html("订购失败，请稍后重试");
            setTimeout(function(){
                $('.orderPrompt').css({display:"none"});
            },3000);
        }
    })
}
//取消自动续订
function Unsubscribe(){
    $.ajax({
        type:"GET",
        dataType:"json",
        url:"http://"+ip_local+"/gzmobile/pay/payment",
        data:{
            'userId':userId_mg,
        },
        success:function (msg) {
            console.log("Unsubscribe success:"+ JSON.stringify(msg));
            if(msg.code==0){
                if(msg.status==0){
                    //取消自动续订成功
                }else {
                    //取消自动续订失败
                }
            }else {
                //取消自动续订失败
            }
        },
        error:function (msg) {
            console.log("Unsubscribe reeor:"+ JSON.stringify(msg));
        }
    })
}

//   中九 点播，其他，二级节点，推荐位点击数统计
// play	不为空则为点播统计
// other	不为空则为其他统计
// category	不为空则为二级节点统计
// recClick	不为空则为点播数据统计

//一级、二级导航统计

function category_zte(typeCode,pageName){
    // alert(userId_mg) ;
    // alert(userToken_mg) ;
    // alert(userIp_mg) ;
    // alert(appVersion_mg) ;
    // alert(userMacAddress_mg) ;
    // alert(model_mg);
    // alert(versionCode_mg);
    // alert(versionName_mg);
    // alert(release_mg);
    $.ajax({
        type:"GET",
        dataType:"json",
        url:"http://"+ ip + "/stat/music/category",
        data:{
            'model':model_mg,
            'version':appVersion_mg,
            'release':release_mg,
            'mac':userMacAddress_mg,
            'versionCode':versionCode_mg,
            'versionName':versionName_mg,
            'userId':userId_mg,
            'typeCode':typeCode,
            'pageName':pageName,
        },

        success:function(msg){
            console.log(msg);
            // alert("msg.code:"+msg.code);
        },
        error:function (msg) {
            console.log("statistics_zte:"+msg);
        }
    })
}
//推荐位统计
function recClick_zte(recommId,specialName){
    $.ajax({
        type:"GET",
        dataType:"json",
        url:"http://"+ ip + "/stat/music/recClick",
        data:{
            'model':model_mg,
            'version':appVersion_mg,
            'release':release_mg,
            'mac':userMacAddress_mg,
            'versionCode':versionCode_mg,
            'versionName':versionName_mg,
            'userId':userId_mg,
            'recommdId':recommId,
            'pageName':specialName,
        },

        success:function(msg){
            console.log(msg);
            // alert(msg.code);
        },
        error:function (msg) {
            // alert(msg.code);
        }
    })
}
//搜索、订购页统计
function other_zte(pageName){
    $.ajax({
        type:"GET",
        dataType:"json",
        url:"http://"+ ip + "/stat/music/other",
        data:{
            'model':model_mg,
            'version':appVersion_mg,
            'release':release_mg,
            'mac':userMacAddress_mg,
            'versionCode':versionCode_mg,
            'versionName':versionName_mg,
            'userId':userId_mg,
            'pageName':pageName,
        },

        success:function(msg){
            // alert("msg.codemsg.codemsg.code"+msg.code);
            console.log(msg);

        },
        error:function (msg) {
            console.log("statistics_zte:"+msg);
        }
    })
}

//芒果统计
//1 心跳 operator: 001:湖南电信 002:湖南联通 003:湖南移动

// function statisticsHeart_mg() {
//     $.ajax({
//         type:"GET",
//         dataType:"json",
//         url:"http://"+ ip + "/stat/music/other",
//         data:{
//             'user_id':userId_mg,
//             'mac':userMacAddress_mg,
//             'operator':'002',
//             'sp_code':,
//             'create_time':,
//         },
//
//         success:function(msg){
//             alert("msg.codemsg.codemsg.code"+msg.code);
//             console.log(msg);
//
//         },
//         error:function (msg) {
//             console.log("statistics_mg:"+msg);
//         }
//     })
// }

//2 页面浏览 'event_type':,'button_id ':,'button_name':,'reserve1':,'reserve2':,为空
//3 点击事件
// function statisticsVisitHtml_mg(currentdate,page_id,pagepath,nextpagepath,pagename,special_id,way,offset_name,offset_id,category_id,media_id,key,event_type,button_id,button_name,reserve1,reserve2,offset_group,media_group,channel_id) {
//     getNowFormatDate();
//     $.ajax({
//         type:"GET",
//         dataType:"json",
//         url:"http://119.39.13.147/DataCollection ",
//         data:{
//             'type':'0x07',
//             'user_id':userId_mg,
//             'mac':userMacAddress_mg,
//             'operator':'002',
//             'sp_code':'f1bd6740e96341a290588556fd01b810',
//             'create_time':currentdate,
//             'page_id':page_id,
//             'pagepath':pagepath,
//             'nextpagepath':nextpagepath,
//             'pagename':pagename,
//             'special_id':special_id,
//             'way':way,
//             'offset_name':offset_name,
//             'offset_id':offset_id,
//             'category_id':category_id,
//             'media_id ':media_id,
//             'key':key,
//             'event_type':event_type,
//             'button_id ':button_id,
//             'button_name':button_name,
//             'reserve1':reserve1,
//             'reserve2':reserve2,
//             'offset_group':offset_group,
//             'media_group':media_group,
//             'channel_id':channel_id,
//         },
//
//         success:function(msg){
//             alert("statisticsVisitHtml_mg:"+msg.code);
//             // console.log(msg);
//
//         },
//         error:function (msg) {
//             console.log("statistics_mg:"+msg);
//         }
//     })
// }
//
// statisticsVisitHtml_mg('','','','','','','','','','','','','','','','','','','','');

