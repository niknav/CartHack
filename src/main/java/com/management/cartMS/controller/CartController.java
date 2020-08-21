package com.management.cartMS.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.management.cartMS.dto.CartDTO;
import com.management.cartMS.dto.CustomerDTO;
import com.management.cartMS.dto.ProductDTO;
import com.management.cartMS.service.CartService;


@RestController
@CrossOrigin
@RequestMapping(value="/api")
public class CartController {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	CartService buyerService;
	
	@Autowired
    RestTemplate template;
	
	

	@GetMapping(value="cart/{customerid}",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<CartDTO> buyerCartItems(@PathVariable int customerid) {
		List<CartDTO> cartDTO= buyerService.getCartItems(customerid);
		return cartDTO;
	}
	
	
	@PostMapping(value= "/add/cart",consumes = MediaType.APPLICATION_JSON_VALUE)
	public  String addProductToCart(@RequestBody CartDTO cartDTO) {
		try {
			System.out.println("hiii");
			CustomerDTO customerDTO= template.getForObject("http://CUSTOMERMS"+"/api/customer/"+cartDTO.getCustomer().getCustomerid(),CustomerDTO.class);
		ProductDTO productDTO= template.getForObject("http://PRODUCTMS"+"/products/"+cartDTO.getProduct().getProdid(),ProductDTO.class);
		cartDTO.setProduct(productDTO);
		cartDTO.setCustomer(customerDTO);
		System.out.println("cartdto");
		buyerService.addToCart(cartDTO);
		return "Added";
		}catch(Exception e) {
			return "not added";
		}
	}
	
	

	@DeleteMapping(value = "/cart/remove")
	public String removeFromCart(@RequestBody CartDTO cartDTO) {
		try {
			System.out.println("hiii");
		buyerService.removeFromCart(cartDTO);
		return "removed";
		}catch(Exception e) {
			return "not not removed";
		}
	}
	
	}
	
	
	


