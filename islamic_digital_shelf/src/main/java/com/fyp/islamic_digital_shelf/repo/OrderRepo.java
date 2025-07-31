package com.fyp.islamic_digital_shelf.repo;

import com.fyp.islamic_digital_shelf.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepo extends JpaRepository<Order, Long> {
}
