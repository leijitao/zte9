var index;
var orderId;
var selectIndex;
var sucHtml;
var faildHtml;
var xuniHtml;
var tempIndex1 = 0;
var isOpenOne = true;
var isOpenTwo = false;
var isOpenThr = false;
var userId = android.getUserId();
//var userId = 1;
var prprizeId;
var cishu ;
var consignerAds;
var phone;
var gvc= android.getVersionCode();
$(function(){
	//userId=android.getUserId;
	//alert(userId);
	document.getElementById("userSpan").innerText = userId;
	
	//$("#subBtn").css("background","url(./images/mdpi/btn_yellow_focus.png) center no-repeat");
	$("#close_no_btn").css("background","url(./images/mdpi/btn_yellow_focus.png) center no-repeat");
	sucHtml = $("#tan_div").html();
	faildHtml = $("#tan_div_no_zhong").html();
	xuniHtml = $("#tan_div_xuni_zhong").html();
	selectIndex = 0;
	$(".egg").eq(0).css("background","url(./images/mdpi/btn_egg_focus.png) center bottom no-repeat")
	.css("background-size","contain")
	.css("margin-left","0.52rem")
	.find(".hand").show();
	$("#tan_div").empty();
	$("#tan_div_no_zhong").empty();
	$("#tan_div_xuni_zhong").empty();
	$(".egg").mouseover(function(){
		selectIndex = $(this).attr("data");
		$(".hand").hide();
		$(this).find(".hand").show();
	});
	$("#ruleDiv").mouseover(function(){
		selectIndex = $(this).attr("data");
		$(this).css("background","url(./images/mdpi/btn_yellow_focus.png) center no-repeat");
	});
	$("#priseA").mouseover(function(){
		selectIndex = $(this).attr("data");
		$(this).css("background","url(./images/mdpi/btn_yellow_focus.png) center no-repeat");
	});
	$("#quitA").mouseover(function(){
		selectIndex = $(this).attr("data");
		$(this).css("background","url(./images/mdpi/btn_bule_focus.png) center no-repeat");
	});

	
	$.ajax({
		url:"http://10.255.25.151:8080/hncj_api_v3/store/game/v3.1/user/getUserActivityCount",
		dataType:'jsonp', 
		jsonp:'jsonpCallback', 
		type:"GET",
		data:{
					"userIDType":"0",
					"userId":userId,
				},
		success:function(data){
			 cishu = data;
			document.getElementById("cishuspan").innerText = cishu;
		}
	});
		
});

function postCishu(){
	$.ajax({
		url:"http://10.255.25.151:8080/hncj_api_v3/store/game/v3.1/user/getUserActivityCount",
		dataType:'jsonp', 
		jsonp:'jsonpCallback', 
		type:"GET",
		data:{
					"userIDType":"0",
					"userId":userId,
				},
		success:function(data){
			 cishu = data;
			document.getElementById("cishuspan").innerText = cishu;
		}
	});
	
}
function initTapEle(){
	$(".egg").css("background","url(./images/mdpi/btn_egg_normal.png) center bottom no-repeat")
				.css("background-size","contain")
				.css("margin-left","0.52rem");
	$("#ruleDiv").css("background","url(./images/mdpi/btn_yellow_normal.png) center no-repeat").css("background-size","3.068rem 1.339rem");
	$("#priseA").css("background","url(./images/mdpi/btn_yellow_normal.png) center no-repeat").css("background-size","3.068rem 1.339rem");
	$("#quitA").css("background","url(./images/mdpi/btn_bule_normal.png) center no-repeat").css("background-size","3.068rem 1.339rem");
	$("#musicA").css("background","url(./images/mdpi/btn_bule_normal.png) center no-repeat").css("background-size","3.068rem 1.339rem");
}
function initSubOrClose(){
	$("#phone").focus();
	//$("#subBtn").css("background","url(./images/mdpi/btn_yellow_focus.png) center no-repeat");
	$("#subBtn").css("background","url(./images/mdpi/btn_yellow_normal.png) center no-repeat");
	$("#closeBtn").css("background","url(./images/mdpi/btn_yellow_normal.png) center no-repeat");
}
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
	if(selectIndex != 7){
		if(isOpenOne){
			initTapEle();
			$(".hand").hide();
			selectIndex = parseInt(selectIndex) - 1;
			if(selectIndex <= 0){
				selectIndex = 0;
				$(".egg").eq(0).css("background","url(./images/mdpi/btn_egg_focus.png) center bottom no-repeat")
				.css("background-size","contain")
				.css("margin-left","0.52rem")
				.find(".hand").show();
			}else if(selectIndex == 1){
				$(".egg").eq(1).css("background","url(./images/mdpi/btn_egg_focus.png) center bottom no-repeat")
				.css("background-size","contain")
				.css("margin-left","0.52rem")
				.find(".hand").show();
			}else if(selectIndex == 2){
				$(".egg").eq(2).css("background","url(./images/mdpi/btn_egg_focus.png) center bottom no-repeat")
				.css("background-size","contain")
				.css("margin-left","0.52rem")
				.find(".hand").show();
			}else if(selectIndex == 3){
				$("#ruleDiv").css("background","url(./images/mdpi/btn_yellow_focus.png) center no-repeat").css("background-size","3.068rem 1.339rem");
			}else if(selectIndex == 4){
				$("#musicA").css("background","url(./images/mdpi/btn_bule_focus.png) center no-repeat").css("background-size","3.068rem 1.339rem");
			}
			else if(selectIndex == 5){
				$("#priseA").css("background","url(./images/mdpi/btn_yellow_focus.png) center no-repeat").css("background-size","3.068rem 1.339rem");

			}else if(selectIndex == 6){
				$("#quitA").css("background","url(./images/mdpi/btn_bule_focus.png) center no-repeat").css("background-size","3.068rem 1.339rem");

			}
		}
	}
　　　　
	
