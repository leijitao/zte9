var focus=0,pageType=1,focusArea=1,videoData,videoNum;
function pageStyle() {
    if(pageType==1){
        $(".videoTopicsContBox").show();
        $(".videoTopicsContBox2").hide();
        $(".videoTopicsContBox_iconUp").hide();
        $(".videoTopicsContBox_iconDown").hide();
    }else{
        $(".videoTopicsContBox").hide();
        $(".videoTopicsContBox2").show();
        $(".videoTopicsContBox_iconUp").show();
        $(".videoTopicsContBox_iconDown").show();
    }
}
/*pageType:
 1: 当前页面样式为videoTopicsContBox
 2: 当前页面样式为videoTopicsContBox2
 focusArea:
 0 当前焦点在小窗口上
 1 焦点在选集区域
 videoIndex:
 当前播放第几个视频，从0开始
 videoNum:
 总集数 从1开始
*/
function keyLeft() {
    if(pageType==1 && focusArea==1){
        focusArea=0;
        resetBoxStyle();
        rollAnimate(4.69,7,focus,200,$(".videoTopicsContBox > div"));
    }else if(pageType==2 && focusArea==1){
        if(focus==0 || focus % 4==0){
            focusArea=0;
        }else {
            focus--;
        }
        resetBox2Style();
        rollAnimate(3.96,24,focus,200,$(".videoTopicsContBox2 > div"));
    }
}
function keyUp(){
    if(pageType==1 && focusArea==1){
        if(focus>0){
            focus--;
        }
        resetBoxStyle();
        rollAnimate(4.69,7,focus,200,$(".videoTopicsContBox > div"));
    }else if(pageType==2 && focusArea==1){
        if(focus>3){
            focus-=4;
        }else {
            focus=0;
        }
        resetBox2Style();
        rollAnimate(3.96,24,focus,200,$(".videoTopicsContBox2 > div"))
    }
}
function keyRight(){
    if(pageType==1){
        if(focusArea==0){
            focusArea=1;
        }
        resetBoxStyle();
        rollAnimate(4.69,7,focus,200,$(".videoTopicsContBox > div"));
    }else if(pageType==2){
        if(focusArea==0){
            focusArea=1;
        }else if(focusArea==1 && focus < videoNum-1){
            focus++;
        }
        resetBox2Style();
        rollAnimate(3.96,24,focus,200,$(".videoTopicsContBox2 > div"))
    }
}
function keyDown(){
    if(pageType==1 && focusArea==1){
        if(focus < videoNum-1){
            focus++;
        }
        resetBoxStyle();
        rollAnimate(4.69,7,focus,200,$(".videoTopicsContBox > div"));
    }else if(pageType==2 && focusArea==1){
        if(focus < videoNum-4){
            focus+=4;
        }else if(focus > videoNum-5 && focus < videoNum-1){
            focus=videoNum;
        }
        resetBox2Style();
        rollAnimate(3.96,24,focus,200,$(".videoTopicsContBox2 > div"))
    }
}
function keySelect() {
    if(focusArea==0){
        windowStopPlayVideo();
        var dataList={
            "data":videoData,
            "index":videoData.length-1-focus
        };
        playVideoList(dataList);
    }else if(focusArea==1){
        windowStopPlayVideo();
        playVideo(videoData.length-1-focus);
        if(pageType==1){
            $(".videoTopicsContBox_d_icon").remove();
            $(".videoTopicsContBox_big > div").eq(focus).append('<img class="videoTopicsContBox_d_icon" src="images/videoTopices/playvideo_icon.png" alt="">');
        }else {
            $(".videoTopicsContBox2_icon").remove();
            $(".videoTopicsContBox2_d").eq(focus).append('<img class="videoTopicsContBox2_icon" src="images/videoTopices/playvideo_icon.png" alt="">');
        }
    }
}
function keyBack() {
    exit();
}

