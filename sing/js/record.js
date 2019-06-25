// function reset_record(){
// 	$(".record_home0").show();
// 	$(".record_home1").hide();
// 	$(".record_left").css({transform:"scale(1,1)"});
// 	$(".record_right").css({transform:"scale(1,1)"});
// }
statistics(7);
processKeyEvent = function(keyCode) {
    keycord(keyCode);
}
var x=0;
function keycord(key_coke){
		switch(key_coke){
			case mkeyEvent.KEY_LEFT:
				reset_record();
				x--;
				if(x<=0){
					x=0;
					$(".record_home1").show();
					$(".record_home0").hide();
					$(".record_left").css({transform:"scale(1,1)"});
					$(".record_right").css({transform:"scale(1,1)"});	
				}else if(x==1){
					$(".record_home0").show();
					$(".record_home1").hide();
					$(".record_left").css({transform:"scale(1.2,1.2)"});
					$(".record_right").css({transform:"scale(1,1)"});
				}
			
			break;
			case mkeyEvent.KEY_RIGHT:
				reset_record();
				x++;
				if(x==1){
					$(".record_home0").show();
					$(".record_home1").hide();
					$(".record_left").css({transform:"scale(1.2,1.2)"});
					$(".record_right").css({transform:"scale(1,1)"});	
				}else if(x>=2){
					x=2;
					$(".record_home0").show();
					$(".record_home1").hide();
					$(".record_right").css({transform:"scale(1.2,1.2)"});
					$(".record_left").css({transform:"scale(1,1)"});
				}
			break;
			case mkeyEvent.KEY_UP:
				reset_record();
				x--;
				if(x<=0){
					x=0;
					$(".record_home1").show();
					$(".record_home0").hide();
					$(".record_left").css({transform:"scale(1,1)"});
					$(".record_right").css({transform:"scale(1,1)"});	
				}else if(x==1){
					$(".record_home0").show();
					$(".record_home1").hide();
					$(".record_left").css({transform:"scale(1.2,1.2)"});
					$(".record_right").css({transform:"scale(1,1)"});
				}
			break;
			case mkeyEvent.KEY_DOWN:
				reset_record();
				x++;
				if(x==1){
					$(".record_home0").show();
					$(".record_home1").hide();
					$(".record_left").css({transform:"scale(1.2,1.2)"});
					$(".record_right").css({transform:"scale(1,1)"});	
				}else if(x>=2){
					x=2;
					$(".record_home0").show();
					$(".record_home1").hide();
					$(".record_right").css({transform:"scale(1.2,1.2)"});
					$(".record_left").css({transform:"scale(1,1)"});
				}
			break;
			case mkeyEvent.KEY_SELECT:
				if(x==0){
					window.location.href="http://"+ip_local+"/index1.html"
				}else if(x==1){
					
				}else if(x==2){
					
				}
			break;
			case mkeyEvent.KEY_BACK:
				window.location.href="http://"+ip_local+"/lottery.html"
			break;
		}

	}
//设定时间格式化函数
function add0(m){return m<10?'0'+m:m }
function format(shijianchuo)
{
//shijianchuo是整数，否则要parseInt转换
var time = new Date(shijianchuo);
var y = time.getFullYear();
var m = time.getMonth()+1;
var d = time.getDate();
var h = time.getHours();
var mm = time.getMinutes();
var s = time.getSeconds();
return y+'-'+add0(m)+'-'+add0(d)+' '+add0(h)+':'+add0(mm)+':'+add0(s);
}



