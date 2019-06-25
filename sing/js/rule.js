processKeyEvent = function(keyCode) {
    keyrule(keyCode);
}
playmusic(223);
var key_x=0;
	function keyrule(key_coke){
		switch(key_coke){
			case mkeyEvent.KEY_SELECT:
				window.location.href="http://"+ip_local+"/index1.html";
			break;
			case mkeyEvent.KEY_BACK:
				window.location.href="http://"+ip_local+"/index1.html";
			break;
			case mkeyEvent.KEY_LEFT:
				key_x--;
				if(key_x==0){
					$(".rule_text3").hide();
					$(".rule_text2").hide();
					$(".rule_text1").show();
					$(".rule_right").show();
					$(".rule_left").hide();
				}else if(key_x==1){
					$(".rule_text3").hide();
					$(".rule_text1").hide();
					$(".rule_text2").show();
					$(".rule_right").show();
					$(".rule_left").show();
				}
				
			break;
			case mkeyEvent.KEY_RIGHT:
				key_x++;
				if(key_x==2){
					$(".rule_text1").hide();
					$(".rule_text2").hide();
					$(".rule_text3").show();
					$(".rule_right").hide();
					$(".rule_left").show();
				}else if(key_x==1){
					$(".rule_text3").hide();
					$(".rule_text1").hide();
					$(".rule_text2").show();
					$(".rule_right").show();
					$(".rule_left").show();
				}
			break;

		}
	}
	statistics(4);

