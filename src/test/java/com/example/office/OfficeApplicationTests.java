package com.example.office;

import java.io.File;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;

import org.junit.jupiter.api.Test;
import org.junit.platform.engine.support.descriptor.FileSystemSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.office.entity.Account;
import com.example.office.entity.DayOff;
import com.example.office.entity.Pic;
import com.example.office.entity.UserInfo;
import com.example.office.repository.AccountDao;
import com.example.office.repository.DayOffDao;
import com.example.office.repository.PicDao;
import com.example.office.repository.UserInfoDao;
import com.example.office.service.ifs.AccountService;
import com.example.office.service.ifs.DayOffService;
import com.example.office.service.ifs.UserInfoService;
import com.example.office.vo.AccountAndUserinfoVo;
import com.example.office.vo.AddUserInfoResponse;

@SpringBootTest(classes = OfficeApplication.class)
class OfficeApplicationTests {

	@Autowired
	private AccountService accountService;

	@Autowired
	private AccountDao accountDao;

	@Autowired
	private UserInfoDao userInfoDao;

	@Autowired
	private UserInfoService userInfoService;

	@Autowired
	private JavaMailSender mailSender;

	@Autowired
	private DayOffService dayOffService;

	@Autowired
	private DayOffDao dayOffDao;

	@Autowired
	private PicDao picDao;

	@Test
	public void contextLoads() {
		int res = accountDao.updateAccount(false, 2, 109037);
		System.out.println(res);

	}

	@Test
	public void encoder() {
		// 建立密碼加密的工具
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		// 密碼加密
		System.out.println(encoder.encode("abc"));
		System.out.println(encoder.encode("abc"));
		System.out.println(encoder.encode("abc"));

	}

	@Test
	public void join() {
		List<AccountAndUserinfoVo> res = userInfoDao.joinUserinfoAndAccount();
		System.out.println(res);
		res.get(0).getEmail();
		String pwd = null;
		for (AccountAndUserinfoVo item : res) {
			System.out.println(item);
			if (item.getUserId() == 109037) {
				pwd = item.getPwd();

			}

		}
		System.out.println(res.get(0).getEmail());
	}

	@Test
	public void email() {
		AddUserInfoResponse res = userInfoService.forgetPassword(109037, "chengshima5@gmail.com");
		System.out.println(res.getMessgae());

		Optional<UserInfo> op = userInfoDao.findById(109037);
		if (!op.get().getEmail().equals("chengshima5@gmail.com")) {
			System.out.println("比對成功");
		}

	}

	@Test
	public void findbypwd() {
		Account res = accountDao.findByPwd("$2a$10$or3CtZJ1nfu/8Iq/a6UEx.6qvS0gYoTHLPOKx74Dwb/S2ofYu84Fq");
		System.out.println(res.getUserId());

	}

	@Test
	public void email2() {
		Map<String, String> map = new HashMap<>();
		map.put("1", "red");
		map.put("2", "blue");
		String x = "cat";
		System.out.println(x.contains(""));
	}

	@Test
	public void likeSerach() {
		List<UserInfo> res = userInfoDao.likeSearch("y");
		System.out.println(res.size());
		String res2 = res.get(1).getUserName();
		System.out.println(res2);
	}

	@Test
	public void picTest() {
		Scanner scan = new Scanner(System.in);
		System.out.println("今天星期:");
		String input = scan.next();

		int a = 0;

		switch (input.toString()) {
		case "一":
			System.out.println("今天星期一");
			a = 1;
			break;
		case "二":
			System.out.println("今天星期二");
			a = 2;
			break;
		case "三":
			System.out.println("今天星期三");
			a = 3;
			break;
		case "四":
			System.out.println("今天星期四");
			a = 4;
			break;
		case "五":
			System.out.println("今天星期五");
			a = 5;
			break;
		case "六":
			System.out.println("今天星期六");
			a = 6;
			break;
		case "天":
			System.out.println("今天星期天");
			a = 7;
			break;
		default:
			System.out.println("請輸入(中文)的日期");
		}
		



		System.out.println("幾天後:");
		int daynumber = scan.nextInt();


		int res = a + daynumber;

		switch (res) {
		case 0:
			res = a;
		case 1:
			res = 0;
		case 2:
			res = 2;
		case 3:
			res = 3;
		case 4:
			res = 4;
		case 5:
			res = 5;
		case 6:
			res = 6;
		case 7:
			res = 7;
		case 8:
			res = 1;
			break;
		case 9:
			res = 2;
			break;
		case 10:
			res = 3;
			break;
		case 11:
			res = 4;
			break;
		case 12:
			res = 5;
			break;
		case 13:
			res = 6;
			break;
		case 14:
			res = 7;
			break;
		default:
			System.out.println("請輸入(中文)的日期");
		}

		System.out.println("今天是星期" + input + "" + daynumber + "天後是星期" + res);

	}

}