function resetBoxStyle() {
    if(focusArea==0){
        $(".videoTopicsCont_videoFocus").show();
        $(".videoTopicsContBox_d").removeClass("videoTopicsContBox_dFocus");
    }else if(focusArea==1){
        textScroll(280,$(".videoTopicsContBox_d > div > p").eq(focus),2,$(".videoTopicsContBox_d > div > p"));
        $(".videoTopicsCont_videoFocus").hide();
        $(".videoTopicsContBox_d").removeClass("videoTopicsContBox_dFocus");
        $(".videoTopicsContBox > div").children().eq(focus).addClass("videoTopicsContBox_dFocus");
    }
}
function resetBox2Style() {
    if(focusArea==0){
        $(".videoTopicsCont_videoFocus").show();
        $(".videoTopicsContBox2_d").removeClass("videoTopicsContBox2_dFocus");
    }else if(focusArea==1){
        $(".videoTopicsCont_videoFocus").hide();
        $(".videoTopicsContBox2_d").removeClass("videoTopicsContBox2_dFocus");
        $(".videoTopicsContBox2 > div").children().eq(focus).addClass("videoTopicsContBox2_dFocus");
    }
}
window.onload=function(){
    store.clear();
    var id=getUrlParameter("id=");
    // get_videoTopics(1353);
    get_videoTopics(id);
};
function get_videoTopics(id) {
    $.ajax({
        type: "GET",
        dataType: "json",
        url: "http://" + ip + "/recommend/special/" + id + "/list",
        success:function (msg) {
            console.log("get_videoTopics success:"+JSON.stringify(msg));
            pageType=msg.data[0].recomMark;
            pageStyle();
            $(".videoTopicsCont_tit").html(msg.data[0].specialName);
            $(".videoTopicsCont_describe").html(msg.data[0].shortdesc);
            get_videoTopics_VideosInfo(msg.data[0].id);
        },
        error:function (msg) {
            console.log("get_videoTopics error:"+JSON.stringify(msg));
        }
    })
}
function get_videoTopics_VideosInfo(id) {
    $.ajax({
        type:"GET",
        dataType:"json",
        url:"http://"+ip+"/media/special/"+ id +"/list",
        success:function(msg){
            console.log("get_videoTopics_VideosInfo success"+JSON.stringify(msg));
            videoNum = msg.data.length;
            videoData=msg.data;
            if(pageType==1){
                for(var x=msg.data.length-1;x>=0;x--){
                    var lis_nav= '<div class="videoTopicsContBox_d"><div><p>'
                        +msg.data[x].musicName+'</p></div></div>';
                    $(".videoTopicsContBox_big").append(lis_nav);
                    if(msg.data[x].isFree==1){
                        $(".videoTopicsContBox_big > div").eq(x).append('<img class="videoTopicsContBox_d_lable" src="images/videoTopices/lable.png" alt="">');
                    }
                }
                $(".videoTopicsContBox_d").eq(0).append('<img class="videoTopicsContBox_d_icon" src="images/videoTopices/playvideo_icon.png" alt="">');
            }else {
                for(var x=msg.data.length-1;x>=0;x--){
                    var lis_nav= '<div class="videoTopicsContBox2_d"><p class="videoTopicsContBox2_dp">'
                        +(parseInt(x)+1)+'</p></div>';
                    $(".videoTopicsContBox2 > div").append(lis_nav);
                    if(msg.data[x].isFree==1){
                        $(".videoTopicsContBox2 > div > div").eq(x).append('<img class="videoTopicsContBox2_label" src="images/videoTopices/lable.png" alt="">');
                    }
                }
                $(".videoTopicsContBox2 > div > div").eq(0).addClass("videoTopicsContBox2_dFocus");
            }
            resetBoxStyle(focus);
            playVideo(msg.data.length-1-focus);
        },
        error:function (msg) {
            console.log("get_videoTopics_VideosInfo error:"+JSON.stringify(msg));








        }
    })
}
var x,y,width,height;
if(screen.width==1280){
    x=63;
    y=237;
    width=739;
    height=416;
}else if(screen.width==1920){
    x=94;
    y=355;
    width=1330;
    height=624;
}
function playVideo(i) {
    var playList = {
        "x": x,
        "y": y,
        "width": width,
        "height": height,
        "typeCode": 123,
        "contentId": videoData[i].contentId,
        "serviceId": videoData[i].serviceId,
        "checkAutho": 0
        //0表示播放几十秒后检查是否是会员，如果不是则跳订购，1表示不检查
    };
    windowPlayVideo(playList);
}
