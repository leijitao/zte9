var navFocus=0,contFocus=0,isFocus=0;
var navData;
// var urlId=1353;
/*
isFocus=0 焦点在左侧导航栏
isFocus=1 焦点在右侧内容区域
 */
function keyLeft() {
    if(isFocus==1){
        if(contFocus==0 || contFocus % 4 == 0){
            isFocus=0;
            $(".gameClassContent_d_iFocus").hide();
            $("#gameClassNav > div").children().removeClass("gameClassNav_focus1");
            $("#gameClassNav > div").children().eq(navFocus).addClass("gameClassNav_focus");
        }else{
            contFocus--;
            resetContStyle();
            rollAnimate(4,8,contFocus,200,$("#gameClassContent > div"));
        }
    }
}
function keyUp(){
    if(isFocus==0){
       if(navFocus>0){
           navFocus--;
           fillContData_gameClass();
           resetNavStyle();
           get_gameClass_contInfo(navData[navFocus].id);
           rollAnimate(3.66,6,navFocus,200,$("#gameClassNav > div"));
       }
    }else if(isFocus==1){
        if(contFocus >= 4){
            contFocus-=4;
        }else if(contFocus > 0 && contFocus<4){
            contFocus = 0;
        }
        resetContStyle();
        rollAnimate(4,8,contFocus,200,$("#gameClassContent > div"));
    }
}
function keyRight(){
    if(isFocus==0){
        isFocus=1;
        resetContStyle();
        $("#gameClassNav > div").children().removeClass("gameClassNav_focus");
        $("#gameClassNav > div").children().eq(navFocus).addClass("gameClassNav_focus1");
    }else if(isFocus==1){
        if(contFocus < store.get("contJson" + navFocus).length-1){
            contFocus++;
        }
        resetContStyle();
        rollAnimate(4,8,contFocus,200,$("#gameClassContent > div"));
    }
}
function keyDown(){
    if(isFocus==0){
        if(navFocus <= navData.length - 2){
            navFocus++;
            fillContData_gameClass();
            resetNavStyle();
            get_gameClass_contInfo(navData[navFocus].id);
            rollAnimate(3.66,6,navFocus,200,$("#gameClassNav > div"));
        }
    }else if(isFocus==1){
        if(store.get("contJson" + navFocus).length - 1 - contFocus>=4){
            contFocus+=4;
        }else if(store.get("contJson" + navFocus).length - 1 - contFocus <= 4
            && store.get("contJson" + navFocus).length - 1 - contFocus > 0){
            contFocus = store.get("contJson" + navFocus).length-1;
        }
        resetContStyle();
        rollAnimate(4,8,contFocus,200,$("#gameClassContent > div"),1);
    }
}
function keySelect(){
    if(isFocus==1){
        playVideo(JSON.stringify(store.get("contJson" + navFocus)[contFocus]));
    }
}
function keyBack() {
    exit();
}
function resetNavStyle() {
    contFocus=0;
    $("#gameClassContent > div").css({"top":0});
    $("#gameClassNav > div").children().removeClass("gameClassNav_focus");
    $("#gameClassNav > div").children().eq(navFocus).addClass("gameClassNav_focus");
}
function resetContStyle() {
    textScroll(215,$(".gameClassContent_d").eq(contFocus).children("div").children("p"),2,$(".gameClassContent_d").children("div").children("p"));
    $(".gameClassContent_d_iFocus").hide();
    $("#gameClassContent > div").children().eq(contFocus).children(".gameClassContent_d_iFocus").show();
}
window.onload=function () {
    store.clear();
    var id=getUrlParameter("id=");
    get_gameClass_NavInfo(id);
    // get_gameClass_NavInfo(1353);
};
function get_gameClass_NavInfo(recommendId) {
    $.ajax({
        type:"GET",
        dataType:"json",
        url:"http://"+ip+"/recommend/special/"+ recommendId +"/list",
        success:function(msg){
            console.log("get_gameClass_NavInfo success"+JSON.stringify(msg));
            navData=msg.data;
            for(var x in msg.data){
                var lis_nav='<p class="gameClassNav_p">'+msg.data[x].specialName+'</p>';
                $("#gameClassNav > div").append(lis_nav);
            }
            resetNavStyle(navFocus);
            get_gameClass_contInfo(navData[navFocus].id);
        },
        error:function (msg) {
            console.log("get_gameClass_NavInfo error:"+JSON.stringify(msg));
        }
    })
}
function get_gameClass_contInfo(id) {
    $.ajax({
        type:"GET",
        dataType:"json",
        url:"http://"+ip+"/media/special/"+ id +"/list",
        success:function(msg){
            console.log("get_gameClass_contInfo success"+JSON.stringify(msg));
            store.set("contJson" + navFocus,msg.data);
            $("#gameClassContent > div").html("");
            for(var x in msg.data){
                var lis_nav= '<div class="gameClassContent_d"><img class="gameClassContent_d_i" src="images/gameClass/0.jpg" alt=""><img class="gameClassContent_d_iFocus" src="images/gameClass/bigFocus.png" alt=""><div><p>'
                    +msg.data[x].musicName+'</p> </div> </div>';
                $("#gameClassContent > div").append(lis_nav);
            }
        },
        error:function (msg) {
            console.log("get_gameClass_contInfo error:"+msg);
        }
    })
}
function fillContData_gameClass() {
    if(store.get("contentJson"+navFocus)!==undefined){
        var msg=store.get("contentJson"+navFocus);
        $("#gameClassContent > div").html("");
        for(var x in msg){
            var lis_nav= '<div class="gameClassContent_d"><img class="gameClassContent_d_i" src="images/gameClass/0.jpg" alt=""><img class="gameClassContent_d_iFocus" src="images/gameClass/bigFocus.png" alt=""><div><p>'
                +msg[x].musicName+'</p> </div> </div>';
            $("#gameClassContent > div").append(lis_nav);
        }
    }else {
        get_gameClass_contInfo(navData[navFocus].id);
    }
}
