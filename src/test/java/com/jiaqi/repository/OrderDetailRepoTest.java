package com.jiaqi.repository;

import com.jiaqi.dataobject.OrderDetail;
import org.aspectj.weaver.ast.Or;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by mac on 23/07/2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailRepoTest {
    @Autowired
    private OrderDetailRepo repo;
    @Test
    public void saveTest() {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("1234556");
        orderDetail.setOrderId("11111111111");
        orderDetail.setProductIcon("aa.com");
        orderDetail.setProductId("123321123321");
        orderDetail.setProductName("beef");
        orderDetail.setProductPrice(new BigDecimal(1.2));
        orderDetail.setProductAmount(2);
        OrderDetail res = repo.save(orderDetail);
        Assert.assertNotNull(res);
    }
    @Test
    public void findByOrderId() throws Exception {
        List<OrderDetail> orderDetailList = repo.findByOrderId("11111111111");
        Assert.assertNotEquals(0, orderDetailList.size());
    }

}