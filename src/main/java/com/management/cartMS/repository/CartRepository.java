package com.management.cartMS.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.management.cartMS.entity.Cart;
import com.management.cartMS.entity.CartId;



public interface CartRepository extends JpaRepository<Cart, CartId> {
	
}
