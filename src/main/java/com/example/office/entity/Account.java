package com.example.office.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "account")
public class Account {

	@Id
	@Column(name = "user_id")
	private int userId;

	@Column(name = "pwd")
	private String pwd;

	@Column(name = "account_state")
	private boolean accountState;

	@Column(name = "account_permissions")
	private int accountPermissions;

	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Account(int userId, String pwd, boolean accountState, int accountPermissions) {
		super();
		this.userId = userId;
		this.pwd = pwd;
		this.accountState = accountState;
		this.accountPermissions = accountPermissions;
	}

	public Account(int userId, String pwd) {
		super();
		this.userId = userId;
		this.pwd = pwd;
	}

	public Account(int userId) {
		super();
		this.userId = userId;
	}

	public Account(int userId, boolean accountState, int accountPermissions) {
		super();
		this.userId = userId;
		this.accountState = accountState;
		this.accountPermissions = accountPermissions;
	}

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
