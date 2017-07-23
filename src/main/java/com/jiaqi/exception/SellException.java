package com.jiaqi.exception;

import com.jiaqi.enums.ResultEnum;

/**
 * Created by mac on 23/07/2017.
 */
public class SellException extends RuntimeException {
    private Integer code;

    public SellException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }
}
