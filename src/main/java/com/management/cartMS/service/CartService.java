package com.management.cartMS.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.management.cartMS.dto.CartDTO;

import com.management.cartMS.entity.Cart;
import com.management.cartMS.entity.CartId;
import com.management.cartMS.repository.CartRepository;




@Service
public class CartService {
	
	@Autowired
	CartRepository cartRepository;



	@Autowired
	RestTemplate restTemplate;
	
	
	public  String addToCart(CartDTO cartDTO) throws Exception {
		try {
		System.out.println("hello");
		Cart c1=cartDTO.createEntity();
		System.out.println("added");
		cartRepository.save(c1);
		return "added item to cart";
		}catch(Exception e){
			throw new Exception("unable to add");
		}
	}

public List<CartDTO> getCartItems(int customerid) {
	Iterable<Cart> cartEntity = cartRepository.findAll();
	List<CartDTO> cartList = new ArrayList<CartDTO>();
	for (Cart cartEntity2 : cartEntity) {
		if (cartEntity2.getCartId().getCustomerid() == customerid) {
			CartDTO cart = new CartDTO(cartEntity2.getCartId().getCustomerid(), cartEntity2.getCartId().getProdid(),
					cartEntity2.getQuantity());
			cartList.add(cart);
		}

	}

	return cartList;
}


public void removeFromCart(CartDTO cart)  {
	
	Optional<Cart> cartEntity = cartRepository.findById(new CartId(cart.getCustomerid(), cart.getProdid()));
	if(cartEntity.isPresent()) {
		cartRepository.deleteById(new CartId(cart.getCustomerid(), cart.getProdid()));
		}
	else {
		throw new RuntimeException("no item in the cart");
	}
}
}





