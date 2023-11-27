package com.example.office.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import com.example.office.constants.RtnCode;
import com.example.office.entity.Account;
import com.example.office.repository.AccountDao;
import com.example.office.service.ifs.AccountService;
import com.example.office.vo.AddAccountResponse;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountDao accountDao;

	// 登入
	@Override
	public Account login(int userId, String pwd) {
		// 防呆確認帳號是否存在
		if (!accountDao.existsById(userId)) {
			return new Account(404, RtnCode.ACCOUNT_NOT_FOUND.getMessage());
		}

		// 防呆確認密碼不是空白的
		if (!StringUtils.hasText(pwd)) {
			return new Account(404, RtnCode.ACCOUNT_NOT_FOUND.getMessage());
		}
		Optional<Account> op = accountDao.findById(userId);
		if (op.isEmpty()) {
			return new Account(404, RtnCode.ACCOUNT_NOT_FOUND.getMessage());
		}
		// 確認帳號是否啟用
		if (!op.get().isAccountState()) {
			return new Account(404, "This account has been disabled");
		}

		// 建立密碼加密的工具
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		// 比對密碼是否正確
		if (encoder.matches(pwd, op.get().getPwd())) {

			return new Account(200, "sign in suceesfully");
		} else {
			return new Account(400, "wrong password!");
		}

	}

	// 新增帳戶
	@Override
	public AddAccountResponse addAccount(Account AccountInfo) {
		// 防呆判斷是否為空
		if (AccountInfo == null || AccountInfo.getPwd() == null) {
			return new AddAccountResponse(RtnCode.DATA_ERROR.getCode(), RtnCode.DATA_ERROR.getMessage());
		}
		Account res = accountDao.save(AccountInfo);

		return new AddAccountResponse(RtnCode.SUCCESSFUL.getCode(), RtnCode.SUCCESSFUL.getMessage(), res);
	}

	// 取得帳戶的員工Id、密碼、啟用狀態、權限
	@Override
	public AddAccountResponse getAccount(int AccountInfo) {
		// 取得帳戶的員工Id、密碼、啟用狀態、權限
		Optional<Account> op = accountDao.findById(AccountInfo);
		if (op == null) {
			return new AddAccountResponse(RtnCode.DATA_ERROR.getCode(), RtnCode.DATA_ERROR.getMessage());
		}
		Account res = op.get();
		return new AddAccountResponse(RtnCode.SUCCESSFUL.getCode(), RtnCode.SUCCESSFUL.getMessage(), res);
	}

	// 變更密碼
	@Override
	public AddAccountResponse changePassword(int userId, String oldPwd, String newPassword) {
		// 防呆，確認帶進來的是否是空值
		if (!StringUtils.hasText(oldPwd) || !StringUtils.hasText(newPassword)) {
			return new AddAccountResponse(RtnCode.DATA_ERROR.getCode(), RtnCode.DATA_ERROR.getMessage());
		}
		// 取得帳戶的員工Id、密碼、啟用狀態、權限，再將取出來的資料更新密碼後存回去
		Optional<Account> op = accountDao.findById(userId);
		if (op == null) {
			return new AddAccountResponse(RtnCode.DATA_ERROR.getCode(), RtnCode.DATA_ERROR.getMessage());
		}
		// 建立密碼加密的工具
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		// 防呆比對密碼是否正確
		if (!encoder.matches(oldPwd, op.get().getPwd())) {
			return new AddAccountResponse(RtnCode.DATA_ERROR.getCode(), RtnCode.DATA_ERROR.getMessage());
		}
		// 將原本的資料取出
		Account newAccountInfo = op.get();
		// 將新密碼加密後蓋掉原本的舊密碼
		newAccountInfo.setPwd(encoder.encode(newPassword));

		accountDao.save(newAccountInfo);

		return new AddAccountResponse(RtnCode.SUCCESSFUL.getCode(), RtnCode.SUCCESSFUL.getMessage());
	}

	// 透過忘記密碼來變更密碼
	@Override
	public AddAccountResponse forgetChangePassword(int userId, String newPassword) {
		// 防呆，確認帶進來的是否是空值
		if (!StringUtils.hasText(newPassword)) {
			return new AddAccountResponse(RtnCode.DATA_ERROR.getCode(), RtnCode.DATA_ERROR.getMessage());
		}
		// 取得帳戶的員工Id、密碼、啟用狀態、權限，再將取出來的資料更新密碼後存回去
		Optional<Account> op = accountDao.findById(userId);
		if (op == null) {
			return new AddAccountResponse(RtnCode.DATA_ERROR.getCode(), RtnCode.DATA_ERROR.getMessage());
		}
		// 建立密碼加密的工具
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		// 防呆比對密碼是否正確

		// 將原本的資料取出
		Account newAccountInfo = op.get();
		// 將新密碼加密後蓋掉原本的舊密碼
		newAccountInfo.setPwd(encoder.encode(newPassword));

		accountDao.save(newAccountInfo);

		return new AddAccountResponse(RtnCode.SUCCESSFUL.getCode(), RtnCode.SUCCESSFUL.getMessage());
	}

}
