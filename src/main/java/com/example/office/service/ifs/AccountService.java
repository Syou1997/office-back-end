package com.example.office.service.ifs;

import com.example.office.entity.Account;
import com.example.office.vo.AddAccountResponse;

public interface AccountService {

	// 登入
	public Account login(int userId, String pwd);

	// 新增帳戶
	public AddAccountResponse addAccount(Account AccountInfo);

	// 取得帳戶的員工Id、密碼、啟用狀態、權限
	public AddAccountResponse getAccount(int AccountInfo);
	
	//變更密碼
	public AddAccountResponse changePassword(int userId,String oldPwd,String newPassword);
	
	//透過忘記密碼來變更密碼
	public AddAccountResponse forgetChangePassword(int userId,String newPassword);
	

}
