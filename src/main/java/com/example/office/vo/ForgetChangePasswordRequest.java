package com.example.office.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ForgetChangePasswordRequest {

	@JsonProperty("UserID")
	private int userId;

	@JsonProperty("NewPassWord")
	private String newPwd;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getNewPwd() {
		return newPwd;
	}

	public void setNewPwd(String newPwd) {
		this.newPwd = newPwd;
	}

}
