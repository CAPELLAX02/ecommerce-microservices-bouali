package com.capellax.ecommerce.dto.mapper;

import com.capellax.ecommerce.dto.request.OrderRequest;
import com.capellax.ecommerce.model.Order;
import org.springframework.stereotype.Service;

@Service
public class OrderMapper {

    public Order toOrder(OrderRequest request) {
        return Order.builder()
                .id(request.id())
                .customerId(request.customerId())
                .reference(request.reference())
                .totalAmount(request.amount())
                .paymentMethod(request.paymentMethod())
                .build();
    }

}
