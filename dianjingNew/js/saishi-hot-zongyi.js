var fir=true,sec=false,con=false;
var sec_x=0,con_x=0;
var title_second_len;
var category_list=[];
var nav2TypeCod;
var playVideo000;
// var ip=58+"."+20+"."+27+"."+16+":"+8080+"/hnmgGaming_api";
// var ip=58+"."+20+"."+27+"."+15+":"+8080+"/hnmgGaming_api";
var nav2;
// var ip_local=58+"."+20+"."+27+"."+16+":"+8080;
// var ip_local=58+"."+20+"."+27+"."+15+":"+8080;
// var ip_local=192+"."+168+"."+43+"."+11+":"+8080;
console.log(con_x);
// console.log($(".content_con").children().length-1);

//一级导航样式重置
function reset_fir(num){
    $('.title_first').children().hide();
    $('.title_first').children().eq(0).show();
    $('.title_first').children().eq(num+1).show();
}
//二级导航样式重置
function reset_sec(num){
    $(".title_second_con img").hide();
    $(".title_second_con ").children().css({backgroundImage:"none"})
    $(".title_second_con ").children().eq(num).children().eq(1).show();
}
//内容部分样式重置
function reset_con(num){
    $(".content_img3").hide();
    $('.content_con').children().eq(num).children(".content_img3").show();
}


