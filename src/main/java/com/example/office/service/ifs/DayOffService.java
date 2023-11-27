package com.example.office.service.ifs;


import com.example.office.entity.DayOff;
import com.example.office.vo.AddLeaveResponse;

public interface DayOffService {
	
	//新增假單
	public AddLeaveResponse addLeave(DayOff dayOff);
	
	//審核(更新)假單
	public AddLeaveResponse updateLeave(DayOff dayOff);

}
