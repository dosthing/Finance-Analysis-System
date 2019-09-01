package com.dosthing.finance.data.entity.user;

import java.util.Date;

public class CustomerAddr {
    private Integer customerAddrId;

    private Integer customerId;

    private Integer zip;

    private Integer province;

    private Integer city;

    private Integer district;

    private String address;

    private Integer isDefualt;

    private Date modifiedTime;

    public Integer getCustomerAddrId() {
        return customerAddrId;
    }

    public void setCustomerAddrId(Integer customerAddrId) {
        this.customerAddrId = customerAddrId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getZip() {
        return zip;
    }

    public void setZip(Integer zip) {
        this.zip = zip;
    }

    public Integer getProvince() {
        return province;
    }

    public void setProvince(Integer province) {
        this.province = province;
    }

    public Integer getCity() {
        return city;
    }

    public void setCity(Integer city) {
        this.city = city;
    }

    public Integer getDistrict() {
        return district;
    }

    public void setDistrict(Integer district) {
        this.district = district;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Integer getIsDefualt() {
        return isDefualt;
    }

    public void setIsDefualt(Integer isDefualt) {
        this.isDefualt = isDefualt;
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }
}