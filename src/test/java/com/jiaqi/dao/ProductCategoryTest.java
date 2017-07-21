package com.jiaqi.dao;

import com.jiaqi.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

/**
 * Created by mac on 21/07/2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryTest {
    @Autowired
    private ProductCategoryRepo repo;

    @Test
    public void findOneTest() {
        ProductCategory productCategory = repo.findOne(1);
        System.out.println(productCategory.toString());
    }

    @Test
    public void saveTest() {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryId(2);
        productCategory.setCategoryName("Boys' Fav");
        productCategory.setCategoryType(3);
        repo.save(productCategory);
    }

    @Test
    public void findByCategoryTypeInTest() {
        List<Integer> list = Arrays.asList(2, 3, 4);

        List<ProductCategory> res = repo.findByCategoryTypeIn(list);
        Assert.assertNotEquals(0, res.size());
    }
}