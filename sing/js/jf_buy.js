var jf_buy_t4=true,jf_buy_t5=true,jf_buy_t6=true,jf_buy_t7=true,jf_buy_t8=true;
var y=0,z=0;
var x=1;
var phone,phone1,phone2;
statistics(5);
playmusic(223);

	function keybuy(key_code){
		console.log("singwithme keycode " + key_code);
		console.log("singwithme keycode y" + y);
		console.log("singwithme keycode x" + x);
		console.log("singwithme keycode jf_buy_t4" + jf_buy_t4);
		switch(key_code){
			case mkeyEvent.KEY_LEFT:
			if(jf_buy_t4 &&jf_buy_t5 && jf_buy_t6 && jf_buy_t7 && jf_buy_t8){
				x--;
				if (x<=0) {
					x=0;
					$(".jf_buy_bg_d").hide();
					$(".jf_buy_bg_d2").children().eq(0).hide();
					$(".jf_buy_bg_d2").children().eq(1).show();
				}else if(0<x<=12){
					$(".jf_buy_bg_d2").children().eq(1).hide();
					$(".jf_buy_bg_d2").children().eq(0).show();
					$(".jf_buy_bg_d").hide();
					$(".jf_buy_bg_d").eq(x-1).show();
				}
				console.log(x);
			}else if(jf_buy_t4==false && jf_buy_t5){
				y--;
				if(y<=0){
					y=0;
					$(".jf_buy_ti1").focus();
					$(".jf_buy_t4d").children().eq(1).hide();
					$(".jf_buy_t4d").children().eq(0).show();
					$(".jf_buy_t4d2").children().eq(1).hide();
					$(".jf_buy_t4d2").children().eq(0).show();
				}else if(y==1){
					$(".jf_buy_ti1").blur();
					$(".jf_buy_t4d2").children().eq(0).hide();
					$(".jf_buy_t4d2").children().eq(1).show();
					$(".jf_buy_t4d").children().eq(1).hide();
					$(".jf_buy_t4d").children().eq(0).show();
				}
			}else if(jf_buy_t5==false && jf_buy_t4){
				z=0;
				$(".jf_buy_t52").children().eq(1).hide();
				$(".jf_buy_t52").children().eq(0).show();
				$(".jf_buy_t51").children().eq(0).hide();
				$(".jf_buy_t51").children().eq(1).show();
			}

			break;
			case mkeyEvent.KEY_RIGHT:
			if(jf_buy_t4 &&jf_buy_t5 &&jf_buy_t6 &&jf_buy_t7 &&jf_buy_t8){
				x++;
				if (x>=12) {
					x=12;
				}	
				$(".jf_buy_bg_d2").children().eq(1).hide();
				$(".jf_buy_bg_d2").children().eq(0).show();
				$(".jf_buy_bg_d").hide();
				$(".jf_buy_bg_d").eq(x-1).show();
				console.log(x);
			}else if(jf_buy_t4==false && jf_buy_t5){
				y++;
				if(y==1){
					$(".jf_buy_ti1").blur();
					$(".jf_buy_t4d2").children().eq(0).hide();
					$(".jf_buy_t4d2").children().eq(1).show();
					$(".jf_buy_t4d").children().eq(1).hide();
					$(".jf_buy_t4d").children().eq(0).show();
				}else if(y>1){
					y=2;
					$(".jf_buy_ti1").blur();
					$(".jf_buy_t4d").children().eq(0).hide();
					$(".jf_buy_t4d").children().eq(1).show();
					$(".jf_buy_t4d2").children().eq(1).hide();
					$(".jf_buy_t4d2").children().eq(0).show();
				}
			}else if(jf_buy_t5==false && jf_buy_t4){
				z=1;
				$(".jf_buy_t51").children().eq(1).hide();
				$(".jf_buy_t51").children().eq(0).show();
				$(".jf_buy_t52").children().eq(0).hide();
				$(".jf_buy_t52").children().eq(1).show();
			}
			break;
			case mkeyEvent.KEY_UP:
			if(jf_buy_t4 &&jf_buy_t5 &&jf_buy_t6 &&jf_buy_t7 &&jf_buy_t8){
				if(x<7){
					x=0;
					console.log(x);
					$(".jf_buy_bg_d2").children().eq(0).hide();
					$(".jf_buy_bg_d2").children().eq(1).show();
					$(".jf_buy_bg_d").hide();
				}else if(6<x<=12){
					console.log(x);	
					x=x-6;	
					console.log(x);	
					$(".jf_buy_bg_d2").children().eq(1).hide();
					$(".jf_buy_bg_d2").children().eq(0).show();
					$(".jf_buy_bg_d").hide();
					$(".jf_buy_bg_d").eq(x-1).show();
				}
					console.log(x);
			}else if(jf_buy_t4==false && jf_buy_t5){
				y--;
				if(y<=0){
					y=0;
					$(".jf_buy_ti1").focus();
					$(".jf_buy_t4d").children().eq(1).hide();
					$(".jf_buy_t4d").children().eq(0).show();
					$(".jf_buy_t4d2").children().eq(1).hide();
					$(".jf_buy_t4d2").children().eq(0).show();
				}else if(y==1){
					$(".jf_buy_ti1").blur();
					$(".jf_buy_t4d").children().eq(1).hide();
					$(".jf_buy_t4d").children().eq(0).show();
					$(".jf_buy_t4d2").children().eq(0).hide();
					$(".jf_buy_t4d2").children().eq(1).show();
				}
			}else if(jf_buy_t5==false && jf_buy_t4){
				z=0;
				$(".jf_buy_t52").children().eq(1).hide();
				$(".jf_buy_t52").children().eq(0).show();
				$(".jf_buy_t51").children().eq(0).hide();
				$(".jf_buy_t51").children().eq(1).show();
			}3

			break;
			case mkeyEvent.KEY_DOWN:
			if(jf_buy_t4 &&jf_buy_t5 &&jf_buy_t6 &&jf_buy_t7 &&jf_buy_t8){
				if(x>6){
					$(".jf_buy_bg_d").hide();
					$(".jf_buy_bg_d").eq(x-1).show();
					$(".jf_buy_bg_d2").children().eq(1).hide();
					$(".jf_buy_bg_d2").children().eq(0).show();
				}else if(0<x<7){
					console.log(x);
					x = x + 6;
					console.log(x);
					$(".jf_buy_bg_d").hide();
					$(".jf_buy_bg_d").eq(x-1).show();
					$(".jf_buy_bg_d2").children().eq(1).hide();
					$(".jf_buy_bg_d2").children().eq(0).show();
				}else if(x=0){
					x=1;
					console.log(x);		
					$(".jf_buy_bg_d2").children().eq(1).hide();
					$(".jf_buy_bg_d2").children().eq(0).show();
					$(".jf_buy_bg_d").hide();
					$(".jf_buy_bg_d").eq(x-1).show();
				}
				// console.log(x);
				
			}else if(jf_buy_t4==false && jf_buy_t5){
				y++;
				if(y==1){
					$(".jf_buy_ti1").blur();
					$(".jf_buy_t4d").children().eq(1).hide();
					$(".jf_buy_t4d").children().eq(0).show();
					$(".jf_buy_t4d2").children().eq(0).hide();
					$(".jf_buy_t4d2").children().eq(1).show();
				}else if(y>1){
					y=2;
					$(".jf_buy_ti1").blur();
					$(".jf_buy_t4d2").children().eq(1).hide();
					$(".jf_buy_t4d2").children().eq(0).show();
					$(".jf_buy_t4d").children().eq(0).hide();
					$(".jf_buy_t4d").children().eq(1).show();
				}
			}else if(jf_buy_t5==false && jf_buy_t4){
				z=1;
				$(".jf_buy_t51").children().eq(1).hide();
				$(".jf_buy_t51").children().eq(0).show();
				$(".jf_buy_t52").children().eq(0).hide();
				$(".jf_buy_t52").children().eq(1).show();
			}

			break;
			case mkeyEvent.KEY_DELETE: 
                    if(y == 0 && jf_buy_t4==false) {
                        var num = $('.jf_buy_ti1').val();
                        num = num.substring(0, num.length - 1);
                        $('.jf_buy_ti1').val(num);
                    }
            break;
			case mkeyEvent.KEY_SELECT:
				// console.log(x);
				if(jf_buy_t4 &&jf_buy_t5 &&jf_buy_t6 &&jf_buy_t7 &&jf_buy_t8){
					if(x==0){
						window.location.href="http://"+ip_local+"/index1.html"
					}else if(0<x<=12){
						console.log(x);
						jf_buy();
										}
				}else if(jf_buy_t4==false){
					if(y==1){
						checkPhone();		
					}else if(y==2){
						y=0;
						$(".jf_buy_ti1").val("");
						$(".jf_buy_ti1").focus();
						$(".jf_buy_t4d").children().eq(1).hide();
						$(".jf_buy_t4d").children().eq(0).show();
						$(".jf_buy_t4d2").children().eq(1).hide();
						$(".jf_buy_t42").children().eq(0).show();
						
					}
				}else if(jf_buy_t5==false){
					$.ajax({
					type:"POST",
					contentType:'application/x-www-form-urlencoded;charset=utf-8',
					url:"http://"+ip+"/singwithme/user/savePhoneNumber",
					data:{
						"userId":userId,
						"phone":123456,
						"id":x
								},
					success:function(msg){
						jf_ajax();
						console.log("singwithme_msg:"+msg)
						if(msg.code==1){	
							$(".jf_buy_t5").hide();
							jf_buy_t5=true;
						}else{
							$(".jf_buy_t5").hide();
							jf_buy_t5=true;
							$(".jf_buy_t8").show();
							jf_buy_t8=false;
						}	
					},
					error:function(){
						console.log("singwithme_msg_error:"+msg)
						jf_ajax();
						$(".jf_buy_t5").hide();
						jf_buy_t5=true;
						$(".jf_buy_t8").show();
						jf_buy_t8=false;
					}											
					})
						
						if(z==1){
							window.location.href="http://"+ip_local+"/lottery.html"
						}
				}else if(jf_buy_t6==false){
					$(".jf_buy_t6").hide();
					jf_buy_t6=true;
					jf_ajax();
				}else if(jf_buy_t7==false){
					$(".jf_buy_t7").hide();
					jf_buy_t7=true;
					jf_ajax();
				}else if(jf_buy_t8==false){
					$(".jf_buy_t8").hide();
					jf_buy_t8=true;
					jf_ajax();
				}
			break;
			case mkeyEvent.KEY_BACK:
				if(jf_buy_t4 && jf_buy_t5 && jf_buy_t6 && jf_buy_t7 && jf_buy_t8){
					window.location.href="http://"+ip_local+"/top.html"
				}else if(y == 0 && jf_buy_t4==false) {
                        var num = $('.jf_buy_ti1').val();
                        num = num.substring(0, num.length - 1);
                        $('.jf_buy_ti1').val(num);
                }else{
					reset_all();
				}
			break;
			default:
                    if(y == 0 && jf_buy_t4==false) {
                        var num = $('.jf_buy_ti1').val();
                        if(!isNaN(key_code)) {
                            $('.jf_buy_ti1').val(num + "" + key_code);
                        }
                    }
            break;
		}

	}



