package com.neuedu.personnel.dao;

import java.util.List;

import com.neuedu.personnel.bean.Dep_change;
import com.neuedu.personnel.bean.Employee;

public interface Dep_changeDao {

	/* 修改部门编号*/
	void domUpdate (Integer number ,Integer id);
	
    //添加
	void InsertDep(Dep_change depc);
	
	//查询已调动所有
	List<Dep_change> findAllChange();
	
	//已调动部门条件查询
	List<Dep_change> findchange(Dep_change dep);
	
	//调动条件查询
	List<Employee> finOne(Employee emp);

}
