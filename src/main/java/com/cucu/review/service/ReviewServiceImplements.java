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
		HttpSession session = request.getSession();
		String m_id = (String)session.getAttribute("m_id");
		System.out.println(m_id);
		String p_name = request.getParameter("p_name");
		System.out.println("리뷰" + p_name);
		ReviewDAO dao = ReviewDAO.getInstance();
		list = dao.getReivew(m_id, p_name);
		
		return list;
	}

}
