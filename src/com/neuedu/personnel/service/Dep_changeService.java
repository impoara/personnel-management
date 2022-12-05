package com.neuedu.personnel.service;

import java.util.List;

import com.neuedu.personnel.bean.Dep_change;
import com.neuedu.personnel.bean.Employee;

public interface Dep_changeService {

	/* 修改部门编号*/
	void domUpdate (Integer number ,Integer id);
	
	/* 添加部门表中的内容 */
	void InsertDep(Dep_change depc);
	
	//已调动部门条件查询
	List<Dep_change> findAllChange();
	
	//已调动部门条件查询
	List<Dep_change> findchange(Dep_change dep);

	//调动条件查询
	List<Employee> findOne(Employee emp);
}
