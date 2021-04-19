package com.ztz.system.dao;

import com.ztz.system.pojo.Company;

import java.util.List;

public interface CompanyMapper {

    // 通过id查找公司
    Company getCompanyById(Integer id);

    // 查找全部公司
    List<Company> getAllCompanies();

    // 查找部分公司
    List<Company> getSelectiveCompanies(String text);

    // 增
    int insertCompany(Company company);

    // 删
    int deleteCompany(Integer id);

    // 改
    int updateCompany(Company company);
}