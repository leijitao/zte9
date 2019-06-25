var focus01=0,focus02=0;
var focus11=0,focus12=0;
var focus21=0;
var focus31=0,focus32=0;

var focusWhere=0,focus0=0;
var length1_1 = 6,length1_2 = 8;
var length2_1 = 3,length2_2 = 7;
var length3_1 = 12;
var length4_1 = 9,length4_2 = 8;
/*
focusWhere:焦点位置  0 左边导航栏 1 顶部导航栏 2 内容区域
* */
function keyLeft() {
    if (focusWhere == 0) {
        if (focus0 == 0) {

        } else if (focus0 == 1) {

        } else if (focus0 == 2) {

        } else if (focus0 == 3) {

        }
    } else if (focusWhere == 1) {
        if (focus0 == 0) {
            focusWhere = 0;
            $(".gameMatchCont0_left > div").removeClass("homePageCont2_vs1_focus homePageCont2_vs2_focus");
            reset_navLeftStyle();
        } else if (focus0 == 1) {
            if(focus11>0){
                focus11--;
                getRankingCont(store.get("navList1"+focus0)[focus11].id);
                reset_gameMatchCont1_nav_Style();
            }else if(focus11==0){
                focusWhere = 0;
                $(".gameMatchCont1_nav_p").removeClass("gameMatchCont1_nav_pFocus");
                reset_navLeftStyle();
            }
        } else if (focus0 == 2) {
            if(focus21%4==0 || focus21==0){
                focusWhere = 0;
                $("#gameMatchCont2 .gameClassContent_d_iFocus").hide();
                reset_navLeftStyle();
            }else if(focus21>0){
                focus21--;
                reset_gameMatchCont2_cont_Style();
                rollAnimate(4,8,focus21,200,$(".gameMatchCont2 > div"));
            }
        } else if (focus0 == 3) {
            if(focus31%3==0 || focus31==0){
                focusWhere = 0;
                $(".gameMatchCont3_left .gameClassContent_d_iFocus").hide();
                reset_navLeftStyle();
            }else if(focus31>0){
                focus31--;
                reset_gameMatchCont3_cont_Style();
            }
        }
    } else if (focusWhere == 2) {
        if (focus0 == 0) {
            focusWhere = 1;
            $(".gameMatchCont0_right_d").removeClass("gameMatchCont0_right_dFocus");
            $(".gameMatchCont0_right_d").eq(focus02).append('<img src="images/gameMatch/now.png" alt="">');
            reset_gameMatchCont0_left_Style();
        } else if (focus0 == 1) {
            focusWhere = 0;
            $(".gameMatchCont1_cont_contFocus").remove();
            reset_navLeftStyle();
        } else if (focus0 == 2) {

        } else if (focus0 == 3) {
            focusWhere=1;
            $(".gameMatchCont3_right_d > div").removeClass("gameMatchCont3_right_d_focus2");
            reset_gameMatchCont3_cont_Style();
        }
    }
}
function keyUp(){
    if(focusWhere==0){
        if(focus0>0){
            focus0--;
            fillInformation_list1();
            reset_navLeftStyle();
            $(".gameMatchCont0_right_d").removeClass("gameMatchCont0_right_dFocus");
            $(".gameMatchCont0_right_d > img").remove();
            $(".gameMatchCont0_right_d").eq(focus02).append('<img src="images/gameMatch/now.png" alt="">');
            $(".gameMatchCont1_nav_p").eq(focus11).addClass("gameMatchCont1_nav_pFocus1");
        }
    }else if(focusWhere==1){
        if(focus0==0){
            if(focus01>0){
                focus01--;
            }
            reset_gameMatchCont0_left_Style();
            rollAnimate(4.8,4,focus01,200,$(".gameMatchCont0_left"));
        } else if (focus0 == 1) {

        } else if (focus0 == 2) {
            if(focus21>4){
                focus21-=4;
            }else {
                focus21=0;
            }
            reset_gameMatchCont2_cont_Style();
            rollAnimate(4,8,focus21,200,$(".gameMatchCont2 > div"));
        } else if (focus0 == 3) {
            if(focus31>3){
                focus31-=3;
            }else {
                focus31=0;
            }
            reset_gameMatchCont3_cont_Style();
            rollAnimate(4,6,focus31,200,$(".gameMatchCont3_left"));
        }
    }else if(focusWhere==2){
        if(focus0==0){
            focus01=0;
            $(".gameMatchCont0_left").css({top:0});
            if(focus02>0){
                focus02--;
                getDateCont(store.get("navList1"+focus0)[focus02].dateStr);
                reset_gameMatchCont0_right_Style();
                rollAnimate(5.1,10,focus02,200,$(".gameMatchCont0_right"));
            }
        } else if (focus0 == 1) {
            if(focus12>0){
                focus12--;
                reset_gameMatchCont1_cont_Style();
                rollAnimate(3.6,5,focus12,200,$(".gameMatchCont1_cont_cont > div"));
            }else if(focus12==0){
                focusWhere=1;
                $(".gameMatchCont1_cont_contFocus").remove();
                reset_gameMatchCont1_nav_Style();
            }
        } else if (focus0 == 2) {

        } else if (focus0 == 3) {
            focus31=0;
            $(".gameMatchCont3_left").css({top:0});
            if(focus32>0){
                focus32--;
                getTeamCont(store.get("navList1"+focus0)[focus32].id);
            }
            reset_gameMatchCont3_right_Style();
            rollAnimate(4.72,4,focus32,200,$(".gameMatchCont3_right"));
        }
    }
}
function keyRight(){
    if(focusWhere==0){
        $(".gameMatchNavBtn").removeClass("gameMatchNavBtnFocus0") ;
        $(".gameMatchNavBtn").eq(focus0).addClass("gameMatchNavBtnFocus1") ;
        if(focus0==0){
            focusWhere=1;
            reset_gameMatchCont0_left_Style();
        }else if(focus0==1){
            focusWhere=2;
            reset_gameMatchCont1_cont_Style();
        }else if(focus0==2){
            focusWhere=1;
            reset_gameMatchCont2_cont_Style();
        }else if(focus0==3){
            focusWhere=1;
            reset_gameMatchCont3_cont_Style();
        }
    }else if (focusWhere==1){
        if(focus0==0){
            focusWhere=2;
            $(".gameMatchCont0_right_d").children("img").remove();
            $(".gameMatchCont0_left > div").removeClass("homePageCont2_vs1_focus homePageCont2_vs2_focus");
            reset_gameMatchCont0_right_Style();
        }else if(focus0==1){
            if(focus11 < length2_1-1){
                focus11++;
                getRankingCont(store.get("navList1"+focus0)[focus11].id);
                reset_gameMatchCont1_nav_Style();
            }
        }else if(focus0==2){
            if(focus21<length3_1-1){
                focus21++;
                reset_gameMatchCont2_cont_Style();
                rollAnimate(4,8,focus21,200,$(".gameMatchCont2 > div"));
            }
        }else if(focus0==3){
            if((focus31+1)%3==0 || focus31==length4_1-1){
                focusWhere = 2;
                $(".gameMatchCont3_left .gameClassContent_d_iFocus").hide();
                reset_gameMatchCont3_right_Style();
            }else if(focus31<length4_1){
                focus31++;
                reset_gameMatchCont3_cont_Style();
            }
        }
    }
}
function keyDown(){
    if(focusWhere==0){
        if(focus0<3){
            focus0++;
            fillInformation_list1();
            reset_navLeftStyle();
            reset_gameMatchCont0_right_Style();
            $(".gameMatchCont1_nav_p").removeClass("gameMatchCont1_nav_pFocus gameMatchCont1_nav_pFocus1");
            $(".gameMatchCont1_nav_p").eq(focus11).addClass("gameMatchCont1_nav_pFocus1");
        }
    }else if(focusWhere==1){
        if(focus0==0){
            if(focus01 < length1_1 - 1){
                focus01++;
            }
            reset_gameMatchCont0_left_Style();
            rollAnimate(4.8,4,focus01,200,$(".gameMatchCont0_left"));
        } else if (focus0 == 1) {
            focusWhere=2;
            $(".gameMatchCont1_nav_p").removeClass("gameMatchCont1_nav_pFocus");
            $(".gameMatchCont1_nav_p").eq(focus11).addClass("gameMatchCont1_nav_pFocus1");
            reset_gameMatchCont1_cont_Style();
        } else if (focus0 == 2) {
            if(focus21<length3_1-4){
                focus21+=4;
            }else if(focus21 >= length3_1-4){
                focus21=length3_1-1
            }
            reset_gameMatchCont2_cont_Style();
            rollAnimate(4,8,focus21,200,$(".gameMatchCont2 > div"));
        } else if (focus0 == 3) {
            if(focus31 < length4_1-4){
                focus31+=3;
            }else {
                focus31=length4_1-1;
            }
            reset_gameMatchCont3_cont_Style();
            rollAnimate(4,6,focus31,200,$(".gameMatchCont3_left"));
        }
    }else if(focusWhere==2){
        if(focus0==0){
            focus01=0;
            $(".gameMatchCont0_left").css({top:0});
            if(focus02 < length1_2 - 1){
                focus02++;
                getDateCont(store.get("navList1"+focus0)[focus02].dateStr);
            }
            reset_gameMatchCont0_right_Style();
            rollAnimate(5.1,10,focus02,200,$(".gameMatchCont0_right"));
        } else if (focus0 == 1) {
            if(focus12<length2_2-1){
                focus12++;
                reset_gameMatchCont1_cont_Style();
                rollAnimate(3.6,5,focus12,200,$(".gameMatchCont1_cont_cont > div"));
            }
        } else if (focus0 == 2) {

        } else if (focus0 == 3) {
            focus31=0;
            $(".gameMatchCont3_left").css({top:0});
            if(focus32<length4_2-1){
                focus32++;
                getTeamCont(store.get("navList1"+focus0)[focus32].id);
            }
            reset_gameMatchCont3_right_Style();
            rollAnimate(4.72,4,focus32,200,$(".gameMatchCont3_right"));
        }
    }
}
function keySelect() {
    if(focus0==0 && focusWhere==1){
        // jump_ZtList_playVideo();
    }else if(focus0==1){

    }else if(focus0==2 && focusWhere==1){

    }else if(focus0==3 && focusWhere==1){

    }
}
function keyBack() {
    exit();
}
function reset_navLeftStyle() {
    $(".gameMatchNavBtn").removeClass("gameMatchNavBtnFocus0 gameMatchNavBtnFocus1") ;
    $("#gameMatchNav").children().eq(focus0).addClass("gameMatchNavBtnFocus0");
    $(".gameMatchCont").hide();
    $(".gameMatchCont").eq(focus0).show();
}
/*gameMatchCont0*/
function reset_gameMatchCont0_left_Style() {
    $(".gameMatchCont0_left > div").removeClass("homePageCont2_vs1_focus homePageCont2_vs2_focus");
    var objCla = getElementClass($(".gameMatchCont0_left > div").eq(focus01),0);
    if(objCla == "homePageCont2_vs1"){
        $(".gameMatchCont0_left > div").eq(focus01).addClass("homePageCont2_vs1_focus");
    }else {
        $(".gameMatchCont0_left > div").eq(focus01).addClass("homePageCont2_vs2_focus");
    }
}
function reset_gameMatchCont0_right_Style() {
    $(".gameMatchCont0_right_d").removeClass("gameMatchCont0_right_dFocus");
    $(".gameMatchCont0_right > div").eq(focus02).addClass("gameMatchCont0_right_dFocus")
}
/*gameMatchCont1*/
function reset_gameMatchCont1_nav_Style() {
    $(".gameMatchCont1_nav_p").removeClass("gameMatchCont1_nav_pFocus gameMatchCont1_nav_pFocus1");
    $(".gameMatchCont1_nav_p").eq(focus11).addClass("gameMatchCont1_nav_pFocus");
}
function reset_gameMatchCont1_cont_Style() {
    $(".gameMatchCont1_cont_contFocus").remove();
    $(".gameMatchCont1_cont_cont_d").eq(focus12).append('<img class="gameMatchCont1_cont_contFocus" src="images/gameMatch/contFocus.png" alt="">');
}
/*gameMatchCont2*/
function reset_gameMatchCont2_cont_Style() {
    $(".gameClassContent_d_iFocus").hide();
    $(".gameClassContent_d_iFocus").eq(focus21).show();
    textScroll(215,$(".gameMatchCont2_p").eq(focus21),2,$(".gameMatchCont2_p"));
}
/*gameMatchCont3*/
function reset_gameMatchCont3_cont_Style() {
    $(".gameMatchCont3_left .gameClassContent_d_iFocus").hide();
    $(".gameMatchCont3_left .gameClassContent_d_iFocus").eq(focus31).show();
    textScroll(215,$(".gameMatchCont3_p").eq(focus31),2,$(".gameMatchCont3_p"));
}
function reset_gameMatchCont3_right_Style() {
    $(".gameMatchCont3_right_d").removeClass("gameMatchCont3_right_d_focus1");
    $(".gameMatchCont3_right_d > div").removeClass("gameMatchCont3_right_d_focus2");
    $(".gameMatchCont3_right_d").eq(focus32).addClass("gameMatchCont3_right_d_focus1");
    $(".gameMatchCont3_right_d").eq(focus32).children("div").addClass("gameMatchCont3_right_d_focus2");
}
window.onload=function () {
    store.clear();
    getAllTeamList();
    var id=getUrlParameter("id=");
    getNavList(id);
    // getNavList(1382);
};
function getNavList(recommendId) {
    $.ajax({
        type:"GET",
        dataType:"json",
        url:"http://"+ip+"/recommend/special/"+ recommendId +"/list",
        success:function(msg){
            console.log("getNavList success from gameMatch:"+JSON.stringify(msg));
            store.set("getNavListMsg",msg.data);
            for(var x=0;x<4;x++){
                $("#gameMatchNav").children().eq(x).html(msg.data[x].specialName);
            }
            getDateList(msg.data[0].id);
        },
        error:function (msg) {
            console.log("getNavList error from gameMatch:"+JSON.stringify(msg));
        }
    })
}
function getDateList(id) {
    /*日期*/
    $.ajax({
        type:"GET",
        dataType:"json",
        url:"http://"+ip+"/competition/dates",
        data:{
            specialId:id
        },
        success:function(msg){
            console.log("getDateList success from gameMatch:"+JSON.stringify(msg));
            store.set("navList1"+focus0,msg.data);
            length1_2=msg.data.length;
            for(var x in msg.data){
                var dateStr=msg.data[x].dateStr.split("-");
                dateStr=dateStr[1]+"."+dateStr[2];
                var txt='<div class="gameMatchCont0_right_d"><p class="gameMatchCont0_right_p1">' +
                    dateStr+'</p><p class="gameMatchCont0_right_p2">' +
                    msg.data[x].weekStr+'</p></div>';
                $(".gameMatchCont0_right").append(txt);
            }
            getDateCont(msg.data[0].dateStr);
            $(".gameMatchCont0_right_d").eq(0).append('<img src="images/gameMatch/now.png" alt="">');
        },
        error:function (msg) {
            console.log("getDateList error from gameMatch:"+JSON.stringify(msg));
        }
    })
}
function getRankingList(id) {
    /*排行*/
    $.ajax({
        type:"GET",
        dataType:"json",
        url:"http://"+ip+"/competition/districts",
        data:{
            specialId:id
        },
        success:function(msg){
            console.log("getRankingList success from gameMatch:"+JSON.stringify(msg));
            store.set("navList1"+focus0,msg.data);
            length2_1=msg.data.length;
            for(var x in msg.data){
                var txt='<p class="gameMatchCont1_nav_p">'+msg.data[x].name+'</p>';
                $(".gameMatchCont1_nav").append(txt);
            }
            getRankingCont(msg.data[0].id);
            $(".gameMatchCont1_nav_p").eq(focus11).addClass("gameMatchCont1_nav_pFocus1");
        },
        error:function (msg) {
            console.log("getRankingList error from gameMatch:"+JSON.stringify(msg));
        }
    })
}
function getTeamList(id) {
    /*队伍*/
    $.ajax({
        type:"GET",
        dataType:"json",
        url:"http://"+ip+"/competition/teams",
        data:{
            specialId:id
        },
        success:function(msg){
            console.log("getTeamList success from gameMatch:"+JSON.stringify(msg));
            store.set("navList1"+focus0,msg.data);
            length4_2=msg.data.length;
            for(var x in msg.data){
                var id=msg.data[x].id;
                var txt='<div class="gameMatchCont3_right_d"><img src="'+allTeamList[id].logUrl+'" alt=""><div></div></div>';
                $(".gameMatchCont3_right").append(txt);
            }
            $(".gameMatchCont3_right_d").eq(0).addClass("gameMatchCont3_right_d_focus1");
            getTeamCont(msg.data[0].id);
        },
        error:function (msg) {
            console.log("getRankingList error from gameMatch:"+JSON.stringify(msg));
        }
    })
}
function getDateCont(id) {
/*日期*/
    $.ajax({
        type:"GET",
        dataType:"json",
        url:"http://"+ip+"/competition/course/"+store.get("getNavListMsg")[focus0].id+"/list",
        data:{
            date:id
        },
        success:function(msg){
            console.log("getDateCont success from gameMatch:"+JSON.stringify(msg));
            length1_1=msg.data.length;
            var data=msg.data;
            $(".gameMatchCont0_left").html("");
            for (var i in data){
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

                    $(".gameMatchCont0_left").append(txt);
                }else if(data[i].onlineStatus==0){
                    var team=data[i].teamA;
                    txt='<div class="homePageCont2_vs2">' +
                        '<img class="homePageCont2_vs1_logo1" src="'+allTeamList[team].logUrl+'" alt="">'+
                        '<div class="homePageCont2_vs2_tit"><p class="homePageCont2_vs2_tit_p">'+data[i].musicName+ '</p></div>'+
                        '<p class="homePageCont2_vs2_type1">观看视频</p>' +
                        '<p class="homePageCont2_vs1_matchTime1">'+time1+'</p>' +
                        '<p class="homePageCont2_vs1_matchTim2">'+time2+'</p>' +
                        '<p class="homePageCont2_vs_name1">'+allTeamList[team].gameName+'</p>' +
                        '</div>';
                    $(".gameMatchCont0_left").append(txt);
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
                        '<p class="homePageCont2_vs_name1">'+allTeamList[teamA].gameName+'</p>' +
                        '</div>';
                    $(".gameMatchCont0_left").append(txt);
                }

            }
        },
        error:function (msg) {
            console.log("getDateCont error from gameMatch:"+JSON.stringify(msg));
        }
    })
}
function getPeripheryCont(id) {
/*周边*/
    $.ajax({
        type:"GET",
        dataType:"json",
        url:"http://"+ip+"/competition/around/"+id+"/list",
        success:function(msg){
            console.log("getPeripheryCont success from gameMatch:"+JSON.stringify(msg));
            length3_1=msg.data.length;
            $(".gameMatchCont2 > div").html("");
            for(var i in msg.data){
                var txt='<div class="gameClassContent_d"><img class="gameClassContent_d_i" src="'+
                    msg.data[i].smallPic+'" alt=""><img class="gameClassContent_d_iFocus" src="images/gameClass/bigFocus.png" alt=""><div><p class="gameMatchCont2_p">'+
                    msg.data[i].musicName+'</p></div></div>';
                $(".gameMatchCont2 > div").append(txt);
            }
        },
        error:function (msg) {
            console.log("getPeripheryCont error from gameMatch:"+JSON.stringify(msg));
        }
    })
}
function getRankingCont(id) {
/*排行*/
    $.ajax({
        type:"GET",
        dataType:"json",
        url:"http://"+ip+"/competition/rank/"+store.get("getNavListMsg")[focus0].id+"/list",
        data:{
            districtId:id
        },
        success:function(msg){
            console.log("getRankingCont success from gameMatch:"+JSON.stringify(msg));
            length2_2=msg.data.length;
            $(".gameMatchCont1_cont_cont > div").html("");
            for(var i in msg.data){
                var teamId=msg.data[i].teamId;
                var scene=msg.data[i].victory+msg.data[i].defeat+msg.data[i].draw;
                var txt='<div class="gameMatchCont1_cont_cont_d">' +
                    '<p class="gameMatchCont1_cont_cont1">'+(parseInt(i)+1)+'</p>' +
                    '<img class="gameMatchCont1_cont_cont_logo" src="'+allTeamList[teamId].logUrl+'" alt="">' +
                    '<p class="gameMatchCont1_cont_cont2">'+allTeamList[teamId].name+'</p>' +
                    '<p class="gameMatchCont1_cont_cont3">'+scene+'</p>' +
                    '<p class="gameMatchCont1_cont_cont3">'+msg.data[i].victory+'</p>' +
                    '<p class="gameMatchCont1_cont_cont3">'+msg.data[i].defeat+'</p>' +
                    '<p class="gameMatchCont1_cont_cont3">'+msg.data[i].draw+'</p>' +
                    '<p class="gameMatchCont1_cont_cont3">'+msg.data[i].score+'</p>' +
                    '<img class="gameMatchCont1_cont_cont_underline" src="images/gameMatch/underline.png" alt="">' +
                    '</div>';
                $(".gameMatchCont1_cont_cont > div").append(txt);
            }
            $(".gameMatchCont1_cont_cont_d").eq(0).addClass("gameMatchCont1_cont_cont_dBg1");
            $(".gameMatchCont1_cont_cont_d").eq(1).addClass("gameMatchCont1_cont_cont_dBg2");
            $(".gameMatchCont1_cont_cont_d").eq(2).addClass("gameMatchCont1_cont_cont_dBg3");
        },
        error:function (msg) {
            console.log("getRankingCont error from gameMatch:"+JSON.stringify(msg));
        }
    })
}
function getTeamCont(id) {
/*队伍*/
    $.ajax({
        type:"GET",
        dataType:"json",
        url:"http://"+ip+"/competition/team/"+store.get("getNavListMsg")[focus0].id+"/list",
        data:{
            teamId:id
        },
        success:function(msg){
            console.log("getTeamCont success from gameMatch:"+JSON.stringify(msg));
            length4_1=msg.data.length;
            $(".gameMatchCont3_left").html("");
            for(var i in msg.data){
                var txt='<div class="gameClassContent_d"><img class="gameClassContent_d_i" src="'+
                    msg.data[i].smallPic+'" alt=""><img class="gameClassContent_d_iFocus" src="images/gameClass/bigFocus.png" alt=""><div><p class="gameMatchCont3_p">'+
                    msg.data[i].musicName+'</p></div></div>';
                $(".gameMatchCont3_left").append(txt);
            }
        },
        error:function (msg) {
            console.log("getTeamCont error from gameMatch:"+JSON.stringify(msg));
        }
    })
}
function fillInformation_list1() {
    if(focus0==0){
        if(store.get("navList1"+focus0)!==undefined){

        }else {
            getDateList(store.get("getNavListMsg")[focus0].id);
        }
    }else if(focus0==1){
        if(store.get("navList1"+focus0)!==undefined){

        }else {
            getRankingList(store.get("getNavListMsg")[focus0].id)
        }
    }else if(focus0==2){
        if(store.get("navList1"+focus0)!==undefined){

        }else {
            getPeripheryCont(store.get("getNavListMsg")[focus0].id)
        }
    }else if(focus0==3){
        if(store.get("navList1"+focus0)!==undefined){

        }else {
            getTeamList(store.get("getNavListMsg")[focus0].id)
        }
    }
}
