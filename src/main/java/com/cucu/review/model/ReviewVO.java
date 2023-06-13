package com.cucu.review.model;

import java.sql.Date;

public class ReviewVO {
	
	private String review;
	private String id;
	private String title;
	private Date regdate;
	private int star;
	
	public ReviewVO() {
		// TODO Auto-generated constructor stub
	}

	public ReviewVO(String review, String id, String title, Date regdate, int star) {
		super();
		this.review = review;
		this.id = id;
		this.title = title;
		this.regdate = regdate;
		this.star = star;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public int getStar() {
		return star;
	}

	public void setStar(int star) {
		this.star = star;
	}
	
	

}
