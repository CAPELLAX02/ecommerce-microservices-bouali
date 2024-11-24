package com.capellax.ecommerce.dto.response;

import com.capellax.ecommerce.model.Address;

public record CustomerResponse(
        String id,
        String firstName,
        String lastName,
        String email,
        Address address
) {
}
