package com.cucu.product.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cucu.product.model.ProductDAO;
import com.cucu.product.model.ProductVO;

public class ProductServiceImpl implements ProductService{

	@Override
	public void insertProduct(HttpServletRequest request, HttpServletResponse response) {
		
		String p_name = request.getParameter("p_name");
		int price = Integer.parseInt(request.getParameter("price"));
		int stock = Integer.parseInt(request.getParameter("stock"));
		String seller = request.getParameter("seller");
		String p_detail = request.getParameter("p_detail");
		
		ProductDAO dao = ProductDAO.getInstance();
		dao.insertProduct(p_name, price, stock, seller, p_detail);
	}

	
	@Override
	public List<ProductVO> getList(HttpServletRequest request, HttpServletResponse response) {
		
		ProductDAO dao = ProductDAO.getInstance();
		List<ProductVO> list = dao.getList();

		return list;
	}


	@Override
	public ProductVO getProduct(HttpServletRequest request, HttpServletResponse response) {
		
		ProductDAO dao = ProductDAO.getInstance();
		
		String id = request.getParameter("p_name");
		ProductVO vo = dao.getProduct(id);
		
		return vo;
	}
	
	
}
