package com.jiaqi.repository;

import com.jiaqi.dataobject.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by mac on 21/07/2017.
 */
public interface ProductCategoryRepo extends JpaRepository<ProductCategory, Integer> {
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
