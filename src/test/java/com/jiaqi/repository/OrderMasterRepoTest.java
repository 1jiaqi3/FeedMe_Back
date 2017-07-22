package com.jiaqi.repository;

import com.jiaqi.dataobject.OrderMaster;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * Created by mac on 22/07/2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterRepoTest {
    @Autowired
    private OrderMasterRepo repo;

    private final String OPENID = "110110";

    @Test
    public void findByCustomerOpenid() throws Exception {
        PageRequest request = new PageRequest(0, 1);
        Page<OrderMaster> res = repo.findByCustomerOpenid(OPENID, request);
        Assert.assertNotEquals(0, res.getTotalElements());
    }

    @Test
    public void saveTest() {
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("1234567");
        orderMaster.setCustomerName("Todd");
        orderMaster.setCustomerCell("11122233344");
        orderMaster.setCustomerAddress("middle");
        orderMaster.setCustomerOpenid("110110");
        orderMaster.setOrderAmount(new BigDecimal(2.3));
        OrderMaster res = repo.save(orderMaster);
        Assert.assertNotNull(res);
    }

}