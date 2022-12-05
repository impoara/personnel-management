package com.neuedu.personnel.bean;

import java.util.Date;

/**
 *  员工实体
 * @author Administrator
 *
 */
public class Employee {

	//普通属性
	private Integer id;
	private Integer em_number;
	private String em_name;
	private Date em_birth;
	private Integer sex;
	private Integer em_format;
	private Integer em_source;
	private Integer em_polity;
	private Integer em_folk;
	private String em_id;
	private Date em_indate;
	private Date em_worktime;
	private String em_birthplace;
	private String em_phone;
	private String em_mail;
	private Integer em_blood;
	private Integer em_wedlock;
	private String em_stature;
	private String em_seat;
	private Integer em_learn;
	private Integer em_degree;
	private String em_graduate;
	private String em_specialty;
	private Date em_gradate;
	private String em_homeplace;
	private Integer situation;
	
	
	//分页属性，需要分页的总页数
	private Integer pagesum;
	//当前为第几页
	private Integer page;
	//查询有多少条数据
	private Integer pagecoun;

	//关联属性
	private Dept dept;
	private Job job;
	private Code code;
	//试用期
	private Probation probation;
	
	//特殊属性  判断是否选择试用期
	private String prob;
	
	

	public Integer getPagecoun() {
		return pagecoun;
	}
	public void setPagecoun(Integer pagecoun) {
		this.pagecoun = pagecoun;
	}
	public Integer getPagesum() {
		return pagesum;
	}
	public void setPagesum(Integer pagesum) {
		this.pagesum = pagesum;
	}
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Code getCode() {
		return code;
	}
	public void setCode(Code code) {
		this.code = code;
	}
	public String getProb() {
		return prob;
	}
	public void setProb(String prob) {
		this.prob = prob;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getEm_number() {
		return em_number;
	}
	public void setEm_number(Integer em_number) {
		this.em_number = em_number;
	}
	public String getEm_name() {
		return em_name;
	}
	public void setEm_name(String em_name) {
		this.em_name = em_name;
	}
	public Date getEm_birth() {
		return em_birth;
	}
	public void setEm_birth(Date em_birth) {
		this.em_birth = em_birth;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public Integer getEm_format() {
		return em_format;
	}
	public void setEm_format(Integer em_format) {
		this.em_format = em_format;
	}
	public Integer getEm_source() {
		return em_source;
	}
	public void setEm_source(Integer em_source) {
		this.em_source = em_source;
	}
	public Integer getEm_polity() {
		return em_polity;
	}
	public void setEm_polity(Integer em_polity) {
		this.em_polity = em_polity;
	}
	public Integer getEm_folk() {
		return em_folk;
	}
	public void setEm_folk(Integer em_folk) {
		this.em_folk = em_folk;
	}
	public String getEm_id() {
		return em_id;
	}
	public void setEm_id(String em_id) {
		this.em_id = em_id;
	}
	public Date getEm_indate() {
		return em_indate;
	}
	public void setEm_indate(Date em_indate) {
		this.em_indate = em_indate;
	}
	public Date getEm_worktime() {
		return em_worktime;
	}
	public void setEm_worktime(Date em_worktime) {
		this.em_worktime = em_worktime;
	}
	public String getEm_birthplace() {
		return em_birthplace;
	}
	public void setEm_birthplace(String em_birthplace) {
		this.em_birthplace = em_birthplace;
	}
	public String getEm_phone() {
		return em_phone;
	}
	public void setEm_phone(String em_phone) {
		this.em_phone = em_phone;
	}
	public String getEm_mail() {
		return em_mail;
	}
	public void setEm_mail(String em_mail) {
		this.em_mail = em_mail;
	}
	public Integer getEm_blood() {
		return em_blood;
	}
	public void setEm_blood(Integer em_blood) {
		this.em_blood = em_blood;
	}
	public Integer getEm_wedlock() {
		return em_wedlock;
	}
	public void setEm_wedlock(Integer em_wedlock) {
		this.em_wedlock = em_wedlock;
	}
	public String getEm_stature() {
		return em_stature;
	}
	public void setEm_stature(String em_stature) {
		this.em_stature = em_stature;
	}
	public String getEm_seat() {
		return em_seat;
	}
	public void setEm_seat(String em_seat) {
		this.em_seat = em_seat;
	}
	public Integer getEm_learn() {
		return em_learn;
	}
	public void setEm_learn(Integer em_learn) {
		this.em_learn = em_learn;
	}
	public Integer getEm_degree() {
		return em_degree;
	}
	public void setEm_degree(Integer em_degree) {
		this.em_degree = em_degree;
	}
	public String getEm_graduate() {
		return em_graduate;
	}
	public void setEm_graduate(String em_graduate) {
		this.em_graduate = em_graduate;
	}
	public String getEm_specialty() {
		return em_specialty;
	}
	public void setEm_specialty(String em_specialty) {
		this.em_specialty = em_specialty;
	}
	public Date getEm_gradate() {
		return em_gradate;
	}
	public void setEm_gradate(Date em_gradate) {
		this.em_gradate = em_gradate;
	}
	public String getEm_homeplace() {
		return em_homeplace;
	}
	public void setEm_homeplace(String em_homeplace) {
		this.em_homeplace = em_homeplace;
	}
	public Integer getSituation() {
		return situation;
	}
	public void setSituation(Integer situation) {
		this.situation = situation;
	}
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
	
	public Probation getProbation() {
		return probation;
	}
	public void setProbation(Probation probation) {
		this.probation = probation;
	}
}
