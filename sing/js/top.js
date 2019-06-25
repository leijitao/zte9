console.log("userId:"+userId+"appName:"+appName+"appVersion:"+appVersion+"mac:"+mac+"contentCode:"+contentCode+"token:"+token);
statistics(2);
playmusic(223);
function reset_top(){
	$(".top_but1").children().eq(0).show();
	$(".top_but1").children().eq(1).hide();
	$(".top_but2").children().eq(0).show();
	$(".top_but2").children().eq(1).hide();
	$(".top_but3").children().eq(1).hide();
	$(".top_but3").children().eq(0).show();
	$(".top_but4").children().eq(1).hide();
	$(".top_but4").children().eq(0).show();
	$(".top_but5").children().eq(1).hide();
	$(".top_but5").children().eq(0).show();
}
var fal=true;
var fal1=true;
var top_awardx=0;
var top522=true;
var top_award_success=true;
function reset_top_award(){
	$(".top_awardi1").blur();
	$(".top_awardd").children().eq(1).hide();
	$(".top_awardd").children().eq(0).show();
}
console.log(top_awardx);

processKeyEvent = function(keyCode) {
    keytop(keyCode);
}
var t=4;
function keytop(key_code){
	switch(key_code){
		case mkeyEvent.KEY_LEFT:
		if(fal&&fal1&&top_award_success&&top_award_success){
			reset_top();
			t--;
			// console.log(t);
			if (t<=0) {
				t=0;
			$(".top_but1").children().eq(1).show();
			$(".top_but1").children().eq(0).hide();	
			}else if(t==1){
				$(".top_but2").children().eq(1).show();
				$(".top_but2").children().eq(0).hide();	
			}else if(t==2){
				$(".top_but3").children().eq(0).hide();
				$(".top_but3").children().eq(1).show();	
			}else if(t==3){
				$(".top_but5").children().eq(0).hide();
				$(".top_but5").children().eq(1).show();	
			}
		}
		break;
		case mkeyEvent.KEY_RIGHT:
		if(fal&&fal1&&top_award_success){
			reset_top();
			t++;
			// console.log(t);
			if(t==1){
				$(".top_but2").children().eq(1).show();
				$(".top_but2").children().eq(0).hide();	
			}else if(t==2){
				$(".top_but3").children().eq(0).hide();
				$(".top_but3").children().eq(1).show();		
			}else if(t==3){
				$(".top_but5").children().eq(0).hide();
				$(".top_but5").children().eq(1).show();		
			}else if(t>=4){
				t=4;
				$(".top_but4").children().eq(0).hide();
				$(".top_but4").children().eq(1).show();		
			}
		}
		break;
		case mkeyEvent.KEY_UP:
			if(fal1==false){
				reset_top_award();
				top_awardx=0;
				$(".top_awardi1").focus();

			}
		break;
		case mkeyEvent.KEY_SELECT:
		if(fal && fal1 && top_award_success){
			if(t==0){
				if(top522){
					top522=false;
					list_now();
					$(".top_list2").hide();
					$(".top_list1").show();
					setTimeout(function(){
						top522=true;
					},60000)
				}else{
					$(".top_list2").hide();
					$(".top_list1").hide();
					setTimeout(function(){
						$(".top_list1").show();
					},200)
				}
			}else if(t==1){
				list_last();
				$(".top_list1").hide();
				$(".top_list2").show();
			}else if(t==2){
				award();
				
				
			}else if(t==3){
				window.location.href="http://"+ip_local+"/lottery.html"
				// alert(1);
			}else if(t==4){
				window.location.href="http://"+ip_local+"/answer.html"
				// alert(1);
			}
		}else if(fal1==false){
			if(top_awardx==1){				
				// fal1=true;
				checkPhone();

			}
		}else if(fal==false){
			$(".top_award_no").hide();
				fal=true;
		}else if(top_award_success==false){
			$(".top_award_success").hide();
				top_award_success=true;
		}
		break;
		case mkeyEvent.KEY_DOWN:
			if(fal1==false){
				top_awardx=1;
				reset_top_award();
				if(top_awardx==1){
				$(".top_awardd").children().eq(0).hide();
				$(".top_awardd").children().eq(1).show();
				}
			}
		break;
		case mkeyEvent.KEY_DELETE:
			if(top_awardx == 0 && fal1==false) {
				
                 var num = $('.top_awardi1').val();
                        num = num.substring(0, num.length - 1);
                        $('.top_awardi1').val(num);
            }
        break;
		case mkeyEvent.KEY_BACK:
		console.log(false)
			if(top_awardx == 0 && fal1==false) {
				 var num = $('.top_awardi1').val();
                        num = num.substring(0, num.length - 1);
                        $('.top_awardi1').val(num);

            }else if(fal && fal1 && top_award_success){
				window.location.href="http://"+ip_local+"/index1.html";
            }else{
            	window.location.href="http://"+ip_local+"/top.html";
            }
		break;
		default:
                if(top_awardx == 0 && fal1==false) {
                    var num = $('.top_awardi1').val();
                    if(!isNaN(key_code)) {
                        $('.top_awardi1').val(num + "" + key_code);
                    }
                }
        break;
		
	}

}

