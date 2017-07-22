package com.jiaqi.enums;

/**
 * Created by mac on 22/07/2017.
 */
public enum PayStatusEnum {
    WAIT(0, "Waiting"),
    SUCCESS(1, "Success");

    private Integer code;
    private String message;

    PayStatusEnum(Integer code, String message) {
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
