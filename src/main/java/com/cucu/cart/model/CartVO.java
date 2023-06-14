package com.cucu.cart.model;

public class CartVO {
	
	private String p_name;
	private String price;
	private String count;
	
	public CartVO() {
		// TODO Auto-generated constructor stub
	}

	public CartVO(String p_name, String price, String count) {
		super();
		this.p_name = p_name;
		this.price = price;
		this.count = count;
	}

	public String getP_name() {
		return p_name;
	}

	public void setP_name(String p_name) {
		this.p_name = p_name;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}
	
	

}
