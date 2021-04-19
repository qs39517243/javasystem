(function () {
    var Dialog = function (config) {
        var _this_ = this;
        //参数的配置
        this.config = {
            //对话框的宽
            width: "auto",
            height: "auto",
            //对话框的提示信息
            message: null,
            //对话框类型
            type: "waiting",
            //按钮配置
            buttons: null,
            //弹出框延迟多久关闭
            delay: null,
            //对话框遮罩透明度
            maskOpacity: null,
            effect: null
        }
        //默认扩展参数
        if (config && $.isPlainObject(config)) {
            $.extend(this.config, config);
        } else {
            this.isConfig = true;
        }
        //创建基本的DOM
        this.body = $("body");
        //创建遮罩层
        this.mask = $('<div class="g-dialog-contianer">');
        //创建弹出框
        this.win = $('<div class="dialog-window"></div>');
        //创建弹出框头部
        this.winHeader = $('<div class="dialog-header"></div>');
        //创建提示信息
        this.winContent = $('<div class="dialog-content"></div>');
        //创建弹出框按钮组
        this.winFooter = $('<div class="dialog-footer"></div>');
        //渲染Dom
        /*this.create();*/

    }
    Dialog.prototype = {
        animate: function () {
            var _this_ = this;
            this.win.css("-webkit-transform", "scale(0,0)");
            setTimeout(function () {
                _this_.win.css("-webkit-transform", "scale(1,1)");
            }, 100)
        },
        create: function () {
            //alert(1)
            var _this_ = this;
            config = this.config;
            mask = this.mask;
            win = this.win;
            header = this.winHeader;
            content = this.winContent;
            footer = this.winFooter;
            body = this.body;
            //如果没有传递任何配置参数 就弹出一个loading框
            if (this.isConfig) {
                //alert(2)
                win.append(header.addClass("waiting"));
                if (config.effect) {
                    this.animate()
                }
                mask.append(win);
                body.append(mask);
                //alert(3)
            } else {
                //根据配置参数创建相应的弹框
                //header.addClass(config.type)
                header.addClass("waiting")
                win.append(header)
                if (config.message) {
                    win.append(content.html(config.message));
                }
                //按钮组
                if (config.buttons) {
                    this.createButtons(footer, config.buttons);

                    win.append(footer);
                }
                //设置对话框的宽高
                if (config.width != "auto") {
                    win.width(config.width);
                }
                if (config.height != "auto") {
                    win.width(config.height);
                }
                //对话框遮罩透明度
                if (config.maskOpacity) {
                    mask.css("backgroundColor", "rgba(0,0,0," + config.maskOpacity + ")");

                }
                //设置谈出口弹出后多久关闭
                if (config.delay && config.delay != 0) {
                    window.setTimeout(function () {
                        _this_.close();
                    }, config.delay)
                }
                //设置动画
                if (config.effect) {
                    this.animate()
                }
                //插入到页面
                mask.append(win)
                body.append(mask)

            }
        },
        //创建按钮组
        createButtons: function (footer, buttons) {
            var _this_ = this;
            $(buttons).each(function () {
                //获取按钮的样式
                var type = this.type ? " class='" + this.type + "'" : "";
                var btnText = this.text ? this.text : "";
                var callback = this.callback ? this.callback : null;
                var button = $("<button" + type + ">" + btnText + "</button>");
                if (callback) {
                    button.click(function () {
                        var isClose = callback();
                        if (isClose != false) {
                            _this_.close();
                        }
                    })
                } else {
                    button.click(function () {
                        _this_.close();
                    })
                }
                footer.append(button)
            })
        },
        show: function () {
            this.create();
        },
        close: function () {
            this.mask.remove();
        }

    }
    window.Dialog = Dialog;
    $.dialog = function (config) {
        return new Dialog(config)
    }
})();