package com.ztz.system.service.imp;

import com.ztz.system.pojo.Company;

import java.util.List;

public interface CompanyServiceImp {

    // 通过id查找公司
    public Company getCompanyById(Integer id);

    // 查找全部公司
    public List<Company> getAllCompanies();

    // 查找部分公司
    public List<Company> getSelectiveCompanies(String text);

    // 增
    public int insertCompany(Company company);

    // 删
    public int deleteCompany(Integer id);

    // 改
    public int updateCompany(Company company);
}
