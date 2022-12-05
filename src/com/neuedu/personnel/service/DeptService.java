package com.neuedu.personnel.service;

import java.util.List;

import com.neuedu.personnel.bean.Dept;

public interface DeptService {

	/*
	 * 添加
	 */
	 void insertDept(Dept dept);
	 
	 /*
	  * 删除时，查看部门是否有父级对象
	  */
	 Boolean DeleteDept(Integer id);

	/*  
	 * 删除 
	 */
	 void DeleteDate(Integer id);
	
	 /*
	  * 修改
	  */
	 void UpdateDept(Dept dept,Integer id);
	 /*
	  * 查询所有(数据库)
	  */
	List<Dept> finAllDept1(Dept insertdept);
	
	 /*
	  * 查询所有(用户的)
	  */
	 List<Dept> findAllDept();
	
	 /*
	  * 按id查询岗位
	  */
	 List<Dept> findByDept(Integer id);
	 
	/*
	 * 条件查询
	 */
	 List<Dept>findDeptIf(Dept dept);
	
	

}
