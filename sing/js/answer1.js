statistics(0);
// Webview.stopVideo();
var questionId;//题号
var question;//问题
var optionA;//
var optionB;//
var optionC;//题号
var optionD;//题号
var questionNum=1;//第几题
var isCorrect;//是否正确
var correctOption;//正确答案
var tim//定时器
var list;
var x=0,y;
var answer_errorx=1,
answer_error_endx=0,
answer_successx=0,
answer_success_endx=0,
answer_nox=0,
answer_no_vipx=0;
var answer_error=true;
var answer_error_end=true;
var answer_success=true;
var answer_success_end=true;
var answer_no=true;
var answer_no_vip=true;
var channel;
var jump_lis=true;
var jump_vip=true;
function reset_true(){
	answer_error=true;
	answer_error_end=true;
	answer_success=true;
	answer_success_end=true;
	answer_no=true;
	answer_no_vip=true;
}
function answer_no_vip_reset(){
	$(".answer_no_vip2").children().eq(1).hide();
	$(".answer_no_vip2").children().eq(0).show();
	$(".answer_no_vip3").children().eq(1).hide();
	$(".answer_no_vip3").children().eq(0).show();
	$(".answer_no_vip1").children().eq(1).hide();
	$(".answer_no_vip1").children().eq(0).show();
}
function answer_error_end_reset(){
	$(".answer_error_end2").children().eq(1).hide();
	$(".answer_error_end2").children().eq(0).show();
	$(".answer_error_end3").children().eq(1).hide();
	$(".answer_error_end3").children().eq(0).show();
	$(".answer_error_end1").children().eq(1).hide();
	$(".answer_error_end1").children().eq(0).show();
}
function reset_hand(){
	x=0;
	$(".answer_hand").css({top:"4.36rem"})
}
processKeyEvent = function(keyCode) {
    keyanswer1(keyCode);
}
function keyanswer1(key_code){
	switch(key_code){
		case mkeyEvent.KEY_UP:
		if(jump_lis && jump_vip && answer_error && answer_error_end && answer_success && answer_success_end  && answer_no && answer_no_vip){
			x--;
			if (x<=0) {
				x=0;
			$(".answer_hand").css({top:"4.36rem"})
			}else if(x==1){
				$(".answer_hand").css({top:"5.66rem"})
			}else if(x==2){
				$(".answer_hand").css({top:"6.96rem"})
			}
		}else if (answer_error==false){
			
		}else if (answer_error_end==false){
			answer_error_endx=0;
			answer_error_end_reset();
			$(".answer_error_end1").children().eq(0).hide();
			$(".answer_error_end1").children().eq(1).show();

		}else if (answer_success==false){
			
		}else if (answer_success_end==false){
			
		}else if (answer_no==false){
			
		}else if (answer_no_vip==false){
			answer_no_vipx=0;
			answer_no_vip_reset();
			$(".answer_no_vip1").children().eq(0).hide();
			$(".answer_no_vip1").children().eq(1).show();
		}
		break;
		case mkeyEvent.KEY_LEFT:
			if (answer_error==false){
				answer_errorx=0;
				$(".answer_error_but1").children().eq(0).hide();
				$(".answer_error_but1").children().eq(1).show();
				$(".answer_error_but2").children().eq(0).show();
				$(".answer_error_but2").children().eq(1).hide();
			}else if (answer_error_end==false){
				answer_error_endx--;
				answer_error_end_reset();
				if (answer_error_endx<=0) {
					answer_error_endx=0;
					$(".answer_error_end1").children().eq(0).hide();
					$(".answer_error_end1").children().eq(1).show();
				}else if(answer_error_endx==1){
					$(".answer_error_end2").children().eq(0).hide();
					$(".answer_error_end2").children().eq(1).show();
				}
			}else if (answer_success==false){
				// answer_successx=0;
				// $(".answer_success_but1").children().eq(0).hide();
				// $(".answer_success_but1").children().eq(1).show();
				// $(".answer_success_but2").children().eq(0).show();
				// $(".answer_success_but2").children().eq(1).hide();
			}else if (answer_success_end==false){

			}else if (answer_no==false){
				
			}else if (answer_no_vip==false){
				answer_no_vipx--;
				answer_no_vip_reset();
				if (answer_no_vipx<=0) {
					answer_no_vipx=0;
					
					$(".answer_no_vip1").children().eq(0).hide();
					$(".answer_no_vip1").children().eq(1).show();
				}else if (answer_no_vipx==1) {
					$(".answer_no_vip2").children().eq(0).hide();
					$(".answer_no_vip2").children().eq(1).show();
				}
			}
		break;
		case mkeyEvent.KEY_RIGHT:
			if (answer_error==false){
				answer_errorx=1;
				$(".answer_error_but1").children().eq(1).hide();
				$(".answer_error_but1").children().eq(0).show();
				$(".answer_error_but2").children().eq(1).show();
				$(".answer_error_but2").children().eq(0).hide();
			}else if (answer_error_end==false){
				answer_error_endx++;
				answer_error_end_reset();
				if (answer_error_endx>=2) {
					answer_error_endx=2;

					$(".answer_error_end3").children().eq(0).hide();
					$(".answer_error_end3").children().eq(1).show();
				}else if(answer_error_endx==1){
					$(".answer_error_end2").children().eq(0).hide();
					$(".answer_error_end2").children().eq(1).show();
				}
			}else if (answer_success==false){
				
			}else if (answer_success_end==false){
				
			}else if (answer_no==false){
				
			}else if (answer_no_vip==false){
				answer_no_vipx++;
				answer_no_vip_reset()
				if (answer_no_vipx>=2) {
					answer_no_vipx=2;
					
					$(".answer_no_vip3").children().eq(0).hide();
					$(".answer_no_vip3").children().eq(1).show();
				}else if(answer_no_vipx==1){
					$(".answer_no_vip2").children().eq(0).hide();
					$(".answer_no_vip2").children().eq(1).show();
					
				}
			}
		break;
		case mkeyEvent.KEY_DOWN:
		if(jump_lis && jump_vip && answer_error && answer_error_end && answer_success && answer_success_end  && answer_no && answer_no_vip){
			x++;
			if(x==1){
				$(".answer_hand").css({top:"5.66rem"})
			}else if(x==2){
				$(".answer_hand").css({top:"6.96rem"})	
			}else if(x>=3){
				x=3;
				$(".answer_hand").css({top:"8.26rem"})	
			}
		}else if (answer_error==false){
			
		}else if (answer_error_end==false){
			answer_error_endx=2;
			answer_error_end_reset();
			$(".answer_error_end3").children().eq(0).hide();
			$(".answer_error_end3").children().eq(1).show();

		}else if (answer_success==false){

		}else if (answer_success_end==false){
			
		}
		break;
		case mkeyEvent.KEY_SELECT:
			if(jump_lis && jump_vip && answer_error && answer_error_end && answer_success && answer_success_end){
				console.log(x);
				// error();
				clearInterval(tim);
				answer1();
				Webview.stopVideo();
			}else if (answer_error==false){
				// reset_true();
				if(answer_errorx==0){
					console.log(answer_errorx);
					channel=list.data.questionList[questionNum-1].channel;
					var fullMusicInfoVO= list.data.questionList[questionNum-1].fullMusicInfoVO;
					if(channel==0){
						if(app1==9 && app2==0){
						$(".jump_lis").show();
						jumpx=0;
						jump_lis=false;
						answer_error=true;
						}else{
							statistics(8);
							//欢唱播放
							// window.location.href="http://"+ip_local+"/index1.html";
							jump2Zte9MusicPlay(fullMusicInfoVO);
						}
					}else if(channel==1){
						//芒果播放
						statistics(10);
						// window.location.href="http://"+ip_local+"/index1.html";
						window.location.href="http://10.255.0.219/en/template6/index.html?style_id=506";
						

					}
				}else if(answer_errorx==1){	
					answer2();
				}
			}else if (answer_error_end==false){
				// reset_true();
				if (answer_error_endx==0){
					if(app1==9 && app2==0){
						$(".jump_lis").show();
						jump_lis=false;
						jumpx=1;
						answer_error_end=true;
					}else{
						statistics(12);
						//欢唱大厅
						// window.location.href="http://"+ip_local+"/index1.html";
						jump2Zte9Music();
					}
				}else if(answer_error_endx==1){
					
					statistics(13);
					//芒果大厅
					// window.location.href="http://"+ip_local+"/index1.html";
					window.location.href="http://10.255.0.219/en/template6/index.html?style_id=506";
				}else if(answer_error_endx==2){
					window.location.href="http://"+ip_local+"/answer.html"
				}
				
			}else if (answer_success==false){
				// if(answer_successx==1){
				// 	answer_success=true;
				// 	channel=list.data.questionList[questionNum-1].channel;
				// 	if(channel==0){
				// 		// android.playmusic();
				// 	}else if(channel==1){
				// 		// android.openMangguo();
				// 	}

				// }else 
				if(answer_successx==0){
					answer2();
				}
			}else if (answer_success_end==false){
				answer_success_end=true;
				$(".answer_kuang").hide();
				window.location.href="http://"+ip_local+"/index1.html"
			}else if(jump_lis==false && jumpx==0) {
				$(".jump_lis").hide();
				jump_lis=true;
				answer_error=false;
			}else if(jump_lis==false && jumpx==1) {
				$(".jump_lis").hide();
				jump_lis=true;
				answer_error_end=false;
			}
			// else if (answer_no==false){
			// 	window.location.href="http://"+ip_local+"/index.html"
			// }else if (answer_no_vip==false){
			// 	if(answer_no_vipx==0){
			// 		// android.openOrder();
			// 		 statistics(9);
			// 	}else if(answer_no_vipx==1){
			// 		// android.openMangguo();
			// 		statistics(11);
			// 	}else if(answer_no_vipx==2){
			// 		window.location.href="http://"+ip_local+"/index.html";
			// 	}
			// }
		break;
		case mkeyEvent.KEY_BACK:
			if(jump_lis==false && jumpx==0) {
				$(".jump_lis").hide();
				jump_lis=true;
				answer_error=false;
			}else if(jump_lis==false && jumpx==1) {
				$(".jump_lis").hide();
				jump_lis=true;
				answer_error_end=false;
			}else{
                Webview.stopVideo();
				window.location.href="http://"+ip_local+"/top.html"
			}
		break;
	}

	
}
// 获取题目信息
function answer(){
	$.ajax({
		type:"GET",
		dataType:"json",
		contentType:'application/x-www-form-urlencoded;charset=utf-8',
		url:"http://"+ip+"/singwithme/practice/question/getQuestionList",
		data:{
			"userId":userId,		
		   },
		success:function(msg){
			console.log(msg);
			list=msg;
			if(list.code==1){
					questionId=list.data.questionList[questionNum-1].id;
					console.log(questionId);
					question=list.data.questionList[questionNum-1].question;
					optionA=list.data.questionList[questionNum-1].optionA;
					optionB=list.data.questionList[questionNum-1].optionB;
					optionC=list.data.questionList[questionNum-1].optionC;
					optionD=list.data.questionList[questionNum-1].optionD;
					correctOption=list.data.questionList[questionNum-1].correctOption;
					questionMusicUrl=parseInt(list.data.questionList[questionNum-1].questionMusicUrl);
					console.log("singwithme:"+question);
					console.log("singwithme_questionMusicUrl:"+questionMusicUrl);
					playmusic(questionMusicUrl);
					$(".answer_num").html(questionNum);
					$(".answer_tit0").html(question);
					$(".answer_tit1").html(optionA);
					$(".answer_tit2").html(optionB);
					$(".answer_tit3").html(optionC);
					$(".answer_tit4").html(optionD);
					console.log(correctOption);
					
					y=list.data.questionList[questionNum-1].questionPlayTime+3;
					tim=setInterval(function(){	
						y--;
						$(".answer_tim").html(y);
						$(".answer_tim").css({color:"white",fontSize:"1rem"})
						if(y<=5){
							$(".answer_tim").css({color:"red",fontSize:"1.2rem"})	
						}
						if(y<=0){
							clearInterval(tim);
							answer_tim0();
						}
					},1000);
					return correctOption;
					return questionId;
					
			}
		}

	})
};
answer();
// console.log(questionId);
// 答题错误
function answer_tim0(){
	if(y==0){
		$(".answer_error").css({backgroundImage:"url(./images/answer/time0.png)"});	
	}else{
		$(".answer_error").css({backgroundImage:"url(./images/answer/error_bg0.png)"});
	};
	// error.play();
	var error=parseInt(100*Math.random());
	error=document.createElement("audio");
    error.src='sound/error.mp3';
    $(".box").append(error);
    error.play();
		optionA=list.data.questionList[questionNum-1].optionA;
		optionB=list.data.questionList[questionNum-1].optionB;
		optionC=list.data.questionList[questionNum-1].optionC;
		optionD=list.data.questionList[questionNum-1].optionD;
		correctOption=list.data.questionList[questionNum-1].correctOption;
		console.log(correctOption);
		isCorrect=0;
		// $(".answer_error").css({backgroundImage:"../images/answer/"+a});
		if(questionNum==10){
			$(".answer_error_end").show();
			answer_error_end=false;
		}else{
			$(".answer_error").show();
			answer_error=false;
			if(correctOption == "A"){
				$(".answer_error_p").html(correctOption + '<span style="margin-left: 0.2rem">' + optionA + '</span>');
			}else if(correctOption == "B"){
				$(".answer_error_p").html(correctOption + '<span style="margin-left: 0.2rem">' + optionB + '</span>');
			}else if(correctOption == "C"){
				$(".answer_error_p").html(correctOption + '<span style="margin-left: 0.2rem">' + optionC + '</span>');
			}else if(correctOption == "D"){
				$(".answer_error_p").html(correctOption + '<span style="margin-left: 0.2rem">' + optionD + '</span>');
			}
		}
}
// 提交验证答案
function answer1(){
	if(correctOption=="A"){
		correctOption=0
	}else if(correctOption=="B"){
		correctOption=1
	}else if(correctOption=="C"){
		correctOption=2
	}else if(correctOption=="D"){
		correctOption=3
	}
	if(correctOption==x){
		//答对
		isCorrect=1;
		console.log("aaa");
		questionId=list.data.questionList[questionNum-1].id;
		console.log(questionId);
		console.log(questionNum);
		console.log(isCorrect);
		console.log(userId);
		// success.play();
		var audio=parseInt(100*Math.random());
		audio=document.createElement("audio");
		audio.src='sound/success.mp3';
		$(".box").append(audio);
		audio.play();
		if(questionNum==10){
			$(".answer_success_end").show();
			answer_success_end=false;
		}else{
			$(".answer_success").show();
			answer_success=false;

			// $(".answer_success_p1").html(0);
			// $(".answer_success_p2").html("50%");
		}
		

	}else if(correctOption!=x){
		//答错
		answer_tim0();
	}
	
}
//答对一题  继续答题
function answer2(){
	answer_success=true;
	answer_error=true;
	$(".answer_kuang").hide();
	questionNum++;
	questionId=list.data.questionList[questionNum-1].id;
	console.log(questionId);
	question=list.data.questionList[questionNum-1].question;
	optionA=list.data.questionList[questionNum-1].optionA;
	optionB=list.data.questionList[questionNum-1].optionB;
	optionC=list.data.questionList[questionNum-1].optionC;
	optionD=list.data.questionList[questionNum-1].optionD;
	correctOption=list.data.questionList[questionNum-1].correctOption;
	correctOption=list.data.questionList[questionNum-1].correctOption;
	questionMusicUrl=parseInt(list.data.questionList[questionNum-1].questionMusicUrl);
	console.log("singwithme:"+question);
	console.log("singwithme_questionMusicUrl:"+questionMusicUrl);
	playmusic(questionMusicUrl);
	$(".answer_num").html(questionNum);
	$(".answer_tit0").html(question);
	$(".answer_tit1").html(optionA);
	$(".answer_tit2").html(optionB);
	$(".answer_tit3").html(optionC);
	$(".answer_tit4").html(optionD);
	console.log(correctOption);
	y=list.data.questionList[questionNum-1].questionPlayTime+3;
	console.log(y);
	tim=setInterval(function(){
		y--;
		$(".answer_tim").html(y);
		$(".answer_tim").css({color:"white",fontSize:"1rem"})
		if(y<=5){
			$(".answer_tim").css({color:"red",fontSize:"1.2rem"})	
		}
		if(y<=0){
			clearInterval(tim);
							// audio.pause();
			answer_tim0();
		}
	},1000);

}

