var enterKey = true;

var Box = { "OK": "", "PAGEUP": "", "PAGEDOWN": "", "PAUSE": "", "PLAY": "", "FASTFORWARD": "", "FASTREWIND": "", "BACK": "", "ZERO": "", "ONE": "", "TWO": "", "THREE": "", "FOUR": "", "FIVE": "", "SIX": "", "SEVEN": "", "EIGHT": "", "NINE": "", "UP": "", "DOWN": "", "LEFT": "", "RIGHT": "", "VolumeQuiet": "", "VolumeUp": "", "VolumeDown": "" }
var KeyCodeList = {
    //ok
    13: "OK",
    273: "OK",
    //0
    0x0030: "ZERO",
    48: "ZERO",
    //1
    49: "ONE",
    //2
    50: "TWO",
    51: "THREE", //3
    52: "FOUR", //4
    53: "FIVE", //5
    54: "SIX", //6
    55: "SEVEN", //7
    56: "EIGHT", //8
    57: "NINE", //9
    //back
    8: "BACK",
    27: "BACK",
    122: "BACK",
    126: "BACK",
    339: "BACK",
    340: "BACK",
    640: "BACK",
    //left
    3: "LEFT",
    21: "LEFT",
    29: "LEFT",
    37: "LEFT",
    65: "LEFT",
    271: "LEFT",
    //up
    1: "UP",
    19: "UP",
    28: "UP",
    38: "UP",
    87: "UP",
    269: "UP",
    //right
    4: "RIGHT",
    22: "RIGHT",
    30: "RIGHT",
    39: "RIGHT",
    68: "RIGHT",
    272: "RIGHT",
    //down
    2: "DOWN",
    20: "DOWN",
    31: "DOWN",
    40: "DOWN",
    83: "DOWN",
    270: "DOWN",
    //快进
    44: "FASTREWIND",
    //播放
    //39: "PLAY",
    //暂停
    59: "PAUSE",
    //后退
    46: "FASTFORWARD",
    //音量--
    45: "VolumeDown",
    //音量++
    61: "VolumeUp",
    //静音
    67: "VolumeQuiet"
}

document.ua = navigator.userAgent.toLowerCase();
//如果(是谷歌浏览器)或者(是IE浏览器并且不是iPanel浏览器)
if (document.ua.indexOf('chrome') > 0 || (document.ua.indexOf('msie') > 0 && document.ua.indexOf('ipanel') < 0))
    document.onkeydown = DoKeyPress;
else //否则，如果是其它浏览器
    document.onkeypress = DoKeyPress;
//有线盒子捕获退出键
document.onirkeypress = DoKeyPress;


function DoKeyPress() {
    if (!btnconfig.status) return;
    var ev = ev || window.event; //获取event对象  
    var keyCode = ev.which || ev.keyCode;  //获取事件源  
    var keyName = KeyCodeList[keyCode];
    if (keyName == "BACK") {
        ev.preventDefault();
    }
    var param = GetKeyCodeParam(keyName);
    D(param);
}

function GetKeyCodeParam(keyCodeName) {
    if (keyCodeName != undefined) {
        if (Box.ZERO.length == 0 && keyCodeName == "ZERO")
            return Box.BACK; //经常用的,0==back
        return Box[keyCodeName];
    }
    return "";
}

/**
 * 返回IPTV门户或者来源地址
 */
function goIptvPortal() {
    window.location.href = Authentication.CTCGetConfig('EPGDomain');
}


/*通用方法*/
function G(id) { return document.getElementById(id); }
function S(id) { G(id).style.display = "block"; }
function H(id) { G(id).style.display = "none"; }
function J(href) {
    if (poslogconfig.open != 0) {
        if (href.indexOf("?") > -1) {
            href += "&";
        } else {
            href += "?";
        }
        href += "btn_posy=" + btninfo.posy;
        href += "&btn_posx=" + btninfo.posx;
        href += "&openlog=" + poslogconfig.open;
    }
    window.location.href = href;
}
function D(param) {
    if (param != "" && param != "undefined" && param != undefined) {
        if (param.indexOf("javascript:") > -1) {
            param = param.replace("javascript:", "");
            eval(param);
        }
        else J(param);
    }
}
function SwapImage(imgId, imgsrc) { document.oldSrc = G(imgId).src; G(imgId).src = imgsrc; }
function SwapImageRestore(imgId) { if (G(imgId) && document.oldSrc) { G(imgId).src = document.oldSrc; } }
function SwapImagePos(imgId, imgsrc, top, left)
{
    document.oldSrc = G(imgId).src;
    document.oldTop = G(imgId).style.top;
    document.oldLeft = G(imgId).style.left;
    
    G(imgId).style.top = top + "px";
    G(imgId).style.left = left + "px";
    G(imgId).style.zIndex = "1";
    G(imgId).src = imgsrc;
}
function SwapImageRestorePos(imgId)
{
    if (G(imgId) && document.oldSrc && document.oldTop && document.oldLeft) {
        G(imgId).style.top = document.oldTop;
        G(imgId).style.left = document.oldLeft;
        G(imgId).style.zIndex = "0";
        G(imgId).src = document.oldSrc;
    }
}

