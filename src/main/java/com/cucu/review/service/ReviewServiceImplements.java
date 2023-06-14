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

	@Override
	public void regiReview(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("member_id");
		String name = (String)request.getParameter("p_name");
		String review = (String)request.getParameter("content");
		String star = (String)request.getParameter("rating");
		ReviewDAO dao = ReviewDAO.getInstance();
		dao.regiReview(review, id, name, star);
		
	}

}
