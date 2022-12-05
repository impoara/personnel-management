package com.neuedu.personnel.dao;

import java.util.List;

import com.neuedu.personnel.bean.Dept;
import com.neuedu.personnel.bean.Job;

public interface DeptDao {

	/*
	 * 添加
	 */
	 void insertDept(Dept dept);
	 
	 /*
	  * 判断删除时，有没有上级部门
	  */
	 int DeleteDept(Integer id);
	 
	 /*
	  * 修改
	  */
	 void UpdateDept(Dept dept,Integer id);

	 /*
	  * 查询所有(数据库的)
	  */
	List<Dept> findAllD();
	
	 /*
	  * 查询所有(用户所见)
	  */
	 List<Dept> findAllDept();
	 
	 /* 
	 * 删除 1
	 */
	void DeleteDate(Integer id);
		 
	 /*
	  * 按id查询岗位
	  */
	 List<Dept> findByDept(Integer id);
	 
	/*
	 * 条件查询
	 */
	 List<Dept>findDeptIf(Dept dept);

}
