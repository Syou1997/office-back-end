package com.example.office.vo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AddUserInfoRequest {

	@JsonProperty("UserID")
	private int userId;

	@JsonProperty("UserName")
	private String userName;

	@JsonProperty("Team")
	private String team;

	@JsonProperty("Email")
	private String email;

	@JsonProperty("Dob")
	private Date dob;

	@JsonProperty("AnnualLeave")
	private int annualLeave;

	@JsonProperty("SickLeave")
	private int sickLeave;

	@JsonProperty("InDay")
	private Date inDay;

	@JsonProperty("OutDay")
	private Date outDay;

	@JsonProperty("ResignReason")
	private String resignReason;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public int getAnnualLeave() {
		return annualLeave;
	}

	public void setAnnualLeave(int annualLeave) {
		this.annualLeave = annualLeave;
	}

	public int getSickLeave() {
		return sickLeave;
	}

	public void setSickLeave(int sickLeave) {
		this.sickLeave = sickLeave;
	}

	public Date getInDay() {
		return inDay;
	}

	public void setInDay(Date inDay) {
		this.inDay = inDay;
	}

	public Date getOutDay() {
		return outDay;
	}

	public void setOutDay(Date outDay) {
		this.outDay = outDay;
	}

	public String getResignReason() {
		return resignReason;
	}

	public void setResignReason(String resignReason) {
		this.resignReason = resignReason;
	}

}
