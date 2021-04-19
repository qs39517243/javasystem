var Utils = (function () {

    var baseUrl = "http://127.0.0.1/cms/";

    var StorageGetter = function (key) {
        return localStorage.getItem(prefix + key);
    }
    var StorageSetter = function (key, val) {
        return localStorage.setItem(prefix + key, val);
    }
    var getBaseUrl = function () {
        return baseUrl;
    }
    //判断终端是ios还是android
    var getPhoneType = function () {
        var u = navigator.userAgent;
        var isAndroid = u.indexOf('Android') > -1 || u.indexOf('Adr') > -1; //android终端
        var isiOS = !!u.match(/\(i[^;]+;( U;)? CPU.+Mac OS X/); //ios终端
        if (isAndroid) {
            return "android";
        }
        if (isiOS) {
            return "ios";
        }
        return false;
    }
    var SendRequest = function (params, successFunction, URL) {
        var dialog = $.dialog();
        $.ajax({
            type: "post",
            contentType: "application/x-www-form-urlencoded;charset=utf-8",
            dataType: "jsonp",
            jsonp: "jsonpStr",
            url: Utils.getBaseUrl() + URL,
            data: params,
            beforeSend: function () {
                dialog.show();
            },
            success: function (data) {
                dialog.close();
            },
            error: function (errorData) {
                dialog.close();
            },
            complete: function () {
                dialog.close();
            }
        });
    }

    return {
        StorageGetter: StorageGetter, //本地取
        StorageSetter: StorageSetter, //本地存
        getBaseUrl: getBaseUrl,
        SendRequest: SendRequest, //接口请求公共方法
        getPhoneType: getPhoneType//判断终端类型
    }
})();
