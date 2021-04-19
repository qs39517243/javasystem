package com.ztz.system.controller;

import com.ztz.system.pojo.Form;
import com.ztz.system.pojo.User;
import com.ztz.system.service.FormService;
import com.ztz.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class LoginController {

    @Autowired
    UserService userService;

    @GetMapping(value = "/")
    public String toLoginPage() {
        return "login";
    }

    @PostMapping(value = "/login")
    public String userLogin(@RequestParam("username") String username,
                            @RequestParam("password") String password,
                            HttpSession session, Model model) {



        System.out.println("登录ing");


        // 检查用户名及密码
        User checkUser = userService.getUserByUsername(username);

        // 登录失败（无此用户名）
        if (userService.getUserByUsername(username) == null) {



            System.out.println("登录失败");



            model.addAttribute("msg", "无此用户");
            return "login.html";
        }

        // 登录失败（错误）
        if (!checkUser.getPassword().equals(password)) {



            System.out.println("登录失败");



            model.addAttribute("msg", "用户名或密码错误，请重试");
            return "login.html";
        }

        // 登录成功



        System.out.println("登录成功");



        session.setAttribute("user", checkUser);
        return "redirect:/index";
    }

    @GetMapping(value = "/index")
    public String userLogin(HttpSession session) {

        // 如果用户不符合规范
        User user = (User) session.getAttribute("user");
        if (user == null) {
            // 用户为空 重定向到登录页面
            return "redirect:/";
        }

        return "index";
    }

    @GetMapping(value = "/registerPage")
    public String registerToPage(Model model) {
        return "register";
    }

    @PostMapping(value = "/register")
    public String register(String username, String password, String passwordCheck, Model model) {

        if (username == null || password == null || username.equals("") || password.equals("")) {
            model.addAttribute("msg", "请输入完整的信息");
            return "register";
        }

        if (!password.equals(passwordCheck)) {
            model.addAttribute("msg", "两次密码输入不一致，请重试");
            return "register";
        } else if (userService.getUserByUsername(username) != null) {
            model.addAttribute("msg", "用户名已存在，请换一个试试");
            return "register";
        } else {
            // 用户名不冲突，可以注册，用实体类存储信息
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            user.setUserType(3);
            // 使用映射存入数据库
            userService.insertUser(user);
            model.addAttribute("msg", "注册成功");
            return "login";
        }
    }

    @GetMapping(value = "/quit")
    public String quit(HttpSession session) {
        session.setAttribute("user", null);
        return "redirect:/";
    }
}
