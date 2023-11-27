package com.example.office.vo;

import com.example.office.entity.Account;

public class AddAccountResponse {

	private String code;

	private String messgae;

	private Account account;

	public AddAccountResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AddAccountResponse(String code, String messgae, Account account) {
		super();
		this.code = code;
		this.messgae = messgae;
		this.account = account;
	}
	
	
	public AddAccountResponse(String code, String messgae) {
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

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

}
