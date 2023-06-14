package com.cucu.product.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cucu.product.model.ProductVO;

public interface ProductService {

	void insertProduct(HttpServletRequest request, HttpServletResponse response);
	
	List<ProductVO> getList(HttpServletRequest request, HttpServletResponse response);
	
	ProductVO getProduct(HttpServletRequest request, HttpServletResponse response);
	
	void addCart(HttpServletRequest request, HttpServletResponse response);

}
