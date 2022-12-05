package com.neuedu.personnel.service.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import com.neuedu.personnel.bean.Domission;
import com.neuedu.personnel.bean.Employee;
import com.neuedu.personnel.dao.DomissionDao;
import com.neuedu.personnel.dao.daoimpl.DomissionDaoimpl;
import com.neuedu.personnel.service.DomissionService;

public class DomissionServiceimpl implements DomissionService {

	//单例模式，节省资源
	private static DomissionService domissionservice =new DomissionServiceimpl();
	private DomissionServiceimpl() {}
	public static DomissionService getDomissionService() {
		return domissionservice;
	}
	/*
	 * 离职人员的条件查询
	 */
	@Override
	public List<Domission> lizhiFind(Domission dom) {
		DomissionDao domDao = new DomissionDaoimpl();
		List<Domission> domList = new ArrayList<Domission>();
		domList = domDao.lizhiFind(dom);
		return domList;
	}
	
	/* 添加离职表 */
	@Override
	public void domInsert(Domission dom) {
		DomissionDao domissiondao =new DomissionDaoimpl();
		domissiondao.domInsert(dom);
	}

	/* 查询所有 */
	public List<Employee> finAllEmp() {
		List<Employee> domall=new ArrayList<Employee>();
		DomissionDao domissionDao=new DomissionDaoimpl();
		domall=domissionDao.finAllEmp();
		return domall;
	}
	
	//显示离职人员

	@Override
	public List<Domission> finAllDom() {
		List<Domission> domall=new ArrayList<Domission>();
		DomissionDao domissionDao=new DomissionDaoimpl();
		domall=domissionDao.finAllDom();
		return domall;
	}
	
	/* 按id查询，回显 */
	@Override
	public Employee findNumberEmp(Integer id) {
		Employee domall=new Employee();
		DomissionDao domissionDao=new DomissionDaoimpl();
		domall=domissionDao.findnumberEmp(id);
		return domall;
	}

	/* 修改 */
	@Override
	public void domUpdate(Integer id) {
		DomissionDao domissiondao =new DomissionDaoimpl();
		domissiondao.domUpdate(id);
		
	}
	
	/*
	 * 在职人员的条件查询
	 */
	@Override
	public List<Employee> zaizhiFind(Employee emp) {
		DomissionDao domissiondao =new DomissionDaoimpl();
		List<Employee> inEmpList = new ArrayList<Employee>();
		inEmpList = domissiondao.zaizhiFind(emp);
		return inEmpList;	}


}
