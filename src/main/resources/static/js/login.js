(function () {
    var Dom = {
        username: $("#username"),// 用户名
        password: $("#password"),//用户密码
        login: $("#login"),
        username_warn: $("#username_warn"),
        password_warn: $("#password_warn")
    }

    function main() {
        eventHandler();
    }

    function initCss() {
        Dom.orderManageItem.css("display", "flex");
        Dom.peopleManageItem.css("display", "none");
        Dom.businessManageItem.css("display", "none");
    }

    function eventHandler() {
        Dom.username.blur(function () {
            if (Dom.username.val() == "") {
                Dom.username_warn.html("用户名不能为空");
                Dom.username_warn.css("display", "block");
            }
        });
        Dom.username.bind('input propertychange', function () {
            if (Dom.username.val() != "") {
                Dom.username_warn.html("");
                Dom.username_warn.css("display", "none");
            }
        });
        Dom.password.blur(function () {
            if (Dom.password.val() == "") {
                Dom.password_warn.html("用户密码不能为空");
                Dom.password_warn.css("display", "block");
            }
        });
        Dom.password.bind('input propertychange', function () {
            if (Dom.password.val() != "") {
                Dom.password_warn.html("");
                Dom.password_warn.css("display", "none");
            }
        });
        Dom.login.click(function () {
            var username = Dom.username.val();
            var password = Dom.password.val();
            if (username == "") {
                Dom.username_warn.html("用户名不能为空");
                Dom.username_warn.css("display", "block");
                return;
            } else if (password == "") {
                Dom.password_warn.html("用户密码不能为空");
                Dom.password_warn.css("display", "block");
                return;
            }
            // alert("用户名："+username+"   "+"用户密码："+password);

            var dialog = $.dialog();
            dialog.show();
            setTimeout(function () {
                dialog.close();
                window.location.href = "index.html";
            }, 3000);
        });
    }

    main();
})();



