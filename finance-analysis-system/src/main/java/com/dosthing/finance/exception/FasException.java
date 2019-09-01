package com.dosthing.finance.exception;

import com.dosthing.finance.enums.ErrorEnum;
import lombok.Getter;

/**
 * @program: sell
 * @description:
 * @author: Mr.Shuang
 * @create: 2019-03-03 16:
 **/
@Getter
public class FasException extends RuntimeException {
    private Integer code;

    public FasException(ErrorEnum errorEnum) {
        super(errorEnum.getMsg());
        this.code = errorEnum.getCode();
    }

    public FasException(Integer code, String mesage){
        super(mesage);
        this.code =code;
    }
}