processKeyEvent = function(keyCode) {
    console.log("singwithme processKeyEvent keycode " + keyCode);
    try{
        keybuy(keyCode);
    } catch (e) {
        console.log("singwithme processKeyEvent error " + e);
    }
}

handler = function (action, keyCode, keyName, metaState) {
    console.log("singwithme keycode " + keyCode);
    console.log("singwithme keyName" + keyName);
    processKeyEvent(keyName);
    return true;
}

try {
    Webview.requestFocus();
    Webview.setKeyEventHandler(handler);
    console.log("singwithme setKeyEventHandler ok");
} catch (e) {
    console.log("singwithme webview.setKeyEventHandler error");
    document.onkeydown = function (event)
    {
        mkeyEvent.KEY_UP = 38;
        mkeyEvent.KEY_DOWN = 40;
        mkeyEvent.KEY_LEFT = 37;
        mkeyEvent.KEY_RIGHT = 39;
        mkeyEvent.KEY_SELECT = 13;
        mkeyEvent.KEY_PAGEUP = 33;
        mkeyEvent.KEY_PAGEDOWN = 34;
        var e = event || window.event || arguments.callee.caller.arguments[0];
        if (e)
        {
            processKeyEvent(e.keyCode);

        }

    };
}

Webview.setInputTypeTextFlag("true");



