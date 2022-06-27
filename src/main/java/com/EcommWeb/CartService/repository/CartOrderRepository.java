package com.EcommWeb.CartService.repository;

import com.EcommWeb.CartService.entities.CartOrder;
import com.EcommWeb.CartService.entities.Details;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartOrderRepository extends JpaRepository<CartOrder,Integer> {
}
