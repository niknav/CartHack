package com.management.cartMS.dto;




import com.management.cartMS.entity.*;



public class CartDTO {
	int customerid;
	int prodid;
	int quantity;
	ProductDTO product;
	CustomerDTO customer;
	
	public CartDTO() {
		super();
	}
	public CartDTO(int customerid, int prodid, int quantity) {
		super();
		this.customerid = customerid;
		this.prodid = prodid;
		this.quantity = quantity;
	}
	
	
	public CustomerDTO getCustomer() {
		return customer;
	}
	public void setCustomer(CustomerDTO customer) {
		this.customer = customer;
	}
	public ProductDTO getProduct() {
		return product;
	}
	public void setProduct(ProductDTO product) {
		this.product = product;
	}
	public int getCustomerid() {
		return customerid;
	}

	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}

	public int getProdid() {
		return prodid;
	}

	public void setProdid(int prodid) {
		this.prodid = prodid;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	

	public Cart createEntity(){
		
		Cart cart = new Cart();
		cart.getCartId().setCustomerid(this.getCustomerid());
		cart.getCartId().setProdid(this.getProdid());
		cart.setQuantity(this.getQuantity());
		cart.getCartId().setProdid(this.getProduct().getProdid());
		cart.getCartId().setCustomerid(this.getCustomer().getCustomerid());
		
		
		return cart;
	}
	
	public static CartDTO valueOf(Cart cart) {
		
		CartDTO cartDTO=new CartDTO();
		cartDTO.setCustomerid(cart.getCartId().getCustomerid());
		cartDTO.setProdid(cart.getCartId().getProdid());
		cartDTO.setQuantity(cart.getQuantity());
		ProductDTO productDTO = new ProductDTO();
		productDTO.setProdid(cart.getCartId().getProdid());
		cartDTO.setProduct(productDTO);
		CustomerDTO customerDTO= new CustomerDTO();
		customerDTO.setCustomerid(cart.getCartId().getCustomerid());
		cartDTO.setCustomer(customerDTO);
		return cartDTO;
	}

	@Override
	public String toString() {
		return "CartDTO [customerid="+ customerid + "Prodid=" + prodid+ "quantity="+ quantity +"product="+ product+"customer="+ customer+"]";
	}
   
    
}