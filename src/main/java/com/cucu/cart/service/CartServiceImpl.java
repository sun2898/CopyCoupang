package com.cucu.cart.service;

import java.util.ArrayList;
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
	public void clearCart(HttpServletRequest request, HttpServletResponse response) {
		
		CartDAO dao = CartDAO.getInstance();
		dao.clearCart();
		
	}

}
