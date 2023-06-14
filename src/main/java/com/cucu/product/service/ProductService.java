package com.cucu.product.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cucu.product.model.ProductVO;

public interface ProductService {


	void insertProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
	
	List<ProductVO> getList(HttpServletRequest request, HttpServletResponse response);
	
	ProductVO getProduct(HttpServletRequest request, HttpServletResponse response);
	
	public void deleteProduct(HttpServletRequest request, HttpServletResponse response);
}
