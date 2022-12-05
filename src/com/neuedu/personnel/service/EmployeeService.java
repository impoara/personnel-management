package com.neuedu.personnel.service;

import java.util.List;

import com.neuedu.personnel.bean.Employee;

public interface EmployeeService {

	/*
	 * 添加
	 */
	 void insert(Employee employee);

	/* 查询所有 */
	  List<Employee> finAllEmp(Employee emp);
	 
/* 按id查询 */
	 
	 List<Employee> findByEmp(Integer id);
	 /*
	  * 修改
	  */
	 void UpdateEmp(Employee emp ,Integer id);
	 
	 /* 条件查询 */
	 List<Employee> findIfEmp(Employee emp);
	 
	 /* 按员工编号查询查询 */
	Employee findByEmpDept(Integer number);
	
	/* 按部门编号查询查询 */
	List<Employee> findByDept(Integer number);
	
	/* 按岗位编号查询查询 */
	List<Employee> findByJob(Integer number);
	
	/* 显示全部 计数 */
	public Integer finAllEmpAll();
	
	/* 查询所有 */
	  List<Employee> finAllEmp1(Employee emp);
	  
	  /* 分页 */
	  List<Employee> finAllPage(Employee emp);
	
	
}
