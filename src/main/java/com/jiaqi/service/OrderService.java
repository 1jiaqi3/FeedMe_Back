package com.jiaqi.service;

import com.jiaqi.dataobject.OrderMaster;
import com.jiaqi.dto.OrderDTO;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;

/**
 * Created by mac on 23/07/2017.
 */
public interface OrderService {
    // Create order
    OrderDTO create(OrderDTO orderDTO);
    OrderDTO findOne(String orderId);
    Page<OrderDTO> findList(String customerOpenid, Pageable pageable);
    OrderDTO cancel(OrderDTO orderDTO);
    OrderDTO finish(OrderDTO orderDTO);
    OrderDTO paid(OrderDTO orderDTO);
}
