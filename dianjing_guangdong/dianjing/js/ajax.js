//ajax方法
function myAjax(type, url, data, callback1, callback2, isAsync) {
    var async = (typeof isAsync != 'undefined') ? isAsync : false;
    $.ajax({
        async: async,
        type: type,
        url: url,
        data: data,
        contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
        success: function (json) {
            if (callback1 != '') { callback1(json); }
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            if (callback2 != '') { callback2(XMLHttpRequest, textStatus, errorThrown); }
        }
    });
}
// var ip=118+"."+190+"."+65+"."+84+":"+5600+"/gdgdGaming_api";
// var ip=115+"."+28+"."+228+"."+74+":"+5522+"/hnmgGaming_api";
var ip=183+"."+234+"."+214+"."+6+":"+8082+"/gdydGaming_api";

var DJCategory = {
    shouye: { "typeCode": '100110001000', "typeName": "首页" },
    saishi: { "typeCode": '100710001000', "typeName": "精彩赛事" },
    youxi: { "typeCode": '100310001000', "typeName": "热门游戏" },
    zhubo: { "typeCode": '100810001000', "typeName": "知名主播" },
    zhongyi: { "typeCode": '100510001000', "typeName": "电竞综艺" }
};

//接口方法
var djAPI = {
    //获取一级分类下二级分类列表
    getSubCategory: function (data, callback1, callback2, isAsync) {
        var url = 'http://'+ip+'/musicCategory/getCategory';
        myAjax('GET', url, data, callback1, callback2, isAsync);
    },
    //获取首页推荐位列表
    getShouYeAPI: function (data, callback1, callback2, isAsync) {
        var url = 'http://'+ip+'/music/hot';
        myAjax('GET', url, data, callback1, callback2, isAsync);
    },
    //获取精彩赛事推荐位列表
    getSaiShiAPI: function (data, callback1, callback2, isAsync) {
        var url = 'http://'+ip+'/music/ktv';
        myAjax('GET', url, data, callback1, callback2, isAsync);
    },
    //获取热门游戏推荐位列表
    getYouXiAPI: function (data, callback1, callback2, isAsync) {
        var url = 'http://'+ip+'/music/mv';
        myAjax('GET', url, data, callback1, callback2, isAsync);
    },
    //获取知名主播推荐位列表
    getZhuBoAPI: function (data, callback1, callback2, isAsync) {
        var url = 'http://'+ip+'/music/concert';
        myAjax('GET', url, data, callback1, callback2, isAsync);
    },
    //获取电竞综艺推荐位列表
    getZhongYiAPI: function (data, callback1, callback2, isAsync) {
        var url = 'http://'+ip+'/music/child';
        myAjax('GET', url, data, callback1, callback2, isAsync);
    },
    //获取推荐位为列表的详细信息
    getDetailListAPI: function (data, callback1, callback2, isAsync) {
        var url = 'http://'+ip+'/musicRecommd/detail/musicList';
        myAjax('GET', url, data, callback1, callback2, isAsync);
    },
    //搜索
    getSearchAPI: function (data, callback1, callback2, isAsync) {
        var url = 'http://'+ip+'/music/serachMusicInfo';
        myAjax('GET', url, data, callback1, callback2, isAsync);
    },
    //挽留
    getWanLiuAPI: function (data, callback1, callback2, isAsync) {
        var url = 'http://'+ip+'/music/pic/staypic';
        myAjax('GET', url, data, callback1, callback2, isAsync);
    },
    //启动图
    getStartPic: function (data, callback1, callback2, isAsync) {
        var url = 'http://'+ip+'/music/pic/backpic';
        myAjax('GET', url, data, callback1, callback2, isAsync);
    }
};

var userAPI = {
    userInfo: function (data, callback1, callback2, isAsync) {
        var url = 'http://'+ip+'/user/selectUserInfo';
        myAjax('GET', url, data, callback1, callback2, isAsync);
    },
    userSaveTel: function (data, callback1, callback2, isAsync) {
        var url = 'http://'+ip+'/user/saveUserTelephone';
        myAjax('GET', url, data, callback1, callback2, isAsync);
    },
    userSaveCollect: function (data, callback1, callback2, isAsync) {
        var url = 'http://'+ip+'/user/saveCollection';
        myAjax('GET', url, data, callback1, callback2, isAsync);
    },
    userDelCollect: function (data, callback1, callback2, isAsync) {
        var url = 'http://'+ip+'/user/deleteCollection';
        myAjax('GET', url, data, callback1, callback2, isAsync);
    },
    userSavePlayRecord: function (data, callback1, callback2, isAsync) {
        var url = 'http://'+ip+'/stat/music/play';
        myAjax('GET', url, data, callback1, callback2, isAsync);
    },
    userPlayRecord: function (data, callback1, callback2, isAsync) {
        var url = 'http://'+ip+'/stat/music/selectVideoPlayHistory';
        myAjax('GET', url, data, callback1, callback2, isAsync);
    },
    userCollect: function (data, callback1, callback2, isAsync) {
        var url = 'http://'+ip+'/user/selectMusicCollection';
        myAjax('GET', url, data, callback1, callback2, isAsync);
    }
}

