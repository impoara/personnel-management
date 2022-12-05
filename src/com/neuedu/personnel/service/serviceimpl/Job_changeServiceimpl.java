package com.neuedu.personnel.service.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import com.neuedu.personnel.bean.Employee;
import com.neuedu.personnel.bean.Job_change;
import com.neuedu.personnel.dao.Dep_changeDao;
import com.neuedu.personnel.dao.Job_changeDao;
import com.neuedu.personnel.dao.daoimpl.Dep_changeDaoimpl;
import com.neuedu.personnel.dao.daoimpl.Job_changeDaoimpl;
import com.neuedu.personnel.service.Job_changeService;

public class Job_changeServiceimpl implements Job_changeService {
	
	//单例模式，节省资源
	private static Job_changeService job_changeservice =new Job_changeServiceimpl();
	private Job_changeServiceimpl() {};
	public static Job_changeService getjobservice() {
		return job_changeservice;
		
	}
	//添加
	@Override
	public void InsertJob(Job_change job) {
		Job_changeDao changdao =new Job_changeDaoimpl();
		changdao.InsertJob(job);
		
	}
	//修改
	@Override
	public void UpdateJob(Integer number, Integer id) {
		Job_changeDao changdao =new Job_changeDaoimpl();
		changdao.UpdateJob(number, id);
	}

	/*
	 * 条件查询已调动
	 */
	@Override
	public List<Job_change> findOnech(Job_change jch) {
		Job_changeDao chaJobDao=new Job_changeDaoimpl();
		List<Job_change> jchList = new ArrayList<Job_change>();
		jchList = chaJobDao.findOnech(jch);
		return jchList;
	}
	/*
	 * 查询所有已调动
	 */
	@Override
	public List<Job_change> findAllCjod(Job_change cJob) {
		Job_changeDao chaJobDao=new Job_changeDaoimpl();
		List<Job_change> cJobList = new ArrayList<Job_change>();
		cJobList = chaJobDao.findAllCjob(cJob);
		return cJobList;
	}
	//调动条件查询
	@Override
	public List<Employee> finOne(Employee emp) {
		Job_changeDao job_changeDao = new Job_changeDaoimpl();
		List<Employee> inEmpList = new ArrayList<Employee>();
		inEmpList = job_changeDao.finOne(emp);
		return inEmpList;
	}

	
	

}
