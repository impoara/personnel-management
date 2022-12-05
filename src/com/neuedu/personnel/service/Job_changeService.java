package com.neuedu.personnel.service;

import java.util.List;

import com.neuedu.personnel.bean.Employee;
import com.neuedu.personnel.bean.Job_change;

public interface Job_changeService {

	//添加
	void InsertJob(Job_change job);
	
	//修改
	void UpdateJob(Integer number ,Integer id);
	
	/*
	 * 	已调动条件查询
	 */
	List<Job_change> findOnech(Job_change jch);
	/*
	 * 查询所有已调动
	 */
	List<Job_change> findAllCjod(Job_change cJob);
	
	//调动条件查询
	List<Employee> finOne(Employee emp);

}
