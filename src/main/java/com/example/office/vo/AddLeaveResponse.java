package com.example.office.vo;

import java.util.List;

import com.example.office.entity.DayOff;

public class AddLeaveResponse {

	private String code;

	private String messgae;

	private DayOff dayOff;
	
	private List<DayOff> dayOffList;

	public AddLeaveResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AddLeaveResponse(String code, String messgae, DayOff dayOff) {
		super();
		this.code = code;
		this.messgae = messgae;
		this.dayOff = dayOff;
	}
	
	

	public AddLeaveResponse(String code, String messgae, List<DayOff> dayOffList) {
		super();
		this.code = code;
		this.messgae = messgae;
		this.dayOffList = dayOffList;
	}

	public AddLeaveResponse(String code, String messgae) {
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

	public DayOff getDayOff() {
		return dayOff;
	}

	public void setDayOff(DayOff dayOff) {
		this.dayOff = dayOff;
	}

	public List<DayOff> getDayOffList() {
		return dayOffList;
	}

	public void setDayOffList(List<DayOff> dayOffList) {
		this.dayOffList = dayOffList;
	}

	
}
