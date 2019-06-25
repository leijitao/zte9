var lottery0=true;
var isOrder;
// 19：未订购
// 20：订购但未抽奖
// 13：已填写手机号
// 18：已抽奖未填写手机号
// userId_mg="88888";
var myreg=/^[1][3,4,5,7,8][0-9]{9}$/;

var interceptPageLottery=false;
var interceptPageJumpOrder=false;
var interceptPageRule=false;
var interceptPageSubmitPhone=false;
var interceptPageSubmitSuccess=false;
var interceptPageWinningMessage=false;
var interceptPagelotteryNum0=false;

var lottery=0;
var jumpOrder=0;
var rule=0;
var submitPhone=0;
var submitSuccess=0;
var winningMessage=2;
var lotteryNum0=0;
var phoneNum;
var ip=58+"."+20+"."+27+"."+15+":"+8080;
// var ip=175+"."+6+"."+223+"."+26+":"+8088;
var ip_local=58+"."+20+"."+27+"."+15+":"+8080;

var allWinningMessage;
var allPage;
var nowPage;

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
    		if(interceptPageLottery){
    			if(lottery==0){
    				lottery=1;
    				lotteryResetStyle(lottery);
    			}
    		}else if(interceptPageJumpOrder){
    			jumpOrder=0;
    			jumpOrderResetStyle(jumpOrder);

    		}else if(interceptPageRule){
    			
    		}else if(interceptPageSubmitPhone){
    			if(submitPhone>0){
    				submitPhone--;
    				submitPhoneResetStyle(submitPhone);
    			}
    			
    		}else if(interceptPageSubmitSuccess){
    			
    		}else if(interceptPageWinningMessage){
    			if(winningMessage==1){
    				winningMessage=0;
    				winningMessageResetStyle(winningMessage);
    			}
    			
    		}else if(interceptPagelotteryNum0){
    			
    		}
    	break;
    	case 38:
    		if(interceptPageLottery){
    			if(lottery>1){
    				lottery--;
	    			lotteryResetStyle(lottery);
    			}
    		}else if(interceptPageJumpOrder){
    			
    		}else if(interceptPageRule){
    			
    		}else if(interceptPageSubmitPhone){
    			if(submitPhone>2){
    				submitPhone-=3;
    				submitPhoneResetStyle(submitPhone);
    			}
    			
    		}else if(interceptPageSubmitSuccess){
    			
    		}else if(interceptPageWinningMessage){
    			if(winningMessage==2){
    				winningMessage=1;
    				winningMessageResetStyle(winningMessage);
    			}
    		}else if(interceptPagelotteryNum0){
    			
    		}
    	break;
    	case 39:
    		if(interceptPageLottery){
    			lottery=0;
    			lotteryResetStyle(lottery);

    		}else if(interceptPageJumpOrder){
    			jumpOrder=1;
    			jumpOrderResetStyle(jumpOrder);
    			
    		}else if(interceptPageRule){
    			
    		}else if(interceptPageSubmitPhone){
    			if(submitPhone<13){
    				submitPhone++;
    				submitPhoneResetStyle(submitPhone);
    			}
    		}else if(interceptPageSubmitSuccess){
    			
    		}else if(interceptPageWinningMessage){
    			if(winningMessage==0){
    				winningMessage=1;
    				winningMessageResetStyle(winningMessage);
    			}
    		}else if(interceptPagelotteryNum0){
    			
    		}
    	break;
    	case 40:
    		if(interceptPageLottery){
    			if(0<lottery && lottery<3){
    				lottery++;
	    			lotteryResetStyle(lottery);
    			}
    		}else if(interceptPageJumpOrder){
    			
    		}else if(interceptPageRule){
    			
    		}else if(interceptPageSubmitPhone){
    			if(submitPhone<9){
    				submitPhone+=3;
    				submitPhoneResetStyle(submitPhone);
    			}else if(submitPhone>=9 && submitPhone<=11){
    				submitPhone=12
    				submitPhoneResetStyle(submitPhone);
    			}
    		}else if(interceptPageSubmitSuccess){
    			
    		}else if(interceptPageWinningMessage){
    			if(winningMessage<2){
    				winningMessage=2;
    				winningMessageResetStyle(winningMessage);
    			}
    		}else if(interceptPagelotteryNum0){
    			
    		}
    	break;
    	case 13:
    		if(interceptPageLottery){
    			if(lottery==0){
	    			if(lottery0){
                        if(isOrder==19){
                            $(".interceptPageLottery").hide();
                            interceptPageLottery=false;
                            $(".interceptPageJumpOrder").show();
                            interceptPageJumpOrder=true;
                        }else if(isOrder==20){
                            startLottery();
                        }else if(isOrder==15){
                            $(".interceptPageLottery").hide();
                            interceptPageLottery=false;
                            $(".interceptPagelotteryNum0").show();
                            interceptPagelotteryNum0=true;
                        }else if(isOrder==18){
                            $(".interceptPageLottery").hide();
                            interceptPageLottery=false;
                            $(".interceptPageSubmitPhone").show();
                            interceptPageSubmitPhone=true;
                        }
	    			}
	    		}else if(lottery==1){
                    $(".interceptPageLottery").hide();
                    interceptPageLottery=false;
                    $(".interceptPageRule").show();
                    interceptPageRule=true;
                }else if(lottery==2){
                    $(".interceptPageLottery").hide();
                    interceptPageLottery=false;
                    $(".interceptPageWinningMessage").show();
                    interceptPageWinningMessage=true;
                    getWinningMessage();
                }else if(lottery==3){
                    var url=window.location.href.split("?url=")[0];
                    // window.location.href=url;
                    window.location.href="http://" + ip_local + "/dianjing/index.html?html="+url;
                }
    		}else if(interceptPageJumpOrder){
    			if(jumpOrder==0){
                    window.location.href="http://" + ip_local + "/dianjing/order.html";
                }else if(jumpOrder==1){
                    $(".interceptPageJumpOrder").hide();
                    interceptPageJumpOrder=false;
                    $(".interceptPageLottery").show();
                    interceptPageLottery=true;
                }
    		}else if(interceptPageRule){
    			$(".interceptPageRule").hide();
                interceptPageRule=false;
                $(".interceptPageLottery").show();
                interceptPageLottery=true;
    		}else if(interceptPageSubmitPhone){
    			if(0<=submitPhone && submitPhone<=8 ||submitPhone==10){
    				var onkeydownNum=submitPhone+1;
    				if(submitPhone==10){
    					onkeydownNum=0;
    				}
                    if($(".interceptPageSubmitPhone_num").html().length>=11){
                        phoneNum=$(".interceptPageSubmitPhone_num").html();
                    }else{
                        phoneNum=$(".interceptPageSubmitPhone_num").html()+onkeydownNum;
                    }
    				$(".interceptPageSubmitPhone_num").html(phoneNum);
    			}else if(submitPhone==9){
    				phoneNum=$(".interceptPageSubmitPhone_num").html().toString();
    				phoneNum=phoneNum.substring(0,phoneNum.length-1);
    				console.log(phoneNum);
    				$(".interceptPageSubmitPhone_num").html(phoneNum)
    			}else if(submitPhone==11){
    				$(".interceptPageSubmitPhone_num").html("");
    			}else if(submitPhone==12){
    				phoneNum=$(".interceptPageSubmitPhone_num").html().toString();
    				
    				if(!myreg.test(phoneNum)){
    					$('.submitPhoneError').show();
    				}else{
    					$('.submitPhoneError').hide();
                        submitPhone1622();
    				}
    			}else if(submitPhone==13){
    				interceptPageSubmitPhone=false;
    				interceptPageLottery=true;
    				$(".interceptPageSubmitPhone").hide();
    				$(".interceptPageLottery").show();
    			}
    			
    		}else if(interceptPageSubmitSuccess){
    			interceptPageSubmitSuccess=false;
                interceptPageLottery=true;
                $(".interceptPageSubmitSuccess").hide();
                $(".interceptPageLottery").show();
    		}else if(interceptPageWinningMessage){
    			if(winningMessage==0){
                    nowPage--;
                    if(nowPage<1){
                        nowPage=allPage;
                    }
                    allWinningAnimate();
                }else if(winningMessage==1){
                    nowPage++;
                    if(nowPage>allPage){
                        nowPage=1;
                    }
                    allWinningAnimate();
                }else if(winningMessage==2){
                    interceptPageWinningMessage=false;
                    interceptPageLottery=true;
                    $(".interceptPageWinningMessage").hide();
                    $(".interceptPageLottery").show();
                }
    		}else if(interceptPagelotteryNum0){
    			interceptPagelotteryNum0=false;
                interceptPageLottery=true;
                $(".interceptPagelotteryNum0").hide();
                $(".interceptPageLottery").show();
    		}
    	break;
    }
};

