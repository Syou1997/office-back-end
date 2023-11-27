package com.example.office.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.office.constants.RtnCode;
import com.example.office.entity.UserInfo;
import com.example.office.repository.UserInfoDao;
import com.example.office.service.ifs.UserInfoService;
import com.example.office.vo.AccountAndUserinfoVo;
import com.example.office.vo.AddUserInfoRequest;
import com.example.office.vo.AddUserInfoResponse;
import com.example.office.vo.ForgetPasswordRequest;
import com.example.office.vo.LikeSearchRequest;

@CrossOrigin
@RestController
//@Controller
public class UserInfoController {

	@Autowired
	private UserInfoService userInfoService;

	@Autowired
	private UserInfoDao userInfoDao;

	@Autowired
	private JavaMailSender mailSender;

	// 新增帳戶資訊
	@PostMapping(value = "add_user_info")
	public AddUserInfoResponse addUserInfo(@RequestBody AddUserInfoRequest req) {
		int userId = userInfoDao.userInfoCheck(req.getUserId());
		// 如果userId已經存在會回傳此帳號已存在的錯誤訊息
		if (userId != 0) {
			return new AddUserInfoResponse(RtnCode.ACCUONT_ALREADY_EXISTS.getCode(),
					RtnCode.ACCUONT_ALREADY_EXISTS.getMessage());
		}
		AddUserInfoResponse res = userInfoService.addUserInfo(new UserInfo(req.getUserId(), req.getUserName(),
				req.getTeam(), req.getEmail(), req.getDob(), req.getAnnualLeave(), req.getSickLeave(), req.getInDay(),
				req.getOutDay(), req.getResignReason()));
		return res;

	}

	// 更新帳戶資訊
	@PostMapping(value = "update_user_info")
	public AddUserInfoResponse updateUserInfo(@RequestBody AddUserInfoRequest req) {
		int userId = userInfoDao.userInfoCheck(req.getUserId());
		// 如果userId不存在會回傳此帳號不存在的錯誤訊息
		if (userId != 1) {
			return new AddUserInfoResponse(RtnCode.ACCOUNT_NOT_FOUND.getCode(), RtnCode.ACCOUNT_NOT_FOUND.getMessage());
		}
		AddUserInfoResponse res = userInfoService.updateUserInfo(new UserInfo(req.getUserId(), req.getUserName(),
				req.getTeam(), req.getEmail(), req.getDob(), req.getAnnualLeave(), req.getSickLeave(), req.getInDay(),
				req.getOutDay(), req.getResignReason()));
		return res;

	}

	// 查詢帳戶是否存在。存在回傳1，不存在回傳0
	@PostMapping(value = "search_user_info")
	public int searchAccount(@RequestBody AddUserInfoRequest req) {
		int res = userInfoDao.userInfoCheck(req.getUserId());
		return res;
	}

	// 取得帳戶資訊
	@GetMapping(value = "get_userinfo/{userId}")
	public AddUserInfoResponse getUserInfo(@PathVariable("userId") int userId) {
		return userInfoService.getUserInfo(userId);
	}

	// 忘記密碼之發送郵件
	@PostMapping(value = "/mail")
	public AddUserInfoResponse sendChamgePasswordMail(@RequestBody ForgetPasswordRequest req) {
		AddUserInfoResponse res = userInfoService.forgetPassword(req.getUserId(), req.getEmail());
		if (res.getCode() != "200") {
			return res;
		}
		// 取出使用者密碼的
		List<AccountAndUserinfoVo> joinRes = userInfoDao.joinUserinfoAndAccount();
		String pwd = null;
		for (AccountAndUserinfoVo item : joinRes) {
			if (item.getUserId() == req.getUserId()) {
				pwd = item.getPwd();
				break;
			}
		}

		// 寄送變更密碼的信件
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo("chengshima5@Gmail.com", "chengshima5@Gmail.com");
		message.setSubject("WXY[密碼變更]");
		message.setText("請點擊以下連結重新設定您的密碼\n" + "http://localhost:5173/ForgetChangePassword/?pwd="+pwd);

		mailSender.send(message);
		return res;
	}
	
	//姓名的模糊搜尋
	@PostMapping(value = "/like_search")
	public AddUserInfoResponse likeSearch(@RequestBody LikeSearchRequest req){
		AddUserInfoResponse res = userInfoService.likeSearch(req.getUserName());
		return res;
	}
	
	//更新年假時數(假單結案後)
	@PostMapping(value = "annual_leave_update")
	public AddUserInfoResponse annualLeaveUpdate(@RequestBody AddUserInfoRequest req) {
		Optional<UserInfo> op = userInfoDao.findById(req.getUserId());
		if(op == null) {
			return new AddUserInfoResponse(RtnCode.DATA_ERROR.getCode(),RtnCode.DATA_ERROR.getMessage());
		}
		UserInfo res = op.get();
		int newAnnualLeave = op.get().getAnnualLeave()- req.getAnnualLeave();
		res.setAnnualLeave(newAnnualLeave);
		userInfoDao.save(res);
		return new AddUserInfoResponse(RtnCode.SUCCESSFUL.getCode(),RtnCode.SUCCESSFUL.getMessage());
	}
	
	//更新病假時數(假單結案後)
	@PostMapping(value = "sick_leave_update")
	public AddUserInfoResponse sickLeaveUpdate(@RequestBody AddUserInfoRequest req) {
		Optional<UserInfo> op = userInfoDao.findById(req.getUserId());
		if(op == null) {
			return new AddUserInfoResponse(RtnCode.DATA_ERROR.getCode(),RtnCode.DATA_ERROR.getMessage());
		}
		UserInfo res = op.get();
		int newSickLeave = op.get().getSickLeave() - req.getSickLeave();
		res.setSickLeave(newSickLeave);
		userInfoDao.save(res);
		return new AddUserInfoResponse(RtnCode.SUCCESSFUL.getCode(),RtnCode.SUCCESSFUL.getMessage());
		
		
		
	}

}
