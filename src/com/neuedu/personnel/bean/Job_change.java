package com.neuedu.personnel.bean;

import java.util.Date;

/**
 *  岗位调动信息
 * @author Administrator
 *
 */
public class Job_change {

	private Integer id;
	private String job_chreason;//调动原有
	private Integer job_chtype;
	private Date job_chdate;
	private String job_chextra;
	private String job_chname;//新岗位名称
	
	private Domission dom;
	public Domission getDom() {
		return dom;
	}
	public void setDom(Domission dom) {
		this.dom = dom;
	}
	private Integer job_chnumber;
	private String job_oldname;
	
	private Date job_chks;
	private Date job_chend;
	
	private Employee emp;
	private Code code;
	
	public Code getCode() {
		return code;
	}
	public void setCode(Code code) {
		this.code = code;
	}
	private Code code1;
	private Code code2;
	public Date getJob_chks() {
		return job_chks;
	}
	public void setJob_chks(Date job_chks) {
		this.job_chks = job_chks;
	}
	public Date getJob_chend() {
		return job_chend;
	}
	public void setJob_chend(Date job_chend) {
		this.job_chend = job_chend;
	}


	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getJob_chreason() {
		return job_chreason;
	}
	public void setJob_chreason(String job_chreason) {
		this.job_chreason = job_chreason;
	}
	public Integer getJob_chtype() {
		return job_chtype;
	}
	public void setJob_chtype(Integer job_chtype) {
		this.job_chtype = job_chtype;
	}
	public Date getJob_chdate() {
		return job_chdate;
	}
	public void setJob_chdate(Date job_chdate) {
		this.job_chdate = job_chdate;
	}
	public String getJob_chextra() {
		return job_chextra;
	}
	public void setJob_chextra(String job_chextra) {
		this.job_chextra = job_chextra;
	}
	public Employee getEmp() {
		return emp;
	}
	public void setEmp(Employee emp) {
		this.emp = emp;
	}
	public String getJob_chname() {
		return job_chname;
	}
	public void setJob_chname(String job_chname) {
		this.job_chname = job_chname;
	}
	public String getJob_oldname() {
		return job_oldname;
	}
	public void setJob_oldname(String job_oldname) {
		this.job_oldname = job_oldname;
	}
	
	public Integer getJob_chnumber() {
		return job_chnumber;
	}
	public void setJob_chnumber(Integer job_chnumber) {
		this.job_chnumber = job_chnumber;
	}
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
}