function loadPage(){
    console.log("come in activity");
    console.log("userId_mg:"+userId_mg);
    $.ajax({
        type:"GET",
        dataType:"json",
        url:"http://"+ip+"/hncj_api_v2/store/game/v3.1/user/activityRule",
        data:{},
        success:function(msg){
            console.log("backgroundImage success:"+JSON.stringify(msg))
            if(msg.code==1){
                $('.interceptPage').css("background-image","url("+msg.data.backImg+")");
                $('.interceptPageLottery').css("background-image","url("+msg.data.img+")");
                $('.interceptPageRule').css("background-image","url("+msg.data.ruleImg+")");
            }
           
        },
        error:function (msg) {
            
        }
    });
    $.ajax({
        type:"GET",
        dataType:"json",
        url:"http://"+ip+"/hncj_api_v2/store/game/v3.1/user/queryUserPrize",
        data:{
            userId:userId_mg
        },
        success:function(msg){
             console.log("isOrder success:"+JSON.stringify(msg))
            if(msg.code==18){
                isOrder=18;
                $(".interceptPageSubmitPhone").show();
                interceptPageSubmitPhone=true;
                $(".prizePic").attr("src",msg.data[0].prizeImg);
            }else if(msg.code==19){
                isOrder=19;
                $(".interceptPageLottery").show();
                interceptPageLottery=true;
            }else if(msg.code==20){
                isOrder=20;
                $(".interceptPageLottery").show();
                interceptPageLottery=true;
            }else if(msg.code==15){
                isOrder=15;
                $(".interceptPageLottery").show();
                interceptPageLottery=true;
            }
        },
        error:function(msg){
            console.log("isOrder error:"+JSON.stringify(msg))
        }
    })
}
function lotteryResetStyle(x){
	$(".interceptPageLottery").children().children(".interceptPageLottery_leftButton2").hide();
	$(".interceptPageLottery").children().eq(x).children(".interceptPageLottery_leftButton2").show();

}
function jumpOrderResetStyle(x){
	console.log(x);
	$(".interceptPageJumpOrder").children().children(".interceptPageJumpOrderImg2").hide();
	$(".interceptPageJumpOrder").children().eq(x).children(".interceptPageJumpOrderImg2").show();

}
function submitPhoneResetStyle(x){
	console.log(x);
	$('.key_focus2').hide();
	$('.key_focus').eq(x).children().eq(1).show();
}
function winningMessageResetStyle(x){
	console.log(x);
	$('.WinningMessage2').hide();
	$('.interceptPageWinningMessageButton').eq(x).children().eq(1).show();
}


