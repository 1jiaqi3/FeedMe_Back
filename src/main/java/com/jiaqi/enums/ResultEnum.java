package com.jiaqi.enums;

/**
 * Created by mac on 23/07/2017.
 */
public enum ResultEnum {
    PRODUCT_NOT_EXIST(10, "product not exist"),
    PRODUCT_STOCK_ERROR(11, "error while pulling from stock"),
    ORDER_NOT_EXIST(12, "order not exist"),
    ORDERDETAIL_NOT_EXIST(13, "order detail not exist"),
    ORDER_STATUS_ERROR(14, "order status error"),
    ORDER_UPDATE_FAIL(15, "order update failure"),
    ORDER_DATAIL_EMPTY(16, "order detail is empty"),
    ORDER_PAY_STATUS_ERROR(17, "order payment status error");


    private Integer code;
    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
