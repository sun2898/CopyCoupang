package com.cucu.review.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class ReviewDAO {
	
	private static ReviewDAO instance = new ReviewDAO();
	
	private ReviewDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static ReviewDAO getInstance() {
		return instance;
	}
	
	private String url = "jdbc:oracle:thin:@172.30.1.89:1521:xe";
	private String uid = "JSPPN";
	private String upw = "JSPPN";
	
	public List<ReviewVO> getReivew(String p_name){
		List<ReviewVO> list = new ArrayList<>();
		String sql = "select * from review where p_name = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, p_name);
			rs = pstmt.executeQuery();

			while(rs.next()) {
				String review = rs.getString("REVIEW");
				String id = rs.getString("M_ID");
				String name = rs.getString("P_NAME");
				Timestamp regdate = rs.getTimestamp("REGDATE");
				int star = rs.getInt("STAR");
				ReviewVO vo = new ReviewVO(review, id, name, regdate, star);
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

	public void regiReview(String review, String m_id, String p_name, String star) {
		
		String sql = "insert into review values(?,?,?, sysdate, ?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		System.out.println("리뷰입장");
		try {
			conn = DriverManager.getConnection(url,uid,upw);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, review);
			pstmt.setString(2, m_id);
			pstmt.setString(3, p_name);
			pstmt.setString(4, star);
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