// 中奖信息

function getWinningMessage(){
    $(".interceptPageWinningMessage_news").html("");
    $(".interceptPageWinningMessage_me_new div").html("");
    $.ajax({
        type:"GET",
        dataType:"json",
        url:"http://"+ip+"/hncj_api_v2/store/game/v3.1/user/selectUserPrizeRecord",
        // url:"http://192.168.0.64:8080/hncj_api_v2/store/game/v3.1/user/selectUserPrizeRecord",
        data:{
            userId:userId_mg
        },
        success:function(msg){
            console.log("getWinningMessageAll error:"+JSON.stringify(msg))
            allWinningMessage=msg.data;
            allPage=Math.ceil(allWinningMessage.length/5);
            nowPage=1;
            if(allWinningMessage.length>5){
                console.log(1);
                for(var x=0;x<5;x++){
                    console.log(11);
                    var lis2="<div><p style='width:3.66rem;float:left;height:0.5rem'>"+msg.data[x].createDateTime+"</p><p style='width:2.73rem;float:left;height:0.5rem'>"+msg.data[x].userId+"</p><p style='width:4.5rem;float:left;height:0.5rem'>"+msg.data[x].prizeName+"</p></div>";
                    
                    $(".interceptPageWinningMessage_news").append(lis2);
                    // alert(data1[integra].integralRanking);
                    // alert(lis1);
                }
            }else{
                console.log(2);
                for(var integra in msg.data){
                    console.log(22);
                    var lis2="<div><p style='width:3.66rem;float:left;height:0.5rem'>"+msg.data[integra].createDateTime+"</p><p style='width:2.73rem;float:left;height:0.5rem'>"+msg.data[integra].userId+"</p><p style='width:4.5rem;float:left;height:0.5rem'>"+msg.data[integra].prizeName+"</p></div>";
                    
                    $(".interceptPageWinningMessage_news").append(lis2);
                    // alert(data1[integra].integralRanking);
                    // alert(lis1);
                }
            }
        },
        error:function(){

        }
    })
    $.ajax({
        type:"GET",
        dataType:"json",
        url:"http://"+ip+"/hncj_api_v2/store/game/v3.1/user/selectPrizeUser",
        data:{
            userId:userId_mg
        },
        success:function(msg){
            console.log("getWinningMessageMe error:"+JSON.stringify(msg))
            if(msg.code==1){
                var myWinning="<p style='float:left;margin-right:0.3rem'>时间："+ msg.data[0].createDateTime +"</p>"+"<p style='float:left;margin-right:0.3rem'>手机号："+ msg.data[0].phoneNum +"</p>"+"<p style='float:left;margin-right:0.3rem'>奖品："+ msg.data[0].prizeName +"</p>"
                
                $(".interceptPageWinningMessage_me_new div").html(myWinning);
                myWinningAnimate(); 
            }else if(msg.code==2){
                var myWinning="<p style='float:left;margin-right:0.3rem'>您还未抽奖哦，赶快去抽奖吧~</p>"
                
                $(".interceptPageWinningMessage_me_new div").html(myWinning);
            }
            
        },
        error:function(){

        }
    })
}
function allWinningAnimate(){
    $(".interceptPageWinningMessage_news").html("");
    console.log(nowPage);
    if(nowPage<allPage){
        for(var x=5*nowPage-5;x<5*nowPage;x++){
            var lis2="<div><p style='width:3.66rem;float:left;height:0.5rem'>"+allWinningMessage[x].createDateTime+"</p><p style='width:2.73rem;float:left;height:0.5rem'>"+allWinningMessage[x].userId+"</p><p style='width:4.5rem;float:left;height:0.5rem'>"+allWinningMessage[x].prizeName+"</p></div>";
            $(".interceptPageWinningMessage_news").append(lis2);
                        // alert(data1[integra].integralRanking);
                        // alert(lis1);
        }
    }else{
       for(var x=5*nowPage-5;x<allWinningMessage.length;x++){
            var lis2="<div><p style='width:3.66rem;float:left;height:0.5rem'>"+allWinningMessage[x].createDateTime+"</p><p style='width:2.73rem;float:left;height:0.5rem'>"+allWinningMessage[x].userId+"</p><p style='width:4.5rem;float:left;height:0.5rem'>"+allWinningMessage[x].prizeName+"</p></div>";
            $(".interceptPageWinningMessage_news").append(lis2);
                        // alert(data1[integra].integralRanking);
                        // alert(lis1);
        } 
    }
}
function myWinningAnimate(){
    var size=parseFloat($("html").css("font-size").split("p")[0]);
    var wid=(parseInt($(".interceptPageWinningMessage_me_new div").children().eq(0).css("width").substr(0,3))
    +parseInt($(".interceptPageWinningMessage_me_new div").children().eq(1).css("width").substr(0,3))
    +parseInt($(".interceptPageWinningMessage_me_new div").children().eq(2).css("width").substr(0,3)))/size
    +1
    console.log(wid);
    $(".interceptPageWinningMessage_me_new div").css({"width":wid+"rem","left":"7rem"});
    setInterval(t(),12000);
    function t(){
        $(".interceptPageWinningMessage_me_new div").animate({
            "left":"-"+wid+"rem"
        },12000,"linear",function(){
            $(".interceptPageWinningMessage_me_new div").css({"left":"7rem"})
            t();
        })
    }

}

