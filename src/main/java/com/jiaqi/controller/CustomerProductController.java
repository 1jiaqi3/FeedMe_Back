package com.jiaqi.controller;

import com.jiaqi.VO.ProductInfoVO;
import com.jiaqi.VO.ProductVO;
import com.jiaqi.VO.ResultVo;
import com.jiaqi.dataobject.ProductCategory;
import com.jiaqi.dataobject.ProductInfo;
import com.jiaqi.service.ProductCategoryService;
import com.jiaqi.service.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by mac on 22/07/2017.
 */
@RestController
@RequestMapping("/customer/product")
public class CustomerProductController {
    @Autowired
    private ProductInfoService productInfoService;

    @Autowired
    private ProductCategoryService productCategoryService;

    @GetMapping("/list")
    public ResultVo list() {

        ResultVo resultVo = new ResultVo();

        ProductVO productVO = new ProductVO();
        ProductInfoVO productInfoVO = new ProductInfoVO();
        productVO.setProductInfoVOList(Arrays.asList(productInfoVO));

        resultVo.setCode(0);
        resultVo.setMsg("Success");
        resultVo.setData(Arrays.asList(productVO));
        return resultVo;
    }
}
