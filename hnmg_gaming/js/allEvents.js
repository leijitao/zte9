var focus = 0,videoNum;
resetContStyle();
function keyLeft() {
    if(focus>0){
        focus--;
    }
    resetContStyle();
    rollAnimate(4,10,focus,200,$(".allEventContAll"))
}
function keyUp(){
    if (focus > 0 && focus < 5){
        focus = 0;
    }else if( focus > 4){
        focus -= 5;
    }
    resetContStyle();
    rollAnimate(4,10,focus,200,$(".allEventContAll"))
}
function keyRight(){
    if(focus < videoNum - 1){
        focus ++;
    }

    resetContStyle();
    rollAnimate(4,10,focus,200,$(".allEventContAll"))
}
function keyDown(){
    if( focus < videoNum - 5){
        focus += 5;
    }else if(focus > videoNum - 1 - 5 && focus < videoNum - 1){
        focus = videoNum - 1;
    }
    resetContStyle();
    rollAnimate(4,10,focus,200,$(".allEventContAll"));
}
function keySelect() {
    // jump_ZtList_playVideo(store.set("allEventsContJson")[focus]);
    playVideo(JSON.stringify( store.get("allEventsContJson")[focus]));
}
function keyBack() {
    exit();
}

function resetContStyle() {
    textScroll(215,$(".gameClassContent_d").eq(focus).children("div").children("p"),2,$(".gameClassContent_d").children("div").children("p"));
    $(".gameClassContent_d_iFocus").hide();
    $(".allEventContAll").children().eq(focus).children(".gameClassContent_d_iFocus").show();
}
window.onload=function () {
    store.clear();
    var typeCode=getUrlParameter("typeCode=");
    get_allEvents_VideosCont(typeCode);
};
function get_allEvents_VideosCont(typeCode) {
    $.ajax({
        type: "GET",
        dataType: "json",
        url: "http://" + ip + "/media/category/" + typeCode + "/list",
        success:function (msg) {
            console.log("get_allEvents_VideosCont success"+JSON.stringify(msg));
            videoNum=msg.data.length;
            store.set("allEventsContJson",msg.data);
            $(".allEventContAll").html("");
            for(var x in msg.data){
                var lis_nav= '<div class="gameClassContent_d"><img class="gameClassContent_d_i" src="images/gameClass/0.jpg" alt=""><img class="gameClassContent_d_iFocus" src="images/gameClass/bigFocus.png" alt=""><div><p>'
                    +msg.data[x].musicName+'</p> </div> </div>';
                $(".allEventContAll").append(lis_nav);
            };
            $(".allEventContAll").children().eq(focus).children(".gameClassContent_d_iFocus").show();
        },
        error:function (msg) {
            console.log("get_allEvents_VideosCont error"+JSON.stringify(msg));
        }
    })
}
