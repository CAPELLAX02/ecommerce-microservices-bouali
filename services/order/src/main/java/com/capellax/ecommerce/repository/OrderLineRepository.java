package com.capellax.ecommerce.repository;

import com.capellax.ecommerce.model.OrderLine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderLineRepository extends JpaRepository<OrderLine, Integer> {



}
