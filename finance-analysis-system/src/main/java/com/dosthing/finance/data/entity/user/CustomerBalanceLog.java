package com.dosthing.finance.data.entity.user;

import java.math.BigDecimal;

import java.math.BigDecimal;
;import java.math.BigDecimal;
import java.util.Date;

public class CustomerBalanceLog {
    private Integer balanceId;

    private Integer customerId;

    private Integer source;

    private String sourceSn;

    private Date createTime;

    private BigDecimal amount;

    public Integer getBalanceId() {
        return balanceId;
    }

    public void setBalanceId(Integer balanceId) {
        this.balanceId = balanceId;
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

    public String getSourceSn() {
        return sourceSn;
    }

    public void setSourceSn(String sourceSn) {
        this.sourceSn = sourceSn;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}