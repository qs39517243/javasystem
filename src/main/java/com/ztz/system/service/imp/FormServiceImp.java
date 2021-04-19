package com.ztz.system.service.imp;

import com.ztz.system.pojo.Form;

import java.util.List;

public interface FormServiceImp {

    // 根据id查找单个订单
    public Form getFormById(Integer id);

    // 查找所有订单
    public List<Form> getAllForms();

    // 条件查找订单
    public List<Form> getSelectiveForms(String text);

    // 添加订单
    public int addForm(Form Form);

    // 删除订单
    public int deleteForm(Integer id);

    // 伪删订单
    public int deleteFormByState(Integer id);

    // 修改订单
    public int updateForm(Form Form);
}
