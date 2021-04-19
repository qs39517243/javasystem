package com.ztz.system.pojo;

import java.io.Serializable;
import java.util.Date;

public class Form implements Serializable {

    private Integer formId;

    private String formContent;

    private Integer formState;

    private Date formCreateTime;

    private Integer formCompanyId;

    private Integer formEmployeeId;

    private Company company;

    private Employee employee;

    public Integer getFormId() {
        return formId;
    }

    public void setFormId(Integer formId) {
        this.formId = formId;
    }

    public String getFormContent() {
        return formContent;
    }

    public void setFormContent(String formContent) {
        this.formContent = formContent == null ? null : formContent.trim();
    }

    public Integer getFormState() {
        return formState;
    }

    public void setFormState(Integer formState) {
        this.formState = formState;
    }

    public Date getFormCreateTime() {
        return formCreateTime;
    }

    public void setFormCreateTime(Date formCreateTime) {
        this.formCreateTime = formCreateTime;
    }

    public Integer getFormCompanyId() {
        return formCompanyId;
    }

    public void setFormCompanyId(Integer formCompanyId) {
        this.formCompanyId = formCompanyId;
    }

    public Integer getFormEmployeeId() {
        return formEmployeeId;
    }

    public void setFormEmployeeId(Integer formEmployeeId) {
        this.formEmployeeId = formEmployeeId;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "Form{" +
                "formId=" + formId +
                ", formContent='" + formContent + '\'' +
                ", formState=" + formState +
                ", formCreateTime=" + formCreateTime +
                ", formCompanyId=" + formCompanyId +
                ", formEmployeeId=" + formEmployeeId +
                ", company=" + company +
                ", employee=" + employee +
                '}';
    }
}