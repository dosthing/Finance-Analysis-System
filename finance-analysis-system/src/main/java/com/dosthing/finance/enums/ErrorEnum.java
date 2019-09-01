package com.dosthing.finance.enums;

import lombok.Getter;

@Getter
public enum ErrorEnum {

    USER_REGISTED(10,"用户已存在"),
    USER_PASSWORD_ERROE(11,"用户密码错误"),
    USER_MONNEY_SHORTAGE(20,"用户余额不足"),
    VALID_TIMEOUT(20,"验证码已过期"),
    PRODUCT_STOCK_ERROR(11,"商品库存不正确")
     ;
    private  Integer code;

    private  String msg;

    ErrorEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