//获取一级分类下二级分类
function InitSubCategory(_data) {
    var jsonData = null;
    djAPI.getSubCategory(_data, function (json) {
        jsonData = json.data.musicCategory;
    });
    return jsonData;
}
//首页推荐位列表
function InitShoYe() {
    // alert(111);
    var epgJson;
    // if (typeof epgJson == 'undefined') {
    //     alert(222);
        var data = { typeCode: DJCategory.shouye.typeCode };
        djAPI.getShouYeAPI(data, function (json) {
            epgJson = json.data;
            store.set("ShouYe", epgJson);
            epgJson = store.get("ShouYe");
            // alert('tuiJianJsonAll:'+ JSON.stringify(json));
        });
    // }
    return epgJson;
}
//赛事推荐列表
function InitSaiShi(_typeCode) {
    var epgJson = store.get(_typeCode);
    if (typeof epgJson == 'undefined') {
        var data = { typeCode: _typeCode };
        djAPI.getSaiShiAPI(data, function (json) {
            epgJson = json.data.musicRecommed;
            store.set(_typeCode, epgJson);
        });
    }
    return epgJson;
}
//热门游戏推荐列表
function InitHotGame(_typeCode) {
    var epgJson = store.get(_typeCode);
    if (typeof epgJson == 'undefined') {
        var data = { typeCode: _typeCode };
        djAPI.getYouXiAPI(data, function (json) {
            epgJson = json.data.musicRecommed;
            store.set(_typeCode, epgJson);
        });
    }
    return epgJson;
}
//主播推荐位列表
function InitZhuBo() {
    var epgJson = store.get("ZhuBo");
    if (typeof epgJson == 'undefined') {
        var data = { typeCode: DJCategory.zhubo.typeCode };
        djAPI.getZhuBoAPI(data, function (json) {
            epgJson = json.data;
            store.set("ZhuBo", json.data);
        });
    }
    return epgJson;
}
//电竞综艺推荐列表
function InitZongYi(_typeCode) {
    store.clear();
    var epgJson = store.get(_typeCode);
    if (typeof epgJson == 'undefined') {
        var data = { typeCode: _typeCode };
        djAPI.getZhongYiAPI(data, function (json) {
            epgJson = json.data.musicRecommed;
            store.set(_typeCode, epgJson);
        });
    }
    return epgJson;
}
//列表页详情
function InitDetailList(_data) {
    var epgJson = null;
    djAPI.getDetailListAPI(_data, function (json) {
        epgJson = json.data;
    });
    return epgJson;
}
//查询
function Search(page, rows, firstLetter, userId) {
    var epgJson = null;
    var data = {
        page: page,
        rows: rows,
        firstLetter: firstLetter,
        userId: userId
    };
    djAPI.getSearchAPI(data, function (json) {
        epgJson = json.data;
    });
    return epgJson;
}
//获取换留页推荐
function InitWanLiu() {
    var epgJson = store.get("WanLiu");
    if (typeof epgJson == 'undefined') {
        var data = { "userId": "jsUser" };
        djAPI.getWanLiuAPI(null, function (json) {
            epgJson = json.data.musicRecommed;
            store.set("WanLiu", epgJson);
        });
    }
    return epgJson;
}
//启动图
function InitStartPic() {
    var epgJson = store.get("StartPic");
    if (typeof epgJson == 'undefined') {
        djAPI.getStartPic(null, function (json) {
            epgJson = json.data;
            store.set("StartPic", epgJson);
        });
    }
    return epgJson;
}




//获取用户帐号和手机号
function InitUserInfo() {
    var userInfo = null;
    var data = { "userId": "jsUser" };
    userAPI.userInfo(data, function (json) {
        userInfo = json.data;
    });
    return userInfo;
}
//保存用户手机号码
function SaveUserTel(phone) {
    var result = false;
    var data = { "userId": "jsUser", "phone": phone };
    userAPI.userSaveTel(data, function (json) {
        result = json.success;
    });
    return result;
}
//用户播放记录
function InitPlayRecord(_data) {
    var epgJson = null;
    userAPI.userPlayRecord(_data, function (json) {
        epgJson = json.data;
    });
    return epgJson;
}
//用户收藏列表
function InitUserCollect(_data) {
    var epgJson = null;
    userAPI.userCollect(_data, function (json) {
        epgJson = json.data;
    });
    return epgJson;
}
//保存播放记录
function SavePlayRecord(data) {
    var result = false;
    userAPI.userSavePlayRecord(data, function (json) {
        result = json.success;
    });
    return result;
}
//收藏
function SaveCollect(data) {
    var result = false;
    userAPI.userSaveCollect(data, function (json) {
        result = json.success;
    });
    return result;
}
//取消收藏
function DelCollect(data) {
    var result = false;
    userAPI.userDelCollect(data, function (json) {
        result = json.success;
    });
    return result;
}
















