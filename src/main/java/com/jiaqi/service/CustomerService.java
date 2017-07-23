package com.jiaqi.service;

import com.jiaqi.dto.OrderDTO;

/**
 * Created by mac on 23/07/2017.
 */
public interface CustomerService {
    // Check an order
    OrderDTO findOneOrder(String openid, String orderId);
    // Cancel an order
    OrderDTO cancelOrder(String openid, String orderId);
}
