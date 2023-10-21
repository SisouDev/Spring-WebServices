package com.webservice.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webservice.project.entities.OrderItem;
import com.webservice.project.entities.pk.OrderItemPK;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK>{
    
}
