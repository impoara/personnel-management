package com.neuedu.personnel.service;

import java.util.List;

import com.neuedu.personnel.bean.Code;

public interface CodeService {
	/*
	 * 按类型code_typeid查找
	 */
	List<Code> findByType(Integer id);
	
	
	
}
