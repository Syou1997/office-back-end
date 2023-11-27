package com.example.office.service.impl;




import java.time.LocalDateTime;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.office.constants.RtnCode;
import com.example.office.entity.DayOff;
import com.example.office.repository.DayOffDao;
import com.example.office.service.ifs.DayOffService;
import com.example.office.vo.AddLeaveResponse;

@Service
public class DayOffServiceImpl implements DayOffService{
	
	@Autowired
	private DayOffDao dayOffDao;
	
	//新增假單
	@Override
	public AddLeaveResponse addLeave(DayOff dayOff) {
		//防呆，判斷接進來的資料是否為空
		if(!StringUtils.hasText(dayOff.getUserName())) {
			return new AddLeaveResponse(RtnCode.DATA_ERROR.getCode(),"Data cannot be null");
		}
		if(!StringUtils.hasText(dayOff.getTeam())) {
			return new AddLeaveResponse(RtnCode.DATA_ERROR.getCode(),"Data cannot be null");
		}
		if(!StringUtils.hasText(dayOff.getLeave())) {
			return new AddLeaveResponse(RtnCode.DATA_ERROR.getCode(),"Data cannot be null");
		}
		if(!StringUtils.hasText(dayOff.getLeaveReason())) {
			return new AddLeaveResponse(RtnCode.DATA_ERROR.getCode(),"Data cannot be null");
		}
		if(!StringUtils.hasText(dayOff.getPs())) {
			return new AddLeaveResponse(RtnCode.DATA_ERROR.getCode(),"Data cannot be null");
		}
		if(dayOff.getTime() <= 0){
			return new AddLeaveResponse(RtnCode.DATA_ERROR.getCode(),"\"Leave time\" is at least 1 hour");
		}
		DayOff res = dayOffDao.save(dayOff);
		return new AddLeaveResponse(RtnCode.SUCCESSFUL.getCode(),RtnCode.SUCCESSFUL.getMessage(),res);
	}
	
	//審核(更新)假單
	@Override
	public AddLeaveResponse updateLeave(DayOff dayOff) {
		Optional<DayOff> op = dayOffDao.findById(dayOff.getId());
		if(op == null) {
			return new AddLeaveResponse(RtnCode.DATA_ERROR.getCode(), RtnCode.DATA_ERROR.getMessage());
		}
		DayOff res = op.get();
		//審核者
		res.setAuditor(dayOff.getAuditor());
		//審核狀態
		res.setState(dayOff.getState());
		//審核不通過原因
		res.setFailReason(dayOff.getFailReason());
		//假單更新時間
//		res.setUpdateTime(null);
//		System.out.println("下個訊息是update時間");
//		System.out.println(dayOff.getUpdateTime());
		//前端接近來的時間會有問題，所以直接再後端now一個新的時間
		res.setUpdateTime(LocalDateTime.now());
		 
		
		//覆蓋原本的資料
		DayOff res2 = dayOffDao.save(res);
		return new AddLeaveResponse(RtnCode.SUCCESSFUL.getCode(), RtnCode.SUCCESSFUL.getMessage(), res2);
	}
	

	
	

}
