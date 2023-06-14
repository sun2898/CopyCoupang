package com.cucu.cart.service;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cucu.cart.model.CartDAO;
import com.cucu.cart.model.CartVO;


public class CartServiceImpl implements CartService {

	@Override
	public List<CartVO> getCart(HttpServletRequest request, HttpServletResponse response) {
		
		CartDAO dao = CartDAO.getInstance();
		List<CartVO> list = dao.getCart();
		

		return list;
	}

	@Override
	public void addCart(HttpServletRequest request, HttpServletResponse response) {
		String name = request.getParameter("name");
		String price = request.getParameter("price");
		String count = request.getParameter("count");
		System.out.println("이름" + name);
		System.out.println("가격" + price);
		System.out.println("개수" + count);
		
		CartDAO dao = CartDAO.getInstance();
		dao.addCart(name, price, count);
		
	}


	public void clearCart(HttpServletRequest request, HttpServletResponse response) {
		
		CartDAO dao = CartDAO.getInstance();
		dao.clearCart();
		
	}

}

