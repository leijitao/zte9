var bridge;
// 测试ip
var ip=112+"."+18+"."+251+"."+15+":"+5400+"/scydGaming_api";
var ip_local=112+"."+18+"."+251+"."+15+":"+5400+"/dianjing";

//来自于哪个平台 0 中兴  1华为  2烽火
var userId = window.widgetmanager.getParameter('userId');
// var userId = 18349306863;
var deviceId= window.widgetmanager.getParameter('deviceID');
// var deviceId= 123;
console.log('userId:'+userId+'deviceId:'+deviceId);

var videoNum;
var VipResult;
var palyVideoUrl716;

var model_mg;
var versionCode_mg;
var versionName_mg;
var release_mg;
var currentdate;

var click_goback=true;

//一级导航样式重置
 reset_fir=function (num){
    $('.title_first').children().hide();
    $('.title_first').children().eq(0).show();
    $('.title_first').children().eq(num+1).show();
}

//获取当前时间 年月日
function getNowFormatDate() {
    var date = new Date();
    var seperator1 = "-";
    var seperator2 = ":";
    var month = date.getMonth() + 1;
    var strDate = date.getDate();
    if (month >= 1 && month <= 9) {
        month = "0" + month;
    }
    if (strDate >= 0 && strDate <= 9) {
        strDate = "0" + strDate;
    }
    currentdate = date.getFullYear() + seperator1 + month + seperator1 + strDate
        + " " + date.getHours() + seperator2 + date.getMinutes()
        + seperator2 + date.getSeconds();
}
/*文字提示框*/
var frame={};
var time = function () {
    setTimeout(function () {
        $(".frameTxt").fadeOut();
    }, 5000)
};
frame.hasAttend=function (html) {
    $(".frameTxt").html(html);
    $(".frameTxt").fadeIn();
    clearTimeout(time);
    time();
};
// 计费
function charging(packageId,action,merchantId,contentList) {
    $.ajax({
        type: "GET",
        dataType: "json",
        url: "http://112.54.201.200:8082/yst-pvn-prd-api/cp/syncPackageContentRelation",
        data: {
            "packageId": packageId,
            "action": action,
            "merchantId": merchantId,
            "contentList": contentList
        },
        success: function (msg) {
            console.log("charging success" + JSON.stringify(msg));

        },
        error: function (msg) {
            console.log("charging error" + JSON.stringify(msg));
        }
    })
}

/*播放时鉴权
鉴权返回码
0	鉴权成功
320	DB处理异常
340	请求参数为空
350	本地数据校验异常
360	配置项未配置
400	用户未订购产品包
670	运营商处理异常
680	运营商返回TOKEN失效
999	系统异常*/
function authentication(serviceId ,productIds,musicName,method) {
    console.log("userId:"+ userId+",serviceId:"+serviceId+",productIds:"+productIds+",musicName:"+musicName+",method:"+method);
    $.ajax({
        type: "GET",
        dataType: "json",
        url: "http://112.18.251.15:5400/scydGaming_pay/scyd/queryUserInfo",
        data: {
            "custId": userId,
            "contentId": serviceId ,
            "productIds": productIds,
            "musicName":musicName
        },
        success: function (msg) {
            console.log("authentication success" + JSON.stringify(msg));
            if (msg.data.result == 400) {
                //    去订购
                window.location.href = msg.data.cloudPayUrl;
            } else if(msg.data.result == 0){
            //    已订购该包月
                method;
            }else{

            }
        },
        error: function (msg) {
            console.log("authentication error" + JSON.stringify(msg))
        }
    })
}


//   中九 点播，其他，二级节点，推荐位点击数统计
// play	不为空则为点播统计
// other	不为空则为其他统计
// category	不为空则为二级节点统计
// recClick	不为空则为点播数据统计

//一级、二级导航统计

function category_zte(typeCode,pageName){
    $.ajax({
        type:"GET",
        dataType:"json",
        url:"http://"+ ip + "/stat/music/category",
        data:{
            'model':"",
            'version':"",
            'release':"",
            'mac':"",
            'versionCode':"",
            'versionName':"",
            'userId':userId,
            'typeCode':typeCode,
            'pageName':pageName,
        },

        success:function(msg){
            console.log(msg);
            // alert("msg.code:"+msg.code);
        },
        error:function (msg) {
            console.log("statistics_zte:"+msg);
        }
    })
}
//推荐位统计
function recClick_zte(recommId,specialName){
    $.ajax({
        type:"GET",
        dataType:"json",
        url:"http://"+ ip + "/stat/music/recClick",
        data:{
            'model':'',
            'version':'',
            'release':'',
            'mac':'',
            'versionCode':'',
            'versionName':'',
            'userId':userId,
            'recommdId':recommId,
            'pageName':specialName,
        },

        success:function(msg){
            console.log(msg);
            // alert(msg.code);
        },
        error:function (msg) {
            // alert(msg.code);
        }
    })
}
//搜索、订购统计
function other_zte(pageName){
    $.ajax({
        type:"GET",
        dataType:"json",
        url:"http://"+ ip + "/stat/music/other",
        data:{
            'model':'',
            'version':'',
            'release':'',
            'mac':'',
            'versionCode':'',
            'versionName':'',
            'userId':userId,
            'pageName':pageName,
        },

        success:function(msg){
            // alert("msg.codemsg.codemsg.code"+msg.code);
            console.log(msg);

        },
        error:function (msg) {
            console.log("statistics_zte:"+msg);
        }
    })
}
