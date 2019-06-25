var focusArea=1,navBtnFocus=0,contentBtnFocus=0,topFocus=0;
/*
focusArea 判断焦点区域
0: 右上角区域  订购、搜索
1：导航栏
2：推荐位区域

navBtnFocus 判断当前导航栏焦点位置，精选 0 → 订购 9

contentBtnFocus 判断当前推荐位栏焦点位置，下标从0开始
*/
var navList;
window.onload=function () {
    store.clear();
    getAllTeamList();
    getNavList(7);
};
function navResteStyle() {
    for(var i=0;i<8;i++){
        if ($("#NavBar").children().eq(i).html().length==2){
            $("#NavBar").children().eq(i).addClass("NavBtn_letrer2");
        }else {
            $("#NavBar").children().eq(i).addClass("NavBtn_letrer4");
        }
    }
    navBtnFocus=0;
    $("#NavBar").children().eq(0).addClass("navBtnLeft");
}
navResteStyle();
function navRemoveStyle() {
    $("#NavBar").children().eq(0).removeClass("navBtnLeft navLineLeft");
    $("#NavBar").children().eq(7).removeClass("navBtnRight navLineRight");
    for (var i=1;i<7;i++){
        $("#NavBar").children().eq(i).removeClass("navBtnMid navLineMiddle");
    }
}
function navMoveFocusStyle() {
    navRemoveStyle();
    fillContData();
    $("#homePageCont").children().hide();
    $("#homePageCont").children().eq(navBtnFocus).show();
    if(navBtnFocus < navList.length-1 && navList.length>8){
        $(".moveLeft").show();
    }
    if(navBtnFocus == 0){
        $(".navBtn1").addClass("navBtnLeft");
        $(".moveLeft").hide();
    }else if(navBtnFocus > 0 && navBtnFocus < 7){
        $(".navBtn" + (navBtnFocus+1)).addClass("navBtnMid");
        $(".moveLeft").hide();
    }else if(navBtnFocus >= 7){
        $(".navBtn8").addClass("navBtnRight");
        if(navBtnFocus>7){
            if(navBtnFocus==navList.length-1){
                $(".moveRight").hide();
                $(".moveLeft").show();
            }else {
                $(".moveRight").show();
                $(".moveLeft").show();
            }
        }else {
            $(".moveLeft").hide();
        }
        var x = -1;
        for(var i=navBtnFocus-7;i <= navBtnFocus;i++){
            x++;
            $(".NavBar").children().eq(x).html(navList[i].typeName);
        }
    }
}
function navLeaveFocus() {
    navRemoveStyle();
    if(navBtnFocus == 0){
        $(".navBtn1").addClass("navLineLeft")
    }else if(navBtnFocus > 0 && navBtnFocus < 7){
        $(".navBtn" + (navBtnFocus+1)).addClass("navLineMiddle")
    }else if(navBtnFocus >= 7){
        $(".navBtn8").addClass("navLineRight")
    }
}
function resetTopStyle() {
   $("#othBtn").children().hide();
   $("#othBtn").children().eq(topFocus).show();
}
function resetFocus_left(fun) {
    if (contentBtnFocus > 0 && contentBtnFocus < 3 ||
        contentBtnFocus > 3 && contentBtnFocus < 9 ||
        contentBtnFocus > 9 && contentBtnFocus < 13){
        contentBtnFocus--;
    }
    fun();
}
function resetFocus_up(fun1,fun2) {
    if (contentBtnFocus >= 0 && contentBtnFocus < 3){
        contentBtnFocus=0;
        focusArea=1;
        fun1();
        navMoveFocusStyle();
    }else if(contentBtnFocus == 9){
        contentBtnFocus=3;
        fun2();
    }else if(contentBtnFocus == 10){
        contentBtnFocus=5;
        fun2();
    }else if(contentBtnFocus == 11){
        contentBtnFocus=6;
        fun2();
    }else if(contentBtnFocus == 12){
        contentBtnFocus=8;
        fun2();
    }else if(contentBtnFocus > 2 && contentBtnFocus < 9){
        contentBtnFocus = Math.ceil(contentBtnFocus/2)-2;
        fun2();
    }
}
function resetFocus_right(fun) {
    if (contentBtnFocus >= 0 && contentBtnFocus < 2 ||
        contentBtnFocus > 2 && contentBtnFocus < 8 ||
        contentBtnFocus > 8 && contentBtnFocus < 12){
        contentBtnFocus++;
    }
    fun();
}
function resetFocus_down(fun) {
    if(contentBtnFocus>=0 && contentBtnFocus<3){
        contentBtnFocus=contentBtnFocus*2+3;
    }else if(contentBtnFocus == 3 || contentBtnFocus == 4){
        contentBtnFocus=9;
    }else if(contentBtnFocus == 5){
        contentBtnFocus=10;
    }else if(contentBtnFocus == 6 || contentBtnFocus == 7){
        contentBtnFocus=11;
    }else if(contentBtnFocus == 8){
        contentBtnFocus=12;
    }
    fun();
}
function keyLeft() {
    clearInterval(settime);
    if(focusArea==1){
        if(navBtnFocus>0){
            navBtnFocus--;
        }
        navMoveFocusStyle();
    }else if(focusArea==2){
        if(navBtnFocus==0){
            if(contentBtnFocus>8){
                contentBtnFocus=4;
            }else if(contentBtnFocus==4){
                contentBtnFocus=0
            }else if(contentBtnFocus>5 && contentBtnFocus <9){
                contentBtnFocus--;
            }
            homePageCont1_ResetStyle();
        }else if(navBtnFocus==1){
            if(contentBtnFocus==3){
                contentBtnFocus=0;
            }else if(contentBtnFocus==4){
                contentBtnFocus=3;
            }else if(contentBtnFocus>5){
                contentBtnFocus--;
            }
            homePageCont2_ResetStyle();
        }else if(navBtnFocus==2){
            if(contentBtnFocus>0){
                contentBtnFocus=0;
            }
            homePageCont3_ResetStyle();
        }else if(navBtnFocus==3){
            resetFocus_left(homePageCont4_ResetStyle);
        }else if(navBtnFocus==4){
            resetFocus_left(homePageCont5_ResetStyle);
        }else if(navBtnFocus==5){
            resetFocus_left(homePageCont6_ResetStyle);
        }else if(navBtnFocus==6){
            resetFocus_left(homePageCont7_ResetStyle);
        }else if(navBtnFocus>=7){
            resetFocus_left(homePageCont8_ResetStyle);
        }
    }else if(focusArea==0){
        if(topFocus>0){
            topFocus--;
        }
        resetTopStyle();
    }
}
function keyUp() {
    clearInterval(settime);
    if(focusArea==1){
        focusArea=0;
        topFocus=0;
        resetTopStyle();
        navLeaveFocus();
    }else if(focusArea==2){
        if(navBtnFocus==0){
            if(contentBtnFocus > 9){
                contentBtnFocus--;
                homePageCont1_ResetStyle();
            }else if(contentBtnFocus==8){
                contentBtnFocus=13;
                homePageCont1_ResetStyle();
            }else if(contentBtnFocus==7 || contentBtnFocus==6){
                contentBtnFocus=4;
                homePageCont1_ResetStyle();
            }else if(contentBtnFocus==5){
                contentBtnFocus=3;
                homePageCont1_ResetStyle();
            }else if(contentBtnFocus>0 && contentBtnFocus<4){
                contentBtnFocus--;
                homePageCont1_ResetStyle();
            }else if(contentBtnFocus==0 || contentBtnFocus==4|| contentBtnFocus==9){
                homePageCont1_RemoveStyle();
                contentBtnFocus=0;
                focusArea=1;
                navMoveFocusStyle();
            }
        }else if(navBtnFocus==1){
            if(contentBtnFocus > 0 && contentBtnFocus < 3){
                contentBtnFocus--;
                homePageCont2_ResetStyle();
            }else if(contentBtnFocus > 4 && contentBtnFocus < 8){
                contentBtnFocus=2;
                homePageCont2_ResetStyle();
            }else if(contentBtnFocus == 8 || contentBtnFocus == 9){
                contentBtnFocus=3;
                homePageCont2_ResetStyle();
            }else if(contentBtnFocus == 10){
                contentBtnFocus=4;
                homePageCont2_ResetStyle();
            }else if(contentBtnFocus == 0 || contentBtnFocus == 3 || contentBtnFocus == 4){
                homePageCont2_RemoveStyle();
                contentBtnFocus=0;
                focusArea=1;
                navMoveFocusStyle();
            }
        }else if(navBtnFocus==2){
            if(contentBtnFocus<2){
                homePageCont3_RemoveStyle();
                contentBtnFocus=0;
                focusArea=1;
                navMoveFocusStyle();
            }else {
                contentBtnFocus--;
                homePageCont3_ResetStyle()
            }
        }else if(navBtnFocus==3){
            resetFocus_up(homePageCont4_RemoveStyle,homePageCont4_ResetStyle)
        }else if(navBtnFocus==4){
            resetFocus_up(homePageCont5_RemoveStyle,homePageCont5_ResetStyle)
        }else if(navBtnFocus==5){
            resetFocus_up(homePageCont6_RemoveStyle,homePageCont6_ResetStyle)
        }else if(navBtnFocus==6){
            resetFocus_up(homePageCont7_RemoveStyle,homePageCont7_ResetStyle)
        }else if(navBtnFocus>=7){
            resetFocus_up(homePageCont8_RemoveStyle,homePageCont8_ResetStyle)
        }
    }
    console.log("focusArea:"+focusArea+",navBtnFocus:"+navBtnFocus);
}
function keyRight() {
/*    clearInterval(settime);*/
    if(focusArea==1){
        if(navBtnFocus < navList.length-1){
            navBtnFocus++;
        }
        navMoveFocusStyle();
    }else if(focusArea==2){
        if(navBtnFocus==0){
            if(contentBtnFocus<4){
                contentBtnFocus=4;
            }else if(contentBtnFocus==4){
                contentBtnFocus=9;
            }else if(contentBtnFocus>4 && contentBtnFocus <8){
                contentBtnFocus++;
            }
            homePageCont1_ResetStyle();
        }else if(navBtnFocus==1){
            if(contentBtnFocus < 3){
                contentBtnFocus=3;
            }else if (contentBtnFocus == 3 || contentBtnFocus > 4 && contentBtnFocus<10){
                contentBtnFocus++;
            }
            homePageCont2_ResetStyle();
        }else if(navBtnFocus==2){
            if(contentBtnFocus==0){
                contentBtnFocus=1;
            }
            homePageCont3_ResetStyle();
        }else if(navBtnFocus==3){
            resetFocus_right(homePageCont4_ResetStyle);
        }else if(navBtnFocus==4){
            resetFocus_right(homePageCont5_ResetStyle);
        }else if(navBtnFocus==5){
            resetFocus_right(homePageCont6_ResetStyle);
        }else if(navBtnFocus==6){
            resetFocus_right(homePageCont7_ResetStyle);
        }else if(navBtnFocus>=7){
            resetFocus_right(homePageCont8_ResetStyle);
        }
    }else if(focusArea==0){
        topFocus=1;
        resetTopStyle();
    }
}
function keyDown() {
    clearInterval(settime);
    if(focusArea==1){
        focusArea=2;
        navLeaveFocus();
        if(navBtnFocus==0){
            homePageCont1_ResetStyle();
        }else if(navBtnFocus==1){
            homePageCont2_ResetStyle();
        }else if(navBtnFocus==2){
            homePageCont3_ResetStyle();
        }else if(navBtnFocus==3){
            homePageCont4_ResetStyle();
        }else if(navBtnFocus==4){
            homePageCont5_ResetStyle();
        }else if(navBtnFocus==5){
            homePageCont6_ResetStyle();
        }else if(navBtnFocus==6){
            homePageCont7_ResetStyle();
        }else if(navBtnFocus>=7){
            homePageCont8_ResetStyle();
        }
    }else if(focusArea==2){
        if(navBtnFocus==0){
            if(contentBtnFocus > 8 && contentBtnFocus < 13){
                contentBtnFocus++;
            }else if(contentBtnFocus==13){
                contentBtnFocus=8;
            }else if(contentBtnFocus==4){
                contentBtnFocus=6
            }else if(contentBtnFocus==3){
                contentBtnFocus=5
            }else if(contentBtnFocus>=0 && contentBtnFocus<3){
                contentBtnFocus++
            }
            homePageCont1_ResetStyle();
        }else if(navBtnFocus==1){
            if(contentBtnFocus<2){
                contentBtnFocus++;
            }else if(contentBtnFocus==2){
                contentBtnFocus=5;
            }else if(contentBtnFocus==3){
                contentBtnFocus=8;
            }else if(contentBtnFocus==4){
                contentBtnFocus=10;
            }
            homePageCont2_ResetStyle();
        }else if(navBtnFocus==2){
            if(contentBtnFocus>0 && contentBtnFocus<4){
                contentBtnFocus++;
            }
            homePageCont3_ResetStyle();
        }else if(navBtnFocus==3){
            resetFocus_down(homePageCont4_ResetStyle);
        }else if(navBtnFocus==4){
            resetFocus_down(homePageCont5_ResetStyle);
        }else if(navBtnFocus==5){
            resetFocus_down(homePageCont6_ResetStyle);
        }else if(navBtnFocus==6){
            resetFocus_down(homePageCont7_ResetStyle);
        }else if(navBtnFocus>=7){
            resetFocus_down(homePageCont8_ResetStyle);
        }
    }else if(focusArea==0){
        focusArea=1;
        navMoveFocusStyle();
        $("#othBtn").children().hide();
    }
    console.log("focusArea:"+focusArea+",navBtnFocus:"+navBtnFocus+",contentBtnFocus:"+contentBtnFocus);
}
function keySelect() {
    if(focusArea==2){
        if(navBtnFocus==0){
            var contentJson0=store.get("contentJson"+navBtnFocus);
            if(contentBtnFocus<5){
                jump_ZtList_playVideo(contentJson0[contentBtnFocus]);
            }else if(contentBtnFocus>4 && contentBtnFocus<9){
                jump_ZtList_playVideo(contentJson0[contentBtnFocus+5]);
            }else if(contentBtnFocus>8 && contentBtnFocus<14){
                jump_ZtList_playVideo(contentJson0[contentBtnFocus-4]);
            }
        }else if(navBtnFocus>0){
            jump_ZtList_playVideo(store.get("contentJson"+navBtnFocus)[contentBtnFocus]);
        }
    }
}
function keyBack() {
    showRecommend();
}
function keyNum_mg() {

}
function keyNum_hc() {

}
function keyDelete() {

}