function record_all(){
	console.log(1);
	$.ajax({
		type:"GET",
		dataType:"json",
		url:"http://"+ip+"/singwithme/lottery/finalLottery",
		data:{
			// "userId":userId,		
		   },
		success:function(msg){
			console.log(msg);
			console.log(msg.data[0].pname);
			console.log(msg.data[0].modifiedTime);
			var name0=msg.data[0].pname;
			var name1=msg.data[1].pname;
			var name2=msg.data[2].pname;
			var name3=msg.data[3].pname;
			var name4=msg.data[4].pname
			var name5=msg.data[5].pname;
			var name6=msg.data[6].pname;
			var name7=msg.data[7].pname;
			var name8=msg.data[8].pname;
			var name9=msg.data[9].pname;
			var record_all="<div><p>"+msg.data[0].userId.toString().substr(0,5)+"*****"+msg.data[0].userId.toString().substr(10)+"</p><p>"+format(msg.data[0].modifiedTime)+"</p><p>"+name0+"</p></div>"
				+"<div><p>"+msg.data[1].userId.toString().substr(0,5)+"*****"+msg.data[1].userId.toString().substr(10)+"</p><p>"+format(msg.data[1].modifiedTime)+"</p><p>"+name1+"</p></div>"
				+"<div><p>"+msg.data[2].userId.toString().substr(0,5)+"*****"+msg.data[2].userId.toString().substr(10)+"</p><p>"+format(msg.data[2].modifiedTime)+"</p><p>"+name2+"</p></div>"
				+"<div><p>"+msg.data[3].userId.toString().substr(0,5)+"*****"+msg.data[3].userId.toString().substr(10)+"</p><p>"+format(msg.data[3].modifiedTime)+"</p><p>"+name3+"</p></div>"
				+"<div><p>"+msg.data[4].userId.toString().substr(0,5)+"*****"+msg.data[4].userId.toString().substr(10)+"</p><p>"+format(msg.data[4].modifiedTime)+"</p><p>"+name4+"</p></div>"
				+"<div><p>"+msg.data[5].userId.toString().substr(0,5)+"*****"+msg.data[5].userId.toString().substr(10)+"</p><p>"+format(msg.data[5].modifiedTime)+"</p><p>"+name5+"</p></div>"
				+"<div><p>"+msg.data[6].userId.toString().substr(0,5)+"*****"+msg.data[6].userId.toString().substr(10)+"</p><p>"+format(msg.data[6].modifiedTime)+"</p><p>"+name6+"</p></div>"
				+"<div><p>"+msg.data[7].userId.toString().substr(0,5)+"*****"+msg.data[7].userId.toString().substr(10)+"</p><p>"+format(msg.data[7].modifiedTime)+"</p><p>"+name7+"</p></div>"
				+"<div><p>"+msg.data[8].userId.toString().substr(0,5)+"*****"+msg.data[8].userId.toString().substr(10)+"</p><p>"+format(msg.data[8].modifiedTime)+"</p><p>"+name8+"</p></div>"
				+"<div><p>"+msg.data[9].userId.toString().substr(0,5)+"*****"+msg.data[9].userId.toString().substr(10)+"</p><p>"+format(msg.data[9].modifiedTime)+"</p><p>"+name9+"</p></div>"
				
			
				$(".record_all").html(record_all);
			
		}

	})
}
record_all();
function record_my(){
	console.log(125);
	$.ajax({
		type:"GET",
		dataType:"json",
		url:"http://"+ip+"/singwithme/lottery/prizeHandle",
		data:{
			"userId":userId,		
		   },
		success:function(msg){
			console.log(msg);
			// var record_me="<div><p>"+msg.data[0].pname+"</p><p>"+format(msg.data[0].modifiedTime/1000)+"</p></div>"
			// 	+"<div><p>"+msg.data[1].pname+"</p><p>"+format(msg.data[1].modifiedTime/1000)+"</p></div>"
			// 	+"<div><p>"+msg.data[2].pname+"</p><p>"+format(msg.data[2].modifiedTime/1000)+"</p></div>"
			// 	+"<div><p>"+msg.data[3].pname+"</p><p>"+format(msg.data[3].modifiedTime/1000)+"</p></div>"
			// 	$(".record_me2").html(record_me);

				var data1=msg.data;
				for(var integra in data1){
					var lis2="<div><p>"+data1[integra].pname+"</p><p>"+format(data1[integra].modifiedTime)+"</p></div>";
					$(".record_me2").append(lis2);
					// alert(data1[integra].integralRanking);
					// alert(lis1);
				}
			
		}

	})
}
record_my();


