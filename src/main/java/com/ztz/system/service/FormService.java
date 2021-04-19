package com.ztz.system.service;

import com.ztz.system.dao.FormMapper;
import com.ztz.system.pojo.Form;
import com.ztz.system.service.imp.FormServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FormService implements FormServiceImp {

    @Autowired
    FormMapper formMapper;

    @Override
    public Form getFormById(Integer id) {
        return formMapper.getFormById(id);
    }

    @Override
    public List<Form> getAllForms() {
        return formMapper.getAllForms();
    }

    @Override
    public List<Form> getSelectiveForms(String text) {
        return formMapper.getSelectiveForms(text);
    }

    @Override
    public int addForm(Form form) {
        return formMapper.addForm(form);
    }

    @Override
    public int deleteForm(Integer id) {
        return formMapper.deleteForm(id);
    }

    @Override
    public int deleteFormByState(Integer id) {
        return formMapper.deleteFormByState(id);
    }

    @Override
    public int updateForm(Form form) {
        return formMapper.updateForm(form);
    }
}