function homePageCont1_RemoveStyle() {
    for(var i=0;i<4;i++){
        $("#homePageCont1_poster").children().eq(i).removeClass("leftFocus");
    }
    for(var i=5;i<9;i++){
        $("#homePageCont1_poster").children().eq(i).removeClass("bottomFocus");
    }
    $("#homePageCont1_poster").children().eq(4).removeClass("videoFocus");
    $("#homePageCont1_title").children().removeClass("homePageCont1_title_d_focus");
}
function homePageCont1_ResetStyle(){
    homePageCont1_RemoveStyle();
    if(contentBtnFocus < 4){
        $("#homePageCont1_poster").children().eq(contentBtnFocus).addClass("leftFocus");
    }else if(contentBtnFocus==4){
        $("#homePageCont1_poster").children().eq(contentBtnFocus).addClass("videoFocus");
    }else if(contentBtnFocus>4 && contentBtnFocus<9){
        $("#homePageCont1_poster").children().eq(contentBtnFocus).addClass("bottomFocus");
    }else if(contentBtnFocus>8 && contentBtnFocus<14){
        $("#homePageCont1_title").children().eq(contentBtnFocus-9).addClass("homePageCont1_title_d_focus");
        textScroll(276,$(".homePageCont1_title_d").eq(contentBtnFocus-9).children("div"),3,$(".homePageCont1_title_d > div"));
    }
}
function homePageCont2_RemoveStyle() {
    $(".homePageCont2_vs2_tit_p").css({left:0});
    $("#homePageCont2_match > div").removeClass("homePageCont2_vs1_focus homePageCont2_vs2_focus");
    $("#homePageCont2_posterBig > div").removeClass("homePageCont2_posterBig_focus");
    $("#homePageCont2_posterSm > div").removeClass("homePageCont2_posterSm_focus");
}
function homePageCont2_ResetStyle() {
    clearInterval(settime);
    homePageCont2_RemoveStyle();
    if(contentBtnFocus<3){
        var objCla = getElementClass($("#homePageCont2_match > div").eq(contentBtnFocus),0);
        if(objCla == "homePageCont2_vs1"){
            $("#homePageCont2_match > div").eq(contentBtnFocus).addClass("homePageCont2_vs1_focus");
        }else {
            $("#homePageCont2_match > div").eq(contentBtnFocus).addClass("homePageCont2_vs2_focus");
        }
        textScroll(280,$("#homePageCont2_match > div").eq(contentBtnFocus).children(".homePageCont2_vs2_tit").children(".homePageCont2_vs2_tit_p"),2,$(".homePageCont2_vs2_tit_p"));
    }else if(contentBtnFocus>4){
        $("#homePageCont2_posterSm > div").eq(contentBtnFocus-5).addClass("homePageCont2_posterSm_focus");
    }else {
        $("#homePageCont2_posterBig > div").eq(contentBtnFocus-3).addClass("homePageCont2_posterBig_focus")
        textScroll(270,$("#homePageCont2_posterBig > div").eq(contentBtnFocus-3).children(".homePageCont2_posterBig_tit").children(".homePageCont2_posterBig_tit_p"),2,$(".homePageCont2_posterBig_tit_p"));

    }
}
function homePageCont3_RemoveStyle() {
    $("#homePageCont3").children().eq(0).removeClass("homePageCont3_videoWindow_focus");
    for (var i=1;i<5;i++){
        $("#homePageCont3").children().eq(i).removeClass("homePageCont3_videoPoster_focus");
    }
}
function homePageCont3_ResetStyle() {
    homePageCont3_RemoveStyle();
    if(contentBtnFocus==0){
        $("#homePageCont3").children().eq(0).addClass("homePageCont3_videoWindow_focus");
    }else {
        $("#homePageCont3").children().eq(contentBtnFocus).addClass("homePageCont3_videoPoster_focus");
    }
}
function homePageCont4_RemoveStyle() {
    $(".homePageCont4_top > div").removeClass("homePageCont4_top_focus");
    $(".homePageCont4_middle > div").removeClass("homePageCont4_middle_focus1");
    $(".homePageCont4_middle > div > div").removeClass("homePageCont4_middle_focus2");
    $(".homePageCont4_bottom > div").removeClass("homePageCont4_bottom_focus");
}
function homePageCont4_ResetStyle() {
    homePageCont4_RemoveStyle();
    if(contentBtnFocus<3){
        $("#homePageCont4 .homePageCont4_top > div").eq(contentBtnFocus).addClass("homePageCont4_top_focus");
    }else if(contentBtnFocus > 2 && contentBtnFocus < 9){
        $("#homePageCont4 .homePageCont4_middle > div").eq(contentBtnFocus-3).addClass("homePageCont4_middle_focus1");
        $("#homePageCont4 .homePageCont4_middle > div").eq(contentBtnFocus-3).children().eq(1).addClass("homePageCont4_middle_focus2");
    }else if(contentBtnFocus > 8 && contentBtnFocus < 13){
        $("#homePageCont4 .homePageCont4_bottom > div").eq(contentBtnFocus-9).addClass("homePageCont4_bottom_focus");
    }
}
function homePageCont5_RemoveStyle() {
   /* $(".homePageCont5_top > div").removeClass("homePageCont5_top_focus");
    $(".homePageCont5_middle > div").removeClass("homePageCont5_middle_focus1");
    $(".homePageCont5_middle > div > div").removeClass("homePageCont5_middle_focus2");
    $(".homePageCont5_bottom > div").removeClass("homePageCont5_bottom_focus");*/
    homePageCont8_RemoveStyle()
}
function homePageCont5_ResetStyle() {
    homePageCont8_ResetStyle();
    /*homePageCont5_RemoveStyle();
    if(contentBtnFocus<3){
        $(".homePageCont5_top > div").eq(contentBtnFocus).addClass("homePageCont5_top_focus");
    }else if(contentBtnFocus > 2 && contentBtnFocus < 9){
        $(".homePageCont5_middle > div").eq(contentBtnFocus-3).addClass("homePageCont5_middle_focus1");
        $(".homePageCont5_middle > div").eq(contentBtnFocus-3).children().eq(1).addClass("homePageCont5_middle_focus2");
    }else if(contentBtnFocus > 8 && contentBtnFocus < 13){
        $(".homePageCont5_bottom > div").eq(contentBtnFocus-9).addClass("homePageCont5_bottom_focus");
    }*/
}
function homePageCont6_RemoveStyle() {
    $("#homePageCont6 .homePageCont4_top > div").removeClass("homePageCont4_top_focus");
    $("#homePageCont6 .homePageCont4_middle > div").removeClass("homePageCont4_middle_focus1");
    $("#homePageCont6 .homePageCont4_middle > div > div").removeClass("homePageCont4_middle_focus2");
    $("#homePageCont6 .homePageCont4_bottom > div").removeClass("homePageCont4_bottom_focus");
}
function homePageCont6_ResetStyle() {
    homePageCont4_RemoveStyle();
    if(contentBtnFocus<3){
        $("#homePageCont6 .homePageCont4_top > div").eq(contentBtnFocus).addClass("homePageCont4_top_focus");
    }else if(contentBtnFocus > 2 && contentBtnFocus < 9){
        $("#homePageCont6 .homePageCont4_middle > div").eq(contentBtnFocus-3).addClass("homePageCont4_middle_focus1");
        $("#homePageCont6 .homePageCont4_middle > div").eq(contentBtnFocus-3).children().eq(1).addClass("homePageCont4_middle_focus2");
    }else if(contentBtnFocus > 8 && contentBtnFocus < 13){
        $("#homePageCont6 .homePageCont4_bottom > div").eq(contentBtnFocus-9).addClass("homePageCont4_bottom_focus");
    }
}
function homePageCont7_RemoveStyle() {
    $("#homePageCont7 .homePageCont4_top > div").removeClass("homePageCont4_top_focus");
    $("#homePageCont7 .homePageCont4_middle > div").removeClass("homePageCont4_middle_focus1");
    $("#homePageCont7 .homePageCont4_middle > div > div").removeClass("homePageCont4_middle_focus2");
    $("#homePageCont7 .homePageCont4_bottom > div").removeClass("homePageCont4_bottom_focus");
}
function homePageCont7_ResetStyle() {
    homePageCont4_RemoveStyle();
    if(contentBtnFocus<3){
        $("#homePageCont7 .homePageCont4_top > div").eq(contentBtnFocus).addClass("homePageCont4_top_focus");
    }else if(contentBtnFocus > 2 && contentBtnFocus < 9){
        $("#homePageCont7 .homePageCont4_middle > div").eq(contentBtnFocus-3).addClass("homePageCont4_middle_focus1");
        $("#homePageCont7 .homePageCont4_middle > div").eq(contentBtnFocus-3).children().eq(1).addClass("homePageCont4_middle_focus2");
    }else if(contentBtnFocus > 8 && contentBtnFocus < 13){
        $("#homePageCont7 .homePageCont4_bottom > div").eq(contentBtnFocus-9).addClass("homePageCont4_bottom_focus");
    }
}
function homePageCont8_RemoveStyle() {
    $("#homePageCont > div").eq(navBtnFocus).children(".homePageCont4_top").children("div").removeClass("homePageCont4_top_focus");
    $("#homePageCont > div").eq(navBtnFocus).children(".homePageCont4_middle").children("div").removeClass("homePageCont4_middle_focus1");
    $("#homePageCont > div").eq(navBtnFocus).children(".homePageCont4_middle").children("div").children("div").removeClass("homePageCont4_middle_focus2");
    $("#homePageCont > div").eq(navBtnFocus).children(".homePageCont4_bottom").children("div").removeClass("homePageCont4_bottom_focus");
}
function homePageCont8_ResetStyle() {
    homePageCont4_RemoveStyle();
    if(contentBtnFocus<3){
        $("#homePageCont > div").eq(navBtnFocus).children(".homePageCont4_top").children("div").eq(contentBtnFocus).addClass("homePageCont4_top_focus");
    }else if(contentBtnFocus > 2 && contentBtnFocus < 9){
        $("#homePageCont > div").eq(navBtnFocus).children(".homePageCont4_middle").children("div").eq(contentBtnFocus-3).addClass("homePageCont4_middle_focus1");
        $("#homePageCont > div").eq(navBtnFocus).children(".homePageCont4_middle").children("div").eq(contentBtnFocus-3).children().eq(1).addClass("homePageCont4_middle_focus2");
    }else if(contentBtnFocus > 8 && contentBtnFocus < 13){
        $("#homePageCont > div").eq(navBtnFocus).children(".homePageCont4_bottom").children("div").eq(contentBtnFocus-9).addClass("homePageCont4_bottom_focus");
    }
}

