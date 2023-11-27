package com.example.office.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ForgetPasswordRequest {

	@JsonProperty("UserID")
	private int userId;

	@JsonProperty("Email")
	private String email;

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

}
