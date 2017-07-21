package com.jiaqi.service.impl;

import com.jiaqi.dataobject.ProductInfo;
import com.jiaqi.enums.ProductStatusEnums;
import com.jiaqi.repository.ProductInfoRepo;
import com.jiaqi.service.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by mac on 22/07/2017.
 */
@Service
public class ProductServiceImpl implements ProductInfoService{
    @Autowired
    private ProductInfoRepo repo;

    @Override
    public ProductInfo findOne(String productId) {
        return repo.findOne(productId);
    }

    @Override
    public List<ProductInfo> findUpAll() {
        return repo.findByProductStatus(ProductStatusEnums.UP.getCode());
    }

    @Override
    public Page<ProductInfo> findAll(Pageable pageable) {
        return repo.findAll(pageable);
    }

    @Override
    public ProductInfo save(ProductInfo productInfo) {
        return repo.save(productInfo);
    }
}
