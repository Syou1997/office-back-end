package com.example.office.controller;

import java.io.File;
import java.io.FileInputStream;
import java.util.Base64;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.office.constants.RtnCode;
import com.example.office.entity.Pic;
import com.example.office.repository.PicDao;
import com.example.office.vo.PicResponse;

@CrossOrigin
@RestController
public class PicController {
	
	@Autowired
	private PicDao picDao;
	
	
	//透過圖片Id取得圖片路徑
	@GetMapping(value = "get_pic_path/{picId}")
	public PicResponse getPicPath(@PathVariable("picId") int picId) {
		
		Optional<Pic> op = picDao.findById(picId);
		//防呆
		if(op == null) {
			return new PicResponse(RtnCode.DATA_ERROR.getCode(),RtnCode.DATA_ERROR.getMessage());
		}
		//取得圖片路徑
		String imagePath = op.get().getPicAddress();
		//讀取圖片
		File imageFile = new File(imagePath);
		try {
			FileInputStream imageInputStream = new FileInputStream(imageFile);
			// 創建緩衝空間
			byte[] imageBytes = new byte[(int) imageFile.length()];
			imageInputStream.read(imageBytes);
			imageInputStream.close();
			// 轉成Base64
			String base64Image = Base64.getEncoder().encodeToString(imageBytes);
			String resString = "data:image/" + imagePath.split("\\.")[imagePath.split("\\.").length - 1] + ";base64,"
					+ base64Image;
			return new PicResponse(RtnCode.SUCCESSFUL.getCode(),RtnCode.SUCCESSFUL.getMessage(),base64Image);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e);
			return new PicResponse(RtnCode.DATA_ERROR.getCode(), RtnCode.DATA_ERROR.getMessage());
		}
		
		
		
		
		
	}
	
}
