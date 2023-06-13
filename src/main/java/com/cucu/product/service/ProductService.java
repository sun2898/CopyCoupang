package com.cucu.product.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ProductService {


	void insertProduct(HttpServletRequest request, HttpServletResponse response);
	
	List<ProductVO> getList(HttpServletRequest request, HttpServletResponse response);
	
	ProductVO getProduct(HttpServletRequest request, HttpServletResponse response);


}
