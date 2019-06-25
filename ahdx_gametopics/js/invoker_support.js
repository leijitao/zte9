
var AndroidInvoker = window.AndroidInvoker || {
    /*
     * 将日志输出到Android的#android.util.Log.v;
     */
    log:function(tag, msg){ },
    selfDefinedOnBackPressed:function(yes){ },
    invoke:function(jsintent) { return "{}";},
    screenWidth:function() { return 1280; },
    screenHeight:function() { return 720; }
 };

/*
 * 接口版本号
 */
AndroidInvoker.SDK_INT = 1;

/*
 * 调试追踪接口，在文档窗口输出文本
 */
AndroidInvoker.trace = function(text) {
    document.write(text);
}

/*
 * 调试追踪接口，在文档窗口输出文本并换行
 */
AndroidInvoker.traceln = function(text) {
    AndroidInvoker.trace(text + "<br/>");
}

AndroidInvoker.toString = function() {
    return "[AndroidInvoker]";
}

AndroidInvoker.JSIntent = function(name) {
    this.name = name;
    this.extras = { };
    this.getName = function() {
        return this.name;
    }
    this.getExtra = function(name) {
        return this.extras[name];
    }
    this.putExtra = function(name, value) {
        this.extras[name] = value;
    }
    this.startInvoke = function() {
        var result = AndroidInvoker.invoke(JSON.stringify(this));
        var resultJSIntent = new AndroidInvoker.JSIntent();
        var json = JSON.parse(result);
        resultJSIntent.extras = json.extras;
        return resultJSIntent;
    }
    this.toString = function() {
        return "[AndroidInvoker.JSIntent" + JSON.stringify(this) + "]";
    }
}

AndroidInvoker.SUPPORT_EVENT = {
    /*
     * 窗口返回键事件监听器
     */
    onBack:function() { }
 };
AndroidInvoker.SUPPORT_CALLBACK = {
    /*
     * 卸载应用回调接口，
     * @param pkg - string类型，被卸载应用的包名，
     * @param result - boolean类型，是否卸载成功
     */
    onUninstall:function(pkg, result) { }
};

/*
 * 为事件绑定监听器
 * @param name - string类型，事件名称
 * @param fun - function类型，事件监听器函数
 * 如：自定义返回键事件监听器，
 * AndroidInvoker.event("onBack", function() {
 *     document.write("返回建按下！");
 * });
 */
AndroidInvoker.event = function(name, fun) {
    AndroidInvoker.SUPPORT_EVENT[name] = fun;
    if ("onBack" === name) {
        AndroidInvoker.selfDefinedOnBackPressed(true);
    }
}
/*
 * 为动作指定回调监听器
 * @param name - string类型，回调动作名称
 * @param fun - function类型，回调动作监听器函数
 * 如：自定义卸载应用回调监听器，
 * AndroidInvoker.callback("onUninstall", function(pkg, result) {
 *     if (result) {
 *         document.write("应用:" + pkg + "卸载成功！");
 *     } else {
 *         document.write("应用:" + pkg + "卸载失败！");
 *     }
 * });
 */
AndroidInvoker.callback = function(name, fun) {
    AndroidInvoker.SUPPORT_CALLBACK[name] = fun;
}

/*
 * 弹窗打开指定的 url，
 * @param url - 网页地址，必传
 * @param width - 弹窗的宽
 * @param height - 弹窗的高
 */
AndroidInvoker.popupWindow = function(url, width, height) {
    var jsIntent = new AndroidInvoker.JSIntent("popup_window");
    jsIntent.putExtra("url", url);
    jsIntent.putExtra("width", width);
    jsIntent.putExtra("height", height);
    jsIntent.startInvoke();
}
/*
 * 关闭当前页面的窗口
 */
AndroidInvoker.closeSelfWindow = function() {
    var jsIntent = new AndroidInvoker.JSIntent("close_self_window");
    jsIntent.startInvoke();
}

/*
 * 关闭当前app
 */
AndroidInvoker.closeAppWindow = function() {
    var jsIntent = new AndroidInvoker.JSIntent("close_app_window");
    jsIntent.startInvoke();
}

/*
 * 清理缓存
 */
AndroidInvoker.cleanCache = function() {
    var jsIntent = new AndroidInvoker.JSIntent("clear_cache");
    jsIntent.startInvoke();
}

/*
 * 卸载指定包名的应用，
 * 接收执行结果请使用AndroidInvoker.callback（"onUninstall", function(pkg, result){}）
 */
AndroidInvoker.uninstallApp = function(pkg) {
    var jsIntent = new AndroidInvoker.JSIntent("uninstall_app");
    jsIntent.putExtra("package_name", pkg);
    jsIntent.startInvoke();
}

/*
 * 跳转到查找游戏页面
 */
AndroidInvoker.gotoSearchGame = function() {
    var jsIntent = new AndroidInvoker.JSIntent("goto_search_game");
    jsIntent.startInvoke();
}

/*
 * 使用包名获取已安装的应用信息
 */
AndroidInvoker.getInstalledAppInfo = function(packageName) {
    var jsIntent = new AndroidInvoker.JSIntent("get_installed_app_info");
    jsIntent.putExtra("package_name", packageName);
    return jsIntent.startInvoke().extras;
}

/*
 * 获取设备信息
 */
AndroidInvoker.getDeviceInfo = function() {
    var jsIntent = new AndroidInvoker.JSIntent("get_device_info");
    return jsIntent.startInvoke().extras;
}

/*
 * 显示一条Toast
 */
AndroidInvoker.showToast = function(text) {
    var jsIntent = new AndroidInvoker.JSIntent("show_toast");
    jsIntent.putExtra("text", text);
    jsIntent.startInvoke();
}

/*
 * 使用 appId 跳转到APP详情页  根据游戏id跳转到相应的游戏
 */
AndroidInvoker.gotoAppDetails = function(appId) {
    var jsIntent = new AndroidInvoker.JSIntent("goto_app_details_page");
    jsIntent.putExtra("app_id", appId);
    jsIntent.startInvoke();
    console.log("Calling method gotoAppDetails appId"+appId)
}

/*
 * 使用 appId 启动ＡＰＰ
 */
AndroidInvoker.startupGameByAppId = function(appId) {
    var jsIntent = new AndroidInvoker.JSIntent("startup_game_by_app_id");
    jsIntent.putExtra("app_id", appId);
    jsIntent.startInvoke();
}

/*
 * 启动已安装的应用
 */
AndroidInvoker.startupInstalledApp = function(packageName) {
    var jsIntent = new AndroidInvoker.JSIntent("startup_installed_app");
    jsIntent.putExtra("packageName", packageName);
    jsIntent.startInvoke();
}

/*
 * 设置导航栏可见性
 */
AndroidInvoker.setNavigationBarVisible = function(visible) {
    var jsIntent = new AndroidInvoker.JSIntent("set_navigation_bar_visible");
    jsIntent.putExtra("visible", visible);
    jsIntent.startInvoke();
}

/*
 * 启动 action 指定的android 活动页面
 * @param activity - 活动全类名
 * @param transferData － 活动启动参数数据
 */
AndroidInvoker.startActivityForAndroid = function(activity, transferData) {
    var jsIntent = new AndroidInvoker.JSIntent("start_activity_for_android");
    jsIntent.putExtra("action", activity);
    jsIntent.putExtra("transferData", transferData);
    jsIntent.startInvoke();
}