var poslogconfig = {
    open: 0 //默认跳转不记录按键属性
}

var btnconfig = {
    back_x: 0, //x或者y轴到达顶点返回 0关闭1开启
    back_y: 0,
    only_y: 0, //x或者y轴可以移动 0关闭1开启
    only_x: 0,
    level_x: 0, //x或者y轴移动优先级 0关闭1开启
    level_y: 0,
    dirLevel: 0, //焦点移动事件的优先级
    status: true
}

var btninfo = {
    posy: -1,
    posx: -1,
};

var btnModel = function (param, type, resurl, id, top, left) {
    this.Param = param,
    this.Type = type, //1焦点坐标变化 2焦点图片替换 3焦点显示隐藏  5自定义
    this.ResUrl = resurl, //图片切换使用，新图片地址
    this.Id = id,
    this.OnMouseOver = this.OnMouseOut = "",
    this.MoveUp = this.MoveDown = this.MoveLeft = this.MoveRight = null,
    this.Top = top,
    this.Left = left;
}

//1焦点样式为位置移动
function setBtnForPos(param, id, top, left) {
    var btn = new btnModel(param, 1, "", id, top, left);
    return btn;
}


//2焦点样式为图片替换
function setBtnForRes(param, resUrl, id) {
    var btn = new btnModel(param, 2, resUrl, id, 0, 0);
    return btn;
}
function setBtnForRes(param, resUrl, id, top, left) {
    var btn = new btnModel(param, 4, resUrl, id, top, left);
    return btn;
}

//3焦点样式为显示和隐藏
function setBtnForSH(param, id) {
    var btn = new btnModel(param, 3, "", id, 0, 0);
    return btn;
}
//5焦点样式自定义
function setBtnForMy(param, id, over, out) {
    var btn = new btnModel(param, 5, "", id, 0, 0);
    btn.OnMouseOver = over;
    btn.OnMouseOut = out;
    return btn;
}


/*核心命名空间*/
var zte9 = {
    isArray: function (obj) {
        return (obj instanceof Array);
    },
    call: function (fn, args) {
        if (typeof fn == "string" && fn !== '')
            return eval("(" + fn + ")");
        else if (typeof fn == "function") {
            if (!this.isArray(args)) {
                var temp = [];
                for (var i = 1; i < arguments.length; i++) //arguments不是标准的数组（是一个伪数组）
                    temp.push(arguments[i]);
                args = temp;
            }
            return fn.apply(window, args);
        }
    },
    ajax: function (config) {
        var url = config.url;
        var data = config.data;
        var type = (config.type || 'GET').toUpperCase();
        var contentType = config.contentType || 'application/x-www-form-urlencoded';
        var dataType = config.dataType;
        var headers = config.headers || [];
        var fnSuccess = config.success;
        var fnError = config.error;
        var xmlhttp;
        if (window.XMLHttpRequest)
            xmlhttp = new XMLHttpRequest();
        else
            xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");

        xmlhttp.onreadystatechange = function () {
            if (xmlhttp.readyState === 4) {
                var rsp = xmlhttp.responseText || xmlhttp.responseXML;
                if (dataType === 'json')
                    rsp = eval("(" + rsp + ")");
                if (xmlhttp.status === 200)
                    zte9.call(fnSuccess, [xmlhttp, rsp]);
                else
                    zte9.call(fnError, [xmlhttp, rsp]);
            }
        };

        xmlhttp.open(type, url, true);
        for (var i = 0; i < headers.length; ++i) {
            xmlhttp.setRequestHeader(headers[i].name, headers[i].value);
        }
        xmlhttp.setRequestHeader('Content-Type', contentType);

        if (typeof data == 'object' && contentType == 'application/x-www-form-urlencoded') {
            var s = '';
            for (attr in data) {
                s += attr + '=' + data[attr] + '&';
            }
            if (s) {
                s = s.substring(0, s.length - 1);
            }
            xmlhttp.send(s);
        }
        else
            xmlhttp.send(data);
    },
    getContextPath: function () {
        var contextPath = '/' + location.href.split('/')[3] + '/';
        return contextPath;
    },
    getParent: function () {
        return window == window.parent ? window.top : window.parent;
    }
};

