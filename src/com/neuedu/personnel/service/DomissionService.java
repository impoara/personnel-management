package com.neuedu.personnel.service;

import java.util.List;

import com.neuedu.personnel.bean.Domission;
import com.neuedu.personnel.bean.Employee;

public interface DomissionService {

	/* 修改离职的状态为1 */
	void domUpdate (Integer id);
	
	/* 添加离职表 */
	 void domInsert(Domission dom);
	 
	 /* 查询所有 */
	 List<Employee> finAllEmp();
	 
	 /* 按id查询，回显 */
	 Employee findNumberEmp(Integer id);

	 //显示离职人员
	List<Domission> finAllDom();
	/*
	 * 离职人员的条件查询
	 */
	List<Domission> lizhiFind(Domission dom);
	/*
	 * 在职人员的条件查询
	 */
	List<Employee> zaizhiFind(Employee emp);
}
