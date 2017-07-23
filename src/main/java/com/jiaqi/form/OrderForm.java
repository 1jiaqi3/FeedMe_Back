package com.jiaqi.form;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by mac on 23/07/2017.
 */
public class OrderForm {
    @NotEmpty(message = "Name is required")
    private String name;
    @NotEmpty(message = "Cell is required")
    private String phone;
    @NotEmpty(message = "Address is required")
    private String address;
    @NotEmpty(message = "Openid is required")
    private String openid;
    @NotEmpty(message = "Cart can't be empty")
    private String items;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getItems() {
        return items;
    }

    public void setItems(String items) {
        this.items = items;
    }
}
