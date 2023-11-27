package com.example.office.vo;

public class AccountAndUserinfoVo {

	private int userId;

	private String email;

	private String pwd;

	public AccountAndUserinfoVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AccountAndUserinfoVo(int userId, String email, String pwd) {
		super();
		this.userId = userId;
		this.email = email;
		this.pwd = pwd;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	@Override
	public String toString() {
		return "AccountAndUserinfoVo [userId=" + userId + ", email=" + email + ", pwd=" + pwd + "]";
	}
	

}
