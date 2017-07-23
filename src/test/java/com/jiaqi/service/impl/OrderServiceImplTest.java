package com.jiaqi.service.impl;

import com.jiaqi.dataobject.OrderDetail;
import com.jiaqi.dto.OrderDTO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
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
    }

    @Test
    public void findList() throws Exception {
    }

    @Test
    public void cancel() throws Exception {
    }

    @Test
    public void finish() throws Exception {
    }

    @Test
    public void paid() throws Exception {
    }

}