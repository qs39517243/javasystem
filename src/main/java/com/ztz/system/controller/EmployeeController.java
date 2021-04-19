package com.ztz.system.controller;

import com.ztz.system.pojo.Employee;
import com.ztz.system.pojo.Form;
import com.ztz.system.pojo.User;
import com.ztz.system.service.EmployeeService;
import com.ztz.system.service.FormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @Autowired
    FormService formService;

    @GetMapping(value = "/emp/list")
    public String empList(HttpSession session, Model model) {

        // 如果用户不符合规范
        User user = (User) session.getAttribute("user");
        if (user == null) {
            // 用户为空 重定向到登录页面
            return "redirect:/";
        }

        List<Employee> employees = employeeService.getAllEmployees();
        model.addAttribute("employees", employees);
        return "employee_list";
    }

    // 关键字查询——>list
    @PostMapping(value = "/emp/list/select")
    public String empListSelect(String text, HttpSession session, Model model) {

        // 如果用户不符合规范
        User user = (User) session.getAttribute("user");
        if (user == null) {
            // 用户为空 重定向到登录页面
            return "redirect:/";
        }

        List<Employee> employees = employeeService.getSelectiveEmployees(text);
        model.addAttribute("employees", employees);
        return "employee_list";
    }

    // 关键字查询——>manage
    @PostMapping(value = "/emp/manage/select")
    public String empManageSelect(String text, HttpSession session, Model model) {

        // 如果用户不符合规范
        User user = (User) session.getAttribute("user");
        if (user == null) {
            // 用户为空 重定向到登录页面
            return "redirect:/";
        } else if (user.getUserType() == 2 || user.getUserType() == 3) {
            // 用户权限不足，返回主页
            model.addAttribute("msg", "权限不足，请联系管理员授予权限");
            return "index";
        }

        List<Employee> employees = employeeService.getSelectiveEmployees(text);
        model.addAttribute("employees", employees);
        return "employee_manage";
    }

    // 跳转添加职员页面
    @GetMapping(value = "/emp/add")
    public String empAddToPage(HttpSession session, Model model) {

        // 如果用户不符合规范
        User user = (User) session.getAttribute("user");
        if (user == null) {
            // 用户为空 重定向到登录页面
            return "redirect:/";
        } else if (user.getUserType() == 2 || user.getUserType() == 3) {
            // 用户权限不足，返回主页
            model.addAttribute("msg", "权限不足，请联系管理员授予权限");
            return "index";
        }

        return "employee_add";
    }

    // 表单提交，添加职员
    @PostMapping(value = "/emp/add")
    public String empAdd(Employee employee, HttpSession session, Model model) {

        // 如果用户不符合规范
        User user = (User) session.getAttribute("user");
        if (user == null) {
            // 用户为空 重定向到登录页面
            return "redirect:/";
        } else if (user.getUserType() == 2 || user.getUserType() == 3) {
            // 用户权限不足，返回主页
            model.addAttribute("msg", "权限不足，请联系管理员授予权限");
            return "index";
        }

        // 添加
        employeeService.addEmployee(employee);
        // 弹出提示框，添加成功
        model.addAttribute("msg", "添加职员成功");
        // 获取职员
        List<Employee> employees = employeeService.getAllEmployees();
        model.addAttribute("employees", employees);
        // 返回
        return "employee_list";
    }

    // 跳转manage页面
    @GetMapping(value = "/emp/manage")
    public String empManage(HttpSession session, Model model) {
        // manage页面也需要所有的employee信息，只是多了update和delete
        // 如果用户不符合规范
        User user = (User) session.getAttribute("user");
        if (user == null) {
            // 用户为空 重定向到登录页面
            return "redirect:/";
        } else if (user.getUserType() == 2 || user.getUserType() == 3) {
            // 用户权限不足，返回主页
            model.addAttribute("msg", "权限不足，请联系管理员授予权限");
            return "index";
        }

        List<Employee> employees = employeeService.getAllEmployees();
        model.addAttribute("employees", employees);
        return "employee_manage";
    }


    // 进入修改界面
    @GetMapping(value = "/emp/update/{id}")
    public String empToUpdatePage(@PathVariable("id") Integer id, HttpSession session, Model model) {
        // 如果用户不符合规范
        User user = (User) session.getAttribute("user");
        if (user == null) {
            // 用户为空 重定向到登录页面
            return "redirect:/";
        } else if (user.getUserType() == 2 || user.getUserType() == 3) {
            // 用户权限不足，返回主页
            model.addAttribute("msg", "权限不足，请联系管理员授予权限");
            return "index";
        }

        // 查找对应的信息，要反馈到界面上
        Employee employee = employeeService.getEmployeeById(id);
        model.addAttribute("emp", employee);
        return "employee_update";
    }

    // 提交修改表单
    @PostMapping(value = "/emp/update")
    public String empUpdate(Employee employee, HttpSession session, Model model) {

        // 如果用户不符合规范
        User user = (User) session.getAttribute("user");
        if (user == null) {
            // 用户为空 重定向到登录页面
            return "redirect:/";
        } else if (user.getUserType() == 2 || user.getUserType() == 3) {
            // 用户权限不足，返回主页
            model.addAttribute("msg", "权限不足，请联系管理员授予权限");
            return "index";
        }

        // 调用service修改
        employeeService.updateEmployee(employee);
        // 弹出提示框，修改成功
        model.addAttribute("msg", "修改职员成功");
        // 获取职员
        List<Employee> employees = employeeService.getAllEmployees();
        model.addAttribute("employees", employees);
        // 返回
        return "employee_manage";
    }

    // 删除
    @GetMapping(value = "/emp/delete/{id}")
    public String empDelete(@PathVariable("id") Integer id, HttpSession session, Model model) {
        // 如果用户不符合规范
        User user = (User) session.getAttribute("user");
        if (user == null) {
            // 用户为空 重定向到登录页面
            return "redirect:/";
        } else if (user.getUserType() == 2 || user.getUserType() == 3) {
            // 用户权限不足，返回主页
            model.addAttribute("msg", "权限不足，请联系管理员授予权限");
            return "index";
        }

        // 调用service删除
        employeeService.deleteEmployee(id);
        // 弹出提示框，删除成功
        model.addAttribute("msg", "删除职员成功");
        // 获取职员
        List<Employee> employees = employeeService.getAllEmployees();
        model.addAttribute("employees", employees);
        // 返回
        return "employee_manage";
    }
}
