// 8080现网  8088测试
var ip=10+"."+255+"."+25+"."+151+":"+8080+"/musicRoad";
var ip_local=10+"."+255+"."+25+"."+151+":"+8080+"/hc_webMusicRoad";

var userId = android.getUserId();
var mac = android.getMac();
var token = android.getUserToken();
var contentCode="D00000001201801021631280084099997";
var version="YYS.4.9.2.266.2.HNDX.0.0_Release_ZTE_4K";
var fromSource="4";


// 统计
function statistics(statistics_x){
    var x=parseInt("100"+statistics_x);
    console.log("11111111111"+userId+statistics_x);
    $.ajax({
        type:"GET",
        contentType:'application/json;charset=utf-8',
        dataType: "json",
        url:"http://"+ip+"/page/getpageCount",
        data:{
            "userId":userId,
            "statisticsx":x
        },
        success:function(msg){
            console.log("statisticsSuccess:"+JSON.stringify(msg));
        },
        error:function (msg) {
            console.log("statisticsError:"+JSON.stringify(msg));
        }
    })
}
//返回键
// function doBackPressed() {
//     console.log("WebActivity onKeyDown_goBack");
// }
//专题
function goSubject(){
    android.goToActivityWithTypeCode("com.zte9.music.activity.OldSepecAct","272");
}
// 退出
function exitPage(){
    android.exit();
}
//订购
function orderPage(){
    android.goToActivity("com.zte9.music.activity.PayActivityNoteWeb");
}
//打开apk
function openApk(){
    android.openExternalApk("com.zte9.musicoutrecommtest","com.the9.musicoutrecommtest.MainActivity","jsonData","This is data","launcher");
}

var frame={};
var time = function () {
    setTimeout(function () {
        $(".frameTxt").fadeOut();
    }, 3000)
};
frame.hasAttend=function (html) {
    $(".frameTxt").html(html);
    $(".frameTxt").fadeIn();
    clearTimeout(time);
    time();
};

// 文字横向滚动
function rollingInformation(element1,element2,speed,pxOrRem){
    var widD=element1.width();
    var widP=element2.width();
    var speeds=speed;
    // console.log(widD+":"+widP);
    if(widP>widD){
        function Marquee() {
            // if()
            var lef=parseInt(element2.css("left"));
            // console.log(lef)
            if (lef<(-widP)) {
                lef=widD;
                element2.css({left:lef+pxOrRem});
            } else{
                lef--
                // $(".div2").css({left:$(".div2").style.left++})
                element2.css({left:lef+pxOrRem});
            }
            // console.log(lef)
        }

        MyMar=setInterval(Marquee,speeds);
    }else{
        // 内容不超出不滚动
        element2.css({left:0});
        // 内容不超出滚动出现，显示完全后停止，但是有bug
        // function Marquee() {
        // 	var lef=parseInt(element2.css("left"));
        // 	if (lef==0) {
        // 		clearInterval(MyMar);
        // 	} else{
        // 		lef--
        // 		element2.css({left:lef+pxOrRem});
        // 	}
        // }
        // MyMar=setInterval(Marquee,speeds);
    }

}
function freshPage() {
    var url=window.location.href;
    window.location.href=url;
}
// rollingInformation($(".div1"),$(".div2"),50,"px");