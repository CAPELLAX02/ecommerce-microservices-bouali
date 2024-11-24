package com.capellax.ecommerce.dto.request;

import com.capellax.ecommerce.model.Address;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record CustomerRequest(

        String id,

        @NotNull(message = "Customer first name field is required")
        String firstName,

        @NotNull(message = "Customer last name field is required")
        String lastName,

        @NotNull(message = "Customer email field is required")
        @Email(message = "Customer mail should be a valid email")
        String email,

        Address address

) {

}
