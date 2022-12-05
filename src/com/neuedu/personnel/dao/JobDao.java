package com.neuedu.personnel.dao;

import java.util.List;

import com.neuedu.personnel.bean.Job;

public interface JobDao {

	/*
	 * 添加
	 */
	 void insertJob(Job job);
	 
	 /*
	  * 删除 
	  */
	 
	 void DeleteJob(Integer id);
	 /*
	  * 修改
	  */
	 void UpdateJob(Job job,Integer id);
	 /*
	  * 查询所有(无论是否删除，数据库界面)
	  */
	List<Job> findAllJob1();
	 /*
	  * 查询所有(用户界面的所有)
	  */
	 List<Job> findAllJob();
	 /*
	  * 按id查询岗位
	  */
	 List<Job> findByJob(Integer id); 
	/*
	 * 条件查询
	 */
	  List<Job>findJobIf(Job job);
	/*
	* 按number条件查询
	*/
	 Job findIdJob(Integer number);	
	 /*
	  * id查询，加1
	  */
	void JobNumber(Integer number,Integer man) ;
	
	/*
	  * 显示全部，计数	 
	  */
	Integer findAllcount(Integer job_type);
	
	/*
	  *修改岗位编号
	  */
	void updatejob(Integer job_number ,Integer job_type,Integer id);
	
	/*
	 * 计算在岗人数
	 */
	void JobCount();
	
}
