package com.neuedu.personnel.service.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import com.neuedu.personnel.bean.Job;
import com.neuedu.personnel.dao.JobDao;
import com.neuedu.personnel.dao.daoimpl.JobDaoimpl;
import com.neuedu.personnel.service.JobService;

public class JobServiceimpl implements JobService {
	
	//单例模式，节省资源，两个私有一个公有
	private static JobService jobservice =new JobServiceimpl();
	private JobServiceimpl() {};
	public static JobService getJobService() {
		return jobservice;
	}
	 
	/*
	 * 添加
	 */
	@Override
	public void insertJob(Job insertJob) {
		JobDao jobdao =new JobDaoimpl();
		jobdao.insertJob(insertJob);	
	}
	 /*
	  * 删除 
	  */
	 
	@Override
	public void DeleteJob(Integer id) {
		JobDao jobdao =new JobDaoimpl();
		jobdao.DeleteJob(id);
		
	}
	 /*
	  * 修改
	  */
	@Override
	public void UpdateJob(Job job,Integer id) {
		JobDao jobdao =new JobDaoimpl();
		jobdao.UpdateJob(job,id);
		
	}

	/*
	  * 查询所有(用户的所有)
	  */
	@Override
	public List<Job> findAllJob() {
		List<Job> joblist = new ArrayList<Job>();
		JobDao jobdao =new JobDaoimpl();
		joblist = jobdao.findAllJob();
		return joblist;
	}
	 /*
	  * 查询所有(数据库的所有)
	  */
	@Override
	public List<Job> findAllJob1() {
		List<Job> joblist = new ArrayList<Job>();
		JobDao jobdao =new JobDaoimpl();
		joblist = jobdao.findAllJob1();
		return joblist;
	}
	/*
	  * 按id查询岗位
	  */
	@Override
	public List<Job> findByJob(Integer id) {
		List<Job> joblist = new ArrayList<Job>();
		JobDao jobdao =new JobDaoimpl();
		joblist = jobdao.findByJob(id);
		return joblist;
	}
	 /*
	 * 条件查询
	 */
	@Override
	public List<Job> findJobIf(Job job) {
		List<Job> joblist = new ArrayList<Job>();
		JobDao jobdao =new JobDaoimpl();
		joblist = jobdao.findJobIf(job);
		return joblist;
	}
	
	 /*
	 * 按number查询
	 */
	@Override
	public Job findIdJob(Integer number) {
		Job job=new Job();
		JobDao jobdao =new JobDaoimpl();
		job=jobdao.findIdJob(number);
		return job;
	}

	 /*
	  * id查询，加1
	  */
	@Override
	public void JobNumber(Integer number, Integer man) {
		JobDao jobdao =new JobDaoimpl();
		jobdao.JobNumber(number, man);
		
	}
	/*
	  * 显示全部，计数	 
	  */
	@Override
	public Integer findAllcount(Integer job_type) {
		JobDao jobdao =new JobDaoimpl();
		Integer num=jobdao.findAllcount(job_type);
		return num;
	}
	
	/*
	  *修改岗位编号
	  */
	@Override
	public void updatejob(Integer job_number, Integer job_type,Integer id) {
		JobDao jobdao =new JobDaoimpl();
		jobdao.updatejob(job_number, job_type,id);
	}
	@Override
	public void JobCount() {
		JobDao jobdao =new JobDaoimpl();
		jobdao.JobCount();	
	}

	
	
}
