package com.jiaqi.service.impl;

import com.jiaqi.repository.ProductCategoryRepo;
import com.jiaqi.dataobject.ProductCategory;
import com.jiaqi.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

/**
 * Created by mac on 22/07/2017.
 */
@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {
    @Autowired
    private ProductCategoryRepo repo;

    @Override
    public ProductCategory findOne(Integer categoryId) {
        return repo.findOne(categoryId);
    }

    @Override
    public List<ProductCategory> findAll() {
        return repo.findAll();
    }

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList) {
        return repo.findByCategoryTypeIn(categoryTypeList);
    }

    @Override
    public ProductCategory save(ProductCategory productCategory) {
        return repo.save(productCategory);
    }
}
