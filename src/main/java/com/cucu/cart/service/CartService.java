package com.cucu.cart.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cucu.cart.model.CartVO;

public interface CartService {
	
	List<CartVO> getCart(HttpServletRequest request, HttpServletResponse response);

}
