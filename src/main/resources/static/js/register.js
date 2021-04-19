(function () {
    var Dom = {
        username: $("#username"),// 用户名
        password: $("#password"),//用户密码
        passwordConfirm: $("#passwordConfirm"),//用户密码
        register: $("#register"),
        username_warn: $("#username_warn"),
        password_warn: $("#password_warn"),
        passwordConfirm_warn: $("#passwordConfirm_warn")
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
        Dom.passwordConfirm.blur(function () {
            if (Dom.passwordConfirm.val() == "") {
                Dom.passwordConfirm_warn.html("用户密码不能为空");
                Dom.passwordConfirm_warn.css("display", "block");
            } else if (Dom.passwordConfirm.val() != Dom.password.val()) {
                Dom.passwordConfirm_warn.html("两次输入密码不一致,请确认");
                Dom.passwordConfirm_warn.css("display", "block");
            }
        });
        Dom.passwordConfirm.bind('input propertychange', function () {
            if (Dom.passwordConfirm.val() != "") {
                Dom.passwordConfirm_warn.html("");
                Dom.passwordConfirm_warn.css("display", "none");
            }
        });
        Dom.register.click(function () {
            var username = Dom.username.val();
            var password = Dom.password.val();
            var passwordConfirm = Dom.passwordConfirm.val();
            if (username == "") {
                Dom.username_warn.html("用户名不能为空");
                Dom.username_warn.css("display", "block");
                return;
            } else if (password == "") {
                Dom.password_warn.html("用户密码不能为空");
                Dom.password_warn.css("display", "block");
                return;
            } else if (passwordConfirm == "") {
                Dom.passwordConfirm_warn.html("用户密码不能为空");
                Dom.passwordConfirm_warn.css("display", "block");
                return;
            } else if (passwordConfirm != password) {
                Dom.passwordConfirm_warn.html("两次输入密码不一致,请确认");
                Dom.passwordConfirm_warn.css("display", "block");
                return;
            }
            alert("用户名：" + username + "   " + "用户密码：" + password);
        });
    }

    main();
})();



