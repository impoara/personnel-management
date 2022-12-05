package com.neuedu.personnel.dao;

import java.util.List;

import com.neuedu.personnel.bean.Code;

public interface CodeDao {
	/*
	 * 按类型code_typeid查找
	 */
	List<Code> findByType(Integer id);
	
	
	

}
