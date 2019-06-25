var ix=0;
var homepage_up=true;
var home_vip=true;
var homepage_leave=true;
var homepage_leavex=0;
var homepage_upx;
playmusic(223);
function reset_home(){
    $(".homepage1").children().eq(0).show();
    $(".homepage1").children().eq(1).hide();
    $(".homepage2").children().eq(0).show();
    $(".homepage2").children().eq(1).hide();
    $(".homepage3").children().eq(0).show();
    $(".homepage3").children().eq(1).hide();
    $(".homepage4").children().eq(0).show();
    $(".homepage4").children().eq(1).hide();

}
function reset_up(){
    $(".homepage_up1").children().eq(0).show();
    $(".homepage_up1").children().eq(1).hide();
    $(".homepage_up2").children().eq(0).show();
    $(".homepage_up2").children().eq(1).hide();
    $(".homepage_close").children().eq(0).show();
    $(".homepage_close").children().eq(1).hide();

}
processKeyEvent = function(keyCode) {
    keydw(keyCode);
};
function keydw(key_code){
    switch(key_code){
        case mkeyEvent.KEY_UP:
        if (homepage_up && home_vip && homepage_leave){
            reset_home();
            ix-=2;
            if(ix<=0){
                ix=0;
                $(".homepage1").children().eq(1).show();
                $(".homepage1").children().eq(0).hide();
            }else if (ix==1) {
                $(".homepage2").children().eq(1).show();
                $(".homepage2").children().eq(0).hide();
            }
        }else if (homepage_up==false && home_vip && homepage_leave) {
            homepage_upx=0;
            reset_up();
            $(".homepage_up1").children().eq(1).show();
            $(".homepage_up1").children().eq(0).hide();
        }else if (homepage_up && home_vip && homepage_leave==false) {
            homepage_leavex=0;
            $(".homepage_leave1").children().eq(1).show();
            $(".homepage_leave1").children().eq(0).hide();
            $(".homepage_leave2").children().eq(0).show();
            $(".homepage_leave2").children().eq(1).hide();
        }
        break;
        case mkeyEvent.KEY_LEFT:
        if (homepage_up && home_vip && homepage_leave){
            reset_home();
             ix--;
             if (ix<=0) {
                 ix=0;
                $(".homepage1").children().eq(1).show();
                $(".homepage1").children().eq(0).hide();
            }else if(ix==1){
                $(".homepage2").children().eq(1).show();
                $(".homepage2").children().eq(0).hide();
            }else if(ix==2){
                $(".homepage3").children().eq(1).show();
                $(".homepage3").children().eq(0).hide();
            }
        }else if (homepage_up==false && home_vip && homepage_leave) {
            homepage_upx--;
            reset_up();
            if(homepage_upx<=0){
                homepage_upx=0;
                $(".homepage_up1").children().eq(1).show();
                $(".homepage_up1").children().eq(0).hide();
            }else if(homepage_upx==1){
                $(".homepage_up2").children().eq(1).show();
                $(".homepage_up2").children().eq(0).hide();
            }
        }else if (homepage_up && home_vip && homepage_leave==false) {
            homepage_leavex=0;
            $(".homepage_leave1").children().eq(1).show();
            $(".homepage_leave1").children().eq(0).hide();
            $(".homepage_leave2").children().eq(0).show();
            $(".homepage_leave2").children().eq(1).hide();
        }
        break;
        case mkeyEvent.KEY_RIGHT:
        if (homepage_up && home_vip && homepage_leave){
            reset_home();
             ix++;
             if (ix==1) {
                $(".homepage2").children().eq(1).show();
                $(".homepage2").children().eq(0).hide();
             }else if(ix==2){
                $(".homepage3").children().eq(1).show();
                $(".homepage3").children().eq(0).hide();
             }else if(ix>=3){
                ix=3;
                $(".homepage4").children().eq(1).show();
                $(".homepage4").children().eq(0).hide();
             }
        }else if (homepage_up==false && home_vip) {
            homepage_upx++;
            reset_up();
            if(homepage_upx>=2){
                homepage_upx=2;
                $(".homepage_close").children().eq(1).show();
                $(".homepage_close").children().eq(0).hide();
            }else if(homepage_upx==1){
                $(".homepage_up2").children().eq(1).show();
                $(".homepage_up2").children().eq(0).hide();
            }
        }else if (homepage_up && home_vip && homepage_leave==false) {
            homepage_leavex=1;
            $(".homepage_leave2").children().eq(1).show();
            $(".homepage_leave2").children().eq(0).hide();
            $(".homepage_leave1").children().eq(0).show();
            $(".homepage_leave1").children().eq(1).hide();
        }
        break;
        case mkeyEvent.KEY_DOWN:
        if (homepage_up && home_vip && homepage_leave){
            reset_home();
            ix+=2;
            if(ix>=3){
                ix=3;
                $(".homepage4").children().eq(1).show();
                $(".homepage4").children().eq(0).hide();
            }else if (ix==2) {
                $(".homepage3").children().eq(1).show();
                $(".homepage3").children().eq(0).hide();
            }
        }else if (homepage_up==false && home_vip && homepage_leave) {
            homepage_upx=2;
            reset_up();
            $(".homepage_close").children().eq(1).show();
            $(".homepage_close").children().eq(0).hide();
        }else if (homepage_up && home_vip && homepage_leave==false) {
            homepage_leavex=1;
            $(".homepage_leave2").children().eq(1).show();
            $(".homepage_leave2").children().eq(0).hide();
            $(".homepage_leave1").children().eq(0).show();
            $(".homepage_leave1").children().eq(1).hide();
        }
        break;
        case mkeyEvent.KEY_SELECT:
        if (homepage_up && home_vip && homepage_leave){
            if(ix==0){
                 window.location.href="http://"+ip_local+"/top.html";
                 // alert(ix);
             }else if(ix==1){
                 window.location.href="http://"+ip_local+"/jf_buy.html";
             }else if(ix==2){
                 window.location.href="http://"+ip_local+"/rule.html";
                 // alert(ix);
             }else if(ix==3){
                 window.location.href="http://"+ip_local+"/answer1.html";
                 // alert(ix);
             }
        }else if (homepage_up==false && home_vip && homepage_leave) {
            if(homepage_upx==0){
                if (app1 == 9 && app2 == 0) {
                    $(".home_vip").show();
                    home_vip = false;
                } else {
                    statistics(16);
                    //欢唱订购
                    // window.location.href="http://"+ip_local+"/index1.html";
                    jump2Zte9MusicSubs();
                }
            }else if (homepage_upx==1){
                // 芒果订购;
                statistics(17);
                // window.location.href="http://"+ip_local+"/index1.html";
                window.location.href = "http://10.255.0.219/en/jump_order/index.html?product_list={'product_id':'3779','time':'30','product_type':'2','price':'1500','name':'王牌综艺','bag':'wpzy_bag'}";
            } else {
                window.location.href="http://"+ip_local+"/top.html"
            }
        }else if(homepage_up==false && home_vip==false && homepage_leave){
            $(".home_vip").hide();
            home_vip=true;
        }else if(homepage_up && home_vip && homepage_leave==false){
            if(homepage_leavex==0){
                if (app1 == 9 && app2 == 0) {
                    $(".home_vip").show();
                    home_vip = false;
                } else {
                    statistics(9);
                    //欢唱订购
                    // window.location.href="http://"+ip_local+"/index1.html";
                    jump2Zte9MusicSubs();
                }
            }else  if(homepage_leavex==1){
                if(app1==9 && app2==0){
                    statistics(15);
                    window.location.href="http://10.255.0.219/en/template6/index.html?style_id=506";
                }else{

                    var rand=Math.floor(Math.random()*10);
                    if(rand<=7){
                        statistics(14);
                        jump2Zte9Music();
                        Webview.closeBrwoser("返回");
                    }else{
                        statistics(15);
                        window.location.href="http://10.255.0.219/en/template6/index.html?style_id=506";
                    }
                }
                // Webview.closeBrwoser("返回");
            }
        }else if(homepage_up && home_vip==false && homepage_leave==false){
            $(".home_vip").hide();
            home_vip=true;
        }
        break;
        case mkeyEvent.KEY_BACK:
        if (homepage_up && home_vip && homepage_leave){
            $(".homepage_leave").show();
            homepage_leave=false;
        }else if(homepage_up==false && home_vip==false && homepage_leave){
            $(".home_vip").hide();
            home_vip=true;
        }else if(homepage_up==false && home_vip && homepage_leave){
            $(".homepage_up").hide();
            homepage_up=true;
        }else if(homepage_up && home_vip==false && homepage_leave==false){
            $(".home_vip").hide();
            home_vip=true;
        }else if(homepage_up && home_vip && homepage_leave==false){
            $(".homepage_leave").hide();
            homepage_leave=true;
        }
        break;
    };
}


// alert(userId);
    // 创建用户信息
function set(){
    var data1={
            userId:userId,
            contentcode:"5a4b88e31dcde1f1b8f100d80651db79",
            usertoken:token,
            mac:mac,
            version:appVersion,
            fromsource:"4",
    }
    $.ajax({
         type:"POST",
         contentType:'application/json',
         dataType: "json",
         url:"http://"+ip+"/singwithme/user/saveUser",
         data:JSON.stringify(data1),
         // data:{
         //  "userId":"123456",
         //  "mac":"000000",
         //  // "result":a,
         //  },
         success:function(msg){
             console.log(msg);
         },
     })
};
    set();


console.log("userId:"+userId+"appName:"+appName+"appVersion:"+appVersion+"mac:"+mac+"contentCode:"+contentCode+"token:"+token);


