//package com.ztz.system.component;
//
//import com.ztz.system.pojo.User;
//import org.springframework.lang.Nullable;
//import org.springframework.web.servlet.HandlerInterceptor;
//import org.springframework.web.servlet.ModelAndView;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
///**
// * 登陆检查
// *
// */
//public class LoginHandlerInterceptor implements HandlerInterceptor{
//
//    // 目标方法执行之前
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        User user = (User) request.getSession().getAttribute("user");
//        if (user == null){
//            // 未登录，返回登陆页面
////            request.setAttribute("msg","没有权限，请先登录");
////            request.getRequestDispatcher("/login").forward(request, response);
//            response.sendRedirect("");
//            return false;
//        }else{
//            // 有登录信息，放行
//            return true;
//        }
//    }
//
//    @Override
//    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
//    }
//
//    @Override
//    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
//    }
//}
