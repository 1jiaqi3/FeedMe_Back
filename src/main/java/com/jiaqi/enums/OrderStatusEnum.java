package com.jiaqi.enums;

/**
 * Created by mac on 22/07/2017.
 */
public enum OrderStatusEnum {
    NEW(0, "New Order"),
    FINISHED(1, "Finished"),
    CANCEL(2, "Canceled");

    private Integer code;
    private String message;

    OrderStatusEnum(Integer code, String message) {
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
