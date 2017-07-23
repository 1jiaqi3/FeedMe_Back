package com.jiaqi.converter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jiaqi.dataobject.OrderDetail;
import com.jiaqi.dto.OrderDTO;
import com.jiaqi.enums.ResultEnum;
import com.jiaqi.exception.SellException;
import com.jiaqi.form.OrderForm;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mac on 23/07/2017.
 */
public class OrderForm2OrderDTOConverter {
    public static OrderDTO convert(OrderForm orderForm) {
        Gson gson = new Gson();

        OrderDTO orderDTO = new OrderDTO();

        orderDTO.setCustomerName(orderForm.getName());
        orderDTO.setCustomerCell(orderForm.getPhone());
        orderDTO.setCustomerAddress(orderForm.getAddress());
        orderDTO.setCustomerOpenid(orderForm.getOpenid());

        List<OrderDetail> orderDetailList = new ArrayList<>();
        try {
            orderDetailList = gson.fromJson(orderForm.getItems(), new TypeToken<List<OrderDetail>>() {
            }.getType());
        } catch (Exception e) {
            throw new SellException(ResultEnum.PARAM_ERROR);
        }
        orderDTO.setOrderDetailList(orderDetailList);
        return orderDTO;
    }
}
