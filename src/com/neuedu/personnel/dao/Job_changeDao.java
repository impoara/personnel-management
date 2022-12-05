package com.neuedu.personnel.dao;

import java.util.List;

import com.neuedu.personnel.bean.Employee;
import com.neuedu.personnel.bean.Job_change;

public interface Job_changeDao {
	
	//添加
	void InsertJob(Job_change job);
	
	//修改
	void UpdateJob(Integer number ,Integer id);
	
	/*
	 * 查询所有已调动
	 */
	List<Job_change> findAllCjob(Job_change cJob);
	/*
	 * 条件查询已调动
	 */
	List<Job_change> findOnech(Job_change jch);

	//调动条件查询
	List<Employee> finOne(Employee emp);

	

}