zte9.Button = zte9.btn = {
    pos: { y: -1, x: -1 },
    data: null,
    init: function (y, x) {
        Box.UP = "javascript:zte9.btn.up()";
        Box.DOWN = "javascript:zte9.btn.down()";
        Box.LEFT = "javascript:zte9.btn.left()";
        Box.RIGHT = "javascript:zte9.btn.right()";
        Box.OK = "javascript:zte9.btn.ok()";
        var data = new Array();
        for (var i = 0; i < y; i++) {
            data[i] = new Array();
            for (var j = 0; j < x; j++) data[i][j] = null;
        }
        return data;
    },
    load: function (data, y, x) {
        if (this.data != null) {
            var btn = this.data[this.pos.y][this.pos.x];
            if (btn != null) {
                if (btn.Type === 1 || btn.Type === 3) {
                    H(btn.Id);
                } else if (btn.Type === 2 || btn.Type == 4)
                    SwapImageRestore(btn.Id);
                if (btn.OnMouseOver != "") {
                    eval(btn.OnMouseOut);
                }
            }
            this.pos.y = -1;
            this.pos.x = -1;
        }
        this.data = data;
        this.change(y, x);
    },
    change: function (y, x) {
        var oldbtn = null;
        try {
            oldbtn = this.data[this.pos.y][this.pos.x];
        } catch (e) {
            oldbtn = null;
        }
        var newbtn = this.data[y][x];
        if (oldbtn === newbtn)
            return;
        if (newbtn === null)
            return;
        if (oldbtn != null) {
            if (oldbtn.Type === 1 || oldbtn.Type === 3) {
                H(oldbtn.Id);
            } else if (oldbtn.Type === 2)
                SwapImageRestore(oldbtn.Id);
            else if (oldbtn.Type == 4) {
                SwapImageRestorePos(oldbtn.Id);
            }
            if (oldbtn.OnMouseOut != "") {
                eval(oldbtn.OnMouseOut);
            }
        }
        if (newbtn.Type === 1) {
            var newObj = G(newbtn.Id);
            newObj.style.top = newbtn.Top + "px";
            newObj.style.left = newbtn.Left + "px";
            S(newbtn.Id);
        } else if (newbtn.Type === 2)
            SwapImage(newbtn.Id, newbtn.ResUrl);
        else if (newbtn.Type === 3)
            S(newbtn.Id);
        else if (newbtn.Type == 4) {
            var newObj = G(newbtn.Id);
            SwapImagePos(newbtn.Id, newbtn.ResUrl, newbtn.Top, newbtn.Left);
        }
        if (newbtn.OnMouseOver != "") {
            eval(newbtn.OnMouseOver);
        }
        this.pos.y = y;
        this.pos.x = x;


        btninfo.posy = this.pos.y;
        btninfo.posx = this.pos.x;

    },
    find: function (cury, curx, dir) {
        var check = false;
        var num = -1;
        if (dir === "y") {
            for (var i = curx - 1; i >= 0; i--) {
                if (this.data[cury][i] != null) {
                    num = i;
                    check = true;
                    break;
                }
            }
            if (!check) {
                for (var i = curx + 1; i < this.data[cury].length; i++) {
                    if (this.data[cury][i] != null) {
                        num = i;
                        check = true;
                        break;
                    }
                }
            }
        } else if (dir === "x") {
            for (var i = cury - 1; i >= 0; i--) {
                if (this.data[i][curx] != null) {
                    num = i;
                    check = true;
                    break;
                }
            }
            if (!check) {
                for (var i = cury + 1; i < this.data.length; i++) {
                    if (this.data[i][curx] != null) {
                        num = i;
                        check = true;
                        break;
                    }
                }
            }
        }
        return num;
    },
    up: function () {
        if (!btnconfig.status)
            return;
        var oldbtn = this.data[this.pos.y][this.pos.x];
        if (oldbtn != null && oldbtn.MoveUp != null && btnconfig.dirLevel === 1) {
            D(oldbtn.MoveUp);
            return;
        }
        var y = (this.pos.y - 1) < 0 ? (btnconfig.back_y === 1 ? (this.data.length - 1) : this.pos.y) : (this.pos.y - 1);
        var x = this.pos.x;

        if (y === this.pos.y && oldbtn.MoveUp != null) {
            D(oldbtn.MoveUp);
            return;
        } else if (y === this.pos.y)
            return;

        var newbtn = this.data[y][this.pos.x];

        if (newbtn === oldbtn) {
            this.pos.y = y;
            this.pos.x = x;
            this.up();
            return;
        }

        var checkY = false;
        var checkX = false;
        var skipX = false;

        var tempx = -1;
        var tempy = -1;


        if (newbtn == null) {
            if (oldbtn != null && oldbtn.MoveUp != null) {
                D(oldbtn.MoveUp);
                return;
            }
            for (var i = (this.pos.y - 1) ; i >= 0; i--) {
                if (!checkY) {
                    if (this.data[i][this.pos.x] != null) {
                        checkY = true;
                        y = i;
                    } else
                        y = -999;
                }
                if (!checkX) {
                    tempx = this.find(i, this.pos.x, "y");
                    if (tempx >= 0) {
                        tempy = i;
                        checkX = true;
                    }
                }
            }

            if (btnconfig.back_y != 1) {
                if (btnconfig.only_y != 1) {
                    if (!checkY && checkX) {
                        this.change(tempy, tempx);
                        return;
                    } else if (checkY && checkX) {
                        if (btnconfig.level_y != 1 && tempy > y) {
                            this.change(tempy, tempx);
                            return;
                        } else {
                            this.change(y, this.pos.x);
                            return;
                        }
                    } else if (checkY && !checkX) {
                        this.change(y, this.pos.x);
                        return;
                    } else {
                        return;
                    }
                } else {
                    if (checkY) {
                        this.change(y, this.pos.x);
                        return;
                    } else {
                        return;
                    }
                }
            }

            if (checkX)
                skipX = true;

            for (var i = (this.data.length - 1) ; i > this.pos.y; i--) {
                if (!checkY) {
                    if (this.data[i][this.pos.x] != null) {
                        checkY = true;
                        y = i;
                    } else
                        y = -999;
                }
                if (!checkX) {
                    tempx = this.find(i, this.pos.x, "y");
                    if (tempx >= 0) {
                        tempy = i;
                        checkX = true;
                    }
                }
            }

            if (btnconfig.only_y != 1) {
                if (!checkY && checkX) {
                    this.change(tempy, tempx);
                    return;
                } else if (checkY && checkX) {
                    if (btnconfig.level_y != 1) {
                        if (skipX && tempy < y) {
                            this.change(tempy, tempx);
                            return;
                        } else if (!skipX && tempy > y) {
                            this.change(tempy, tempx);
                            return;
                        } else {
                            this.change(y, this.pos.x);
                            return;
                        }
                    } else {
                        this.change(y, this.pos.x);
                        return;
                    }
                } else if (checkY && !checkX) {
                    this.change(y, this.pos.x);
                    return;
                } else {
                    return;
                }
            } else {
                if (checkY) {
                    this.change(y, this.pos.x);
                    return;
                }
            }

        } else {
            this.change(y, x);
        }
    },
    down: function () {
        if (!btnconfig.status)
            return;
        var oldbtn = this.data[this.pos.y][this.pos.x];
        if (oldbtn != null && oldbtn.MoveDown != null && btnconfig.dirLevel === 1) {
            D(oldbtn.MoveDown);
            return;
        }
        var y = (this.pos.y + 1) > (this.data.length - 1) ? (btnconfig.back_y === 1 ? 0 : this.pos.y) : this.pos.y + 1;
        var x = this.pos.x;

        if (y === this.pos.y && oldbtn.MoveDown != null) {
            D(oldbtn.MoveDown);
            return;
        } else if (y === this.pos.y)
            return;

        var newbtn = this.data[y][this.pos.x];

        if (newbtn === oldbtn) {
            this.pos.y = y;
            this.pos.x = x;
            this.down();
            return;
        }

        var checkY = false;
        var checkX = false;
        var skipX = false;

        var tempx = -1;
        var tempy = -1;


        if (newbtn == null) {
            if (oldbtn != null && oldbtn.MoveDown != null) {
                D(oldbtn.MoveDown);
                return;
            }

            for (var i = (this.pos.y + 1) ; i < this.data.length; i++) {
                if (!checkY) {
                    if (this.data[i][this.pos.x] != null) {
                        checkY = true;
                        y = i;
                    } else
                        y = 999;
                }
                if (!checkX) {
                    tempx = this.find(i, this.pos.x, "y");
                    if (tempx >= 0) {
                        tempy = i;
                        checkX = true;
                    }
                }
            }

            if (btnconfig.back_y != 1) {
                if (btnconfig.only_y != 1) {
                    if (!checkY && checkX) {
                        this.change(tempy, tempx);
                        return;
                    } else if (checkY && checkX) {
                        if (btnconfig.level_y != 1 && tempy < y) {
                            this.change(tempy, tempx);
                            return;
                        } else {
                            this.change(y, this.pos.x);
                            return;
                        }
                    } else if (checkY && !checkX) {
                        this.change(y, this.pos.x);
                        return;
                    } else {
                        return;
                    }
                } else {
                    if (checkY) {
                        this.change(y, this.pos.x);
                        return;
                    } else {
                        return;
                    }
                }
            }

            if (checkX)
                skipX = true;

            for (var i = 0; i < this.pos.y; i++) {
                if (!checkY) {
                    if (this.data[i][this.pos.x] != null) {
                        checkY = true;
                        y = i;
                    } else
                        y = 999;
                }
                if (!checkX) {
                    tempx = this.find(i, this.pos.x, "y");
                    if (tempx >= 0) {
                        tempy = i;
                        checkX = true;
                    }
                }
            }

            if (btnconfig.only_y != 1) {
                if (!checkY && checkX) {
                    this.change(tempy, tempx);
                    return;
                } else if (checkY && checkX) {
                    if (btnconfig.level_y != 1) {
                        if (skipX && tempy > y) {
                            this.change(tempy, tempx);
                            return;
                        } else if (!skipX && tempy < y) {
                            this.change(tempy, tempx);
                            return;
                        } else {
                            this.change(y, this.pos.x);
                            return;
                        }
                    } else {
                        this.change(y, this.pos.x);
                        return;
                    }
                } else if (checkY && !checkX) {
                    this.change(y, this.pos.x);
                    return;
                } else {
                    return;
                }
            } else {
                if (checkY) {
                    this.change(y, this.pos.x);
                    return;
                }
            }

        } else {
            this.change(y, x);
        }
    },
    left: function () {
        if (!btnconfig.status)
            return;
        var oldbtn = this.data[this.pos.y][this.pos.x];
        if (oldbtn != null && oldbtn.MoveLeft != null && btnconfig.dirLevel === 1) {
            D(oldbtn.MoveLeft);
            return;
        }
        var y = this.pos.y;
        var x = (this.pos.x - 1) < 0 ? (btnconfig.back_x === 1 ? (this.data[y].length - 1) : this.pos.x) : (this.pos.x - 1);

        if (x === this.pos.x && oldbtn.MoveLeft != null) {
            D(oldbtn.MoveLeft);
            return;
        } else if (x === this.pos.x)
            return;

        var newbtn = this.data[this.pos.y][x];

        if (newbtn === oldbtn) {
            this.pos.y = y;
            this.pos.x = x;
            this.left();
            return;
        }

        var checkY = false;
        var checkX = false;
        var skipY = false;

        var tempx = -1;
        var tempy = -1;


        if (newbtn == null) {
            if (oldbtn != null && oldbtn.MoveLeft != null) {
                D(oldbtn.MoveLeft);
                return;
            }
            for (var i = (this.pos.x - 1) ; i >= 0; i--) {
                if (!checkY) {
                    tempy = this.find(this.pos.y, i, "x");
                    if (tempy >= 0) {
                        tempx = i;
                        checkY = true;
                    }
                }

                if (!checkX) {
                    if (this.data[this.pos.y][i] != null) {
                        checkX = true;
                        x = i;
                    } else
                        x = -999;
                }

            }

            if (btnconfig.back_x != 1) {
                if (btnconfig.only_x != 1) {
                    if (!checkX && checkY) {
                        this.change(tempy, tempx);
                        return;
                    } else if (checkX && checkY) {
                        if (btnconfig.level_x != 1 && tempx > x) {
                            this.change(tempy, tempx);
                            return;
                        } else {
                            this.change(this.pos.y, x);
                            return;
                        }
                    } else if (checkX && !checkY) {
                        this.change(this.pos.y, x);
                        return;
                    } else {
                        return;
                    }
                } else {
                    if (checkX) {
                        this.change(this.pos.y, x);
                        return;
                    } else {
                        return;
                    }
                }
            }

            if (checkY)
                skipY = true;

            for (var i = (this.data[this.pos.y].length - 1) ; i > this.pos.x; i--) {
                if (!checkY) {
                    tempy = this.find(this.pos.y, i, "x");
                    if (tempy >= 0) {
                        tempx = i;
                        checkY = true;
                    }
                }

                if (!checkX) {
                    if (this.data[this.pos.y][i] != null) {
                        checkX = true;
                        x = i;
                    } else
                        x = -999;
                }
            }

            if (btnconfig.only_x != 1) {
                if (!checkX && checkY) {
                    this.change(tempy, tempx);
                    return;
                } else if (checkX && checkY) {
                    if (btnconfig.level_y != 1) {
                        if (skipY && tempx > x) {
                            this.change(tempy, tempx);
                            return;
                        } else if (!skipY && tempx < x) {
                            this.change(tempy, tempx);
                            return;
                        } else {
                            this.change(this.pos.y, x);
                            return;
                        }
                    } else {
                        this.change(this.pos.y, x);
                        return;
                    }
                } else if (checkX && !checkY) {
                    this.change(this.pos.y, x);
                    return;
                } else {
                    return;
                }
            } else {
                if (checkX) {
                    this.change(this.pos.y, x);
                    return;
                } else {
                    return;
                }
            }
        } else {
            this.change(y, x);
        }
    },
    right: function () {
        if (!btnconfig.status)
            return;
        var oldbtn = this.data[this.pos.y][this.pos.x];
        if (oldbtn != null && oldbtn.MoveRight != null && btnconfig.dirLevel === 1) {
            D(oldbtn.MoveRight);
            return;
        }
        var y = this.pos.y;
        var x = (this.pos.x + 1) > (this.data[y].length - 1) ? (btnconfig.back_x === 1 ? 0 : this.pos.x) : this.pos.x + 1;

        if (x === this.pos.x && oldbtn.MoveRight != null) {
            D(oldbtn.MoveRight);
            return;
        } else if (x === this.pos.x)
            return;

        var newbtn = this.data[this.pos.y][x];

        if (newbtn === oldbtn) {
            this.pos.y = y;
            this.pos.x = x;
            this.right();
            return;
        }

        var checkY = false;
        var checkX = false;
        var skipY = false;

        var tempx = -1;
        var tempy = -1;


        if (newbtn == null) {
            if (oldbtn != null && oldbtn.MoveRight != null) {
                D(oldbtn.MoveRight);
                return;
            }
            for (var i = (this.pos.x + 1) ; i < this.data[this.pos.y].length; i++) {
                if (!checkY) {
                    tempy = this.find(this.pos.y, i, "x");
                    if (tempy >= 0) {
                        tempx = i;
                        checkY = true;
                    }
                }

                if (!checkX) {
                    if (this.data[this.pos.y][i] != null) {
                        checkX = true;
                        x = i;
                    } else
                        x = 999;
                }
            }

            if (btnconfig.back_x != 1) {
                if (btnconfig.only_x != 1) {
                    if (!checkX && checkY) {
                        this.change(tempy, tempx);
                        return;
                    } else if (checkX && checkY) {
                        if (btnconfig.level_x != 1 && tempx < x) {
                            this.change(tempy, tempx);
                            return;
                        } else {
                            this.change(this.pos.y, x);
                            return;
                        }
                    } else if (checkX && !checkY) {
                        this.change(this.pos.y, x);
                        return;
                    } else {
                        return;
                    }
                } else {
                    if (checkX) {
                        this.change(this.pos.y, x);
                        return;
                    } else {
                        return;
                    }
                }
            }

            if (checkY)
                skipY = true;

            for (var i = 0; i < this.pos.x; i++) {
                if (!checkY) {
                    tempy = this.find(this.pos.y, i, "x");
                    if (tempy >= 0) {
                        tempx = i;
                        checkY = true;
                    }
                }

                if (!checkX) {
                    if (this.data[this.pos.y][i] != null) {
                        checkX = true;
                        x = i;
                    } else
                        x = 999;
                }
            }

            if (btnconfig.only_x != 1) {
                if (!checkX && checkY) {
                    this.change(tempy, tempx);
                    return;
                } else if (checkX && checkY) {
                    if (btnconfig.level_y != 1) {
                        if (skipY && tempx < x) {
                            this.change(tempy, tempx);
                            return;
                        } else if (!skipY && tempx > x) {
                            this.change(tempy, tempx);
                            return;
                        } else {
                            this.change(this.pos.y, x);
                            return;
                        }
                    } else {
                        this.change(this.pos.y, x);
                        return;
                    }
                } else if (checkX && !checkY) {
                    this.change(this.pos.y, x);
                    return;
                } else {
                    return;
                }
            } else {
                if (checkX) {
                    this.change(this.pos.y, x);
                    return;
                } else {
                    return;
                }
            }
        } else {
            this.change(y, x);
        }

    },
    ok: function () {
        if (!btnconfig.status) return;
        if (!enterKey) return;
        enterKey = false;
        setTimeout("enterKey=true", 300); //防止重复按键
        var btn = this.data[this.pos.y][this.pos.x];
        D(btn.Param);
    }
};