var timeOut=true;
var time;
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
            if(fir==true){
                fir_x--;
                if(fir_x<=0){
                    fir_x=0;
                }
                reset_fir(fir_x);
            }else if(sec==true){
                if(sec_x % 8 ==0 && Math.floor(sec_x/8)!=0){
                    $(".title_second_con").animate({
                        left:-(Math.floor(sec_x/8)-1)* 11.92+"rem"
                    },500)
                }

                sec_x--;
                if(sec_x<=0){
                    sec_x=0
                }
                category_zte(nav2TypeCod[sec_x].typeCode,nav2TypeCod[sec_x].typeName);
                reset_sec(sec_x);
                $(".content_con").html("");
                // $("#loading").show();
                getNav2Video(sec_x,port);

                // if(timeOut==true){
                //     getNav2Video(sec_x,port);
                //     timeOut=false;
                // }else {
                //     clearTimeout(time);
                //     time=setTimeout(function () {
                //         timeOut=true;
                //     },500);
                // }
                // if(timeOut==true){
                //     getNav2Video(sec_x,port);
                //     timeOut=false;
                // }

            }else if(con==true){
                if(con_x==0){
                    // con=false;
                    // sec=true;
                    // $(".content_img3").hide();
                    // $(".title_second_con img").hide();
                    // $(".title_second_con ").children().eq(sec_x).children().eq(1).show();
                }
                con_x--;
                if(con_x<=0){
                   con_x=0;

                }
                if((con_x+1)%10==0){
                    $(".content_con").animate({top:Math.floor(con_x/10)*4.74 +"rem"},300)
                }
                reset_con(con_x);
                $(".content_img2").hide();
                $(".content_con").children().eq(con_x).children(".content_img2").show();
            }


            console.log("fir_x" + fir_x);
            console.log("sec_x" + sec_x);
            console.log("con_x" + con_x);
        break;
        case 38:
            if(sec==true){
                fir=true;
                sec=false;
                reset_fir(fir_x);
                $(".title_second_con img").hide();
                $(".title_second_con ").children().css({backgroundImage:"none"});
                $(".title_second_con ").children().eq(sec_x).css({backgroundImage:"url(images/new/second_nav2.png)"})
            }else if(con==true){
                if(con_x!=0){
                    con_x-=5;
                    if(con_x<=0){
                        con_x=0;

                    }
                    if(5<= (con_x)%10 <=9){
                        $(".content_con").animate({top:-Math.floor(con_x/10)*4.74 +"rem"},300)
                    }
                    reset_con(con_x);
                    $(".content_img2").hide();
                    $(".content_con").children().eq(con_x).children(".content_img2").show();
                }else {
                    con=false;
                    sec=true;
                    category_zte(nav2TypeCod[sec_x].typeCode,nav2TypeCod[sec_x].typeName);
                    $(".content_img3").hide();
                    $(".title_second_con img").hide();
                    $(".title_second_con ").children().eq(sec_x).children().eq(1).show();
                    $(".content_img2").hide();
                }

            }


            console.log("fir_x" + fir_x);
            console.log("sec_x" + sec_x);
            console.log("con_x" + con_x);
        break;
        case 39:
            if(fir==true){
                fir_x++;
                if(fir_x>=5){
                    fir_x=5;
                }
                reset_fir(fir_x);
            }else if(sec==true){
                sec_x++;
                if(sec_x>=title_second_len-1){
                    sec_x=title_second_len-1
                }
                if(Math.floor(sec_x/8)>0 && sec_x % 8==0){
                    $(".title_second_con").animate({
                        left:-Math.floor(sec_x/8) * 11.92 +"rem"
                    },500)
                }
                category_zte(nav2TypeCod[sec_x].typeCode,nav2TypeCod[sec_x].typeName);
                // alert(category_list);
                reset_sec(sec_x);
                $(".content_con").html("");
                // $("#loading").show();
                getNav2Video(sec_x,port);

                // time=setTimeout(function () {
                //     timeOut=true;
                //     // getNav2Video(sec_x,port);
                // },500);
                // if(timeOut==true){
                //     getNav2Video(sec_x,port);
                //     timeOut=false;
                // }else {
                //     clearTimeout(time);
                //     time=setTimeout(function () {
                //         timeOut=true;
                //     },500);
                // }
                // if(timeOut==true){
                //     getNav2Video(sec_x,port);
                //     timeOut=false;
                // }

            }else if(con==true){
                if(con_x==$(".content_con").children().length-1){

                }
                con_x++;
                if(con_x>= $(".content_con").children().length-1){
                    con_x=$(".content_con").children().length-1;

                }
                if((con_x)%10==0 && con_x<$(".content_con").children().length){
                    $(".content_con").animate({top:-Math.floor(con_x/10)*4.74 +"rem"},300)
                }
                reset_con(con_x);
                $(".content_img2").hide();
                $(".content_con").children().eq(con_x).children(".content_img2").show();

            }



            console.log("fir_x" + fir_x);
            console.log("sec_x" + sec_x);
            console.log("con_x" + con_x);
        break;
        case 40:
            if(fir==true){
                fir=false;
                sec=true;
                $('.title_first').children().hide();
                $('.title_first').children().eq(0).show();
                reset_sec(sec_x);
                category_zte(nav2TypeCod[sec_x].typeCode,nav2TypeCod[sec_x].typeName);
            }else if(sec==true){
                if($(".content_con").children().length>0) {
                    sec = false;
                    con = true;
                    con_x = 0;
                    reset_con(con_x);
                    $(".title_second_con img").hide();
                    $(".title_second_con ").children().css({backgroundImage: "none"});
                    $(".title_second_con ").children().eq(sec_x).css({backgroundImage: "url(images/new/second_nav2.png)"});
                    $(".content_img2").hide();
                    $(".content_con").children().eq(con_x).children(".content_img2").show();
                }
            }else if(con==true){
                if(con_x<$(".content_con").children().length-1){
                    con_x+=5;
                    if(con_x>=$(".content_con").children().length-1){
                        con_x=$(".content_con").children().length-1;

                    }
                    if(0<= (con_x)%10 <=4){
                        $(".content_con").animate({top:-Math.floor(con_x/10) * 4.74 +"rem"},300)
                    }
                    reset_con(con_x);
                    $(".content_img2").hide();
                    $(".content_con").children().eq(con_x).children(".content_img2").show();
                }else {
                    // alert("我也是有底线的")
                 }
            }

            console.log("fir_x" + fir_x);
            console.log("sec_x" + sec_x);
            console.log("con_x" + con_x);
        break;
        case 13:
            if(fir==true){
                if(click_goback==false){
                    click_goback=true;
                }
                if(fir_x==0){
                    window.location.href="http://" + ip_local + "/dianjing/index.html?html="+ html;
                }else if(fir_x==1){
                    window.location.href="http://" + ip_local + "/dianjing/saishi.html?html="+ html;
                }else if(fir_x==2){
                    window.location.href="http://" + ip_local + "/dianjing/hotgame.html?html="+ html;
                }else if(fir_x==3){
                    window.location.href="http://" + ip_local + "/dianjing/zhubo.html?html="+ html;
                }else if(fir_x==4){
                    window.location.href="http://" + ip_local + "/dianjing/zongyi.html?html="+ html;
                }
                // else if(fir_x==5){
                //     window.location.href="http://" + ip_local + "/dianjing/search.html?html="+ html;
                // }
                else if(fir_x==5){
                    window.location.href="http://" + ip_local + "/dianjing/order.html?html="+ html;
                }
            }else if(sec==true){

            }else if(con==true){
                if(playVideo000[con_x].activityType==6){
                    recClick_zte(playVideo000[con_x].id,playVideo000[con_x].specialName);
                    // alert(playVideo000[con_x].id);
                    function newURl() {
                        bridge.callHandler('newURlBridgeHandler', "http://"+ ip_local +"/dianjing/ztlist.html?recomId=" + playVideo000[con_x].id, function (response) {
                            console.log("newURlBridgeHandler:" + response);
                        })
                    }
                    newURl();
                    // J("ztlist.html?recomId=" + playVideo000[con_x].id);
                    // window.location.href="http://"+ ip_local + "/dianjing/ztlist.html?recomId="+playVideo000[con_x].id
                }else if(playVideo000[con_x].activityType==4){
                    playVideo(JSON.stringify(playVideo000[con_x]));
                }else if(playVideo000[con_x].activityType==2){
                    installPackageAndLaunch(playVideo000[con_x].packageNames,playVideo000[con_x].classNames);
                }else if(playVideo000[con_x].activityType==3){

                }else if(playVideo000[con_x].activityType==5){

                }
            }
        break;
    }

};
//获取二级导航
(function fun() {
  $.ajax({
      type:"GET",
      dataType:"json",
      url:"http://"+ip+"/musicCategory/getCategory",
      data:{
          typeCode:typeCode,
      },
      success:function(msg){
          console.log(msg);
          nav2=msg.data.musicCategory;
          store.set("nav_type",nav2);
          title_second_len = (msg.data.musicCategory.length);
          $(".title_second_con").width(1.53 * title_second_len + "rem");
          $(".title_second_con").html("");
          for(var integra in nav2){
              var lis="<div><p>" + nav2[integra].typeName +'</p><img src="images/new/second_nav1.png" alt=""></div>'
              $(".title_second_con").append(lis);
          }
          nav2TypeCod=store.get("nav_type");
          getNav2Video(0,port);
          $(".title_second_con ").children().eq(0).css({backgroundImage:"url(images/new/second_nav2.png)"})
          //tuijianwei

          // alert(category_list);

      },
      error:function (msg) {
          console.log("firstNav:"+msg);
      }
  })
}())

