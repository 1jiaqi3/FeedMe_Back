package com.jiaqi.controller;

import com.jiaqi.VO.ResultVO;
import com.jiaqi.converter.OrderForm2OrderDTOConverter;
import com.jiaqi.dto.OrderDTO;
import com.jiaqi.enums.ResultEnum;
import com.jiaqi.exception.SellException;
import com.jiaqi.form.OrderForm;
import com.jiaqi.service.CustomerService;
import com.jiaqi.service.OrderService;
import com.jiaqi.utils.ResultVOUtil;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by mac on 23/07/2017.
 */
@RestController
@RequestMapping("/customer/order")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private CustomerService customerService;
    // Create order
    @PostMapping("/create")
    public ResultVO<Map<String, String>> create(@Valid OrderForm orderForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new SellException(ResultEnum.PARAM_ERROR.getCode(), bindingResult.getFieldError().getDefaultMessage());
        }
        OrderDTO orderDTO = OrderForm2OrderDTOConverter.convert(orderForm);
        if (CollectionUtils.isEmpty(orderDTO.getOrderDetailList())) {
            throw new SellException(ResultEnum.CART_EMPTY_ERROR);
        }
        OrderDTO res = orderService.create(orderDTO);
        Map<String, String> map = new HashMap<>();
        map.put("orderId", res.getOrderId());
        return ResultVOUtil.success(map);
    }
    // Check List of orders
    @GetMapping("/list")
    public ResultVO<List<OrderDTO>> list(@RequestParam("openid") String openid,
                                         @RequestParam(value = "page", defaultValue = "0") Integer page,
                                         @RequestParam(value = "size", defaultValue = "10") Integer size) {
        if (StringUtils.isEmpty(openid)) {
            throw new SellException(ResultEnum.PARAM_ERROR);
        }
        PageRequest request = new PageRequest(page, size);
        Page<OrderDTO> orderDTOPage = orderService.findList(openid, request);

        return ResultVOUtil.success(orderDTOPage.getContent());
    }
    // Check order detail
    @GetMapping("/detail")
    public ResultVO<OrderDTO> detail(@RequestParam("openid") String openid,
                                     @RequestParam("orderId") String orderId) {
        OrderDTO orderDTO = customerService.findOneOrder(openid, orderId);
        return ResultVOUtil.success(orderDTO);
    }
    // Cancel order
    @PostMapping("/cancel")
    public ResultVO cancel(@RequestParam("openid") String openId,
                           @RequestParam("orderId") String orderId) {

        customerService.cancelOrder(openId, orderId);
        return ResultVOUtil.success();
    }
}
