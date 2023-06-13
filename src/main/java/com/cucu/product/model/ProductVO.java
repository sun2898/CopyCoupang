package com.cucu.product.model;

import java.sql.Timestamp;

public class ProductVO {
	
	private String p_name;
	private int price;
	private int stock;
	private String seller;
	private String p_detail;
	private Timestamp regdate;
	
	public ProductVO() {	}

	public ProductVO(String p_name, int price, int stock, String seller, String p_detail, Timestamp regdate) {

		super();
		this.p_name = p_name;
		this.price = price;
		this.stock = stock;
		this.seller = seller;
		this.p_detail = p_detail;
		this.regdate = regdate;

	}

	public String getP_name() {
		return p_name;
	}

	public void setP_name(String p_name) {
		this.p_name = p_name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getSeller() {
		return seller;
	}

	public void setSeller(String seller) {
		this.seller = seller;
	}

	public String getP_detail() {
		return p_detail;
	}

	public void setP_detail(String p_detail) {
		this.p_detail = p_detail;
	}

	public Timestamp getRegdate() {
		return regdate;
	}

	public void setRegdate(Timestamp regdate) {
		this.regdate = regdate;
	}
	 
}
