package com.cucu.review.model;

import java.sql.Timestamp;

public class ReviewVO {
	
	private String review;
	private String m_id;
	private String p_name;
	private Timestamp regdate;
	private int star;
	
	
	public ReviewVO() {
		// TODO Auto-generated constructor stub
	}


	public ReviewVO(String review, String m_id, String p_name, Timestamp regdate, int star) {
		super();
		this.review = review;
		this.m_id = m_id;
		this.p_name = p_name;
		this.regdate = regdate;
		this.star = star;
	}


	public String getReview() {
		return review;
	}


	public void setReview(String review) {
		this.review = review;
	}


	public String getM_id() {
		return m_id;
	}


	public void setM_id(String m_id) {
		this.m_id = m_id;
	}


	public String getP_name() {
		return p_name;
	}


	public void setP_name(String p_name) {
		this.p_name = p_name;
	}


	public Timestamp getRegdate() {
		return regdate;
	}


	public void setRegdate(Timestamp regdate) {
		this.regdate = regdate;
	}


	public int getStar() {
		return star;
	}


	public void setStar(int star) {
		this.star = star;
	}
	
	

}