　　　　break;
　　　　case 38: //向上键
		if(selectIndex != 7){
			if(isOpenTwo){
				initSubOrClose();
				tempIndex1 = tempIndex1 - 1;
				if(tempIndex1 <= 0){
					tempIndex1 = 0;
					$("#phone").focus();
					$("#consignerAds").blur();
					document.getElementById("phone").disabled=false;
					document.getElementById("consignerAds").disabled=true;
				}else if(tempIndex1 == 1){
					$("#consignerAds").focus();
					$("#phone").blur();
					document.getElementById("phone").disabled=true;
					document.getElementById("consignerAds").disabled=false;
				}else if(tempIndex1 == 2){
					$("#phone").blur();
					$("#consignerAds").blur();
					document.getElementById("phone").disabled=true;
					document.getElementById("consignerAds").disabled=true;
					$("#subBtn")
					.css("background","url(./images/mdpi/btn_yellow_focus.png) center no-repeat");
					$("#closeBtn")
					.css("background","url(./images/mdpi/btn_yellow_normal.png) center no-repeat");
				}

			}else if(isOpenOne){
				initTapEle();
				$(".hand").hide();
				selectIndex=0;
				if(selectIndex == 4 || 5 || 6){	
					$(".egg").eq(0).css("background","url(./images/mdpi/btn_egg_focus.png) center bottom no-repeat")
						.css("background-size","contain")
						.css("margin-left","0.52rem")
						.find(".hand").show();
				}
			}
		}
　　　　break;
　　　　case 39: //右键
	if(selectIndex != 7){
		if(isOpenOne){
			initTapEle();
			$(".hand").hide();
			selectIndex = parseInt(selectIndex) + 1;
			if(selectIndex == 1){
				$(".egg").eq(1).css("background","url(./images/mdpi/btn_egg_focus.png) center bottom no-repeat")
				.css("background-size","contain")
				.css("margin-left","0.52rem")
				.find(".hand").show();
			}else if(selectIndex == 2){
				$(".egg").eq(2).css("background","url(./images/mdpi/btn_egg_focus.png) center bottom no-repeat")
				.css("background-size","contain")
				.css("margin-left","0.52rem")
				.find(".hand").show();
			}else if(selectIndex == 3){
				$("#ruleDiv").css("background","url(./images/mdpi/btn_yellow_focus.png) center no-repeat").css("background-size","3.068rem 1.339rem");
			}else if(selectIndex == 4){
				$("#musicA").css("background","url(./images/mdpi/btn_bule_focus.png) center no-repeat").css("background-size","3.068rem 1.339rem");
			}
			else if(selectIndex == 5){
				$("#priseA").css("background","url(./images/mdpi/btn_yellow_focus.png) center no-repeat").css("background-size","3.068rem 1.339rem");

			}else if(selectIndex >= 6){
				selectIndex = 6;
				$("#quitA").css("background","url(./images/mdpi/btn_bule_focus.png) center no-repeat").css("background-size","3.068rem 1.339rem");
			}
		}
	}
