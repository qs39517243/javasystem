package com.ztz.system.service;

import com.ztz.system.dao.CompanyMapper;
import com.ztz.system.pojo.Company;
import com.ztz.system.service.imp.CompanyServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService implements CompanyServiceImp {

    @Autowired
    CompanyMapper companyMapper;

    @Override
    public Company getCompanyById(Integer id) {
        return companyMapper.getCompanyById(id);
    }

    @Override
    public List<Company> getAllCompanies() {
        return companyMapper.getAllCompanies();
    }

    @Override
    public List<Company> getSelectiveCompanies(String text) {
        return companyMapper.getSelectiveCompanies(text);
    }

    @Override
    public int insertCompany(Company company) {
        return companyMapper.insertCompany(company);
    }

    @Override
    public int deleteCompany(Integer id) {
        return companyMapper.deleteCompany(id);
    }

    @Override
    public int updateCompany(Company company) {
        return companyMapper.updateCompany(company);
    }
}
