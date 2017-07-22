package com.jiaqi.repository;

import com.jiaqi.dataobject.OrderMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by mac on 22/07/2017.
 */
public interface OrderMasterRepo extends JpaRepository<OrderMaster, String>{
    Page<OrderMaster> findByCustomerOpenid(String customerOpenid, Pageable pageable);
}
