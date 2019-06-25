var nav=true;
var content=false;
var nav_num=0;
function reset_fir(num){
    $('.title_first').children().hide();
    $('.title_first').children().eq(0).show();
    $('.title_first').children().eq(num+1).show();
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

    switch(e.keyCode) {
        case 37:
            if(nav){
                nav_num--;
                if(nav_num<=0){
                    nav_num=0
                }
                reset_fir(nav_num);
            }else {

            }
            break;
        case 38:
            if(nav){

            }else {
                content=false;
                nav=true;
            }
            break;
        case 39:
            if(nav){
                nav_num++;
                if(nav_num>=5){
                    nav_num=5
                }
                reset_fir(nav_num);
            }else {

            }
            break;
        case 40:
            if(nav){
                nav=false;
                content=true;
            }else {

            }
            break;
        case 13:
            if(nav){
                nav_num--;
                if(nav_num<=0){
                    nav_num=0
                }
            }else {

            }
            break;
    }
};