　　　　break;
　　　　case 40: //向下键
	if(selectIndex != 7){
		if(isOpenTwo){
			initSubOrClose();
			tempIndex1 = tempIndex1 + 1;
			if(tempIndex1 == 1){
				if($("#phone").val()!=null){
					 phone =  $("#phone").val();
				}
				if($("#consignerAds").val()!=null){
					 consignerAds= $("#consignerAds").val();
				}
				$("#consignerAds").focus();
				$("#phone").blur();
				document.getElementById("phone").disabled=true;
				document.getElementById("consignerAds").disabled=false;
			}else if(tempIndex1 == 2){
				if($("#phone").val()!=null){
					 phone =  $("#phone").val();
				}
				if($("#consignerAds").val()!=null){
					 consignerAds= $("#consignerAds").val();
				}
				$("#phone").blur();
				$("#consignerAds").blur();
				document.getElementById("phone").disabled=true;
				document.getElementById("consignerAds").disabled=true;
				$("#closeBtn")
				.css("background","url(./images/mdpi/btn_yellow_normal.png) center no-repeat");
				$("#subBtn")
				.css("background","url(./images/mdpi/btn_yellow_focus.png) center no-repeat");
			}else if(tempIndex1 >= 3){
				if($("#phone").val()!=null){
					 phone =  $("#phone").val();
				}
				if($("#consignerAds").val()!=null){
					 consignerAds= $("#consignerAds").val();
				}
				tempIndex1 = 3;
				$("#phone").blur();
				$("#consignerAds").blur();
				document.getElementById("phone").disabled=true;
				document.getElementById("consignerAds").disabled=true;
				$("#closeBtn")
				.css("background","url(./images/mdpi/btn_yellow_focus.png) center no-repeat");
				$("#subBtn")
				.css("background","url(./images/mdpi/btn_yellow_normal.png) center no-repeat");
			}
		}else if(isOpenOne){
			initTapEle();
			$(".hand").hide();
			selectIndex=4;
			if(selectIndex == 0 || 1 || 2 || 3){	
				$("#musicA").css("background","url(./images/mdpi/btn_bule_focus.png) center no-repeat").css("background-size","3.068rem 1.339rem");
			}
		}
	}
　　　　break;
　　　　case 13: //回车键
　　　　if(isOpenOne){
			if(selectIndex >= 0 &&  selectIndex <= 2){
				likeClick();

			}else if(selectIndex == 3){
				toHrefRule();
			}else if(selectIndex == 4){	
				if(gvc > 18){
					android.goToActivity("com.zte9.music.activity.SearchActivity");
				}else{
					$(".alert_box_t412").css("display","block");
					selectIndex = 8;
				}
			}else if(selectIndex == 5){
				toHrefZhongjiangList();
			}else if(selectIndex == 6){
				closeWinForQuit();
			}else if(selectIndex == 7){
				$(".alert_box412").css("display","none");
				selectIndex = 0;
				initTapEle();
				$(".hand").hide();
				$(".egg").eq(0).css("background","url(./images/mdpi/btn_egg_focus.png) center bottom no-repeat")
				.css("background-size","contain")
				.css("margin-left","0.52rem")
				.find(".hand").show();
			}else if(selectIndex == 8){
				$(".alert_box_t412").css("display","none");
				selectIndex = 0;
				initTapEle();
				$(".hand").hide();
				$(".egg").eq(0).css("background","url(./images/mdpi/btn_egg_focus.png) center bottom no-repeat")
				.css("background-size","contain")
				.css("margin-left","0.52rem")
				.find(".hand").show();
			}
			
		}
	
	
		if(isOpenTwo){
			if(tempIndex1 == 2){
				toSubForm();
			}else if(tempIndex1 == 3){
				var msg = "您真的确定要取消吗？\n\n请确认！";
				if (confirm(msg)==true){
					toGiveCloseWin();
				}
			}
		}
		
		if(isOpenThr){
			$("#close_no_btn").css("background","url(./images/mdpi/btn_yellow_focus.png) center no-repeat");
			toCloseWin();
		}
