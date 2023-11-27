package com.example.office.vo;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AddLeaveRequest {
	
	@JsonProperty("Id")
	private int id;

	@JsonProperty("UserID")
	private int userId;

	@JsonProperty("UserName")
	private String userName;

	@JsonProperty("Team")
	private String team;

	@JsonProperty("Leave")
	private String leave;

	@JsonProperty("LeaveReason")
	private String leaveReason;

	@JsonProperty("StartDay")
	private LocalDateTime startDay;

	@JsonProperty("EndDay")
	private LocalDateTime endDay;

	@JsonProperty("Time")
	private int time;

	@JsonProperty("Pic64")
	private String pic64;

	@JsonProperty("Ps")
	private String ps;

	@JsonProperty("Auditor")
	private String auditor;

	@JsonProperty("State")
	private String state;

	@JsonProperty("FailReason")
	private String failReason;

	@JsonProperty("UpdateTime")
	private LocalDateTime updateTime;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getLeave() {
		return leave;
	}

	public void setLeave(String leave) {
		this.leave = leave;
	}

	public String getLeaveReason() {
		return leaveReason;
	}

	public void setLeaveReason(String leaveReason) {
		this.leaveReason = leaveReason;
	}

	public LocalDateTime getStartDay() {
		return startDay;
	}

	public void setStartDay(LocalDateTime startDay) {
		this.startDay = startDay;
	}

	public LocalDateTime getEndDay() {
		return endDay;
	}

	public void setEndDay(LocalDateTime endDay) {
		this.endDay = endDay;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public String getPic64() {
		return pic64;
	}

	public void setPic64(String pic64) {
		this.pic64 = pic64;
	}

	public String getPs() {
		return ps;
	}

	public void setPs(String ps) {
		this.ps = ps;
	}

	public String getAuditor() {
		return auditor;
	}

	public void setAuditor(String auditor) {
		this.auditor = auditor;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getFailReason() {
		return failReason;
	}

	public void setFailReason(String failReason) {
		this.failReason = failReason;
	}

	public LocalDateTime getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(LocalDateTime updateTime) {
		this.updateTime = updateTime;
	}


}
