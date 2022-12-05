package com.neuedu.personnel.bean;

import java.util.Date;

/**
 *  部门调动信息
 * @author Administrator
 *
 */
public class Dep_change {

	private Integer id; 
	private Integer dept_chtype;
	private String dept_chreason;
	private Date dept_chdate;
	private String dept_extra;
	
	private Code code;
	private Code code1;
	private Code code2;
	public Code getCode1() {
		return code1;
	}
	public void setCode1(Code code1) {
		this.code1 = code1;
	}
	public Code getCode2() {
		return code2;
	}
	public void setCode2(Code code2) {
		this.code2 = code2;
	}
	public Code getCode() {
		return code;
	}
	public void setCode(Code code) {
		this.code = code;
	}
	private Domission dom;
	public Domission getDom() {
		return dom;
	}
	public void setDom(Domission dom) {
		this.dom = dom;
	}
	private Employee emp;
	private Dept dept_before;
	private Dept dept_after;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getDept_chtype() {
		return dept_chtype;
	}
	public void setDept_chtype(Integer dept_chtype) {
		this.dept_chtype = dept_chtype;
	}
	public String getDept_chreason() {
		return dept_chreason;
	}
	public void setDept_chreason(String dept_chreason) {
		this.dept_chreason = dept_chreason;
	}
	public Date getDept_chdate() {
		return dept_chdate;
	}
	public void setDept_chdate(Date dept_chdate) {
		this.dept_chdate = dept_chdate;
	}
	public String getDept_extra() {
		return dept_extra;
	}
	public void setDept_extra(String dept_extra) {
		this.dept_extra = dept_extra;
	}
	public Employee getEmp() {
		return emp;
	}
	public void setEmp(Employee emp) {
		this.emp = emp;
	}
	public Dept getDept_before() {
		return dept_before;
	}
	public void setDept_before(Dept dept_before) {
		this.dept_before = dept_before;
	}
	public Dept getDept_after() {
		return dept_after;
	}
	public void setDept_after(Dept dept_after) {
		this.dept_after = dept_after;
	}
	
	
}