　　　　default:
　　　　break;
　　}
}



function toHrefRule(){
	window.location.href="http://10.255.25.151:8080/niudan/xiangxi.html";
}
function toHrefZhongjiangList(){
	window.location.href="http://10.255.25.151:8080/niudan/zhongjiangjilu.html";
}
function closeWinForQuit(){
	android.exit();
}
function likeClick(){
	if(cishu==0){
		selectIndex = 7;
		$(".alert_box412").css("display","block");
		return false;
	}else{
	
	$(".hand").hide();
	$(".egg").eq(selectIndex).find(".hand").show();
	$.ajax({
		url:"http://10.255.25.151:8080/hncj_api_v3/store/game/v3.1/user/doPrize",
		data:{
				"userId":userId,
				},
		dataType:'jsonp', 
		jsonp:'jsonpCallback',
		type:"GET",
		success:function(data){
			var prizeInfo = data.prizeInfo;
			orderId = data.orderId;
			prizeId= prizeInfo.id;
			if(prizeInfo.prizeType==1){
			//if(true){
				isOpenOne = false;
				isOpenThr = false;
				isOpenTwo = true;				
				index = layer.open({
				  type: 5, 
				  title:false,
				  area: ['6.00rem', '5.40rem'],
				  resize:false,
				  skin: 'layui-layer-nobg',
				  closeBtn: 0,
				  content: sucHtml
				});
				initSubOrClose();
			}else{
				
				var contentstr;
					if(prizeInfo.prizeType==0){
					  	
					  	
						contentstr= xuniHtml;

					  }else{
					  	contentstr= faildHtml;
					  }
				
				$("#close_no_btn").css("background","url(./images/mdpi/btn_yellow_focus.png) center no-repeat");
				isOpenOne = false;
				isOpenTwo = false;
				isOpenThr = true;
				
				index = layer.open({
				  type: 5, 
				  title:false,
				  area: ['6.00rem', '5.40rem'],
				  resize:false,
				  skin: 'layui-layer-nobg',
				  closeBtn: 0,
				  content: contentstr
				});
			}
			var prizeName=prizeInfo.prizeName;
			$(".aa_name_417").html("恭喜您砸中了"+prizeName);
			return index;
		}
	});
	postCishu();
	}
}
	
function toSubForm(){
 	
 	var myreg = /^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1}))+\d{8})$/; 
	if(!myreg.test($("#phone").val())) 
	{ 
	    $("#tipStep2").show();
	    return false; 
	} 
 	
		 else{
 		$("#tipStep2").hide();
			$.ajax({
				type:"get",
				url:"http://10.255.25.151:8080/hncj_api_v3/store/game/v3.1/user/fillPrize",
				data:{
					"phone":phone,
					"consignerAds":consignerAds,
					"orderId":orderId,
					"userId":userId,
					"prizeId" : prizeId,
				},
				dataType:'jsonp', 
				jsonp:'jsonpCallback',
				success:function(data){
					if(data == 0){
						layer.close(index);
						alert("操作成功");
					}else{
						alert("超过30分钟不能领取奖品");
					}
				}
			});
	
		}
		 
	isOpenOne = true;
	isOpenTwo = false;
	isOpenThr = false;
	layer.close(index);
}
function toCloseWin(){
	isOpenOne = true;
	isOpenTwo = false;
	isOpenThr = false;
	postCishu();
	layer.close(index);
}


function toGiveCloseWin(){
	
	$.ajax({
				type:"get",
				url:"http://10.255.25.151:8080/hncj_api_v3/store/game/v3.1/user/giveupPrize",
				data:{
					"orderId":orderId,
					"userId":userId,
					"prizeId" : prizeId,
				},
				dataType:'jsonp', 
				jsonp:'jsonpCallback',
				success:function(data){
					if(data == 0){
						layer.close(index);
					}
				}
			});
	
	
	isOpenOne = true;
	isOpenTwo = false;
	isOpenThr = false;
	postCishu();
	layer.close(index);
	
};


