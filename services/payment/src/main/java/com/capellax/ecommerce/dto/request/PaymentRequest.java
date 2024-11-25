package com.capellax.ecommerce.dto.request;

import com.capellax.ecommerce.enums.PaymentMethod;

import java.math.BigDecimal;

public record PaymentRequest(

        Integer id,

        BigDecimal amount,

        PaymentMethod paymentMethod,

        Integer orderId,

        String orderReference,

        CustomerRequest customer

) {
}
