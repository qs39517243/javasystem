// (function() {
// 	var Dom = {
// 		homepage: $("#homepage"),// tab-homepage
// 		order:$("#order"),//tab-order
// 		people:$("#people"),//tab-people
// 		business:$("#business"),//tab-business
// 		orderManage:$("#orderManage"),//订单管理子标题
// 		orderManageItem:$("#orderManageItem"),
// 		peopleManage:$("#peopleManage"),//人事管理子标题
// 		peopleManageItem:$("#peopleManageItem"),
// 		businessManage:$("#businessManage"),//公司管理子标题
// 		businessManageItem:$("#businessManageItem"),
// 		exit:$("#exit"),//退出
// 		//订单管理子项目
// 		order_select:$("#order_select"),
// 		order_add:$("#order_add"),
// 		order_manage:$("#order_manage"),
// 		//人事管理子项目
// 		people_select:$("#people_select"),
// 		people_add:$("#people_add"),
// 		people_manage:$("#people_manage"),
// 		//公司管理子项目
// 		business_select:$("#business_select"),
// 		business_add:$("#business_add"),
// 		business_manage:$("#business_manage"),
//
// 		iframe:$("#iframe")
// 	}
// 	function main(){
// 		initCss();
// 		eventHandler();
// 	}
// 	function initCss(){
// 		Dom.orderManageItem.css("display","flex");
// 		Dom.peopleManageItem.css("display","none");
// 		Dom.businessManageItem.css("display","none");
// 	}
// 	function eventHandler(){
// 		Dom.homepage.click(function(){
//
// 		});
// 		Dom.order.click(function(){
// 			Dom.orderManageItem.css("display","flex");
// 		});
// 		Dom.people.click(function(){
// 			Dom.peopleManageItem.css("display","flex");
// 		});
// 		Dom.business.click(function(){
// 			Dom.businessManageItem.css("display","flex");
// 		});
// 		Dom.orderManage.click(function(){
// 			if(Dom.orderManageItem.css("display") != 'none'){
// 				Dom.orderManageItem.css("display","none");
// 			}else{
// 				Dom.orderManageItem.css("display","flex");
// 			}
// 		});
// 		Dom.peopleManage.click(function(){
// 			if(Dom.peopleManageItem.css("display") != 'none'){
// 				Dom.peopleManageItem.css("display","none");
// 			}else{
// 				Dom.peopleManageItem.css("display","flex");
// 			}
// 		});
// 		Dom.businessManage.click(function(){
// 			if(Dom.businessManageItem.css("display") != 'none'){
// 				Dom.businessManageItem.css("display","none");
// 			}else{
// 				Dom.businessManageItem.css("display","flex");
// 			}
// 		});
// 		Dom.order_select.click(function(){
// 			Dom.iframe.attr('src','order_select.html');
// 		});
// 		Dom.order_add.click(function(){
// 			Dom.iframe.attr('src','order_add.html');
// 		});
// 		Dom.order_manage.click(function(){
// 			Dom.iframe.attr('src','order_manage.html');
// 		});
// 		Dom.people_select.click(function(){
// 			Dom.iframe.attr('src','people_select.html');
// 		});
// 		Dom.people_add.click(function(){
// 			Dom.iframe.attr('src','people_add.html');
// 		});
// 		Dom.people_manage.click(function(){
// 			Dom.iframe.attr('src','people_manage.html');
// 		});
// 		Dom.business_select.click(function(){
// 			Dom.iframe.attr('src','business_select.html');
// 		});
// 		Dom.business_add.click(function(){
// 			Dom.iframe.attr('src','business_add.html');
// 		});
// 		Dom.business_manage.click(function(){
// 			Dom.iframe.attr('src','business_manage.html');
// 		});
// 		Dom.exit.click(function(){
// 			window.location.href = "login.html";
// 		});
//
// 	}
// 	main();
// })();
//
//
//
