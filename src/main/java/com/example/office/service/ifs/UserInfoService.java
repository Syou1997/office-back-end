package com.example.office.service.ifs;

import com.example.office.entity.UserInfo;
import com.example.office.vo.AddUserInfoResponse;

public interface UserInfoService {
	
	//新增帳戶資訊
	public AddUserInfoResponse addUserInfo(UserInfo UserInfo);
	
	//更新帳戶資訊
	public AddUserInfoResponse updateUserInfo(UserInfo UserInfo);
	
	//取得帳戶資訊
	public AddUserInfoResponse getUserInfo(int userId);
	
	//忘記密碼
	public AddUserInfoResponse forgetPassword(int userId,String email);
	
	//姓名的模糊搜尋
	public AddUserInfoResponse likeSearch(String userName);
}