// 提交手机号
function submitPhone1622(){
    $.ajax({
        type:"GET",
        dataType:"json",
        url:"http://"+ip+"/hncj_api_v2/store/game/v3.1/user/insertPhoneNum",
        data:{
            userId:userId_mg,
            phoneNum:$(".interceptPageSubmitPhone_num").html(),
        },
        success:function(){
            interceptPageSubmitPhone=false;
            interceptPageSubmitSuccess=true;
            $(".interceptPageSubmitPhone").hide();
            $(".interceptPageSubmitSuccess").show();
        },
        error:function(){

        }
    })
}
function startLottery(){
    lottery0=false;
    $(".masking").children().hide();
    $(".masking").children().eq(0).show();
    var num;
    var prizeUrl;
    $.ajax({
        type:"GET",
        dataType:"json",
        url:"http://"+ip+"/hncj_api_v2/store/game/v3.1/user/doPrize",
        data:{
            userId:userId_mg
        },
        success:function(msg){
           console.log("lottery success:"+JSON.stringify(msg));
           if(msg.code==1){
            num=msg.data.prizeInfo.id;
            prizeUrl=msg.data.prizeInfo.prizeImg;
            console.log("activity num:"+num);
            lotteryAnimate(num,prizeUrl);
           }
        },
        error:function(msg){
            console.log("lottery error:"+JSON.stringify(msg))
        }
    })
    // var num=1;
    
    
    
}
function lotteryAnimate(num,prizeUrl){
	var rdm=Math.floor(Math.random()*10);
	if(rdm<=3){
		rdm=rdm+3;
	}else if(rdm>=7){
		rdm=rdm-3;
	}
	var rotate=rdm-1;
	var x=0,y=0,z=0;
	console.log("activity rdm:"+rdm);
	var quickInterval=setInterval(function(){
		x++;
		// if(x>9){
		// 	x=0
		// }
		$(".masking").children().hide();
		$(".masking").children().eq(x%10-1).show();
	},60)
	setTimeout(function(){
		clearInterval(quickInterval);
		var slowInterval=setInterval(function(){
			y++;
			$(".masking").children().hide();
			$(".masking").children().eq(y-1).show();
			if(y>9){
				$(".masking").children().hide();
				$(".masking").children().eq(0).show();
				clearInterval(slowInterval);
			}
		},80);
	},rotate*10*60);
	setTimeout(function(){
		var slow=setInterval(function(){
			z++;
			console.log("z:"+z);
			$(".masking").children().hide();
			$(".masking").children().eq(z-1).show();
			if(z==num){
				clearInterval(slow);
                setTimeout(function(){
                    $(".interceptPageLottery").hide();
                    interceptPageLottery=false;
                    $(".interceptPageSubmitPhone").show();
                    interceptPageSubmitPhone=true;
                    $(".prizePic").attr("src",prizeUrl);
                },1000)
			}
		},110);
	},rotate*10*60+800);
}

    setupWebViewJavascriptBridge(function (bridge) {
        bridge.registerHandler('keyEventHandler', function (data, responseCallback) {
            console.log("keyEventHandler :"+data);
            if(data==4){
               if(interceptPageLottery){
                    var url=window.location.href.split("?url=")[1];
                    window.location.href=url+"?html="+ window.location.href.split("?url=")[0];
                    // window.location.href="http://" + ip_local + "/dianjing/index.html";
                }else{
                    $(".interceptPageJumpOrder").hide();
                    interceptPageJumpOrder=false;
                    $(".interceptPageRule").hide();
                    interceptPageRule=false;
                    $(".interceptPageSubmitPhone").hide();
                    interceptPageSubmitPhone=false;
                    $(".interceptPageSubmitSuccess").hide();
                    interceptPageSubmitSuccess=false;
                    $(".interceptPageWinningMessage").hide();
                    interceptPageWinningMessage=false;
                    $(".interceptPagelotteryNum0").hide();
                    interceptPagelotteryNum0=false;

                    $(".interceptPageLottery").show();
                    interceptPageLottery=true;
                }
            }else if(data==7||data==8||data==9||data==10||data==11||data==12||data==13||data==14||data==15||data==16){
                if(interceptPageSubmitPhone){
                    if($(".interceptPageSubmitPhone_num").html().length>=11){
                        phoneNum=$(".interceptPageSubmitPhone_num").html()
                    }else{
                        phoneNum=$(".interceptPageSubmitPhone_num").html()+(data-7);
                    }
                    $(".interceptPageSubmitPhone_num").html(phoneNum);
                }
            }else if(data==67){
                phoneNum=$(".interceptPageSubmitPhone_num").html().toString();
                phoneNum=phoneNum.substring(0,phoneNum.length-1);
                console.log(phoneNum);
                $(".interceptPageSubmitPhone_num").html(phoneNum)
            }

        })

    })