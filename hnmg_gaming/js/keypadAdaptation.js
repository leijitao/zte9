/*
适配按键
1 芒果专属适配方案
2 正常适配方案
*/
keypadAdaptation(0);
function keypadAdaptation(from) {
    console.log(from);
    if(from == "1"){
        /*芒果适配*/
        processKeyEvent = function (keyCode) {
            keyIndex(keyCode);
        };
        function keyIndex(key_code) {
            switch (key_code) {
                case mkeyEvent.KEY_LEFT:
                    if (typeof (keyLeft)!="undefined"){
                        keyLeft();
                    }else {
                        console.log("keyIndex keyLeft is undefined mangguo")
                    }
                    break;
                case mkeyEvent.KEY_UP:
                    if (typeof (keyUp)!="undefined"){
                        keyUp();
                    }else {
                        console.log("keyIndex keyUp is undefined mangguo")
                    }
                    break;
                case mkeyEvent.KEY_RIGHT:
                    if (typeof (keyRight)!="undefined"){
                        keyRight();
                    }else {
                        console.log("keyIndex keyRight is undefined mangguo")
                    }
                    break;
                case mkeyEvent.KEY_DOWN:
                    if (typeof (keyDown)!="undefined"){
                        keyDown();
                    }else {
                        console.log("keyIndex keyDown is undefined mangguo")
                    }
                    break;
                case mkeyEvent.KEY_SELECT:
                    if (typeof (keySelect)!="undefined"){
                        keySelect();
                    }else {
                        console.log("keyIndex keySelect is undefined mangguo")
                    }
                    break;
                case mkeyEvent.KEY_BACK:
                    if (typeof (keyBack)!="undefined"){
                        keyBack();
                    }else {
                        console.log("keyIndex keyBack is undefined mangguo")
                    }
                    break;
                case mkeyEvent.KEY_DELETE:
                    if (typeof (keyDelete)!="undefined"){
                        keyDelete();
                    }else {
                        console.log("keyIndex keyDelete is undefined mangguo")
                    }
                    break;
                default://数字键
                    if (typeof (keyNum_mg)!="undefined"){
                        keyNum_mg();
                    }else {
                        console.log("keyIndex keyNum is undefined mangguo")
                    }
                    break;
            }
        }
    }else {
        /*通用适配*/
        document.onkeydown=function(e) {
            e = window.event || e;
            switch (e.keyCode) {
                case 37:
                    if (typeof (keyLeft)!="undefined"){
                        keyLeft();
                    }else {
                        console.log("keyIndex keyLeft is undefined all")
                    }
                    break;
                case 38:
                    if (typeof (keyUp)!="undefined"){
                        keyUp();
                    }else {
                        console.log("keyIndex keyUp is undefined all")
                    }
                    break;
                case 39:
                    if (typeof (keyRight)!="undefined"){
                        keyRight();
                    }else {
                        console.log("keyIndex keyRight is undefined all")
                    }
                    break;
                case 40:
                    if (typeof (keyDown)!="undefined"){
                        keyDown();
                    }else {
                        console.log("keyIndex keyDown is undefined all")
                    }
                    break;
                case 13:
                    if (typeof (keySelect)!="undefined"){
                        keySelect();
                    }else {
                        console.log("keyIndex keySelect is undefined all")
                    }
                    break;
            }
        };
        try{
            setupWebViewJavascriptBridge(function (bridge) {
                bridge.registerHandler('keyEventHandler', function (data, responseCallback) {
                    console.log("keyEventHandler :" + data);
                    if (data == 4) {
                        /*返回*/
                        if (typeof (keyBack)!="undefined"){
                            keyBack();
                        }else {
                            console.log("keyIndex keyBack is undefined all")
                        }
                    }else if(data==7||data==8||data==9||data==10||data==11||data==12||data==13||data==14||data==15||data==16){
                        /*数字键  data-7 等于实际的keyName  即data的7-16等于数字键0-9*/
                        if (typeof (keyNum_hc)!="undefined"){
                            keyNum_hc();
                        }else {
                            console.log("keyIndex keyNum is undefined all")
                        }
                    }else if(data==67){
                        /*删除键*/
                        if (typeof (keyDelete)!="undefined"){
                            keyDelete();
                        }else {
                            console.log("keyIndex keyDelete is undefined all")
                        }
                    }
                })
            })
        }
        catch (e) {
            console.log("key back selete num is undefined:"+ e);
        }

    }
}
