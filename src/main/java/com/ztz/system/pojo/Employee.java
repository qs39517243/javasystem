package com.ztz.system.pojo;

public class Employee {
    private Integer employeeId;

    private Integer employeeAge;

    private String employeeEmail;

    private String employeeName;

    private Integer employeeGender;

    private String employeePhone;

    private Integer employeeOrderFinishTime;

    public Integer getEmployeeAge() {
        return employeeAge;
    }

    public void setEmployeeAge(Integer employeeAge) {
        this.employeeAge = employeeAge;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName == null ? null : employeeName.trim();
    }

    public Integer getEmployeeGender() {
        return employeeGender;
    }

    public void setEmployeeGender(Integer employeeGender) {
        this.employeeGender = employeeGender;
    }

    public String getEmployeePhone() {
        return employeePhone;
    }

    public void setEmployeePhone(String employeePhone) {
        this.employeePhone = employeePhone;
    }

    public Integer getEmployeeOrderFinishTime() {
        return employeeOrderFinishTime;
    }

    public void setEmployeeOrderFinishTime(Integer employeeOrderFinishTime) {
        this.employeeOrderFinishTime = employeeOrderFinishTime;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", employeeAge=" + employeeAge +
                ", employeeEmail='" + employeeEmail + '\'' +
                ", employeeName='" + employeeName + '\'' +
                ", employeeGender=" + employeeGender +
                ", employeePhone='" + employeePhone + '\'' +
                ", employeeOrderFinishTime=" + employeeOrderFinishTime +
                '}';
    }
}