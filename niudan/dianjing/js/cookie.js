function setCookie(cname, cvalue, exdays) {
    var d = new Date();
    d.setTime(d.getTime() + (exdays * 24 * 60 * 60 * 1000));
    var expires = "expires=" + d.toGMTString();
    document.cookie = cname + "=" + cvalue + "; " + expires;
}
function getCookie(cname) {
    var name = cname + "=";
    var ca = document.cookie.split(';');
    for (var i = 0; i < ca.length; i++) {
        var c = ca[i].trim();
        if (c.indexOf(name) == 0) { return c.substring(name.length, c.length); }
    }
    return "";
}

function clearCookie(name) {
    setCookie(name, "", -1);
}

function checkCookie() {
    var isMonth = getCookie("isMonth");
    if (isMonth != "") {
        alert("欢迎 " + isMonth + " 再次访问");
    }
    else {
        isMonth = prompt("是否包月:", "");
        if (isMonth != "" && isMonth != null) {
            setCookie("isMonth", isMonth, 30);
        }
    }
}