package com.cucu.member.model;

import java.sql.Timestamp;

public class MemberVO {
	
	private String m_id;
	private String m_pw;
	private String m_name;
	private String m_email;
	private String m_adress;
	private Timestamp m_regdate;
	
	//생성자
	public MemberVO() {
		
	}

	public MemberVO(String m_id, String m_pw, String m_name, String m_email, String m_adress, Timestamp m_regdate) {
		super();
		this.m_id = m_id;
		this.m_pw = m_pw;
		this.m_name = m_name;
		this.m_email = m_email;
		this.m_adress = m_adress;
		this.m_regdate = m_regdate;
	}

	//getter/setter
	public String getM_id() {
		return m_id;
	}

	public void setM_id(String m_id) {
		this.m_id = m_id;
	}

	public String getM_pw() {
		return m_pw;
	}

	public void setM_pw(String m_pw) {
		this.m_pw = m_pw;
	}

	public String getM_name() {
		return m_name;
	}

	public void setM_name(String m_name) {
		this.m_name = m_name;
	}

	public String getM_email() {
		return m_email;
	}

	public void setM_email(String m_email) {
		this.m_email = m_email;
	}

	public String getM_adress() {
		return m_adress;
	}

	public void setM_adress(String m_adress) {
		this.m_adress = m_adress;
	}

	public Timestamp getM_regdate() {
		return m_regdate;
	}

	public void setM_regdate(Timestamp m_regdate) {
		this.m_regdate = m_regdate;
	}
	
	

	
	
	
	

}