function reset_all(){
	$(".jf_buy_t4").hide();
	$(".jf_buy_t5").hide();
	$(".jf_buy_t6").hide();
	$(".jf_buy_t7").hide();
	$(".jf_buy_t8").hide();
	jf_buy_t4=true;
	jf_buy_t5=true;
	jf_buy_t6=true;
	jf_buy_t7=true;
	jf_buy_t8=true;
}

function jf_buy_t4_reset(){
	$(".jf_buy_ti1").focus();
	$(".jf_buy_t4d").children().eq(0).show();
	$(".jf_buy_t4d").children().eq(1).hide();
	$(".jf_buy_t4d2").children().eq(0).show();
	$(".jf_buy_t4d2").children().eq(1).hide();
}
function jf_buy_t5_reset(){
	$(".jf_buy_t51").children().eq(1).show();
	$(".jf_buy_t51").children().eq(0).hide();
	$(".jf_buy_t52").children().eq(0).show();
	$(".jf_buy_t52").children().eq(1).hide();
}
// 验证手机号

function checkPhone(){ 
	console.log(x);
    phone1 = $('#phone1').val();
    	if(!(/^1[34578]\d{9}$/.test(phone1))){ 
	        $("#jf_buy_red").html("请输入正确的手机号");
	    }else{
	        	$.ajax({
					type:"POST",
					contentType:'application/x-www-form-urlencoded;charset=utf-8',
					url:"http://"+ip+"/singwithme/user/savePhoneNumber",
					data:{
						"userId":userId,
						"phone":phone1,
						"id":x,
								},
					success:function(msg){
						console.log(msg);
						if(msg.code==1){
							 $(".jf_buy_t4").hide();
							 jf_buy_t4=true;
							 $(".jf_buy_t7").show();
							jf_buy_t7=false;

						}else{
							 $(".jf_buy_t4").hide();
							 jf_buy_t4=true;
							$(".jf_buy_t8").show();
							jf_buy_t8=false;
						}
						
						
						},
					error:function(){
						$(".jf_buy_t8").show();
						jf_buy_t8=false;
					}											
				})
				// $.post("http://192.168.0.117:8080/singwithme_api/user/savePhoneNumber",{userId:userId,"phone":phone1,"id":x},
				// 	function(){

				// 	}
				// 	)
	    }
    
}



