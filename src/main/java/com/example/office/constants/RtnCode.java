package com.example.office.constants;

public enum RtnCode {

	SUCCESSFUL("200","successful!"),
	TRANSACTION_SUCCESSFUL("200","transaction successful!"),
	DATA_ERROR("400","data error!"),
	INSUFFICIENT_BALANCE("400","insufficient balance!"),
	ACCOUNT_EXISTED("400","account existed!"),
	ACCOUNT_NOT_FOUND("404","account not found!"),
	PLEASE_LOGIN_FIRST("400","please login first!!"),
	ACCUONT_ALREADY_EXISTS("404","This account already exists!");
	

	private String code;

	private String message;

	private RtnCode(String code, String message) {
		this.code = code;
		this.message = message;

	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
