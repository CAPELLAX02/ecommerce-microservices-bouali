package com.capellax.ecommerce.dto;

import com.capellax.ecommerce.dto.request.PaymentRequest;
import com.capellax.ecommerce.model.Payment;
import org.springframework.stereotype.Service;

@Service
public class ProductMapper {

    public Payment toPayment(PaymentRequest request) {
        return Payment.builder()
                .id(request.id())
                .orderId(request.orderId())
                .paymentMethod(request.paymentMethod())
                .amount(request.amount())
                .build();
    }

}
