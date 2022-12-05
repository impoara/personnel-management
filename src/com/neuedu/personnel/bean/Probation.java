package com.neuedu.personnel.bean;

import java.util.Date;

public class Probation {

	private Integer id;
	private Date prob_start;
	private Date prob_end;
	private String prob_reviews;
	private Integer prob_results;
	private Date prob_data;
	private String prob_notes;
	
	private Employee emp;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getProb_start() {
		return prob_start;
	}

	public void setProb_start(Date prob_start) {
		this.prob_start = prob_start;
	}

	public Date getProb_end() {
		return prob_end;
	}

	public void setProb_end(Date prob_end) {
		this.prob_end = prob_end;
	}

	public String getProb_reviews() {
		return prob_reviews;
	}

	public void setProb_reviews(String prob_reviews) {
		this.prob_reviews = prob_reviews;
	}

	public Integer getProb_results() {
		return prob_results;
	}

	public void setProb_results(Integer prob_results) {
		this.prob_results = prob_results;
	}

	public Date getProb_data() {
		return prob_data;
	}

	public void setProb_data(Date prob_data) {
		this.prob_data = prob_data;
	}

	public String getProb_notes() {
		return prob_notes;
	}

	public void setProb_notes(String prob_notes) {
		this.prob_notes = prob_notes;
	}

	public Employee getEmp() {
		return emp;
	}

	public void setEmp(Employee emp) {
		this.emp = emp;
	}
	
	
}