//获取推荐位及二级导航相关视频；
function getNav2Video(i,port) {
    console.log(1);
    var nav2TypeCode=nav2TypeCod[i].typeCode;
    console.log(nav2TypeCode);
    $.ajax({
        type:"GET",
        dataType:"json",
        url:"http://"+ip +port,
        data:{
            typeCode:nav2TypeCode,
        },
        success:function(msg){
            console.log(msg);
            // $("#loading").hide();
            var tuijian=msg.data.musicRecommed;
            store.set("play",tuijian);
            playVideo000=store.get("play");

            for(var integra in tuijian){

                var lis_all='<div><img src='+ tuijian[integra].picUrl +' alt="" class="content_img1"><p>'+ tuijian[integra].specialName +'</p><img src="images/new/play.png" style="display: none" alt="" class="content_img2"><img src="images/new/select.png" alt="" class="content_img3"></div>'
                $(".content_con").append(lis_all);
            }



        },
        error:function (msg) {
            console.log("contentNav:"+msg);
        }
    })
}


//判断返回处理;

setupWebViewJavascriptBridge(function (bridge) {
    bridge.registerHandler('keyEventHandler', function (data, responseCallback) {
        console.log("keyEventHandler :"+data);
        if(data==4){
            if(con==true){
                con_x=0;
                con=false;
                sec=true;
                $(".content_img3").hide();
                $(".content_con").animate({top:"0"},300);
                $(".title_second_con img").hide();
                $(".title_second_con ").children().eq(sec_x).children().eq(1).show();
            }else if(fir==true || sec==true){
                var x=window.location.href;
                var y=x.split("html=");

                if(click_goback==false || x.indexOf("html=")==-1){
                    window.location.href="http://" + ip_local + "/dianjing/index.html?html="+x;
                }else if(click_goback==true && x.indexOf("html=")!=-1){
                    window.location.href="http://" + ip_local + "/dianjing/"+y[1];
                }
            }
            // responseCallback("true");
        }
        // else {
        //     responseCallback("false");
        // }

    })

})