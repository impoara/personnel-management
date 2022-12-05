package com.neuedu.personnel.service.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import com.neuedu.personnel.bean.Dep_change;
import com.neuedu.personnel.bean.Employee;
import com.neuedu.personnel.dao.Dep_changeDao;

import com.neuedu.personnel.dao.daoimpl.Dep_changeDaoimpl;

import com.neuedu.personnel.service.Dep_changeService;


public class Dep_changeServiceimpl implements Dep_changeService {

	//单例模式，节省资源
			private static Dep_changeService employeeservicee =new Dep_changeServiceimpl();
			private Dep_changeServiceimpl() {};
			public static Dep_changeService getEmployeeService() {
				return employeeservicee;
			}
			/* 修改部门编号*/
			@Override
			public void domUpdate(Integer number ,Integer id) {
				Dep_changeDao changdao =new Dep_changeDaoimpl();
				changdao.domUpdate(number ,id);
			}
		
			//添加
			@Override
			public void InsertDep(Dep_change depc) {
				Dep_changeDao changdao =new Dep_changeDaoimpl();
				changdao.InsertDep(depc);
				
			}
		
			//调动条件查询
			@Override
			public List<Employee> findOne(Employee emp) {
				Dep_changeDao dep_changeDao = new Dep_changeDaoimpl();
				List<Employee> inEmpList = new ArrayList<Employee>();
				inEmpList = dep_changeDao.finOne(emp);
				return inEmpList;
			}
			
			//查询已调动人员
			@Override
			public List<Dep_change> findAllChange() {
				Dep_changeDao dep_changeDao = new Dep_changeDaoimpl();
				List<Dep_change> inEmpList = new ArrayList<Dep_change>();
				inEmpList = dep_changeDao.findAllChange();
				return inEmpList;
			}
			
			//已调动部门条件查询
			@Override
			public List<Dep_change> findchange(Dep_change dep) {
				Dep_changeDao dep_changeDao = new Dep_changeDaoimpl();
				List<Dep_change> inEmpList = new ArrayList<Dep_change>();
				inEmpList = dep_changeDao.findchange(dep);
				return inEmpList;
			}
			
	
}
