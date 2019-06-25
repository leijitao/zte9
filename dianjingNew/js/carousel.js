var Times = 0;
var curNav = 0;
var oldNav = 0;
var oldTimes = 0;
var timer = 0;

function InitNav() {
    var content = "";
    for (var i = 0; i < lunBoJson.length; i++) {
        content += "<li><img id='imgNav" + i + "' src='images/01sy/point.png'></li>";
    }
    G("nav").innerHTML = content;
}

function RecomBigPictur() {
    if (Times < 0) {
        return;
    }
    else if (Times == lunBoJson.length) {
        Times = 1;
    } else {
        Times += 1;
    }
    oldTimes = Times;
    curNav = Times - 1;
    oldNav = curNav - 1;
    if (oldNav < 0) {
        oldNav = lunBoJson.length - 1;
    }
    G("imgLB").src = "images/game/" + lunBoJson[Times - 1].id + ".png";
    G("imgNav" + curNav).src = "images/01sy/point_r.png";
    G("imgNav" + oldNav).src = "images/01sy/point.png";
    timer = setTimeout("RecomBigPictur()", 3000);
}

function OnFocusBigPicture() {
    oldTimes = Times;
    Times = -1;
    //G("imgLeft").src = "../Images/Game/HomeLeft/" + leftJson[oldTimes - 1].GameID + "_r.png";
    S("selBig");
    clearTimeout(timer);
}

function OnblurBigPicture() {
    Times = oldTimes;
    //G("imgLeft").src = "../Images/Game/HomeLeft/" + leftJson[oldTimes - 1].GameID + "_r.png";
    H("selBig");
    RecomBigPictur();
}

function SlideGo() {
    // J("../Home/GotoEpg.aspx?EPGName=" + leftJson[oldTimes - 1].EPGName);
    // alert(lunBoJson[oldTimes - 1].id);
    // alert(1);
    getVideoNum();
    // fullPlayVideoBridgeHandler();

}
// function SlideGo1() {
//     alert(1);
//
// }