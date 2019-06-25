var ip=10+"."+255+"."+25+"."+151+":"+8088;
// var ip=175+"."+6+"."+223+"."+26+":"+8088;
var ip_local=10+"."+255+"."+25+"."+151+":"+8088+"/singwithme";
// var ip_local=192+"."+168+"."+0+"."+123+":"+8080+"/singer";

var userId = Webview.readSystemProp("user.id");
// var userId = "YYS.4.8.2.266.5.HNDX.0.0_Release_ZTE_4K";
var appName = Webview.readSystemProp("app.name");
var appVersion = Webview.readSystemProp("app.version");
var mac = Webview.readSystemProp("device.mac");
var token = Webview.readSystemProp("user.token");
var contentCode="E62670";
// var getVersion=Webview.getVersion();
// alert(getVersion);
var app1=appVersion.substring(6,7);
var app2=appVersion.substring(8,9);

console.log(app1);
    var mkeyEvent = {};
    mkeyEvent.KEY_UP = "UP";
    mkeyEvent.KEY_DOWN = "DOWN";
    mkeyEvent.KEY_LEFT = "LEFT";
    mkeyEvent.KEY_RIGHT = "RIGHT";
    mkeyEvent.KEY_SELECT = "ENTER";
    mkeyEvent.KEY_BACK = "DELETE";
    mkeyEvent.KEY_BACK = "BACK";
    mkeyEvent.KEY_PAGEUP = "PAGEUP";
    mkeyEvent.KEY_PAGEDOWN = "PAGEDOWN";



    handler = function (action, keyCode, keyName, metaState) {
        console.log("singwithme keycode " + keyCode);
        processKeyEvent(keyName);
        return true;
    }

    try {
        Webview.requestFocus();
        Webview.setKeyEventHandler(handler);
        console.log("singwithme setKeyEventHandler ok");
    } catch (e) {
        document.onkeydown = function (event)
        {
            mkeyEvent.KEY_UP = 38;
            mkeyEvent.KEY_DOWN = 40;
            mkeyEvent.KEY_LEFT = 37;
            mkeyEvent.KEY_RIGHT = 39;
            mkeyEvent.KEY_SELECT = 13;
            mkeyEvent.KEY_PAGEUP = 33;
            mkeyEvent.KEY_PAGEDOWN = 34;
            var e = event || window.event || arguments.callee.caller.arguments[0];
            if (e)
            {
                processKeyEvent(e.keyCode);

            }

        };
    }
Webview.setInputTypeTextFlag("true");




function playmusic(questionMusicUrl){
    Webview.requestFocus();
    Webview.setVideoWindowPosition(0,0,1,1);
    console.log("singwithme setVideoWindowPosition OK");
    console.log("singwithme playVideo OK");
    playHandler = function(prepared) {
        console.log("singwithme play PlayPrepared==========="+prepared);
        var playIntent = {
            "cmd_ex" : "play_video",
            "play_video_direct" : 1,
            "video_id" : "5afbb1721fa5cef4bab5bb7d342fc81f",
            "video_type" : 0,
            "video_index" : questionMusicUrl,
            "video_all_index": 10000,
            "ui_style": 0,
            "video_new_index": 10000
        };
        if(prepared){
            console.log("singwithme call playVideo");
            Webview.playVideo(playIntent);
        }
    }
    Webview.setHandler("PlayPrepared", playHandler);
    console.log("singwithme call setHandler ok");
}
//jump to apk
//action : "com.the9.music.WelcomeActivity",
// var jumpIntent = { 
//     package: "com.the9.music",
//     extras : {
//         "typeOne" : "100810001000"
//     },
//     flags : ["NEW_TASK"]
// };*

// Webview.sendIntent("startActivity",jumpIntent);
// 
// 
// 
// 统计
function statistics(statistics_x){
 $.ajax({
         type:"GET",
         contentType:'application/json;charset=utf-8',
         dataType: "json",
         url:"http://"+ip+"/singwithme/page/getpageCount",
         data:{
             "userId":userId,
             "statisticsx":statistics_x,
             },
         success:function(msg){
         },
     })
} 
//跳转欢唱
function jumpApk(jd) {
    var jumpIntent = { 
        package: "com.vunke.apptvstore",
        action : "com.vunke.apptvstore.InterfeceActivity",
        category: "android.intent.category.DEFAULT",
        extras : {
            "jsonData" :jd 
        },
        flags : ["SINGLE_INSTANCE"]
    };

    Webview.sendIntent("startActivity",jumpIntent);
}
//订购欢唱
function jump2Zte9MusicSubs(){
    jdata = "{\"activityName\":\"com.the9.music.activity.PayActivityNote\",\"appId\":\"1822220154\",\"code\":\"422\",\"outDown\":\"1\",\"title\":\"\"}";
    jumpApk(jdata);
}
//欢唱播放
function jump2Zte9MusicPlay(parameter){
    jumpApk(parameter);
}
//跳转欢唱大厅
function jump2Zte9Music() {
    jdata = "{\"activityName\":\"com.the9.music.MainAcitivity\",\"appId\":\"1822220154\",\"code\":\"422\",\"outDown\":\"1\",\"title\":\"\"}";
    jumpApk(jdata);
}
//芒果听歌
function jump2Mongo(u) {
    window.location.href = u;
}
//
function parseUrl(){
    var url=location.href;
    var i=url.indexOf('?');
    if(i==-1)return;
    var querystr=url.substr(i+1);
    var arr1=querystr.split('&');
    var arr2=new Object();
    for  (i in arr1){
        var ta=arr1[i].split('=');
        arr2[ta[0]]=ta[1];
    }
    return arr2;
}
var v = parseUrl();
var l = v['exitStr'];
var decode=unescape(l);


