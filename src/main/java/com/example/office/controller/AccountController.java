package com.example.office.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.office.constants.RtnCode;
import com.example.office.entity.Account;
import com.example.office.repository.AccountDao;
import com.example.office.service.ifs.AccountService;
import com.example.office.vo.AddAccountRequest;
import com.example.office.vo.AddAccountResponse;
import com.example.office.vo.ChangePasswordRequest;
import com.example.office.vo.ForgetChangePasswordRequest;

@CrossOrigin
@RestController
//@Controller
public class AccountController {

	@Autowired
	private AccountService accountService;

	@Autowired
	private AccountDao accountDao;

	// 登入
	@PostMapping(value = "login")
	public Account login(@RequestBody Account Req, HttpSession httpSession) {
		Account res = accountService.login(Req.getUserId(), Req.getPwd());
		// 回傳數字200代表登入成功
		if (res.getUserId() == 200) {
			// 請httpSession暫存帳密
			httpSession.setAttribute("userId", Req.getUserId());
			httpSession.setAttribute("password", Req.getPwd());
			// 設定httpSession的暫存時間(秒)
			// Session預設存活時間是30分鐘，更改活時間是60分鐘
			httpSession.setMaxInactiveInterval(3600);
			System.out.println(httpSession.getId());
			Object op = httpSession.getAttribute("userId");
			return res;

		} else {
			return res;
		}
	}

	// 登出
	@PostMapping(value = "logout")
	public AddAccountResponse logout(HttpSession httpSession) {
		httpSession.invalidate();
		return new AddAccountResponse(RtnCode.SUCCESSFUL.getCode(), "Logout successful");
	}

	// 取得存進HttpSessio裡的帳號(員工ID)
	@PostMapping(value = "get/userid")
	public AddAccountResponse getUseIdInSessio(HttpSession httpSession) {
		Object op = httpSession.getAttribute("userId");
		int userId = (int) httpSession.getAttribute("userId");
		// 如果Session失效救回傳錯誤訊息
		if (op == null) {
			return new AddAccountResponse(RtnCode.PLEASE_LOGIN_FIRST.getCode(),
					RtnCode.PLEASE_LOGIN_FIRST.getMessage());
		}
		// Session還沒失效就回傳userId給前端
		else {
			return new AddAccountResponse(RtnCode.SUCCESSFUL.getCode(), RtnCode.SUCCESSFUL.getMessage(),
					new Account(userId));
		}

	}

	// 新增帳戶
	@PostMapping(value = "add_account")
	public AddAccountResponse addAccount(@RequestBody AddAccountRequest req) {
		int userId = accountDao.userIdCheck(req.getUserId());
		// 如果userId已經存在會回傳已經有此帳號的錯誤訊息
		if (userId != 0) {
			return new AddAccountResponse(RtnCode.ACCUONT_ALREADY_EXISTS.getCode(),
					RtnCode.ACCUONT_ALREADY_EXISTS.getMessage());
		}
		// 建立密碼加密的工具
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		// 密碼加密
		encoder.encode(req.getPwd());
		return accountService.addAccount(new Account(req.getUserId(), encoder.encode(req.getPwd()),
				req.isAccountState(), req.getAccountPermissions()));
	}

	// 更新帳戶
	@PostMapping(value = "update_account")
	public AddAccountResponse updateAccount(@RequestBody AddAccountRequest req) {
		int userId = accountDao.userIdCheck(req.getUserId());
		// 如果userId不存在會回傳不存在此帳號的錯誤訊息
		if (userId != 1) {
			return new AddAccountResponse(RtnCode.ACCOUNT_NOT_FOUND.getCode(), RtnCode.ACCOUNT_NOT_FOUND.getMessage());
		}
		// 更新資訊
		int res = accountDao.updateAccount(req.isAccountState(), req.getAccountPermissions(), req.getUserId());
		if (res == 1) {
			return new AddAccountResponse(RtnCode.SUCCESSFUL.getCode(), RtnCode.SUCCESSFUL.getMessage());

		} else {
			return new AddAccountResponse(RtnCode.DATA_ERROR.getCode(), RtnCode.DATA_ERROR.getMessage());
		}

	}

	// 查詢帳戶是否存在。存在回傳1，不存在回傳0
	@PostMapping(value = "search_account")
	public int searchAccount(@RequestBody AddAccountRequest req) {
		int res = accountDao.userIdCheck(req.getUserId());
		return res;
	}

	// 取得帳戶的員工Id、密碼、啟用狀態、權限
	@GetMapping(value = "get_account_info")
	public AddAccountResponse getPost(@RequestParam int userId) {
		return accountService.getAccount(userId);

	}

	// 變更密碼
	@PostMapping(value = "change_password")
	public AddAccountResponse changePassword(@RequestBody ChangePasswordRequest req) {
		// 防呆，不能帶空值
		if (req == null) {
			return new AddAccountResponse(RtnCode.DATA_ERROR.getCode(), RtnCode.DATA_ERROR.getMessage());
		}
		
		return accountService.changePassword(req.getUserId(),req.getOldPwd(),req.getNewPwd());
	}
	
	//取得忘記帳號的變更密碼的UserID
	@GetMapping(value = "pwd_to_userid")
	public AddAccountResponse pwdToUserid(@RequestParam String pwd) {
		System.out.println("1");
		System.out.println(pwd);
		Account res = accountDao.findByPwd(pwd);
		System.out.println(res.getUserId());
		return new AddAccountResponse(RtnCode.SUCCESSFUL.getCode(),RtnCode.SUCCESSFUL.getMessage(),res);
		
	}
	
	// 透過忘記密碼來變更密碼
	@PostMapping(value = "forget_change_password")
	public AddAccountResponse forgetChangePassword(@RequestBody ForgetChangePasswordRequest req) {
		
		return accountService.forgetChangePassword(req.getUserId(),req.getNewPwd());
	}
}