// 本周排行
(function list_now(){
	$(".top_list1_con").html("<div><p>排名</p><p>账号</p><p>分值</p></div>");
	$.ajax({
		type:"GET",
		dataType:"json",
		contentType:'application/x-www-form-urlencoded;charset=utf-8',
		url:"http://"+ip+"/singwithme/integral/getIntegralWeekRanking",
		data:{
			userId:userId,	
		   },
		success:function(msg){
			console.log(msg);
			if(msg.code==1){
				console.log(msg);
				console.log(msg.data.integralRankingVOList.length);

				var integralRankingVOList=msg.data.integralRankingVOList;
				// alert(integralRankingVOList[0].integralRanking);
				for(var integra in integralRankingVOList){
					var lis1="<div><p>"+integralRankingVOList[integra].integralRanking+"</p><p>"+integralRankingVOList[integra].userId.toString().substr(0,5)+"*****"+integralRankingVOList[integra].userId.substr(10)+"</p><p>"+integralRankingVOList[integra].integralValue+"</p></div>";
					
					$(".top_list1_con").append(lis1);
					// alert(integralRankingVOList[integra].integralRanking);
					// alert(lis1);
				}
				var integralRanking=msg.data.integralRanking;
				var integralValue=msg.data.integralValue;
				if(integralRanking == 0){
					$(".top_list1_bottom").html("<p>我的排名: <span>"+"暂无排名"+"</span></p><p>我的分值: <span>0</span></p>");
				}else{
					$(".top_list1_bottom").html("<p>我的排名: <span>"+integralRanking+"</span></p><p>我的分值: <span>"+integralValue+"</span></p>");
				}
				
			}
		}	

	})
}());

// 上周
function list_last(){
	var time_new = Date.parse(new Date())/1000;
	var time_set = 1527263999;
	if(time_new > time_set){
		$(".top_list2_con").html("<div><p>排名</p><p>账号</p><p>分值</p><p>奖品</p></div>");
		$.ajax({
			type:"GET",
			dataType:"json",
			url:"http://"+ip+"/singwithme/integral/getIntegralLastWeekRanking",
			data:{
				"userId":userId,		
			   },
			success:function(msg){
				if (msg.code==1) {
					console.log(msg.data.integralRankingVOList.length);
					
					var integralRankingVOList=msg.data.integralRankingVOList;
					// alert(integralRankingVOList[0].integralRanking);
					for(var integra in integralRankingVOList){
						var lis2="<div><p>"+integralRankingVOList[integra].integralRanking+"</p><p>"+integralRankingVOList[integra].userId.toString().substr(0,5)+"*****"+integralRankingVOList[integra].userId.substr(10)+"</p><p>"+integralRankingVOList[integra].integralValue+"</p><p>"+integralRankingVOList[integra].prizeRanking+"</p></div>";
						
						$(".top_list2_con").append(lis2);
						// alert(integralRankingVOList[integra].integralRanking);
						// alert(lis1);
					}
					var integralRanking=msg.data.integralRanking;
					var integralValue=msg.data.integralValue;
					var prizeRanking=msg.data.prizeRanking;
					$(".top_list2_bottom").html("<p>我的排名: <span>"+integralRanking+"</span></p><p>我的分值: <span>"+integralValue+"</span></p><p>我的奖品: <span>"+prizeRanking+"</span></p>")
				}
			}

		})
	}
}

//领取奖励
function award(){
	$.ajax({
		type:"GET",
		dataType:"json",
		url:"http://"+ip+"/singwithme/integral/exchangeIntegralWeekRankAward",
		data:{
			"userId":userId,		
		   },
		success:function(msg){
			console.log(msg);
			if (msg.data.isExchange){
				var prisename=msg.data.prizeRanking.name;
				var picUrl=msg.data.prizeRanking.picUrl;
				console.log(prisename);
				$(".top_award").show();
				$(".top_awardi1").focus();
				$("#top_awardimg").attr('src',picUrl);
				// $("#top_awardp").html(prisename);
				fal1=false;

			}else{
				$(".top_award_no").show();
				fal=false;

			}
		}

	})
}
// 验证手机号
function checkPhone(){ 
    var phone1 = $('.top_awardi1').val();
    	if(!(/^1[34578]\d{9}$/.test(phone1))){ 
	        $("#top_award_p53").html("请输入正确的手机号");
	        
	    }else{
	    		$("#top_award_p53").html("");
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
							 $(".top_award").hide();
							 fal1=true;
							 $(".top_award_success").show();
							 top_award_success=false;
						}else{
							alert("领取失败，请稍后重试")
							 $(".top_award").hide();
							 fal1=true;
						}
						
						
					},
					error:function(){
						alert("领取失败，请稍后重试1")
					}											
				})

	    }
    
}
//答题次数
function play_num(){
	
	$.ajax({
		type:"GET",
		dataType:"json",
		url:"http://" + ip + "/singwithme/user/overNum",
		data:{
			"userId":userId,		
		   },
		success:function(msg){
			console.log(msg);
			var numPlay=msg.data.numPlay;
			if(numPlay<=0){
				numPlay=0;
			}
			$(".top_num").html(numPlay);
		}

	})
}
play_num();