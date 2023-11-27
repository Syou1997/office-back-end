package com.example.office.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_info")
public class UserInfo {

	@Id
	@Column(name = "user_id")
	private int userId;

	@Column(name = "user_name")
	private String userName;

	@Column(name = "team")
	private String team;

	@Column(name = "email")
	private String email;

	@Column(name = "dob")
	private Date dob;

	@Column(name = "annual_leave")
	private int annualLeave;

	@Column(name = "sick_leave")
	private int sickLeave;

	@Column(name = "in_day")
	private Date inDay;

	@Column(name = "out_day")
	private Date outDay;

	@Column(name = "resign_reason")
	private String resignReason;

	public UserInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserInfo(int userId, String userName, String team, String email, Date dob, int annualLeave, int sickLeave,
			Date inDay, Date outDay, String resignReason) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.team = team;
		this.email = email;
		this.dob = dob;
		this.annualLeave = annualLeave;
		this.sickLeave = sickLeave;
		this.inDay = inDay;
		this.outDay = outDay;
		this.resignReason = resignReason;
	}


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
