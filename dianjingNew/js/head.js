document.writeln("<img id=\'imgShouYe\' src=\'images/ztNew/tuijian.png\' style=\'position: absolute; top: 40px; left: 225px; display: none;\' />");
document.writeln("<img id=\'imgSaiShi\' src=\'images/ztNew/saishi.png\' style=\'position: absolute; top: 40px; left: 391px; display: none;\' />");
document.writeln("<img id=\'imgYouXi\' src=\'images/ztNew/youxi.png\' style=\'position: absolute; top: 40px; left: 557px; display: none; \' />");
document.writeln("<img id=\'imgZhuBo\' src=\'images/ztNew/zhubo.png\' style=\'position: absolute; top: 40px; left: 723px; display: none;\' />");
document.writeln("<img id=\'imgZongYi\' src=\'images/ztNew/zongyi.png\' style=\'position: absolute; top: 40px; left: 889px; display: none;\' />");
// document.writeln("<img id=\'imgSearch\' src=\'images/menu/search.png\' style=\'position: absolute; top: 58px; left: 1060px; display: none;\' />");
document.writeln("<img id=\'imgUser\' src=\'images/menu/order.png\' style=\'position: absolute; top: 58px; left: 1086px; display: none; \' />");


// function InitHead(dt) {
// //     dt[0][0] = setBtnForSH("index.html", "imgShouYe");
// //     dt[0][1] = setBtnForSH("saishi.html", "imgSaiShi");
// //     dt[0][2] = setBtnForSH("hotgame.html", "imgYouXi");
// //     dt[0][3] = setBtnForSH("zhubo.html", "imgZhuBo");
// //     dt[0][4] = setBtnForSH("zongyi.html", "imgZongYi");
// //     dt[0][5] = setBtnForSH("search.html", "imgSearch");
// //     dt[0][6] = setBtnForSH("order.html", "imgUser");
// // }

function InitHead(dt) {
    dt[0][0] = setBtnForSH("index.html", "imgShouYe");
    dt[0][1] = setBtnForSH("javascript:jumpCatetory('saishi.html')", "imgSaiShi");
    dt[0][2] = setBtnForSH("javascript:jumpCatetory('hotgame.html')", "imgYouXi");
    dt[0][3] = setBtnForSH("javascript:jumpCatetory('zhubo.html')", "imgZhuBo");
    dt[0][4] = setBtnForSH("javascript:jumpCatetory('zongyi.html')", "imgZongYi");
    // dt[0][5] = setBtnForSH("javascript:jumpCatetory('search.html')", "imgSearch");
    dt[0][5] = setBtnForSH("javascript:jumpCatetory('order.html')", "imgUser");
}

function jumpCatetory(url) {
    stopPlayVideoHandler();
    J(url);
}

