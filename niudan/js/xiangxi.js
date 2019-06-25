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