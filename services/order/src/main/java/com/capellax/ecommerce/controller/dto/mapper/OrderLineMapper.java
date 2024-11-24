package com.capellax.ecommerce.controller.dto.mapper;

import com.capellax.ecommerce.controller.dto.request.OrderLineRequest;
import com.capellax.ecommerce.model.Order;
import com.capellax.ecommerce.model.OrderLine;
import org.springframework.stereotype.Service;

@Service
public class OrderLineMapper {

    public OrderLine toOrderLine(OrderLineRequest request) {
        return OrderLine.builder()
                .id(request.id())
                .quantity(request.quantity())
                .order(Order.builder().id(request.orderId()).build())
                .productId(request.productId())
                .build();
    }

}
