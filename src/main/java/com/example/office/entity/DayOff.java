package com.example.office.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "day_off")
public class DayOff {

	@Id
	@Column(name = "id")
	private int id;

	@Column(name = "user_id")
	private int userId;

	@Column(name = "user_name")
	private String userName;

	@Column(name = "team")
	private String team;

	@Column(name = "lleave")
	private String leave;

	@Column(name = "leave_reason")
	private String leaveReason;

	@Column(name = "start_day")
	private LocalDateTime startDay;

	@Column(name = "end_day")
	private LocalDateTime endDay;

	@Column(name = "time")
	private int time;

	@Column(name = "pic_id")
	private int picId;

	@Column(name = "ps")
	private String ps;

	@Column(name = "auditor")
	private String auditor;

	@Column(name = "state")
	private String state;

	@Column(name = "fail_reason")
	private String failReason;

	@Column(name = "update_time")
	private LocalDateTime updateTime;

	public DayOff() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DayOff(int userId, String userName, String team, String leave, String leaveReason, LocalDateTime startDay,
			LocalDateTime endDay, int time, int picId, String ps, String auditor, String state, String failReason,
			LocalDateTime updateTime) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.team = team;
		this.leave = leave;
		this.leaveReason = leaveReason;
		this.startDay = startDay;
		this.endDay = endDay;
		this.time = time;
		this.picId = picId;
		this.ps = ps;
		this.auditor = auditor;
		this.state = state;
		this.failReason = failReason;
		this.updateTime = updateTime;
	}

	public DayOff(int userId, String userName, String team, String leave, String leaveReason, LocalDateTime startDay,
			LocalDateTime endDay, int time, int picId, String ps, String state, LocalDateTime updateTime) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.team = team;
		this.leave = leave;
		this.leaveReason = leaveReason;
		this.startDay = startDay;
		this.endDay = endDay;
		this.time = time;
		this.picId = picId;
		this.ps = ps;
		this.state = state;
		this.updateTime = updateTime;
	}

	public DayOff(int userId, String userName, String team, String leave, String leaveReason, LocalDateTime startDay,
			LocalDateTime endDay, int time, String ps, String state, LocalDateTime updateTime) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.team = team;
		this.leave = leave;
		this.leaveReason = leaveReason;
		this.startDay = startDay;
		this.endDay = endDay;
		this.time = time;
		this.ps = ps;
		this.state = state;
		this.updateTime = updateTime;
	}

	public DayOff(int id, int userId, String userName, String team, String leave, String leaveReason,
			LocalDateTime startDay, LocalDateTime endDay, int time, int picId, String ps, String auditor, String state,
			String failReason, LocalDateTime updateTime) {
		super();
		this.id = id;
		this.userId = userId;
		this.userName = userName;
		this.team = team;
		this.leave = leave;
		this.leaveReason = leaveReason;
		this.startDay = startDay;
		this.endDay = endDay;
		this.time = time;
		this.picId = picId;
		this.ps = ps;
		this.auditor = auditor;
		this.state = state;
		this.failReason = failReason;
		this.updateTime = updateTime;
	}

	public DayOff(int id, String auditor, String state, String failReason, LocalDateTime updateTime) {
		super();
		this.id = id;
		this.auditor = auditor;
		this.state = state;
		this.failReason = failReason;
		this.updateTime = updateTime;
	}

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

	public int getPicId() {
		return picId;
	}

	public void setPicId(int picId) {
		this.picId = picId;
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
