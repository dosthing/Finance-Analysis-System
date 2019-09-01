package mybatis..dosthing.finance.data.entity;

import java.util.Date;

public class CustomerAddr {
    private Integer customerAddrId;

    private Integer customerId;

    private Short zip;

    private Short province;

    private Short city;

    private Short district;

    private String address;

    private Byte isDefualt;

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

    public Short getZip() {
        return zip;
    }

    public void setZip(Short zip) {
        this.zip = zip;
    }

    public Short getProvince() {
        return province;
    }

    public void setProvince(Short province) {
        this.province = province;
    }

    public Short getCity() {
        return city;
    }

    public void setCity(Short city) {
        this.city = city;
    }

    public Short getDistrict() {
        return district;
    }

    public void setDistrict(Short district) {
        this.district = district;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Byte getIsDefualt() {
        return isDefualt;
    }

    public void setIsDefualt(Byte isDefualt) {
        this.isDefualt = isDefualt;
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }
}