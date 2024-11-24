package com.capellax.ecommerce.controller.dto.request;

public record OrderLineRequest(
        Integer id,
        Integer orderId,
        Integer productId,
        Double quantity
) {
}
