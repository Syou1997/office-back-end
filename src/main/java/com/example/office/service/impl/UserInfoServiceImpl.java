package com.example.office.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.office.constants.RtnCode;
import com.example.office.entity.UserInfo;
import com.example.office.repository.UserInfoDao;
import com.example.office.service.ifs.UserInfoService;
import com.example.office.vo.AddUserInfoResponse;

import org.springframework.util.StringUtils;

@Service
public class UserInfoServiceImpl implements UserInfoService {

	@Autowired
	private UserInfoDao userInfoDao;

	@Override
	public AddUserInfoResponse addUserInfo(UserInfo UserInfo) {
		// 防呆判斷是否為空
		if (UserInfo == null) {
			return new AddUserInfoResponse(RtnCode.DATA_ERROR.getCode(), RtnCode.DATA_ERROR.getMessage());
		}
		UserInfo res = userInfoDao.save(UserInfo);

		return new AddUserInfoResponse(RtnCode.SUCCESSFUL.getCode(), RtnCode.SUCCESSFUL.getMessage(), res);
	}

	@Override
	public AddUserInfoResponse updateUserInfo(UserInfo UserInfo) {
		// 防呆判斷是否為空
		if (UserInfo == null) {
			return new AddUserInfoResponse(RtnCode.DATA_ERROR.getCode(), RtnCode.DATA_ERROR.getMessage());
		}
		UserInfo res = userInfoDao.save(UserInfo);

		return new AddUserInfoResponse(RtnCode.SUCCESSFUL.getCode(), RtnCode.SUCCESSFUL.getMessage(), res);
	}
	
	//取得帳戶資訊
	@Override
	public AddUserInfoResponse getUserInfo(int userId) {
		// 防呆判斷是否為空(0)
		if(userId == 0) {
			return new AddUserInfoResponse(RtnCode.DATA_ERROR.getCode(), RtnCode.DATA_ERROR.getMessage());
		}
		Optional<UserInfo> op = userInfoDao.findById(userId);
		return new AddUserInfoResponse(RtnCode.SUCCESSFUL.getCode(), RtnCode.SUCCESSFUL.getMessage(),op.get());
	}
	
	//忘記密碼之發送郵件
	@Override
	public AddUserInfoResponse forgetPassword(int userId, String email) {
		//防呆，確認帶進來的是否是空值
		if(!StringUtils.hasText(email)) {
			System.out.println(1);
			return new AddUserInfoResponse(RtnCode.DATA_ERROR.getCode(), RtnCode.DATA_ERROR.getMessage());
		}
		//防呆確認此userId是否存在
		if(!userInfoDao.existsById(userId)) {
			return new AddUserInfoResponse(RtnCode.ACCOUNT_NOT_FOUND.getCode(),RtnCode.ACCOUNT_NOT_FOUND.getMessage());
		}
		//取出user的帳戶資料比對信箱是否一致
		Optional<UserInfo> op = userInfoDao.findById(userId);
		if(op == null) {
			return new AddUserInfoResponse(RtnCode.DATA_ERROR.getCode(),RtnCode.DATA_ERROR.getMessage());
		}
		if(!op.get().getEmail().equals(email)) {	
			return new AddUserInfoResponse(RtnCode.DATA_ERROR.getCode(),"The account number or email address is incorrect");
		}
		//寄送Email
		
		
		return new AddUserInfoResponse(RtnCode.SUCCESSFUL.getCode(),"Email sent successfully");
	}
	
	//姓名的模糊搜尋
	@Override
	public AddUserInfoResponse likeSearch(String userName) {
		//防呆檢查是否是空字串
		if(!StringUtils.hasText(userName)) {
			return new AddUserInfoResponse(RtnCode.DATA_ERROR.getCode(),RtnCode.DATA_ERROR.getMessage());
		}
		//通過防呆開始關鍵字查詢
		List<UserInfo> res = userInfoDao.likeSearch(userName);
		return new AddUserInfoResponse(RtnCode.SUCCESSFUL.getCode(),RtnCode.SUCCESSFUL.getMessage(),res);
	}
	
	

	




}