// 兑换
function jf_buy(){
	console.log(x);
	$.ajax({
		type:"GET",
		dataType:"json",
		url:"http://"+ip+"/singwithme/integralRecord/selIntegraltotal",
		data:{
			"userId":userId,
			"id":x,
					},
		success:function(msg){
			console.log(msg);
			if(msg.success){	
				if(x!=11){
					jf_buy_t4_reset();					
					$(".jf_buy_t4").show();
					// Webview.setInputTypeTextFlag("true");
					$(".jf_buy_ti1").focus();
					y=0;
					var picUrl=msg.data.list[x-1].picUrl;
					var name=msg.data.list[x-1].name;
					$(".jf_buy_t4_p53").html(name);
					console.log(name);
					// alert(picUrl);
					$(".jf_buy_t4i511").attr("src",picUrl);
					jf_buy_t4=false;
				}else{
					
					$(".jf_buy_t5").show();
					// Webview.setInputTypeTextFlag("true");
					z=0;
					$(".jf_buy_t52").children().eq(1).hide();
					$(".jf_buy_t52").children().eq(0).show();
					$(".jf_buy_t51").children().eq(0).hide();
					$(".jf_buy_t51").children().eq(1).show();
					jf_buy_t5=false;
				}					
			}else{
				$(".jf_buy_t6").show();
				jf_buy_t6=false;
			}					
		}

	})
}
// 获取积分
function jf_ajax(){
	$.ajax({
		type:"GET",
		dataType:"json",
		url:"http://"+ip+"/singwithme/integralRecord/selIntegraltotals",
		data:{
			"userId":userId,
				 },
		success:function(msg){
			var num=msg.data.integralTotal;
			$(".jf_buy_bg_d1").html(num);				
								
		}
	})
}
jf_ajax();


