package com.capellax.ecommerce;

import java.util.Map;

public record ErrorResponse(
        Map<String, String> errors
) {
}
