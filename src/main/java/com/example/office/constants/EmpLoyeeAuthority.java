package com.example.office.constants;

public enum EmpLoyeeAuthority {
	
	admin("admin",99),
	
	manager ("director",2),
	
	general("employee",1);
	
	private String authority;
	
	private int power;

	private EmpLoyeeAuthority(String authority, int power) {
		this.authority = authority;
		this.power = power;
	}
	

}
