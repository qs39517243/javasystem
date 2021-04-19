package com.ztz.system.controller;

import com.ztz.system.pojo.User;
import com.ztz.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    // 去往管理用户的界面
    @GetMapping(value = "/user/manage")
    public String userManageToPage(HttpSession session, Model model) {

        // 如果用户不符合规范
        User user = (User) session.getAttribute("user");
        if (user == null) {
            // 用户为空 重定向到登录页面
            return "redirect:/";
        } else if (user.getUserType() != 1) {
            // 用户权限不足，返回主页
            model.addAttribute("msg", "权限不足，请联系管理员授予权限");
            return "index";
        }

        // 找到所有用户信息
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "user_manage";
    }

    // 去往更新用户的界面
    @GetMapping(value = "/user/update/{id}")
    public String userUpdateToPage(@PathVariable("id") Integer id, HttpSession session, Model model) {

        // 如果用户不符合规范
        User user = (User) session.getAttribute("user");
        if (user == null) {
            // 用户为空 重定向到登录页面
            return "redirect:/";
        } else if (user.getUserType() != 1) {
            // 用户权限不足，返回主页
            model.addAttribute("msg", "权限不足，请联系管理员授予权限");
            return "index";
        }

        // 找到要修改的用户信息
        User mUser = userService.getUserById(id);
        model.addAttribute("mUser", mUser);

        return "user_update";
    }

    // 更新用户
    @PostMapping(value = "/user/update")
    public String userUpdate(User user, HttpSession session, Model model) {

        if (userService.updateUser(user) == 0) {
            model.addAttribute("msg", "修改失败");
        } else {
            model.addAttribute("msg", "修改成功");
        }

        // 所有用户信息
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);

        return "user_manage";
    }

    // 删除用户
    @GetMapping(value = "/user/delete/{id}")
    public String userDelete(@PathVariable("id") Integer id, HttpSession session, Model model) {
        // 如果用户不符合规范
        User user = (User) session.getAttribute("user");
        if (user == null) {
            // 用户为空 重定向到登录页面
            return "redirect:/";
        } else if (user.getUserType() != 1) {
            // 用户权限不足，返回主页
            model.addAttribute("msg", "权限不足，请联系管理员授予权限");
            return "index";
        }

        if (userService.deleteUser(id) == 0) {
            model.addAttribute("msg", "删除失败");
        } else {
            model.addAttribute("msg", "删除成功");
        }

        // 所有用户信息
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);

        return "user_manage";
    }


    // 更新密码的界面
    @GetMapping(value = "/user/updatePwd")
    public String userUpdatePwdToPage(HttpSession session, Model model) {

        // 如果用户不符合规范
        User user = (User) session.getAttribute("user");
        if (user == null) {
            // 用户为空 重定向到登录页面
            return "redirect:/";
        }

        model.addAttribute("user", user);
        return "user_updatePwd";
    }

    // 更新密码
    @PostMapping(value = "/user/updatePwd")
    public String userUpdatePwd(User user, String newPassword, HttpSession session, Model model) {
        // 将实体类的密码改变
        user.setPassword(newPassword);
        // 使用mapper修改
        userService.updateUser(user);
        // 清空登录信息
        session.setAttribute("user", null);
        // 重定向到登陆页面
        return "redirect:/";
    }
}
