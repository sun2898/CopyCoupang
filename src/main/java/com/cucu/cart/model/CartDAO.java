package com.cucu.cart.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CartDAO {

	private static CartDAO instance = new CartDAO();

	private CartDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static CartDAO getInstance() {
		return instance;
	}

	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String uid = "JSP";
	private String upw = "JSP";

	public List<CartVO> getCart() {
		List<CartVO> list = new ArrayList<>();
		String sql = "select * from cart";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DriverManager.getConnection(url,uid,upw);
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String p_name = rs.getString("P_NAME");
				String price = rs.getString("PRICE");
				String count = rs.getString("COUNT");
				CartVO vo = new CartVO(p_name, price, count);
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
				e2.printStackTrace();
			}
		}
		return list;
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