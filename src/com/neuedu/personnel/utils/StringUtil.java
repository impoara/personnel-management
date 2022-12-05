package com.neuedu.personnel.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *   字符串处理工具类
 * @author Administrator
 *
 */
public class StringUtil {

	/*
	 *  判断字符串是否为空
	 */
	public static boolean isNull(String str) {
		if(str==null || "".equals(str)) {
			return true;
		}else {
			return false;
		}
	}
	/*
	 *  判断Integer是否为空
	 */
	public static boolean isNull(Integer in) {
		if(in==null || in == 0) {
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 *   字符串转换int类型
	 *   
	 */
	public static Integer string2Integer(String str) {
		Integer in = null;
		if(!isNull(str) && str.matches("\\d+")) {
			in = Integer.parseInt(str);
		}
		
		return in;
	}
	/**
	 *   字符串转换日期类型
	 *   
	 */
	public static Date string2Date(String str) {
		Date date = null;
		if(str!=null) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			try {
				date = sdf.parse(str);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return date;
	}
}
