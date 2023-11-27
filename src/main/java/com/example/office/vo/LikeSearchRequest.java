package com.example.office.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LikeSearchRequest {

	@JsonProperty("UserName")
	private String userName;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
