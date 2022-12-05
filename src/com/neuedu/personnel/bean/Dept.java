package com.neuedu.personnel.bean;

import java.util.Date;

/**
 *  部门实体
 * @author Administrator
 *
 */
public class Dept {

	//普通属性
	private Integer id;
	private Integer dept_number;
	private String dept_name;
	private Integer dept_type;//值码表id
	private String dept_tel;
	private String dept_fax;
	private String dept_desc;
	private Date dept_setdate;
	private Integer situation;
	
	//关联属性
	private Dept dept_super;
	private Code code_type;

	public Code getCode_type() {
		return code_type;
	}

	public void setCode_type(Code code_type) {
		this.code_type = code_type;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	

	public Integer getDept_number() {
		return dept_number;
	}

	public void setDept_number(Integer dept_number) {
		this.dept_number = dept_number;
	}

	public String getDept_name() {
		return dept_name;
	}

	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}

	public Integer getDept_type() {
		return dept_type;
	}

	public void setDept_type(Integer dept_type) {
		this.dept_type = dept_type;
	}

	public String getDept_tel() {
		return dept_tel;
	}

	public void setDept_tel(String dept_tel) {
		this.dept_tel = dept_tel;
	}

	public String getDept_fax() {
		return dept_fax;
	}

	public void setDept_fax(String dept_fax) {
		this.dept_fax = dept_fax;
	}

	public String getDept_desc() {
		return dept_desc;
	}

	public void setDept_desc(String dept_desc) {
		this.dept_desc = dept_desc;
	}

	public Date getDept_setdate() {
		return dept_setdate;
	}

	public void setDept_setdate(Date dept_setdate) {
		this.dept_setdate = dept_setdate;
	}

	public Integer getSituation() {
		return situation;
	}

	public void setSituation(Integer situation) {
		this.situation = situation;
	}

	public Dept getDept_super() {
		return dept_super;
	}

	public void setDept_super(Dept dept_super) {
		this.dept_super = dept_super;
	}
	
}
