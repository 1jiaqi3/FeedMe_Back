package com.jiaqi.service.impl;

import com.jiaqi.dataobject.OrderDetail;
import com.jiaqi.dto.OrderDTO;
import com.jiaqi.enums.OrderStatusEnum;
import org.aspectj.weaver.ast.Or;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by mac on 23/07/2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest

public class OrderServiceImplTest {
    @Autowired
    private OrderServiceImpl orderService;

    private final String CUSTOMER_OPENID = "110110";
    private final String ORDER_ID = "1500783319903201001";
    @Test
    public void create() throws Exception {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setCustomerName("Virgil");
        orderDTO.setCustomerAddress("Manhattan");
        orderDTO.setCustomerCell("1234567890123");
        orderDTO.setCustomerOpenid(CUSTOMER_OPENID);

        List<OrderDetail> orderDetailList = new ArrayList<>();
        OrderDetail o1 = new OrderDetail();
        o1.setProductId("123457");
        o1.setProductAmount(1);
        orderDetailList.add(o1);

        OrderDetail o2 = new OrderDetail();
        o2.setProductId("1234567");
        o2.setProductAmount(3);
        orderDetailList.add(o2);

        orderDTO.setOrderDetailList(orderDetailList);
        OrderDTO res = orderService.create(orderDTO);

        Assert.assertNotNull(res);
    }

    @Test
    public void findOne() throws Exception {
        OrderDTO res = orderService.findOne(ORDER_ID);
        Assert.assertEquals(ORDER_ID, res.getOrderId());
    }

    @Test
    public void findList() throws Exception {
        PageRequest request = new PageRequest(0, 2);
        Page<OrderDTO> orderDTOPage = orderService.findList(CUSTOMER_OPENID, request);
        Assert.assertNotEquals(0, orderDTOPage.getTotalElements());
    }

    @Test
    public void cancel() throws Exception {
        OrderDTO orderDTO = orderService.findOne(ORDER_ID);
        OrderDTO res = orderService.cancel(orderDTO);
        Assert.assertEquals(OrderStatusEnum.CANCEL.getCode(), res.getOrderStatus());
    }

    @Test
    public void finish() throws Exception {
    }

    @Test
    public void paid() throws Exception {
    }

}