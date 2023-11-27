package com.example.office.vo;

import java.util.List;

import com.example.office.entity.UserInfo;

public class AddUserInfoResponse {

	private String code;

	private String messgae;

	private UserInfo userInfo;
	
	private List<UserInfo> userInfoList;
	

	public AddUserInfoResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AddUserInfoResponse(String code, String messgae, UserInfo userInfo) {
		super();
		this.code = code;
		this.messgae = messgae;
		this.userInfo = userInfo;
	}
	
	

	public AddUserInfoResponse(String code, String messgae, List<UserInfo> userInfoList) {
		super();
		this.code = code;
		this.messgae = messgae;
		this.userInfoList = userInfoList;
	}

	public AddUserInfoResponse(String code, String messgae) {
		super();
		this.code = code;
		this.messgae = messgae;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessgae() {
		return messgae;
	}

	public void setMessgae(String messgae) {
		this.messgae = messgae;
	}

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public List<UserInfo> getUserInfoList() {
		return userInfoList;
	}

	public void setUserInfoList(List<UserInfo> userInfoList) {
		this.userInfoList = userInfoList;
	}
	

}
