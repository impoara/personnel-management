package com.neuedu.personnel;

public class Test {

	public static void main(String[] args) {
	
		String emId = "^[1-9]\\d{5}(18|19|20)\\d{2}((0[1-9])|(1[0-2]))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]$";
		if("371452200006054567".matches(emId)) {
			System.out.println("电话号码正确");
		}else {
			System.out.println("电话号码错误");
		}

	}

}
