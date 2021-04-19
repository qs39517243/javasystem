package com.ztz.system.controller;

import com.ztz.system.pojo.Company;
import com.ztz.system.pojo.User;
import com.ztz.system.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class CompanyController {

    @Autowired
    CompanyService companyService;

    // 公司展示页面
    @GetMapping(value = "/company/list")
    public String companyList(HttpSession session, Model model) {

        // 如果用户不符合规范
        User user = (User) session.getAttribute("user");
        if (user == null) {
            // 用户为空 重定向到登录页面
            return "redirect:/";
        }

        // 获取所有公司
        List<Company> companies = companyService.getAllCompanies();
        model.addAttribute("companies", companies);

        return "company_list";
    }

    // 公司manage页面
    @GetMapping(value = "/company/manage")
    public String companyManage(HttpSession session, Model model) {

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

        // manage页面也需要所有的company信息，只是多了update和delete
        List<Company> companies = companyService.getAllCompanies();
        model.addAttribute("companies", companies);

        return "company_manage";
    }

    // 公司关键词查询，去list
    @PostMapping(value = "/company/list/select")
    public String companyListSelect(String text, HttpSession session, Model model) {

        // 如果用户不符合规范
        User user = (User) session.getAttribute("user");
        if (user == null) {
            // 用户为空 重定向到登录页面
            return "redirect:/";
        }

        // 关键词查询方法
        List<Company> companies = companyService.getSelectiveCompanies(text);
        model.addAttribute("companies", companies);

        return "company_list";
    }

    // 公司关键词查询，去manage
    @PostMapping(value = "/company/manage/select")
    public String companyManageSelect(String text, HttpSession session, Model model) {

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

        // 关键词查询方法
        List<Company> companies = companyService.getSelectiveCompanies(text);
        model.addAttribute("companies", companies);

        return "company_manage";
    }

    // 跳转公司添加页面
    @GetMapping(value = "/company/add")
    public String companyAddToPage(HttpSession session, Model model) {

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

        return "company_add";
    }

    // 添加公司功能
    @PostMapping(value = "/company/add")
    public String companyAdd(Company company, HttpSession session, Model model) {

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

        // 调用添加方法
        companyService.insertCompany(company);
        // 弹出提示框，添加成功
        model.addAttribute("msg", "添加公司成功");
        // 获取公司
        List<Company> companies = companyService.getAllCompanies();
        model.addAttribute("companies", companies);
        // 返回list展示界面
        return "company_list";
    }

    // 删除公司功能
    @GetMapping(value = "/company/delete/{id}")
    public String companyDelete(@PathVariable("id") Integer id, HttpSession session, Model model) {

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

        // 调用删除方法
        companyService.deleteCompany(id);
        // 弹出提示框，删除成功
        model.addAttribute("msg", "删除公司成功");
        // 获取所有公司信息
        List<Company> companies = companyService.getAllCompanies();
        model.addAttribute("companies", companies);
        // 返回list展示界面
        return "company_manage";
    }

    // 跳转公司修改界面
    @GetMapping(value = "/company/update/{id}")
    public String companyUpdateToPage(@PathVariable("id") Integer id, HttpSession session, Model model) {

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

        // 要修改的信息反馈
        Company company = companyService.getCompanyById(id);
        model.addAttribute("company", company);
        return "company_update";
    }

    // 修改功能
    @PostMapping(value = "/company/update")
    public String companyUpdate(Company company, HttpSession session, Model model) {

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

        // 调用修改方法
        companyService.updateCompany(company);
        // 弹出提示框，修改成功
        model.addAttribute("msg", "修改公司成功");
        // 获取公司
        List<Company> companies = companyService.getAllCompanies();
        model.addAttribute("companies", companies);

        return "company_manage";
    }
}
