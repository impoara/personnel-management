package com.neuedu.personnel.bean;

import java.util.Date;

/**
 *   离职信息
 * @author Administrator
 *
 */
public class Domission {

	private Integer id;
	private Integer lz_type;
	private Date lz_date;
	private String lz_go;
	private Code code;
	private Job job;
	private Dept dept;
	
	
	public Dept getDept() {
		return dept;
	}
	public void setDept(Dept dept) {
		this.dept = dept;
	}
	public Job getJob() {
		return job;
	}
	public void setJob(Job job) {
		this.job = job;
	}
	public Code getCode() {
		return code;
	}
	public void setCode(Code code) {
		this.code = code;
	}
	private Employee emp;
	public Employee getEmp() {
		return emp;
	}
	public void setEmp(Employee emp) {
		this.emp = emp;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getLz_type() {
		return lz_type;
	}
	public void setLz_type(Integer lz_type) {
		this.lz_type = lz_type;
	}
	public Date getLz_date() {
		return lz_date;
	}
	public void setLz_date(Date lz_date) {
		this.lz_date = lz_date;
	}
	public String getLz_go() {
		return lz_go;
	}
	public void setLz_go(String lz_go) {
		this.lz_go = lz_go;
	}
	
}
