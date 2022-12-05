package com.neuedu.personnel.dao;

import java.util.List;

import com.neuedu.personnel.bean.Domission;
import com.neuedu.personnel.bean.Employee;

public interface DomissionDao {
	
	/* 修改离职的状态为1 */
	void domUpdate (Integer id);
	
	/* 添加离职表 */
	void domInsert(Domission domission);
	
	 /* 查询所有 */
	List<Employee> finAllEmp();
	
	/* 按id查询，回显 */
	Employee findnumberEmp( Integer id);

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
