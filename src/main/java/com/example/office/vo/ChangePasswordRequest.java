package com.example.office.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ChangePasswordRequest {

	@JsonProperty("UserID")
	private int userId;

	@JsonProperty("OldPassWord")
	private String oldPwd;

	@JsonProperty("NewPassWord")
	private String newPwd;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getOldPwd() {
		return oldPwd;
	}

	public void setOldPwd(String oldPwd) {
		this.oldPwd = oldPwd;
	}

	public String getNewPwd() {
		return newPwd;
	}

	public void setNewPwd(String newPwd) {
		this.newPwd = newPwd;
	}

}
