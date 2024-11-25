package com.capellax.ecommerce.dto.response;

public record CustomerResponse(
        String id,
        String firstName,
        String lastName,
        String email
) {
}
