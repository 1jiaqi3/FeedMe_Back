package com.jiaqi.converter;

import com.jiaqi.dataobject.OrderMaster;
import com.jiaqi.dto.OrderDTO;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by mac on 23/07/2017.
 */
public class OrderMaster2OrderDTOConverter {
    public static OrderDTO converter(OrderMaster orderMaster) {
        OrderDTO orderDTO = new OrderDTO();
        BeanUtils.copyProperties(orderMaster, orderDTO);
        return orderDTO;
    }
    public static List<OrderDTO> convert(List<OrderMaster> orderMasterList) {
        return orderMasterList
                .stream()
                .map(e -> converter(e))
                .collect(Collectors.toList());
    }
}
