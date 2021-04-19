package com.ztz.system.pojo;

public class Company {

    private Integer companyId;

    private String companyName;

    private String companyIntroduction;

    private Integer companyOrderFinishTime;

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName == null ? null : companyName.trim();
    }

    public String getCompanyIntroduction() {
        return companyIntroduction;
    }

    public void setCompanyIntroduction(String companyIntroduction) {
        this.companyIntroduction = companyIntroduction == null ? null : companyIntroduction.trim();
    }

    public Integer getCompanyOrderFinishTime() {
        return companyOrderFinishTime;
    }

    public void setCompanyOrderFinishTime(Integer companyOrderFinishTime) {
        this.companyOrderFinishTime = companyOrderFinishTime;
    }

    @Override
    public String toString() {
        return "Company{" +
                "companyId=" + companyId +
                ", companyName='" + companyName + '\'' +
                ", companyIntroduction='" + companyIntroduction + '\'' +
                ", companyOrderFinishTime=" + companyOrderFinishTime +
                '}';
    }
}