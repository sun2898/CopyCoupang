package com.cucu.product.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
	
	private static ProductDAO instance = new ProductDAO();
	
	private ProductDAO() {
		//생성자에서 드라이버클래스 호출
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	//3. getter를 통해서 객체를 반환
	public static ProductDAO getInstance() {
		return instance;
	}
	
	//데이터베이스 연결주소 + 오라클 커넥터
	private String url = "jdbc:oracle:thin:@172.30.1.89:1521:xe";
	private String uid = "JSPPN";
	private String upw = "JSPPN";
	
	/**
	 * 
	 * @author 20230612 김유리
	 */


	public void insertProduct(String p_name, String price, String stock, String seller, String p_detail, String imgName, String imgPath) {

		String sql = "INSERT INTO PRODUCT(P_NAME, PRICE, STOCK, SELLER, P_DETAIL, IMGNAME, IMGPATH) VALUES(?, ?, ?, ?, ?, ?, ?)";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, p_name);
			pstmt.setString(2, price);
			pstmt.setString(3, stock);
			pstmt.setString(4, seller);
			pstmt.setString(5, p_detail);
			pstmt.setString(6, imgName);
			pstmt.setString(7, imgPath);
			
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
			} catch (Exception e2) {
			}
		}
	}

	public List<ProductVO> getList(){

		List<ProductVO> list = new ArrayList<>();
		
		String sql = "SELECT * FROM PRODUCT";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String p_name = rs.getString("p_name");
				int price = rs.getInt("price");
				int stock = rs.getInt("stock");
				String seller = rs.getString("seller");
				String p_detail = rs.getString("p_detail");
				Timestamp regdate = rs.getTimestamp("regdate");
				String imgName = rs.getString("imgName");
				String imgPath = rs.getString("imgPath");

				ProductVO vo = new ProductVO(p_name, price, stock, seller, p_detail, regdate, imgName, imgPath);

				
				list.add(vo);
				for (ProductVO product : list) {
				    System.out.println("상품 이름: " + product.getP_name());
				    System.out.println("가격: " + product.getPrice());
				    System.out.println("재고: " + product.getStock());
				    System.out.println("판매자: " + product.getSeller());
				    System.out.println("상세 정보: " + product.getP_detail());
				    System.out.println("등록일: " + product.getRegdate());
				    System.out.println("이미지 이름: " + product.getImgName());
				    System.out.println("이미지 경로: " + product.getImgPath());
				    System.out.println("--------------------------------");
				}
				list.toString();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
				rs.close();
			} catch (Exception e2) {
			}
		}

		return list;
	}
	
	public ProductVO getProduct(String p_name) {
		ProductVO vo = new ProductVO();
		String sql = "select * from product where p_name = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DriverManager.getConnection(url,uid,upw);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, p_name);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				String name = rs.getString("P_NAME");
				int price = rs.getInt("PRICE");
				int stock = rs.getInt("STOCK");
				String seller = rs.getString("SELLER");
				String p_detail = rs.getString("P_DETAIL");
				Timestamp regdate = rs.getTimestamp("REGDATE");
				String imgName = rs.getString("IMGNAME");
				String imgPath = rs.getString("IMGPATH");
				vo = new ProductVO(name, price, stock, seller, p_detail, regdate, imgName, imgPath);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
				rs.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return vo;
	}

	
	public void deleteProduct(String p_name) {
		
		String sql = "DELETE FROM PRODUCT WHERE P_NAME = ?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

}
