var list_rows_zt=store.get("list_rows_zt");//当前播放视频列表
var listNumNow_zt=store.get("listNumNow_zt");//当前播放第几个视频 0开始
console.log("video.js:"+"list_rows_zt-"+JSON.stringify(list_rows_zt));
console.log("video.js:"+"listNumNow_zt-"+JSON.stringify(listNumNow_zt));
var listIndex=listNumNow_zt;
var focusIndex=0;
var currentPage=Math.ceil((listNumNow_zt+1)/8);
var allPage=Math.ceil(list_rows_zt.length/8);
var setTime;
console.log("video url:"+list_rows_zt[listNumNow_zt].musicUrl);
console.log("video name:"+list_rows_zt[listNumNow_zt].musicName);
var opt = {
    id: "radioPlayerBig", //播放控件ID
    url: list_rows_zt[listIndex].musicUrl, //视频地址
    name: list_rows_zt[listIndex].musicName, //视频名称
    timeout: 120, //超时时间
    beginTime: 0, //开始播放时间
    onReady: cathStateReady, //进入准备状态的回调函数
    onPlay: cathStatePlay, //进入播放状态的回调函数
    onBuffer: catchStateBuffer, //进入缓冲状态时的回调函数
    onBufferComplete: catchStateBufferComplete, //缓冲状态完成时的回调函数
    onPause: catchStatePause, //进入暂停状态的回调函
    onStop: catchStateStop, //手动停止视频的回调函数
    onOver: catchStateOver, //视频播放结束时的回调函数
    onException: catchStateException, //发生异常时的回调函数
    onError: catchStateErr, //发生错误时的回调函数
    onStatusChange: catchStateChange 	//状态改变时的回调函数
};
function resetOriginalStyle() {
    for (var integra in list_rows_zt) {
        var list ="<p style='width:7rem;margin:0;padding-left: 0.2rem;height: 0.9rem;overflow: hidden'>"+list_rows_zt[integra].musicName+"</p>";
        $("#playListBig").append(list);
    }
    $("#playListBig").css({top:"-"+ (currentPage-1)*7.2 + "rem"});
    resetMoveStyle(listIndex);
}
function resetMoveStyle(x) {
    $("#playListBig").animate({top:-Math.ceil((x+1)/8-1)*7.2 + "rem"},300);
    $("#playListBig").children().css({backgroundColor:"transparent",opacity:"1"});
    $("#playListBig").children().eq(x).css({backgroundColor:"#0abae6",opacity:"0.4"});
}
function cathStateReady() {
    //进入准备状态的回调函数 第一次进入视频
    $("#dataLoad").hide();
};
function cathStatePlay() {
    //进入播放状态的回调函数
    $("#dataLoad").hide();
    $("#playerPauseAd").hide();
};
function catchStateBuffer() {
    //进入缓冲状态时的回调函数
    $("#dataLoad").show();
    $("#playerPauseAd").hide();
};
function catchStateBufferComplete() {
    //缓冲状态完成时的回调函数
    $("#dataLoad").hide();
};
function catchStatePause() {
    //进入暂停状态的回调函
    $("#dataLoad").hide();
    $("#playerPauseAd").show();
};
function catchStateStop() {
    //手动停止视频的回调函数
    $("#dataLoad").hide();
    $("#playerPauseAd").show();
};
function catchStateOver() {
    //视频播放结束时的回调函数
    $("#player").hide();
    $("#dataLoad").hide();
    listIndex++;
    playerCore.ready(opt);
    resetOriginalStyle();
};
function catchStateException() {
    //发生异常时的回调函数
    //$('info').innerHTML = '发生异常时的回调函数';
    frame.hasAttend("播放异常，请稍后重试")
};
function catchStateChange() {
    //状态改变时的回调函数
};
function catchStateErr() {
    //发生错误时的回调函数
    //player.playerBackFn();
    frame.hasAttend("播放错误，请稍后重试")
};

window.onload = function(){
    /*开始播放*/
    $("#dataLoad").hide();
    console.log("windowLocationHref:"+window.location.href);
    playerCore.ready(opt);
    resetOriginalStyle();
};
function playTime_now(){
    //总时长
    var tot = playerCore.getTotalTime();
    //当前时常
    var cur = playerCore.getCurrentTime(); //3000
}
document.onkeydown=function(e){
    e=window.event||e;
    switch (e.keyCode) {
        case 37:
            if( focusIndex=0){
                playerCore.seekByTime(5,-1);
                playTime_now();
            }else {
                focusIndex=0;
                $("#playList").hide();
            }
            break;
        case 38:
            if(focusIndex==0){
                focusIndex=1;
                $("#playList").show();
            }else {
                listIndex--;
                if(listIndex<=0){
                    listIndex=0;
                }
                resetMoveStyle(listIndex);
            }
            clearTimeout(setTime);
            setTime=setTimeout(function () {
                focusIndex=0;
                $("#playList").hide();
            },3000);
            break;
        case 39:
            if(focusIndex==0){
                //跳转时长
                playerCore.seekByTime(5,1);
            }else {
                focusIndex=0;
                $("#playList").hide();
            }
            break;
        case 40:
            if(focusIndex==0){
                focusIndex=1;
                $("#playList").show();
            }else {
                listIndex++;
                if(listIndex>=list_rows_zt.data.rows.length-1){
                    listIndex=list_rows_zt.data.rows.length-1
                }
                resetMoveStyle(listIndex);
            }
            break;
        case 13:
            if(focusIndex==0){
                //暂停播放视频
                var status = playerCore.getStatus();
                if (status == 1 || status == 3) {
                    playerCore.pause();
                    $("#playerPauseAd").show();
                }
                else{
                    playerCore.resume();
                    $("#playerPauseAd").hide();
                }
            }else {
                playerCore.stop();
                playerCore.ready(opt);
                $("#dataLoad").hide();
            }
            break;
        case 27:
            if(focusIndex==0){
                $("#dataLoad").hide();
                playerCore.stop();
                window.location.href = store.get("localUrl");
            }else {
                focusIndex=0;
                $("#playList").hide();
            }
            break;
    }
}
