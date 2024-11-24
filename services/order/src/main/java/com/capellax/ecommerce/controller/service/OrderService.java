package com.capellax.ecommerce.controller.service;

import com.capellax.ecommerce.controller.dto.mapper.OrderMapper;
import com.capellax.ecommerce.controller.dto.request.OrderLineRequest;
import com.capellax.ecommerce.controller.dto.request.OrderRequest;
import com.capellax.ecommerce.controller.dto.request.PurchaseRequest;
import com.capellax.ecommerce.customer.CustomerClient;
import com.capellax.ecommerce.exception.BusinessException;
import com.capellax.ecommerce.product.ProductClient;
import com.capellax.ecommerce.repository.OrderRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final CustomerClient customerClient;
    private final ProductClient productClient;
    private final OrderRepository repository;
    private final OrderMapper mapper;
    private final OrderLineService orderLineService;

    public Integer createOrder(@Valid OrderRequest request) {
        var customer = customerClient.findCustomerById(request.customerId())
                .orElseThrow(() -> new BusinessException("Cannot create order:: No customer exists with the provided ID:: " + request.customerId()));
        productClient.purchaseProducts(request.products());
        var order = repository.save(mapper.toOrder(request));
        for (PurchaseRequest purchaseRequest : request.products()) {
            orderLineService.saveOrderLine(
                    new OrderLineRequest(
                            null,
                            order.getId(),
                            purchaseRequest.productId(),
                            purchaseRequest.quantity()
                    )
            );
        }
        // TODO: Start the payment process.
        return null;
    }


}
