package com.management.cartMS.entity;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Embeddable;

@SuppressWarnings("serial")
@Embeddable
public class CartId implements Serializable {
	@Column(name = "customerid",nullable = false)
	private int customerid;
	
	@Column(name = "prodid",nullable = false)
	private int prodid;
	

	public CartId(int customerid, int prodid) {
		super();
		this.customerid = customerid;
		this.prodid = prodid;
		
	}

	public CartId() {
		super();
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


}