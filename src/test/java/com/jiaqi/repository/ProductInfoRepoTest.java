package com.jiaqi.repository;

import com.jiaqi.dataobject.ProductCategory;
import com.jiaqi.dataobject.ProductInfo;
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
 * Created by mac on 22/07/2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoRepoTest {
    @Autowired
    private ProductInfoRepo repo;

    @Test
    public void saveTest() {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("1234567");
        productInfo.setProductName("hot chicken");
        productInfo.setProductPrice(new BigDecimal(3.2));
        productInfo.setProductStock(100);
        productInfo.setProductDesc("Nice");
        productInfo.setProductIcon("http://xx.jpg");
        productInfo.setProductStatus(0);
        productInfo.setCategoryType(2);

        ProductInfo res = repo.save(productInfo);
        Assert.assertNotNull(res);
    }

    @Test
    public void findByProductStatus() throws Exception {
        List<ProductInfo> productInfoList = repo.findByProductStatus(0);
        Assert.assertNotEquals(0, productInfoList.size());
    }

}