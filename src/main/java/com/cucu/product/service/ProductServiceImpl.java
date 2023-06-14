package com.cucu.product.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cucu.product.model.ProductDAO;
import com.cucu.product.model.ProductVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class ProductServiceImpl implements ProductService{

	@Override
	public void insertProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String savePath = request.getServletContext().getRealPath("img");

		int maxSize = 5 * 1024* 1024;
		String enType = "UTF-8";
		
		
			MultipartRequest multi = new MultipartRequest(request, savePath, maxSize, enType, new DefaultFileRenamePolicy());
			
			String p_name = multi.getParameter("p_name");
			String price = multi.getParameter("price");
			String stock = multi.getParameter("stock");
			String seller = multi.getParameter("seller");
			String p_detail = multi.getParameter("p_detail");
			String imgName = multi.getFilesystemName("imgName");
			String imgPath = savePath + "/" + imgName;
			
			if(imgName == null) {
				imgName = multi.getParameter("No Image");
				imgPath = multi.getParameter("No Image");
			}
			
			ProductDAO dao = ProductDAO.getInstance();
			dao.insertProduct(p_name, price, stock, seller, p_detail, imgName, imgPath);
			
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
		
		String name = request.getParameter("p_name");
		System.out.println(name);
		ProductVO vo = dao.getProduct(name);
		
		return vo;
	}

	
	public void deleteProduct(HttpServletRequest request, HttpServletResponse response) {
		
		String p_name = request.getParameter("p_name");
		ProductDAO dao = ProductDAO.getInstance();
		dao.deleteProduct(p_name);
		
	}

}