zte9.Password = zte9.pwd = {
    data: null,
    index: null,
    init: function (num) {
        this.data = new Array();
        for (var i = 0; i < num; i++) {
            this.data[i] = "";
        }
        this.index = -1;
        Box.ZERO = "javascript:zte9.pwd.pin(0)";
        Box.ONE = "javascript:zte9.pwd.pin(1)";
        Box.TWO = "javascript:zte9.pwd.pin(2)";
        Box.THREE = "javascript:zte9.pwd.pin(3)";
        Box.FOUR = "javascript:zte9.pwd.pin(4)";
        Box.FIVE = "javascript:zte9.pwd.pin(5)";
        Box.SIX = "javascript:zte9.pwd.pin(6)";
        Box.SEVEN = "javascript:zte9.pwd.pin(7)";
        Box.EIGHT = "javascript:zte9.pwd.pin(8)";
        Box.NINE = "javascript:zte9.pwd.pin(9)";
        Box.BACK = "javascript:zte9.pwd.pout()";

    },
    pin: function (num) {
        if (this.index === -1)
            return;
        if (this.data[this.index].length < 11) {
            G("divPwd" + this.index).innerHTML += num;
            this.data[this.index] += num;
            G("selMobile").style.left = parseInt(G("selMobile").style.left) + 15 + "px";
        }
    },
    pout: function () {
        if (this.index === -1)
            return;
        if (this.data[this.index].length > 0) {
            var html = G("divPwd" + this.index).innerHTML;
            G("divPwd" + this.index).innerHTML = html.substring(0, html.length - 1);
            this.data[this.index] = this.data[this.index].substring(0, this.data[this.index].length - 1);
            G("selMobile").style.left = parseInt(G("selMobile").style.left) - 15 + "px";
        }
    },
    chang: function (num) {
        this.index = num;
    },
    check: function () {
        var message = "";
        if (this.data[0].length < 6 || this.data[0].length > 8)
            message = "密码不正确，请重新输入";
        else {
            if (this.data.length == 2 && this.data[0] != this.data[1]) {
                message = "两次密码输入不一致，请重新输入";
            }
            else if (this.data.length == 3 && this.data[1] != this.data[2]) {
                message = "两次密码输入不一致，请重新输入";
            }
            else if (this.data.lenth == 3 && (this.data[1].length < 6 || this.data[i].length > 8)) {
                message = "密码不正确，请重新输入";
            }
        }
        return message;
    },
    submit: function () {
        if (G("action").value == "") {
            G("action").value = "do";
            for (var i = 0; i < this.data.length; i++) {
                G("pwd" + i).value = this.data[i];
            }
            window.form1.submit();
        }
    }
};


