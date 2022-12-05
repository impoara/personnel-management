package com.neuedu.personnel.bean;
/**
 *   岗位实体
 * @author Administrator
 *
 */
public class Job {

	private Integer id;
	private Integer job_number;
	private String job_name;
	private Integer job_type;
	private Integer job_man;
	private Integer job_max;
	private Integer situation;
	
	//特殊属性
	private String job_type_name;
	
	public String getJob_type_name() {
		return job_type_name;
	}
	public void setJob_type_name(String job_type_name) {
		this.job_type_name = job_type_name;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getJob_number() {
		return job_number;
	}
	public void setJob_number(Integer job_number) {
		this.job_number = job_number;
	}
	public String getJob_name() {
		return job_name;
	}
	public void setJob_name(String job_name) {
		this.job_name = job_name;
	}
	public Integer getJob_type() {
		return job_type;
	}
	public void setJob_type(Integer job_type) {
		this.job_type = job_type;
	}
	public Integer getJob_man() {
		return job_man;
	}
	public void setJob_man(Integer job_man) {
		this.job_man = job_man;
	}
	public Integer getJob_max() {
		return job_max;
	}
	public void setJob_max(Integer job_max) {
		this.job_max = job_max;
	}
	public Integer getSituation() {
		return situation;
	}
	public void setSituation(Integer situation) {
		this.situation = situation;
	}
	
	
}