function getNavList(focus) {
    $.ajax({
        type:"GET",
        dataType:"json",
        url:"http://"+ip+"/category/list",
        success:function(msg){
            console.log("getNavList success:"+JSON.stringify(msg));
            navList = msg.data;
            $(".moveLeft").hide();
            if(msg.data.length>8){
                $(".moveRight").show();
                var txt=$("#homePageCont4").html();
                for (var i=5;i<=msg.data.length;i++){
                    var ele ='<div id="homePageCont'+ i+'"></div>';
                    $("#homePageCont").append(ele);
                    $("#homePageCont"+ i).html(txt);
                }
            }
            var x = -1;
            for(var i=focus-7;i <= focus;i++){
                x++;
                $(".NavBar").children().eq(x).html(msg.data[i].typeName);
            }
            getNavList_cont(msg.data[0]);
        },
        error:function (msg) {
            console.log("getNavList error:"+JSON.stringify(msg));
        }
    })
}
function getNavList_cont(navJson) {
    $.ajax({
        type:"GET",
        dataType:"json",
        url:"http://"+ip+"/recommend/category/"+navJson.typeCode+"/list",
        success:function(msg){
            console.log("getNavList success contJson"+navBtnFocus+":"+JSON.stringify(msg));
            store.set("contentJson"+navBtnFocus,msg.data);
            fillContData1(msg.data);
        },
        error:function (msg) {
            console.log("getNavList error:"+JSON.stringify(msg));
        }
    })
}
function fillContData() {
    if(store.get("contentJson"+navBtnFocus)!==undefined){
        // if()
        // fillContData1(store.get("contentJson"+navBtnFocus));
    }else {
        getNavList_cont(navList[navBtnFocus]);
    }
}
function fillContData1(data) {
    if (navBtnFocus==0){
        $("#homePageCont > div").eq(0).children("#homePageCont1_poster").html("");
        $("#homePageCont > div").eq(0).children("#homePageCont1_title").html("");
        for(var i=0;i<5;i++){
            var txt='<div class="homePageCont1_poster'+(i+1)+'"><img src="'+data[i].picUrl+'" alt=""></div>';
            $("#homePageCont > div").eq(0).children("#homePageCont1_poster").append(txt);
        }
        for (var i=10;i<14;i++){
            var txt='<div class="homePageCont1_poster'+(i-4)+'"><img src="'+data[i].picUrl+'" alt=""></div>';
            $("#homePageCont > div").eq(0).children("#homePageCont1_poster").append(txt);
        }
        for (var i=5;i<10;i++){
            var txt='<div class="homePageCont1_title_d"><div>'+data[i].specialName+'</div></div>';
            $("#homePageCont > div").eq(0).children("#homePageCont1_title").append(txt);
        }
    }else if(navBtnFocus==1){
        $("#homePageCont2_match").html("");
        for (var i=0;i<3;i++){
            /*onlineStatus 0已经结束 1正在进行 2即将开始*/
            var time1=data[i].startTime.split(" ")[0];
            var time2=data[i].startTime.split(" ")[1];
            var txt;
            if(data[i].onlineStatus==1){
                var teamA=data[i].teamA;
                var teamB=data[i].teamB;
                 txt='<div class="homePageCont2_vs1">' +
                        '<img class="homePageCont2_vs1_logo1" src="'+allTeamList[teamA].logUrl+'" alt="">'+
                        '<p class="homePageCont2_vs1_mark1">'+ data[i].scoreA+'</p>'+
                        '<p class="homePageCont2_vs1_mark2">'+ data[i].scoreB+'</p>'+
                        '<img class="homePageCont2_vs1_logo2" src="'+allTeamList[teamB].logUrl+'" alt="">'+
                        '<p class="homePageCont2_vs1_matchTime0">'+time1+'</p>' +
                        '<p class="homePageCont2_vs_name0">'+allTeamList[teamA].gameName+'</p>' +
                    '</div>';

                $("#homePageCont2_match").append(txt);
            }else if(data[i].onlineStatus==0){
                var teamA=data[i].teamA;
                 txt='<div class="homePageCont2_vs2">' +
                    '<img class="homePageCont2_vs1_logo1" src="'+allTeamList[teamA].logUrl+'" alt="">'+
                    '<div class="homePageCont2_vs2_tit"><p class="homePageCont2_vs2_tit_p">'+data[i].musicName+ '</p></div>'+
                    '<p class="homePageCont2_vs2_type1">观看视频</p>' +
                    '<p class="homePageCont2_vs1_matchTime1">'+time1+'</p>' +
                    '<p class="homePageCont2_vs1_matchTim2">'+time2+'</p>' +
                    '<p class="homePageCont2_vs_name1">'+allTeamList[teamA].gameName+'</p>' +
                    '</div>';
                $("#homePageCont2_match").append(txt);
            }else if(data[i].onlineStatus==2){
                var teamA=data[i].teamA;
                var teamB=data[i].teamB;
                 txt='<div class="homePageCont2_vs3">' +
                    '<img class="homePageCont2_vs1_logo1" src="'+allTeamList[teamA].logUrl+'" alt="">'+
                    '<img class="homePageCont2_vs2_logoVS" src="images/home/saishi/vs.png" alt="">'+
                    '<p class="homePageCont2_vs2_type2">即将开始</p>' +
                    '<img class="homePageCont2_vs1_logo2" src="'+allTeamList[teamB].logUrl+'" alt="">'+
                    '<p class="homePageCont2_vs1_matchTime1">'+time1+'</p>' +
                    '<p class="homePageCont2_vs1_matchTim2">'+time2+'</p>' +
                    '<p class="homePageCont2_vs_name1">'+allTeamList.teamA.gameName+'</p>' +
                    '</div>';
                $("#homePageCont2_match").append(txt);
            }

        }
        $(".homePageCont2_posterBig1 img").attr("src",data[3].picUrl);
        $(".homePageCont2_posterBig2 img").attr("src",data[4].picUrl);
        $(".homePageCont2_posterBig1 .homePageCont2_posterBig_tit_p").html(data[3].specialName);
        $(".homePageCont2_posterBig2 .homePageCont2_posterBig_tit_p").html(data[4].specialName);
        for (var i=5;i<11;i++){
            $("#homePageCont2_posterSm").children().eq(i-5).children("img").attr("src",data[i].picUrl);
        }
    }else if(navBtnFocus==2){
        $(".homePageCont3_videoWindow_tit").children("div").children("p").html(data[0].specialName);
        for (var i=1;i<5;i++){
            $(".homePageCont3_videoPoster"+i).children("img").attr("src",data[i].picUrl);
            $(".homePageCont3_videoPoster"+i).children("div").children("p").html(data[i].specialName);
        }
    }else if(navBtnFocus>2){
        try{
            for(var i=0;i<13;i++){
                $("#homePageCont"+(navBtnFocus+1)).children().children().children(".homePageCont4_post").eq(i).attr("src",data[i].picUrl);
            }
        }
        catch (e) {
            console.log("error fillContData1:"+e);
        }
    }
}

