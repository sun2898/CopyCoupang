package com.cucu.review.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cucu.review.model.ReviewVO;

public interface ReviewService {
	
	List<ReviewVO> getReview(HttpServletRequest request, HttpServletResponse response);
	
	void regiReview(HttpServletRequest request, HttpServletResponse response);

}