zte9.Search = zte9.srch = {
    data: null,
    index: null,
    init: function (num) {
        this.data = new Array();
        for (var i = 0; i < num; i++) {
            this.data[i] = "";
            G("divSearch" + i).innerHTML = "";
        }
        this.index = -1;
    },
    sin: function (svalue) {
        if (this.index === -1)
            return;
        if (this.data[this.index].length < 25) {
            G("divSearch" + this.index).innerHTML += svalue;
            this.data[this.index] += svalue;
        }
    },
    sclear: function () {
        if (this.index === -1)
            return;
        if (this.data[this.index].length > 0) {
            G("divSearch" + this.index).innerHTML = "";
            this.data[this.index] = "";
        }
    },
    change: function (num) {
        this.index = num;
    },
    check: function () {
        var message = "";
        if (this.data[0].length < 1)
            message = "请输入查询条件";
        return message;
    },
    submit: function () {
        if (G("action").value === "") {
            G("action").value = "do";
            for (var i = 0; i < this.data.length; i++) {
                G("srch" + i).value = this.data[i];
            }
            window.form1.submit();
        }
    }
}

zte9.Page = zte9.page = {
    data: null,
    pageUrl: null,
    init: function (info, url, divPage) {
        this.data = info;
        if (info.TotalPage == 1) {
            //H("imgPre");
            //H("imgNext");
            H("divPage");
            return;
        }
        if (url.indexOf("?") > -1) {
            url += "&";
        } else {
            url += "?";
        }
        this.pageUrl = url + "pageindex=";
        G(divPage).innerHTML = "第 " + this.data.PageIndex + " / " + this.data.TotalPage + " 页";
    },
    pre: function () {
        var pageIndex = this.data.PageIndex;
        var totalPage = this.data.TotalPage;

        if (totalPage === 1)
            return;

        var curPage = pageIndex - 1;
        curPage = curPage < 1 ? totalPage : curPage;
        J(this.pageUrl + curPage);
    },
    next: function () {
        var pageIndex = this.data.PageIndex;
        var totalPage = this.data.TotalPage;

        if (totalPage === 1)
            return;
        var curPage = pageIndex + 1;
        curPage = curPage > totalPage ? 1 : curPage;
        J(this.pageUrl + curPage);
    },
}

