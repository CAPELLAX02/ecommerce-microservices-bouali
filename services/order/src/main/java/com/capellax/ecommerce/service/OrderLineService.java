package com.capellax.ecommerce.service;

import com.capellax.ecommerce.dto.mapper.OrderLineMapper;
import com.capellax.ecommerce.dto.request.OrderLineRequest;
import com.capellax.ecommerce.dto.response.OrderLineResponse;
import com.capellax.ecommerce.repository.OrderLineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderLineService {

    private final OrderLineRepository repository;
    private final OrderLineMapper mapper;

    public Integer saveOrderLine(OrderLineRequest orderLineRequest) {
        var order = mapper.toOrderLine(orderLineRequest);
        return repository.save(order).getId();
    }

    public List<OrderLineResponse> findByOrderId(Integer orderId) {
        return repository.findAllByOrderId(orderId)
                .stream()
                .map(mapper::toOrderLineResponse)
                .toList();
    }
}
