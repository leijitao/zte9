var gameNum=6;//推荐位数量  从1开始
var startFocusNum;//默认焦点位置 从0开始
(function getStartFocusNum() {
    if(gameNum%2==0){
        startFocusNum=gameNum/2-1;
    }else {
        startFocusNum=(gameNum+1)/2-1;
    }
}());
window.onload=function () {
    AndroidInvoker.event("onBack", function() {
        location.href='http://117.71.47.101:18082/web/draws.html';
    })
}
var nowFocusNum=startFocusNum;//当前焦点位置 从0开始
var lef=["1.68rem","5.03rem","8.38rem","11.72rem","15.07rem"];
var gameId=[10181,10189,100140,100145,100035,10184];
function resetBannerStyle(){
    $("#con_game img").css({"zIndex":1000})
    for(var x=0;x<startFocusNum-2;x++){
        $("#con_game").children().eq(x).css({"left":lef[0]})
    }
    for(var x=startFocusNum+3;x<gameNum;x++){
        $("#con_game").children().eq(x).css({"left":lef[4],"zIndex":1000-x});
    }
    $("#con_game").children().eq(startFocusNum-2).css({"left":lef[0]});
    $("#con_game").children().eq(startFocusNum-1).css({"left":lef[1]});
    $("#con_game").children().eq(startFocusNum).css({"left":lef[2],"transform":"scale(1.2,1.2)"});
    $("#con_game").children().eq(startFocusNum+1).css({"left":lef[3]});
    $("#con_game").children().eq(startFocusNum+2).css({"left":lef[4]});
}
resetBannerStyle();
function bannerAnimateLeft(){
    var htm= $("#con_game").children().eq(0).clone();
    $("#con_game").append(htm);
    $("#con_game").children().eq(0).remove();
    $("#con_game").children().eq(startFocusNum-2-1).css({"zIndex":1});
    $("#con_game").children().eq(startFocusNum-1-1).css({"zIndex":2});
    $("#con_game").children().eq(startFocusNum-1).css({"transform":"scale(1,1)"});
    $("#con_game").children().eq(startFocusNum+1-1).css({"transform":"scale(1.2,1.2)"});
    $("#con_game").children().eq(startFocusNum-1-1).stop().animate({"left":lef[0]},300);
    $("#con_game").children().eq(startFocusNum-1).stop().animate({"left":lef[1]},300);
    $("#con_game").children().eq(startFocusNum+1-1).stop().animate({"left":lef[2]},300);
    $("#con_game").children().eq(startFocusNum+2-1).stop().animate({"left":lef[3]},300);
    $("#con_game").children().eq(startFocusNum+3-1).css({"left":lef[4]});
    $("#con_game").children().eq(gameNum-1).css({"left":lef[4]});
    resetBannerStyle()
}
function bannerAnimateRight(){
    var htm= $("#con_game").children().eq(gameNum-1).clone();
    $("#con_game").prepend(htm);
    $("#con_game").children().eq(gameNum).remove();
    $("#con_game").children().eq(startFocusNum+2+1).css({"zIndex":1});
    $("#con_game").children().eq(startFocusNum+1+1).css({"zIndex":2});
    $("#con_game").children().eq(startFocusNum+1).css({"transform":"scale(1,1)"});
    $("#con_game").children().eq(startFocusNum-1+1).css({"transform":"scale(1.2,1.2)"});
    $("#con_game").children().eq(startFocusNum-1+1).stop().animate({"left":lef[2]},300);
    $("#con_game").children().eq(startFocusNum+1).stop().animate({"left":lef[3]},300);
    $("#con_game").children().eq(startFocusNum+1+1).stop().animate({"left":lef[4]},300);
    $("#con_game").children().eq(startFocusNum-2+1).stop().animate({"left":lef[1]},300);
    $("#con_game").children().eq(startFocusNum-3+1).css({"left":lef[0]});
    $("#con_game").children().eq(0).css({"left":lef[0]});
    resetBannerStyle();
}
document.onkeydown=function (e) {
    e = window.event || e;
    switch (e.keyCode) {
        case 37:
            nowFocusNum++;
            if(nowFocusNum>gameNum-1){
                nowFocusNum=0;
            }
            bannerAnimateLeft();
            break;
        case 38:
            break;
        case 39:
            nowFocusNum--;
            if(nowFocusNum<0){
                nowFocusNum=gameNum-1;
            }
            bannerAnimateRight();
            break;
        case 40:
            break;
        case 13:
            AndroidInvoker.gotoAppDetails(gameId[nowFocusNum]);
            console.log("nowFocusNum:"+nowFocusNum);
            break;
    }
}
