package com.example.office.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AddAccountRequest {
	
	@JsonProperty("UserID")
	private int userId;
	
	@JsonProperty("PassWord")
	private String pwd;
	
	@JsonProperty("AccountState")
	private boolean accountState;
	
	@JsonProperty("AccountPermissions")
	private int accountPermissions;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public boolean isAccountState() {
		return accountState;
	}

	public void setAccountState(boolean accountState) {
		this.accountState = accountState;
	}

	public int getAccountPermissions() {
		return accountPermissions;
	}

	public void setAccountPermissions(int accountPermissions) {
		this.accountPermissions = accountPermissions;
	}
	

}
