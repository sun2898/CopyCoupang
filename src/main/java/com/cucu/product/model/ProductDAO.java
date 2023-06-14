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

	// 장바구니에 추가
	public void addCart(String p_name, String price, String count) {
		String selectSql = "select * from cart where p_name = ?";
		String insertSql = "insert into cart values (?, ?, 1)";
		String updateSql = "update cart set count = count + ? where p_name = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DriverManager.getConnection(url,uid,upw);
			pstmt = conn.prepareStatement(selectSql);
			pstmt.setString(1, p_name);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				pstmt.close();
				pstmt = conn.prepareStatement(updateSql);
				pstmt.setString(1, count);
				pstmt.setString(2, p_name);
				pstmt.executeUpdate();
				System.out.println("업데이트");
			} else {
				pstmt.close();
				pstmt = conn.prepareStatement(insertSql);
				pstmt.setString(1, p_name);
				pstmt.setString(2, price);
				pstmt.executeUpdate();
				System.out.println("인서트");
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
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
