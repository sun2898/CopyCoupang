package com.cucu.review.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cucu.review.model.ReviewDAO;
import com.cucu.review.model.ReviewVO;

public class ReviewServiceImplements implements ReviewService {

	@Override
	public List<ReviewVO> getReview(HttpServletRequest request, HttpServletResponse response) {
		List<ReviewVO> list = new ArrayList<>();
		String name = request.getParameter("p_name");
		ReviewDAO dao = ReviewDAO.getInstance();
		list = dao.getReivew(name);
		
		return list;
	}

}