zte9.Mp = zte9.mp = {
    speed: 1,	    // 正常播放速度
    state: 'play', 	// play-播放,pause-暂停,fastForward-快进,fastRewind-快退
    mute: 0,		// 0-有声,1-静音


    init: function (rtspUrl) {
        mp = new MediaPlayer();
        var instanceId = mp.createPlayerInstance("Video", 2);
        mp.Position = "1,0,0,0,0"; //表示视频将全屏播放 "IsFullScreen,x,y,width,height"
        mp.source = rtspUrl;
        mp.play();
    },

    /** 暂停 */
    pause: function (callback) {
        if (this.state == 'play') {
            this.speed = 1;
            this.state = 'pause';
            mp.pause(1);
            zte9.call(callback, [this.state, this]);
        }
    },

    /** 播放*/
    play: function (callback) {
        if (this.state == 'play')
            return;
        if (this.state == 'pause') {
            this.state = 'play';
            mp.play();
        }
        else {
            this.state = 'play';
            this.speed = 1;
            mp.pace = this.speed;
            mp.refresh();
        }
        zte9.call(callback, [this.state, this]);
    },

    /** 播放或暂停 */
    playOrPause: function (callback) {
        if (this.state == 'play')
            this.pause();
        else
            this.play();
        zte9.call(callback, [this.state, this]);
    },

    /** 快进 */
    fastForward: function (callback) {
        if (this.state == 'pause')
            return;
        if (this.state == 'fastRewind') {
            this.speed = 2;
            this.state = 'fastForward';
        }
        else {
            this.speed = this.speed >= 32 ? 2 : this.speed * 2;
            this.state = 'fastForward';
        }
        mp.pace = this.speed;
        mp.refresh();
        zte9.call(callback, [this.state, this.speed, this]);
    },

    /** 快退 */
    fastRewind: function (callback) {
        if (this.state == 'pause')
            return;

        if (this.state == 'fastForward') {
            this.speed = 2;
            this.state = 'fastRewind';
        }
        else {
            this.speed = this.speed >= 32 ? 2 : this.speed * 2;
            this.state = 'fastRewind';
        }
        mp.pace = -this.speed;
        mp.refresh();
        zte9.call(callback, [this.state, this.speed, this]);
    },

    /** 调大声音 */
    volUp: function (callback) {
        var volume = (+DataAccess.getInfo("MediaSetting", "OutputVolumn")) + 4;
        volume = volume > 32 ? 32 : volume;
        DataAccess.setInfo("MediaSetting", "OutputVolumn", volume);
        zte9.call(callback, [volume, this]);
    },

    /** 调小声音 */
    volDown: function (callback) {
        var volume = (+DataAccess.getInfo("MediaSetting", "OutputVolumn")) - 4;
        volume = volume < 0 ? 0 : volume;
        DataAccess.setInfo("MediaSetting", "OutputVolumn", volume);
        zte9.call(callback, [volume, this]);
    },

    /** 开启或关闭声音 */
    toggleMuteFlag: function (callback) {
        ++this.mute;
        var flag = this.mute % 2 == 0 ? true : false; //true解除静音false静音
        if (flag) {
            mp.audioUnmute();
        }
        else {
            mp.audioMute();
        }
        zte9.call(callback, [flag, this]);
    },

    destrory: function () {
        mp.pause(0);
        var aa = mp.releasePlayerInstance();
        aa = mp.unBindPlayerInstance();
        SysSetting.clearIframe();
    }

}

