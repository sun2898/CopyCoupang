package com.cucu.review.model;

public class ReviewDAO {
	
	private static ReviewDAO instance = new ReviewDAO();
	
	private ReviewDAO() {
		
	}
	
	public ReviewDAO getInstance() {
		return instance;
	}
	
	

}
