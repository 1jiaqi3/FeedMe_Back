package com.jiaqi.enums;

/**
 * Created by mac on 22/07/2017.
 */
public enum ProductStatusEnums {
    UP(0, "In Stock"),
    DOWN(1, "Out");

    private Integer code;
    private String message;
    ProductStatusEnums(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
