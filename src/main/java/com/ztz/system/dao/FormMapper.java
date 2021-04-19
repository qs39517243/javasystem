package com.ztz.system.dao;

import com.ztz.system.pojo.Form;

import java.util.List;

public interface FormMapper {

    // 查找单个订单
    Form getFormById(Integer id);

    // 查找所有订单
    List<Form> getAllForms();

    // 查找部分订单
    List<Form> getSelectiveForms(String text);

    // 增
    int addForm(Form form);

    // 删
    int deleteForm(Integer id);

    // 伪删
    int deleteFormByState(Integer id);

    // 改
    int updateForm(Form form);
}