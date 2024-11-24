package com.capellax.ecommerce.controller.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record PurchaseRequest(

        @NotNull(message = "Product is mandatory")
        Integer productId,

        @Positive(message = "Quantity is mandatory and should be positive")
        Double quantity

) {
}
