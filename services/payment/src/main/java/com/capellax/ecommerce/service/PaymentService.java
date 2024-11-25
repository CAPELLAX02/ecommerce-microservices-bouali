package com.capellax.ecommerce.service;

import com.capellax.ecommerce.dto.ProductMapper;
import com.capellax.ecommerce.dto.request.PaymentRequest;
import com.capellax.ecommerce.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentRepository repository;
    private final ProductMapper mapper;

    public Integer createPayment(PaymentRequest request) {
        var payment = repository.save(mapper.toPayment(request));
    }

}
