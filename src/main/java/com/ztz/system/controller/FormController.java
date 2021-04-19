package com.ztz.system.controller;

import com.ztz.system.pojo.Company;
import com.ztz.system.pojo.Employee;
import com.ztz.system.pojo.Form;
import com.ztz.system.pojo.User;
import com.ztz.system.service.CompanyService;
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
public class FormController {

    @Autowired
    FormService formService;

    @Autowired
    EmployeeService employeeService;

    @Autowired
    CompanyService companyService;

    @GetMapping(value = "/form/list")
    public String formList(HttpSession session, Model model) {

        // 如果用户不符合规范
        User user = (User) session.getAttribute("user");
        if (user == null) {
            // 用户为空 重定向到登录页面
            return "redirect:/";
        }

        // 订单用form，因为数据库中order是关键字
        List<Form> forms = formService.getAllForms();
        model.addAttribute("forms", forms);
        return "form_list";
    }

    @PostMapping(value = "/form/list/select")
    public String formListSelect(String text, HttpSession session, Model model) {

        // 如果用户不符合规范
        User user = (User) session.getAttribute("user");
        if (user == null) {
            // 用户为空 重定向到登录页面
            return "redirect:/";
        }

        // 关键词
        List<Form> forms = formService.getSelectiveForms(text);
        model.addAttribute("forms", forms);
        return "form_list";
    }

    @GetMapping(value = "/form/manage")
    public String formManage(HttpSession session, Model model) {

        // 如果用户不符合规范
        User user = (User) session.getAttribute("user");
        if (user == null) {
            // 用户为空 重定向到登录页面
            return "redirect:/";
        } else if (user.getUserType() == 3) {
            // 用户权限不足，返回主页
            model.addAttribute("msg", "权限不足，请联系管理员授予权限");
            return "index";
        }

        List<Form> forms = formService.getAllForms();
        model.addAttribute("forms", forms);
        return "form_manage";
    }

    @PostMapping(value = "/form/manage/select")
    public String formManageSelect(String text, HttpSession session, Model model) {

        // 如果用户不符合规范
        User user = (User) session.getAttribute("user");
        if (user == null) {
            // 用户为空 重定向到登录页面
            return "redirect:/";
        } else if (user.getUserType() == 3) {
            // 用户权限不足，返回主页
            model.addAttribute("msg", "权限不足，请联系管理员授予权限");
            return "index";
        }

        // 关键词
        List<Form> forms = formService.getSelectiveForms(text);
        model.addAttribute("forms", forms);
        return "form_list";
    }

    // 去往add界面
    @GetMapping(value = "/form/add")
    public String formToAddPage(HttpSession session, Model model) {

        // 如果用户不符合规范
        User user = (User) session.getAttribute("user");
        if (user == null) {
            // 用户为空 重定向到登录页面
            return "redirect:/";
        } else if (user.getUserType() == 3) {
            // 用户权限不足，返回主页
            model.addAttribute("msg", "权限不足，请联系管理员授予权限");
            return "index";
        }

        // 这里要把公司和业务员的id和姓名之类的内容传过去
        List<Company> companies = companyService.getAllCompanies();
        List<Employee> employees = employeeService.getAllEmployees();
        model.addAttribute("companies", companies);
        model.addAttribute("employees", employees);
        return "form_add";
    }

    @PostMapping(value = "/form/add")
    public String formAdd(Form form, HttpSession session, Model model) {

        // 如果用户不符合规范
        User user = (User) session.getAttribute("user");
        if (user == null) {
            // 用户为空 重定向到登录页面
            return "redirect:/";
        } else if (user.getUserType() == 3) {
            // 用户权限不足，返回主页
            model.addAttribute("msg", "权限不足，请联系管理员授予权限");
            return "index";
        }

        // 首先往数据库中录入订单
        // 如果成功，要把相应的公司交易次数和业务员完成订单次数+1
        // 如果失败，则不做变动
        if (formService.addForm(form) == 0) {
            model.addAttribute("msg", "订单录入失败");
        } else {
            // 先找到对应职员
            Employee employee = employeeService.getEmployeeById(form.getFormEmployeeId());
            // 将职员完成订单次数+1
            employee.setEmployeeOrderFinishTime(employee.getEmployeeOrderFinishTime() + 1);
            employeeService.updateEmployee(employee);

            // 公司与职员类似
            Company company = companyService.getCompanyById(form.getFormCompanyId());
            company.setCompanyOrderFinishTime(company.getCompanyOrderFinishTime() + 1);
            companyService.updateCompany(company);

            model.addAttribute("msg", "订单录入成功");
        }
        // 返回展示页面
        List<Form> forms = formService.getAllForms();
        model.addAttribute("forms", forms);
        return "form_manage";
    }

    // 去往update界面
    @GetMapping(value = "/form/update/{id}")
    public String formUpdateToPage(@PathVariable("id") Integer id, HttpSession session, Model model) {

        // 如果用户不符合规范
        User user = (User) session.getAttribute("user");
        if (user == null) {
            // 用户为空 重定向到登录页面
            return "redirect:/";
        } else if (user.getUserType() == 3) {
            // 用户权限不足，返回主页
            model.addAttribute("msg", "权限不足，请联系管理员授予权限");
            return "index";
        }

        Form form = formService.getFormById(id);

        List<Company> companies = companyService.getAllCompanies();
        List<Employee> employees = employeeService.getAllEmployees();

        model.addAttribute("form", form);
        model.addAttribute("companies", companies);
        model.addAttribute("employees", employees);
        return "form_update";
    }

    @PostMapping(value = "/form/update")
    public String formUpdate(Form form, HttpSession session, Model model) {

        // 如果用户不符合规范
        User user = (User) session.getAttribute("user");
        if (user == null) {
            // 用户为空 重定向到登录页面
            return "redirect:/";
        } else if (user.getUserType() == 3) {
            // 用户权限不足，返回主页
            model.addAttribute("msg", "权限不足，请联系管理员授予权限");
            return "index";
        }

        // 注意：这里不想让系统默认timestamp，因为默认timestamp会自动获取当前时间，而订单的创建时间不应被更新
        Form formTime = formService.getFormById(form.getFormId());
        form.setFormCreateTime(formTime.getFormCreateTime());

        if (formService.updateForm(form) == 0) {
            model.addAttribute("msg", "订单修改失败");
        } else {
            model.addAttribute("msg", "订单修改成功");
        }

        List<Form> forms = formService.getAllForms();
        model.addAttribute("forms", forms);
        return "form_manage";
    }

    @GetMapping(value = "/form/delete/{id}")
    public String formDelete(@PathVariable("id") Integer id, HttpSession session, Model model) {

        // 如果用户不符合规范
        User user = (User) session.getAttribute("user");
        if (user == null) {
            // 用户为空 重定向到登录页面
            return "redirect:/";
        } else if (user.getUserType() == 3) {
            // 用户权限不足，返回主页
            model.addAttribute("msg", "权限不足，请联系管理员授予权限");
            return "index";
        }

        if (formService.deleteFormByState(id) == 0) {
            model.addAttribute("msg", "删除订单失败");
        } else {
            model.addAttribute("msg", "删除订单成功");
        }

        List<Form> forms = formService.getAllForms();
        model.addAttribute("forms", forms);

        return "form_manage";
    }
}