var $ = {
    //获取url参数
    getUrlParam: function (name) {
        var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
        var r = window.location.search.substr(1).match(reg);
        if (r != null) return unescape(r[2]); return null;
    },

    //class相关
    hasClass: function (id, cls) {
        return G(id).className.match(new RegExp('(\\s|^)' + cls + '(\\s|$)'));
    },
    addClass: function (id, cls) {
        if (!this.hasClass(id, cls))
            G(id).className += ' ' + cls;
    },
    removeClass: function (id, cls) {
        if (this.hasClass(id, cls)) {
            var reg = new RegExp('(\\s|^)' + cls + '(\\s|$)');
            G(id).className = G(id).className.replace(reg, '');
        }
    },
    subTJDesc:function(str){
        if (str.length > 19) {
            str = str.substr(0, 19) + "...";
        }
        return str;
    },
    //ajax相关
    _createAjax: function () {
        if (window.ActiveXObject) {
            return new ActiveXObject("Microsoft.XMLHTTP");
        }
        else if (window.XMLHttpRequest) {
            return new XMLHttpRequest();
        }
        return null;
    },
    _params: function (data) {
        var arr = [];
        for (var i in data) {
            arr.push(encodeURIComponent(i) + "=" + encodeURIComponent(data[i]));
        }
        return arr.join("&");
    },
    _ajax_callBack: function (xhr, dataType, done, fail) {
        if (xhr.status == 200) {
            if (dataType == 'TEXT') {
                if (done) {		//普通文本
                    done(xhr.responseText, xhr.messageText);
                }
            } else if (dataType == 'XML') {
                if (done != null) {		//接收xml文档
                    done(xhr.responseXML);
                }
            } else if (dataType == 'JSON') {
                if (done != null) {
                    //将json字符串转换为js对象
                    done(eval("(" + xhr.responseText + ")"));
                    //alert(xhr.responseText);
                }
            }
        } else {
            if (fail) {
                fail(xhr.status, xhr.statusText);
            }
        }
    },
    ajax: function (conf) {
        var self = this,
			type = conf.type ? conf.type.toUpperCase() : 'GET',			//type参数,可选 
			async = conf.async,
			url = conf.url,						//url参数，必填 
			data = self._params(conf.data),			//data参数可选，只有在post请求时需要 
			dataType = conf.dataType ? conf.dataType.toUpperCase() : 'JSON',	//datatype参数可选 
			success = conf.success,
			error = conf.error,
			xhr = self._createAjax();

        if (type === 'GET') {
            url += url.indexOf('?') < 0 ? '?' + data : '&' + data;
        }

        xhr.open(type, url, async);
        if (type == 'GET') {
            xhr.send(null);
        }
        else if (type == 'POST') {
            //xhr.setRequestHeader("content-type", "application/x-www-form-urlencoded");
            xhr.send(data);
        }

        if (async) {	//异步
            xhr.onreadystatechange = function () {
                if (xhr.readyState == 4) {
                    self._ajax_callBack(xhr, dataType, success, error);
                }
            }
        }
        else {
            self._ajax_callBack(xhr, dataType, success, error);
        }
    }
}

