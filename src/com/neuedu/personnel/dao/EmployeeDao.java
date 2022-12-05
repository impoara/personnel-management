package com.neuedu.personnel.dao;

import java.util.List;

import com.neuedu.personnel.bean.Dept;
import com.neuedu.personnel.bean.Employee;


public interface EmployeeDao {

	/* 添加*/
	 void insert(Employee employee);

	/* 查找全部 */
	List<Employee> finAllEmp(Employee emp);
	
	/* 按id查询 */
	 List<Employee> findByEmp(Integer id);
	
	 /* 修改*/
	 void UpdateEmp(Employee emp ,Integer id);
	 
	/* 条件查询 */
	 List<Employee> findIfEmp(Employee emp);
	 
	 /* 按员工编号number查询所有 */
	Employee findByEmpDept(Integer number);
	
	/* 按部门编号number查询所有 */
	List<Employee> findByDept(Integer number);
	
	/* 按岗位编号number查询所有 */
	List<Employee> findByJob(Integer number);
	
	/* 查找全部 计数*/
	Integer finAllEmpAll();
	
	/* 查找全部(数据库) */
	List<Employee> finAllEmp1(Employee emp);
	
	/* 分页 */
	List<Employee> finAllpage(Employee emp);
	
	
}
