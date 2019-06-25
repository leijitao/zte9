var lottery_t1=true,lottery_t2=true,lottery_t3=true,lottery_t4=true
var lottery_t512=true,lottery_t513=true,lottery_t514=true;
var num=0;
var but=true;
var lottery_t4x=0;
var lottery_resetx=0;
var lottery_reset=true;
statistics(6);
playmusic(223);
function reset_lottery(){
	$(".lottery_star").children().eq(0).show();
	$(".lottery_star").children().eq(1).hide();
	$(".lottery_but1").children().eq(0).show();
	$(".lottery_but1").children().eq(1).hide();
	$(".lottery_but2").children().eq(1).hide();
	$(".lottery_but2").children().eq(0).show();
	$(".lottery_but3").children().eq(1).hide();
	$(".lottery_but3").children().eq(0).show();
}
processKeyEvent = function(keyCode) {
    keylottery(keyCode);
};
var x=0;
	function keylottery(key_code){
		switch(key_code){
			case mkeyEvent.KEY_LEFT:
			if(lottery_reset&&lottery_t1&&lottery_t2&&lottery_t3&&lottery_t4&&lottery_t512&&lottery_t513&&lottery_t514){
				reset_lottery();
				x=0;
				$(".lottery_star").children().eq(1).show();
				$(".lottery_star").children().eq(0).hide();
				console.log(x);
			}else if(lottery_t1==false){

			}else if(lottery_t2==false){

			}else if(lottery_t3==false){

			}else if(lottery_t4==false){

			}
			break;
			case mkeyEvent.KEY_RIGHT:
			if(lottery_reset&&lottery_t1&&lottery_t2&&lottery_t3&&lottery_t4&&lottery_t512&&lottery_t513&&lottery_t514){
				reset_lottery();
				x=1;
				$(".lottery_but1").children().eq(1).show();
				$(".lottery_but1").children().eq(0).hide();
				console.log(x);
			}else if(lottery_t1==false){

			}else if(lottery_t2==false){

			}else if(lottery_t3==false){

			}else if(lottery_t4==false){

			}
			break;
			case mkeyEvent.KEY_UP:
			if(lottery_reset&&lottery_t1&&lottery_t2&&lottery_t3&&lottery_t4&&lottery_t512&&lottery_t513&&lottery_t514){
				reset_lottery();
				x--;
				if(x<=0){
					reset_lottery();
					x=0;
					$(".lottery_star").children().eq(1).show();
					$(".lottery_star").children().eq(0).hide();
				}else if(x==1){
					$(".lottery_but1").children().eq(1).show();
					$(".lottery_but1").children().eq(0).hide();
				}else if(x==2){
					reset_lottery();
 					$(".lottery_but2").children().eq(1).show();
					$(".lottery_but2").children().eq(0).hide();
				}
			}else if(lottery_t1==false){

			}else if(lottery_t2==false){

			}else if(lottery_t3==false){

			}else if(lottery_t4==false){
				lottery_t4x=0;
				lottery_t4_reset();
				$(".lottery_ti1").focus();
			}else if(lottery_reset==false){
				lottery_resetx=0;
				$(".lottery_reset input").focus();
				$(".lottery_reset_d").children().eq(0).show();
				$(".lottery_reset_d").children().eq(1).hide();
				
			}
			break;
			case mkeyEvent.KEY_DOWN:
			if(lottery_reset&&lottery_t1&&lottery_t2&&lottery_t3&&lottery_t4&&lottery_t512&&lottery_t513&&lottery_t514){
				reset_lottery();
				x++;
				if(x==1){
					$(".lottery_but1").children().eq(1).show();
					$(".lottery_but1").children().eq(0).hide();
				}else if(x==2){
 					$(".lottery_but2").children().eq(1).show();
					$(".lottery_but2").children().eq(0).hide();
				}else if(x>=3){
					x=3;
 					$(".lottery_but3").children().eq(1).show();
					$(".lottery_but3").children().eq(0).hide();
				}
			}else if(lottery_t1==false){

			}else if(lottery_t2==false){

			}else if(lottery_t3==false){

			}else if(lottery_t4==false){
				lottery_t4x=1;
				lottery_t4_reset();
				$(".lottery_t4d").children().eq(0).hide();
				$(".lottery_t4d").children().eq(1).show();
			}else if(lottery_reset==false){
				lottery_resetx=1;
				$(".lottery_reset input").blur();
				$(".lottery_reset_d").children().eq(1).show();
				$(".lottery_reset_d").children().eq(0).hide();
				
			}
			break;
			case mkeyEvent.KEY_SELECT:
			if(lottery_reset&&lottery_t1&&lottery_t2&&lottery_t3&&lottery_t4&&lottery_t512&&lottery_t513&&lottery_t514){
				if(x==0){
					if(but){
						lottery();
						getUserPageList();
						but=false;
						setTimeout(function(){
							but=true;
						},5000)
					}
				}else if(x==2){
					window.location.href="http://"+ip_local+"/record.html"
				}else if(x==3){
					window.location.href="http://"+ip_local+"/index1.html";
				}else if(x==1){
					$(".lottery_reset").show();
					get_phone();
					lottery_reset=false;
					lottery_resetx=0;
					$(".lottery_reset input").focus();
					$(".lottery_reset_d").children().eq(0).show();
					$(".lottery_reset_d").children().eq(1).hide();
				}
			}else if(lottery_t1==false){
				$(".lottery_t1").hide();
				console.log(num);
				lottery_t1=true;
			}else if(lottery_t2==false){
				$(".lottery_t2").hide();
				lottery_t2=true;
			}else if(lottery_t3==false){
				$(".lottery_t3").hide();
				lottery_t3=true;
			}else if(lottery_t512==false){
				$(".lottery_t512").hide();
				lottery_t512=true;
			}else if(lottery_t513==false){
				$(".lottery_t513").hide();
				lottery_t513=true;
			}else if(lottery_t514==false){
				$(".lottery_t514").hide();
				lottery_t514=true;
			}else if(lottery_t4==false){
				if(lottery_t4x==1){
					checkPhone();
				}
			}else if(lottery_reset==false){
				if(lottery_resetx==1){
					phone_reset();
				}
			}
			break;
			case mkeyEvent.KEY_DELETE:
				if(lottery_t4 == false && lottery_t4x==0){
					var num = $('.lottery_ti1').val();
                    num = num.substring(0, num.length - 1);
                        $('.lottery_ti1').val(num);
				}else if(lottery_reset == false && lottery_resetx==0){
					var num = $('.lottery_reset input').val();
                    num = num.substring(0, num.length - 1);
                        $('.lottery_reset input').val(num);
				}
			break;
			case mkeyEvent.KEY_BACK:
				if(lottery_reset&&lottery_t1&&lottery_t2&&lottery_t3&&lottery_t4){
					window.location.href="http://"+ip_local+"/top.html";
				}else if(lottery_t4 == false && lottery_t4x==0){
					var num = $('.lottery_ti1').val();
                    num = num.substring(0, num.length - 1);
                        $('.lottery_ti1').val(num);
				}else if(lottery_reset == false && lottery_resetx==0){
					var num = $('.lottery_reset input').val();
                    num = num.substring(0, num.length - 1);
                        $('.lottery_reset input').val(num);
				}else{
					window.location.href="http://"+ip_local+"/lottery.html";
				}
			break;
			default:
                if(lottery_t4x == 0 && lottery_t4==false) {
                    var num = $('.lottery_ti1').val();
                    if(!isNaN(key_code)) {
                        $('.lottery_ti1').val(num + "" + key_code);
                    }
                }else if(lottery_resetx == 0 && lottery_reset==false) {
                    var num = $('.lottery_reset input').val();
                    if(!isNaN(key_code)) {
                        $('.lottery_reset input').val(num + "" + key_code);
                    }
                }
            break;
		}

	}

