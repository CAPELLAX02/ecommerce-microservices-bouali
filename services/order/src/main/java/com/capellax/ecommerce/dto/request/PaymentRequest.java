package com.capellax.ecommerce.dto.request;

import com.capellax.ecommerce.dto.response.CustomerResponse;
import com.capellax.ecommerce.enums.PaymentMethod;

import java.math.BigDecimal;

public record PaymentRequest(
        BigDecimal amount,
        PaymentMethod paymentMethod,
        Integer orderId,
        String orderReference,
        CustomerResponse customer
) {
}
