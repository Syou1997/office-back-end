package com.example.office.controller;

import java.io.File;

import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Base64;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.office.constants.RtnCode;
import com.example.office.entity.DayOff;
import com.example.office.entity.Pic;
import com.example.office.repository.DayOffDao;
import com.example.office.repository.PicDao;
import com.example.office.service.ifs.DayOffService;
import com.example.office.vo.AddLeaveRequest;
import com.example.office.vo.AddLeaveResponse;

@CrossOrigin
@RestController
public class DayOffController {

	@Autowired
	private DayOffService dayOffService;

	@Autowired
	private DayOffDao dayOffDao;

	@Autowired
	private PicDao picDao;

	// 新增假單
	@PostMapping(value = "add_leave")
	public AddLeaveResponse addLeave(@RequestBody AddLeaveRequest req) {
		LocalDateTime a = req.getEndDay();
		System.out.println(a);
		// 先判斷是否不是病假
		if (!req.getLeave().equals("病假")) {

			return dayOffService.addLeave(new DayOff(req.getUserId(), req.getUserName(), req.getTeam(), req.getLeave(),
					req.getLeaveReason(), req.getStartDay(), req.getEndDay(), req.getTime(), req.getPs(),
					req.getState(), req.getUpdateTime()));

		}
		// 是病假就要存入病假證明的圖片
		else {
			// 防呆
			if (!StringUtils.hasText(req.getPic64())) {
				return new AddLeaveResponse(RtnCode.DATA_ERROR.getCode(), "Please upload sick leave certificate");

			}
			// 先判斷使用者的資料夾是否存在沒有就建立
			File dir = new File("D:\\java_project\\office\\img\\" + req.getUserId());
			if (dir.exists()) {
				System.out.println("資料夾已經存在");
			} else {
				dir.mkdir();
				System.out.println("資料夾創建成功");
			}

			// 新增至資料庫 取得自動增長ID
			String address = "D:\\java_project\\office\\img\\" + req.getUserId(); // 存檔位置
			picDao.save(new Pic(address));
			List<Pic> res = picDao.getPicId();
			int picId = res.get(0).getPicId(); // 圖片Id
			String picIdStr = Integer.toString(picId); // 圖片檔名
			// 抓副檔名 與 抓圖片資料
			String pic64Type = req.getPic64().split("/|;")[1]; // 圖片副檔名
			String pic64Image = req.getPic64().split(",")[1]; // 圖片資料
			// 將正確的路徑正式存入圖片的Table
			String addressAll = address + "\\" + picIdStr + "." + pic64Type; // 存檔位置+檔名+附檔名
			// 將圖片的Id和儲存路徑存入
			picDao.save(new Pic(picId, addressAll));

			// 解碼Base64轉成JPEG文件
			byte[] imageBytes = Base64.getDecoder().decode(pic64Image);

			// 指定JPEG儲存路徑 (存檔位置 + 檔名 + 附檔名)
			String outputPath = addressAll;
			System.out.println(outputPath);

			// 創建文件輸出並將其寫入文件
			FileOutputStream imageOutputStream;
			try {
				imageOutputStream = new FileOutputStream(outputPath, true);
				imageOutputStream.write(imageBytes);
				imageOutputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

			System.out.println("圖片儲存完成");

			// 將接進來的資料全部存入day_off的Table

			AddLeaveResponse resInfo = dayOffService.addLeave(new DayOff(req.getUserId(), req.getUserName(),
					req.getTeam(), req.getLeave(), req.getLeaveReason(), req.getStartDay(), req.getEndDay(),
					req.getTime(), picId, req.getPs(), req.getState(), req.getUpdateTime()));

			return resInfo;

		}

	}

	// 取得自己的假單(員工用)
	@GetMapping(value = "get_leave/{userId}")
	public AddLeaveResponse getUserLeave(@PathVariable("userId") int userId) {
		// 防呆
		if (userId <= 0) {
			return new AddLeaveResponse(RtnCode.DATA_ERROR.getCode(), RtnCode.DATA_ERROR.getMessage());
		}
		List<DayOff> res = dayOffDao.findAllByUserId(userId);
		//反轉List
		Collections.reverse(res);
		return new AddLeaveResponse(RtnCode.SUCCESSFUL.getCode(), RtnCode.SUCCESSFUL.getMessage(), res);
	}

	// 取得所有員工的假單(HR人資部門或管理人用)
	@GetMapping(value = "get_leave/all")
	public AddLeaveResponse getUserLeaveAll() {
		List<DayOff> res = dayOffDao.findAll();
		//反轉List
		Collections.reverse(res);
		return new AddLeaveResponse(RtnCode.SUCCESSFUL.getCode(), RtnCode.SUCCESSFUL.getMessage(), res);
	}

	// 取得同部門的假單(主管用)
	@GetMapping(value = "get_leave_by/{team}")
	public AddLeaveResponse getUserLeaveTeam(@PathVariable("team") String team) {
		List<DayOff> infoList = dayOffDao.findAllByTeam(team);
		//反轉List
		Collections.reverse(infoList);
		return new AddLeaveResponse(RtnCode.SUCCESSFUL.getCode(), RtnCode.SUCCESSFUL.getMessage(), infoList);

	}
	
	//取得單筆假單(簽核用)
	@GetMapping(value = "get_leave_one/{leaveId}")
	public AddLeaveResponse getLeaveOne(@PathVariable("leaveId") int leaveId) {
		Optional<DayOff> op = dayOffDao.findById(leaveId);
		if(op == null) {
			return new AddLeaveResponse(RtnCode.DATA_ERROR.getCode(), RtnCode.DATA_ERROR.getMessage());
		}
		return new AddLeaveResponse(RtnCode.SUCCESSFUL.getCode(), RtnCode.SUCCESSFUL.getMessage(), op.get());
	}
	
	//更新假單資訊(簽核用)
	@PostMapping(value = "update_leave")
	public AddLeaveResponse updateLeave(@RequestBody AddLeaveRequest req) {
		AddLeaveResponse res = dayOffService.updateLeave(new DayOff(req.getId(),req.getAuditor(),req.getState(),req.getFailReason(),req.getUpdateTime()));
		return res;
	}
	

}
