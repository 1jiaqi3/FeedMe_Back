package com.jiaqi.service;

import com.jiaqi.dataobject.ProductInfo;
import com.jiaqi.dto.CartDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by mac on 22/07/2017.
 */
public interface ProductInfoService {
    ProductInfo findOne(String productId);
    // Find all products that are still up
    List<ProductInfo> findUpAll();

    Page<ProductInfo> findAll(Pageable pageable);

    ProductInfo save(ProductInfo productInfo);

    // Add products to the stock
    void increaseStock(List<CartDTO> cartDTOList);
    // Remove products from the stock
    void decreaseStock(List<CartDTO> cartDTOList);
}
