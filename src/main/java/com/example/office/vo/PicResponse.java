package com.example.office.vo;

public class PicResponse {

	private String code;

	private String messgae;

	private String img64;

	public PicResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PicResponse(String code, String messgae, String img64) {
		super();
		this.code = code;
		this.messgae = messgae;
		this.img64 = img64;
	}
	

	public PicResponse(String code, String messgae) {
		super();
		this.code = code;
		this.messgae = messgae;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessgae() {
		return messgae;
	}

	public void setMessgae(String messgae) {
		this.messgae = messgae;
	}

	public String getImg64() {
		return img64;
	}

	public void setImg64(String img64) {
		this.img64 = img64;
	}

}
