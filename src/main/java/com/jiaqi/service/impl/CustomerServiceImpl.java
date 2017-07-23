package com.jiaqi.service.impl;

import com.jiaqi.dto.OrderDTO;
import com.jiaqi.enums.ResultEnum;
import com.jiaqi.exception.SellException;
import com.jiaqi.service.CustomerService;
import com.jiaqi.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by mac on 23/07/2017.
 */
@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private OrderService orderService;
    @Override
    public OrderDTO findOneOrder(String openid, String orderId) {
        return checkOrderOwner(openid, orderId);
    }

    @Override
    public OrderDTO cancelOrder(String openid, String orderId) {
        OrderDTO orderDTO = checkOrderOwner(openid, orderId);
        if (orderDTO == null) {
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }
        return orderService.cancel(orderDTO);
    }

    private OrderDTO checkOrderOwner(String openid, String orderId) {
        OrderDTO orderDTO = orderService.findOne(orderId);
        if (orderDTO == null) {
            return null;
        }
        if (!orderDTO.getCustomerOpenid().equalsIgnoreCase(openid)) {
            throw new SellException(ResultEnum.ORDER_OWNER_ERROR);
        }
        return orderDTO;
    }
}
