package com.capellax.ecommerce.controller.dto.request;

import com.capellax.ecommerce.enums.PaymentMethod;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.util.List;

public record OrderRequest(

        Integer id,

        String reference,

        @Positive(message = "Order amount should be positive")
        BigDecimal amount,

        @NotNull(message = "Payment method is required and should be precised")
        PaymentMethod paymentMethod,

        @NotNull(message = "Customer should be present")
        @NotEmpty(message = "Customer should be present")
        @NotBlank(message = "Customer should be present")
        String customerId,

        @NotEmpty(message = "You should at least purchase at least one product")
        List<PurchaseRequest> products

) {
}
