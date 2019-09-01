package com.dosthing.finance.data.entity.user;

import java.util.Date;

import java.util.Date;

public class CustomerLogin {
    private Integer customerId;

    private String loginName;

    private String password;

    private Integer userStats;

    private Date modifiedTime;

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName == null ? null : loginName.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Integer getUserStats() {
        return userStats;
    }

    public void setUserStats(Integer userStats) {
        this.userStats = userStats;
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }
}