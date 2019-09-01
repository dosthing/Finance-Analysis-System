package com.dosthing.finance.data.entity.user;

import java.math.BigDecimal;
import java.util.Date;

public class CustomerInfo {
    private Integer customerInfoId;

    private Integer customerLoginId;

    private String custometName;

    private Integer customerCardType;

    private String customerCardNo;

    private String mobilePhone;

    private String customerEmail;

    private String gender;

    private Integer userPoint;

    private Date registerTime;

    private Date birthday;

    private Integer customerLevel;

    private BigDecimal userMoney;

    private Date modifiedTime;

    public Integer getCustomerInfoId() {
        return customerInfoId;
    }

    public void setCustomerInfoId(Integer customerInfoId) {
        this.customerInfoId = customerInfoId;
    }

    public Integer getCustomerLoginId() {
        return customerLoginId;
    }

    public void setCustomerLoginId(Integer customerLoginId) {
        this.customerLoginId = customerLoginId;
    }

    public String getCustometName() {
        return custometName;
    }

    public void setCustometName(String custometName) {
        this.custometName = custometName == null ? null : custometName.trim();
    }

    public Integer getCustomerCardType() {
        return customerCardType;
    }

    public void setCustomerCardType(Integer customerCardType) {
        this.customerCardType = customerCardType;
    }

    public String getCustomerCardNo() {
        return customerCardNo;
    }

    public void setCustomerCardNo(String customerCardNo) {
        this.customerCardNo = customerCardNo == null ? null : customerCardNo.trim();
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    public Integer getUserPoint() {
        return userPoint;
    }

    public void setUserPoint(Integer userPoint) {
        this.userPoint = userPoint;
    }

    public Date getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Integer getCustomerLevel() {
        return customerLevel;
    }

    public void setCustomerLevel(Integer customerLevel) {
        this.customerLevel = customerLevel;
    }

    public BigDecimal getUserMoney() {
        return userMoney;
    }

    public void setUserMoney(BigDecimal userMoney) {
        this.userMoney = userMoney;
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }
}