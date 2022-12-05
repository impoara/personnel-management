package com.neuedu.personnel.service.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import com.neuedu.personnel.bean.Dept;
import com.neuedu.personnel.bean.Job;
import com.neuedu.personnel.dao.DeptDao;
import com.neuedu.personnel.dao.JobDao;
import com.neuedu.personnel.dao.daoimpl.DeptDaoimpl;
import com.neuedu.personnel.dao.daoimpl.JobDaoimpl;
import com.neuedu.personnel.service.DeptService;


public class DeptServiceimpl implements DeptService{

//单例模式
	private static DeptService deptservice=new DeptServiceimpl();
	private DeptServiceimpl() {};
	public static DeptService getDeptService() {
		return deptservice;
		
	}
	/*
	 * 添加
	 */
	@Override
	public void insertDept(Dept dept) {

		DeptDao deptdao =new DeptDaoimpl();
		deptdao.insertDept(dept);
		
	}

	/*
	  * 删除时，查看部门是否有父级对象
	  */
	@Override
	public Boolean DeleteDept(Integer id) {
		int boo;
		Boolean b=false;
		DeptDao deptdao =new DeptDaoimpl();
		boo=deptdao.DeleteDept(id);
		if(boo==0) {
			b=true;
		}
		return b;	
	}
	
	/*
	  * 修改
	  */
	@Override
	public void UpdateDept(Dept dept, Integer id) {
		DeptDao deptdao =new DeptDaoimpl();
		deptdao.UpdateDept(dept, id);
		
	}
	/*
	  * 查询所有 (数据库的)
	  */
	@Override
	public List<Dept> finAllDept1(Dept insertdept) {
		List<Dept> deptlist1 = new ArrayList<Dept>();
		DeptDao deptdao =new DeptDaoimpl();
		deptlist1=deptdao.findAllD();
		return deptlist1;
	}

	/*
	  * 查询所有 (用户的)
	  */
	@Override
	public List<Dept> findAllDept() {
		List<Dept> deptlist1 = new ArrayList<Dept>();
		DeptDao deptdao =new DeptDaoimpl();
		deptlist1=deptdao.findAllDept();
		return deptlist1;
	}

	/*
	  * 按id查询岗位
	  */
	@Override
	public List<Dept> findByDept(Integer id) {


		List<Dept> deptlist = new ArrayList<Dept>();
		DeptDao deptdao =new DeptDaoimpl();
		deptlist=deptdao.findByDept(id);
		return deptlist;
	}
	
	/*
	 * 条件查询
	 */
	@Override
	public List<Dept> findDeptIf(Dept dept) {
		List<Dept> deptlist2 = new ArrayList<Dept>();
		DeptDao deptdao =new DeptDaoimpl();
		deptlist2=deptdao.findDeptIf(dept);
		return deptlist2;
	}
	 
	 /*
	  * 删除 
	  */
	@Override
	public void DeleteDate(Integer id) {
		DeptDao deptdao =new DeptDaoimpl();
		deptdao.DeleteDate(id);
	}

	
}
