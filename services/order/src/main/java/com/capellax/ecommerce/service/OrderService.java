package com.capellax.ecommerce.service;

import com.capellax.ecommerce.dto.mapper.OrderMapper;
import com.capellax.ecommerce.dto.request.OrderConfirmation;
import com.capellax.ecommerce.dto.request.OrderLineRequest;
import com.capellax.ecommerce.dto.request.OrderRequest;
import com.capellax.ecommerce.dto.request.PurchaseRequest;
import com.capellax.ecommerce.customer.CustomerClient;
import com.capellax.ecommerce.dto.response.OrderResponse;
import com.capellax.ecommerce.exception.BusinessException;
import com.capellax.ecommerce.kafka.OrderProducer;
import com.capellax.ecommerce.product.ProductClient;
import com.capellax.ecommerce.repository.OrderRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final CustomerClient customerClient;
    private final ProductClient productClient;
    private final OrderRepository repository;
    private final OrderMapper mapper;
    private final OrderLineService orderLineService;
    private final OrderProducer orderProducer;

    public Integer createOrder(@Valid OrderRequest request) {
        var customer = customerClient.findCustomerById(request.customerId())
                .orElseThrow(() -> new BusinessException("Cannot create order:: No customer exists with the provided ID:: " + request.customerId()));

        var purchasedProducts =  productClient.purchaseProducts(request.products());
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
        orderProducer.sendOrderConfirmation(
                new OrderConfirmation(
                        request.reference(),
                        request.amount(),
                        request.paymentMethod(),
                        customer,
                        purchasedProducts
                )
        );
        return order.getId();
    }

    public List<OrderResponse> findAll() {
        return repository.findAll()
                .stream()
                .map(mapper::fromOrder)
                .toList();
    }

    public OrderResponse findById(Integer orderId) {
        return repository.findById(orderId)
                .map(mapper::fromOrder)
                .orElseThrow(() -> new EntityNotFoundException(
                        String.format("No order found with the provided ID: %d", orderId)
                ));
    }

}
