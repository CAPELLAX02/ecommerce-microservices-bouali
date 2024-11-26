package com.capellax.ecommerce.kafka;

import com.capellax.ecommerce.dto.response.CustomerResponse;
import com.capellax.ecommerce.dto.response.PurchaseResponse;
import com.capellax.ecommerce.enums.PaymentMethod;

import java.math.BigDecimal;
import java.util.List;

public record OrderConfirmation(
        String orderReference,
        BigDecimal totalAmount,
        PaymentMethod paymentMethod,
        CustomerResponse customer,
        List<PurchaseResponse> products
) {
}
