package com.capellax.ecommerce.controller.dto.response;

public record CustomerResponse(
        String id,
        String firstName,
        String lastName,
        String email
) {
}
