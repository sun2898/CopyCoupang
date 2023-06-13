package com.cucu.member.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;

public class MemberDAO {

	private static MemberDAO instance = new MemberDAO();

	// 싱글톤
	private MemberDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
		}
	}

	public static MemberDAO getInstance() {
		return instance;
	}

	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String uid = "JSPPN";
	private String upw = "JSPPN";

	// 아이디 중복검사
	public int idCheck(String m_id) {

		int result = 1;

		String sql = "select * from member where m_id = ?";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 1. Connector
			conn = DriverManager.getConnection(url, uid, upw);
			// 2. pstmt
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m_id);
			// 3. ResultSet
			rs = pstmt.executeQuery(); // select문

			if (rs.next()) { // 중복 o
				result = 1;
			} else { // 중복 x
				result = 0;
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
		System.out.println(result);
		return result;
	}

	// 회원가입
	public void join(MemberVO vo) {

		String sql = "insert into member(m_id, m_pw, m_name, m_email, m_adress, m_type) values(?,?,?,?,?,?)";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {

			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, vo.getM_id());
			pstmt.setString(2, vo.getM_pw());
			pstmt.setString(3, vo.getM_name());
			pstmt.setString(4, vo.getM_email());
			pstmt.setString(5, vo.getM_adress());
			pstmt.setString(6, vo.getM_type());

			pstmt.executeQuery();

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

	// 로그인
	public MemberVO login(String m_id, String m_pw) {

		MemberVO vo = null;

		String sql = "select * from member where m_id = ? and m_pw =?";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m_id);
			pstmt.setString(2, m_pw);

			rs = pstmt.executeQuery();

			while (rs.next()) {

				String m_id2 = rs.getString("m_id");
				String m_pw2 = rs.getString("m_pw");
				String m_name = rs.getString("m_name");
				String m_email = rs.getString("m_email");
				String m_address = rs.getString("m_adress");
				Timestamp m_regdate = rs.getTimestamp("m_regdate");
				String m_type = rs.getString("m_type");

				vo = new MemberVO(m_id2, m_pw2, m_name, m_email, m_address, m_regdate, m_type);
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
		return vo;
	}

	// 회원정보 조회
	public MemberVO getInfo(String m_id) {

		MemberVO vo = null;

		String sql = "select * from member where m_id = ?";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m_id);
			rs = pstmt.executeQuery();

			while (rs.next()) {

				String m_id2 = rs.getString("m_id");
				String m_name = rs.getString("m_name");
				String m_email = rs.getString("m_email");
				String m_adress = rs.getString("m_adress");
				String m_type = rs.getString("m_type");

				vo = new MemberVO(m_id2, null, m_name, m_email, m_adress, null, m_type);

			}

		} catch (Exception e) {
		} finally {
			try {
				conn.close();
				pstmt.close();
				rs.close();
			} catch (Exception e2) {
			}
		}

		return vo;
	}

	// 회원정보 수정
	public int updateInfo(MemberVO vo) {
		int result = 0;

		String sql = "update member set m_pw = ?, m_name = ?, m_email = ?, m_adress = ?, m_type = ? where m_id = ?";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {

			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, vo.getM_pw());
			pstmt.setString(2, vo.getM_name());
			pstmt.setString(3, vo.getM_email());
			pstmt.setString(4, vo.getM_adress());
			pstmt.setString(5, vo.getM_type());
			pstmt.setString(6, vo.getM_id());

			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
			} catch (Exception e2) {
			}
		}

		return result;
	}

	// 회원탈퇴
	public int deleteInfo(String m_id) {
		
		int result = 0;
		
		String Sql = "delete from member where m_id = ?";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			
			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(Sql);
			pstmt.setString(1, m_id);
			
			result = pstmt.executeUpdate();


		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();

			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return result;

	}


}
