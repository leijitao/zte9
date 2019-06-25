function setBg() {
    var timeStamp=new Date().getTime();
    if(1546099201000<timeStamp && timeStamp<1546790399000){
        $(".setBg").css({backgroundImage:"url('images/ztNew/order_newYear.jpg')"});
    }
}
setBg();
function resetPaymentSureFrame1() {
    $(".paymentSureFrame1").children().eq(0).hide();
    $(".paymentSureFrame1").children().eq(2).hide();
    $(".paymentSureFrame1").children().eq(3).hide();
    $(".paymentSureFrame1").children().eq(4).hide();
    if(x=0){
        $(".paymentSureFrame1").children().eq(x).show();
    }else {
        $(".paymentSureFrame1").children().eq(x+1).show();
    }
}
function resetPaymentSureFrame2(x) {
    $(".paymentSureFrame2").children().eq(0).hide();
    $(".paymentSureFrame2").children().eq(1).hide();
    $(".paymentSureFrame2").children().eq(x).show();
}
var x=0;
var orderFrame=0;
var orderFrameIndex_o=0;
var orderFrameIndex_t=0;
document.onkeydown=function(e){
    e=window.event||e;
    /**
     * 37 左键盘
     * 38 上键盘
     * 39 右键盘
     * 40 下键盘
     * 13 回车键
     */
    switch(e.keyCode){
        case 37:
            if(orderFrame==0){

            }else if(orderFrame==1){
                if(orderFrameIndex_o==1 || orderFrameIndex_o==3){
                    orderFrameIndex_o--;
                    resetPaymentSureFrame1(orderFrameIndex_o);
                }
            }else if(orderFrame==2){
                orderFrameIndex_t=0;
                resetPaymentSureFrame2(orderFrameIndex_t);
            }
            break;
        case 38:
            if(orderFrame==0){

            }else if(orderFrame==1){
                if(orderFrameIndex_o==2||orderFrameIndex_o==3){
                    orderFrameIndex_o-=2;
                    resetPaymentSureFrame1(orderFrameIndex_o);
                }
            }else if(orderFrame==2){

            }
            break;
        case 39:
            if(orderFrame==0){

            }else if(orderFrame==1){
                if(orderFrameIndex_o==0 || orderFrameIndex_o==2){
                    orderFrameIndex_o++;
                    resetPaymentSureFrame1(orderFrameIndex_o);
                }
            }else if(orderFrame==2){
                orderFrameIndex_t=1;
                resetPaymentSureFrame2(orderFrameIndex_t);
            }
            break;
        case 40:
            if(orderFrame==0){

            }else if(orderFrame==1){
                if(orderFrameIndex_o==0||orderFrameIndex_o==1){
                    orderFrameIndex_o+=2;
                    resetPaymentSureFrame1(orderFrameIndex_o);
                }
            }else if(orderFrame==2){

            }
            break;
        case 13:
            if(orderFrame==0){
                authenticationGetUrl(function () {
                    $(".paymentSureFrame1").show();
                    orderFrameIndex_o=0;
                    orderFrame=1;
                    resetPaymentSureFrame1(orderFrameIndex_o);
                })
            }else if(orderFrame==1){
                if(orderFrameIndex_o==2){
                    orderFrameIndex_o=0;
                    resetPaymentSureFrame1(orderFrameIndex_o);
                    $(".paymentSureFrame1_d").html("")
                }else if(orderFrameIndex_o==3){
                    submitPhoneToOrder();
                }else if(orderFrameIndex_o==3){
                    $(".paymentSureFrame1").hide();
                    orderFrame=0;
                }
            }else if(orderFrame==2){
                if(orderFrameIndex_t==0){
                    authenticationGetUrl(OrderResult())
                }else if(orderFrameIndex_t==1){

                }

            }
            break;
    }
}
/*提交手机号*/
function submitPhoneToOrder() {
    var myreg=/^[1][3,4,5,7,8][0-9]{9}$/;
    var phone=$(".paymentSureFrame1_d").html();
    if(!(myreg.test(phone))){
        $(".paymentSureFrame1_phoneError").show();
    }else {
        $(".paymentSureFrame1_phoneError").hide();
        order(phone,function () {
            $(".paymentSureFrame1").hide();
            $(".paymentSureFrame2").show();
            orderFrame = 2;
            resetPaymentSureFrame2(0);
        })
    }
}
/*二次鉴权的结果展示*/
function OrderResult(txt){
    $('.orderPrompt').css({display:"block"});
    $('.orderPromptText').html("订购失败，请稍后再试");
    setTimeout(function(){
        $('.orderPrompt').css({display:"none"});
        var url=window.location.href;
        window.location.href=url;
    },3000);
}
stopPlayVideoHandler();
setTimeout(function () {
    other_zte("订购页")
},1000);
//活动跳转地址
var isJumpActivity=0;

//返回首页处理
setupWebViewJavascriptBridge(function (bridge) {
    bridge.registerHandler('keyEventHandler', function (data, responseCallback) {
        console.log("keyEventHandler :"+data);
        if(data==4){
            // goback();
            if($('.orderPrompt').css("display")=="none") {
                statisticsOrder();
                var x = window.location.href;
                var y = x.split("html=");

                if ( x.indexOf("html=") == -1) {
                    window.location.href = "http://" + ip_local + "/dianjing/index.html?html=order.html";
                } else if (x.indexOf("html=") != -1) {
                    window.location.href = "http://" + ip_local + "/dianjing/" + y[1];
                }
                responseCallback("true");
            }else {
                $('.orderPrompt').css({display:"none"});
            }
        }


    })

})
//    自动跳转到活动页
function backActivityPage() {
    var url=window.location.href;
    console.log(url);
    if(url.indexOf("jumpUrl=") != -1){
        if(isJumpActivity.indexOf("&") == -1)
            isJumpActivity=url.split("jumpUrl=")[1];
        window.location.href=isJumpActivity;
    }

}

function keyEventBack(data) {
    bridge.callHandler('keyHandlerIdBridgeHandler', data, function (response) {
        console.log("keyHandlerIdBridgeHandler:" + response);
    })
};