function lottery_t4_reset(){
	$(".lottery_t4d").children().eq(1).hide();
	$(".lottery_t4d").children().eq(0).show();
	$(".lottery_ti1").blur();

}
// 抽奖次数
function lottery(){
	$.ajax({
		url:"http://"+ip+"/singwithme/lottery/getUserActivityCount",
		data:{"userId":userId,
				},
		dataType:'json',  
		type:"GET",
		success:function(msg){
			if(msg.code==1){
				
				if(msg.data==null){
					num==0;
				}else{
					num=msg.data;
				}
				$(".lottery_num").html(num);
				console.log(msg);
			}
			
		},
		error:function(){
			// debugger;
			 console.log(321);
		},
		
	})
};

lottery();
// 抽奖结果
var getUserPageList = function() {
	console.log(num);
	result();
	if(num==0){
		$(".lottery_t1").show();
		console.log(num);
		lottery_t1=false;
	}else{
			$.ajax({
				type : "GET",
				dataType : "json",
				contentType:'application/json;charset=utf-8',
				url : "http://"+ip+"/singwithme/lottery/doPrize",
				data : {
					"userId":userId,
				},
				success : function(msg) {
					console.log(msg);
					var n2;
					// ur
					if(msg.code!=1){
						n2 = 4;
					}else if(msg.code==1){
						n2=msg.data.prizeId-1;
					}
					console.log(n2);
					var n1 = Math.floor(Math.random()*20+1);//圈数
					if(n1<=10){
						n1=10
					}
					var n = 360*n1 + 45*n2 + 22.5;
					$('.lottery_star').css({
				        "transition": "all 4s ease",  
				        "transform": "rotate("+n+"deg)",  
				        "-webkit-transform": "rotate("+n+"deg)"  
				    });
				    lottery();
				    setTimeout(function(){
				    	if(n2==4){
				    		$(".lottery_t2").show();
							lottery_t2=false;
				    	}else if(n2==5){
				    		$(".lottery_t3").show();
							lottery_t3=false;
				    	}else if(n2==3){
				    		$(".lottery_t512").show();
							lottery_t512=false;
				    	}else if(n2==7){
				    		$(".lottery_t513").show();
							lottery_t513=false;
				    	}else{
				    		$(".lottery_t4").show();
							lottery_t4=false;
							$(".lottery_ti1").focus();
							if(n2==0){
								$(".jf_buy_t4i511").attr('src',"images/prize/lott/1.png");
							}else if(n2==1){
								$(".jf_buy_t4i511").attr('src',"images/prize/lott/2.png");
							 
				    		}else if(n2==2){
				    			$(".jf_buy_t4i511").attr('src',"images/prize/lott/3.png");
							 
				    		}else if(n2==6){
				    			$(".jf_buy_t4i511").attr('src',"images/prize/lott/7.png");

				    		}
						}
				    },4000)

				},
				error : function(){
					console.log(2222222)
				}
			});
		}
	}


