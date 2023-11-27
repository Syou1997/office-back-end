package com.example.office.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pic")
public class Pic {
	
	@Id
	@Column(name = "pic_id")
	private int picId;
	
	@Column(name = "pic_address")
	private String picAddress;

	public Pic() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Pic(int picId, String picAddress) {
		super();
		this.picId = picId;
		this.picAddress = picAddress;
	}
	
	

	public Pic(String picAddress) {
		super();
		this.picAddress = picAddress;
	}

	public int getPicId() {
		return picId;
	}

	public void setPicId(int picId) {
		this.picId = picId;
	}

	public String getPicAddress() {
		return picAddress;
	}

	public void setPicAddress(String picAddress) {
		this.picAddress = picAddress;
	}

}
