package com.jiaqi.service;

import com.jiaqi.dataobject.ProductCategory;

import java.util.List;

/**
 * Created by mac on 22/07/2017.
 */
public interface ProductCategoryService {
    ProductCategory findOne(Integer categoryId);

    List<ProductCategory> findAll();

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    ProductCategory save(ProductCategory productCategory);


}
