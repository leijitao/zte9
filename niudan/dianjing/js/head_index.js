document.writeln("<img id=\'imgShouYe\' src=\'images/menu/shouye.png\' style=\'position: absolute; top: 0.40rem; left: 2.25rem; display: none;width: 1.66rem;height: 0.58rem;z-index: 1\' />");
document.writeln("<img id=\'imgSaiShi\' src=\'images/menu/saishi.png\' style=\'position: absolute; top: 0.40rem; left: 3.91rem; display: none;width: 1.66rem;height: 0.58rem;z-index: 1\' />");
document.writeln("<img id=\'imgYouXi\' src=\'images/menu/youxi.png\' style=\'position: absolute; top: 0.40rem; left: 5.57rem; display: none;width: 1.66rem;height: 0.58rem;z-index: 1 \' />");
document.writeln("<img id=\'imgZhuBo\' src=\'images/menu/zhubo.png\' style=\'position: absolute; top: 0.40rem; left: 7.23rem; display: none;width: 1.66rem;height: 0.58rem;z-index: 1\' />");
document.writeln("<img id=\'imgZongYi\' src=\'images/menu/zongyi.png\' style=\'position: absolute; top: 0.40rem; left: 8.89rem; display: none;width: 1.66rem;height: 0.58rem;z-index: 1\' />");
document.writeln("<img id=\'imgSearch\' src=\'images/menu/search.png\' style=\'position: absolute; top: 0.58rem; left: 10.57rem; display: none;width: 1.04rem;height: 0.23rem\' />");
document.writeln("<img id=\'imgUser\' src=\'images/menu/order.png\' style=\'position: absolute; top: 0.58rem; left: 11.56rem; display: none;width: 1rem;height: 0.23rem \' />");


function InitHead(dt) {
    dt[0][0] = setBtnForSH("index.html", "imgShouYe");
    dt[0][1] = setBtnForSH("saishi.html", "imgSaiShi");
    dt[0][2] = setBtnForSH("hotgame.html", "imgYouXi");
    dt[0][3] = setBtnForSH("zhubo.html", "imgZhuBo");
    dt[0][4] = setBtnForSH("zongyi.html", "imgZongYi");
    dt[0][5] = setBtnForSH("search.html", "imgSearch");
    dt[0][6] = setBtnForSH("order.html", "imgUser");
}

