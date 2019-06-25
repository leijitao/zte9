
var userId=android.getUserId();
//userId=1;
$(function(){
	
	
	
	
	$.ajax({
		url:"http://10.255.25.151:8080/hncj_api_v3/store/game/v3.1/user/prizeList",
		dataType:'jsonp', 
		jsonp:'jsonpCallback', 
		type:"GET",
		success:function(data){
			var list = data.prizeInfo;
			$.each(list, function(i,o) {
				$("#my_jiangpin").append("<div>");
				$("#my_jiangpin").append(o.severalPrizes);
				$("#my_jiangpin").append("</div>");
				$("#my_jiangpin").append("<div>");
				$("#my_jiangpin").append(o.prizeName);
				$("#my_jiangpin").append("</div>");
			});
			
		}
	});
	
		$.ajax({
		url:"http://10.255.25.151:8080/hncj_api_v3/store/game/v3.1/user/myPrize",
		dataType:'jsonp', 
		jsonp:'jsonpCallback', 
		type:"GET",
		data:{
					"userId":userId,
				},
		success:function(data){
			var list = data.data;
			$.each(list, function(i,o) {
				$("#my_wdjiangpin").append("<div>");
				$("#my_wdjiangpin").append(o.prizeName);
				$("#my_wdjiangpin").append("---");
				$("#my_wdjiangpin").append(o.createDateTimeFmt);
				$("#my_wdjiangpin").append("</div>");
			});
			$("#mytupian").append("<img src="+list[0].prizeImg+" />");
		}
	});
});

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
	case 13: //回车键
　　　　toIndexhtml();
　　　　default:
　　　　break;
　　}
}

function toIndexhtml(){
	window.location.href="http://10.255.25.151:8080/niudan/index.html";
}