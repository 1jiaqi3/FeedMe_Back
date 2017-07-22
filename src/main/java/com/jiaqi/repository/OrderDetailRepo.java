package com.jiaqi.repository;

import com.jiaqi.dataobject.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by mac on 22/07/2017.
 */
public interface OrderDetailRepo extends JpaRepository<OrderDetail, String>{
    List<OrderDetail> findByOrderId(String orderId);
}