function result(){
    $('.lottery_star').css({  
        "transition":"none",  
        "transform":"none",  
        "-webkit-transform":"none"
    });
}
// 验证手机号
function checkPhone(){ 
    var phone1 = $('.lottery_ti1').val();
	if(!(/^1[34578]\d{9}$/.test(phone1))){ 
	    $(".lottery_p55").html("请输入正确的手机号");
	        
	}else{
	        	$.ajax({
					type:"POST",
					dataType:"json",
					contentType:'application/x-www-form-urlencoded;charset=utf-8',
					url:"http://"+ip+"/singwithme/user/savePhoneNumber",
					data:{
						"userId":userId,
						"phone":phone1,
						"id":-1
								},
					success:function(msg){
						if(msg.code==1){
							 $(".lottery_t4").hide();
							 lottery_t4=true;
							 $(".lottery_t514").show();
							 lottery_t514=false;
						}else{
							alert("领取失败，请稍后重试1");
						}
						
						
						},
					error:function(msg){
						console.log("mag:"+msg);
						alert("领取失败，请稍后重试1")
						$(".lottery_t4").hide();
						lottery_t4=true;
					}											
				})
	    }

    
}
//修改手机号
function phone_reset(){
	 var phone = $('.lottery_reset input').val();
	if(!(/^1[34578]\d{9}$/.test(phone))){ 
	    $(".lottery_reset_txt").html("请输入正确的手机号");
	        
	}else{
		$.ajax({
			type:"GET",
			dataType:"json",
			url:"http://"+ip+"/singwithme/user/updatePhone",
			data:{
				"userId":userId,
				"phone":phone
						},
			success:function(){
				window.location.href="http://"+ip_local+"/lottery.html"
			}											
		})
	}
}
//获取手机号
function get_phone(){
	
		$.ajax({
			type:"GET",
			dataType:"json",
			url:"http://"+ip+"/singwithme/user/overPhone",
			data:{
				"userId":userId,
						},
			success:function(msg){
				var pho=msg.data.phone;
				$(".lottery_reset_old").html(pho);
			}											
		})
	
}