package com.capellax.ecommerce.repository;

import com.capellax.ecommerce.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {



}
