package com.jiaqi.service.impl;

import com.jiaqi.dataobject.OrderDetail;
import com.jiaqi.dataobject.OrderMaster;
import com.jiaqi.dataobject.ProductInfo;
import com.jiaqi.dto.CartDTO;
import com.jiaqi.dto.OrderDTO;
import com.jiaqi.enums.ResultEnum;
import com.jiaqi.exception.SellException;
import com.jiaqi.repository.OrderDetailRepo;
import com.jiaqi.repository.OrderMasterRepo;
import com.jiaqi.service.OrderService;
import com.jiaqi.service.ProductInfoService;
import com.jiaqi.utils.KeyUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.awt.print.Pageable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by mac on 23/07/2017.
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private ProductInfoService productInfoService;

    @Autowired
    private OrderDetailRepo detailRepo;

    @Autowired
    private OrderMasterRepo masterRepo;

    @Override
    @Transactional
    public OrderDTO create(OrderDTO orderDTO) {
        String orderId = KeyUtil.genUniqueKey();
        BigDecimal orderAmount = new BigDecimal(0);
        // Query Product's amount and price
        for (OrderDetail orderDetail : orderDTO.getOrderDetailList()) {
            ProductInfo productInfo = productInfoService.findOne(orderDetail.getProductId());
            if (productInfo == null) {
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            // Compute the total due
            orderAmount = orderAmount
                    .add(orderDetail.getProductPrice()
                            .multiply(new BigDecimal(orderDetail.getProductAmount())));
            // Write orderDetail to DB
            orderDetail.setDetailId(KeyUtil.genUniqueKey());
            orderDetail.setOrderId(orderId);
            BeanUtils.copyProperties(productInfo, orderDetail);
            detailRepo.save(orderDetail);
        }

        // Write orderMaster to DB
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId(orderId);
        orderMaster.setOrderAmount(orderAmount);
        BeanUtils.copyProperties(orderDTO, orderMaster);
        masterRepo.save(orderMaster);

        // Decrease the stock
        List<CartDTO> cartDTOList = new ArrayList<>();
        orderDTO.getOrderDetailList()
                .stream()
                .map(e -> new CartDTO(e.getProductId(), e.getProductAmount()))
                .collect(Collectors.toList());
        productInfoService.decreaseStock(cartDTOList);
        return orderDTO;
    }

    @Override
    public OrderDTO findOne(String orderId) {
        return null;
    }

    @Override
    public Page<OrderDTO> findList(String customerOpenid, Pageable pageable) {
        return null;
    }

    @Override
    public OrderDTO cancel(OrderDTO orderDTO) {
        return null;
    }

    @Override
    public OrderDTO finish(OrderDTO orderDTO) {
        return null;
    }

    @Override
    public OrderDTO paid(OrderDTO orderDTO) {
        return null;
    }
}
