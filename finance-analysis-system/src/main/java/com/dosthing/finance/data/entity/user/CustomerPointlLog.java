package com.dosthing.finance.data.entity.user;

import java.util.Date;

public class CustomerPointlLog {
    private Integer pointId;

    private Integer customerId;

    private Integer source;

    private String referNumber;

    private Integer changePoint;

    private Date createTime;

    public Integer getPointId() {
        return pointId;
    }

    public void setPointId(Integer pointId) {
        this.pointId = pointId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getSource() {
        return source;
    }

    public void setSource(Integer source) {
        this.source = source;
    }

    public String getReferNumber() {
        return referNumber;
    }

    public void setReferNumber(String referNumber) {
        this.referNumber = referNumber;
    }

    public Integer getChangePoint() {
        return changePoint;
    }

    public void setChangePoint(Integer changePoint) {
        this.changePoint = changePoint;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}