package com.skilldistillery.eventtracker.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Jobs {
	
	//FIELDS
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String company;
	
	@Column(name="date_applied")
	private Date dateApplied;
	
	private String position;
	
	@Column(name="first_interview")
	private Date firstInterview;
	
	private String interviewer;
	
	@Column(name="date_followup")
	private Date dateFollowup;
	
	@Column(name="date_next_interview")
	private Date dateNext;
	
	@Column(name="position_offered")
	private Boolean positionOffered;
	
	private Double salary;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public Date getDateApplied() {
		return dateApplied;
	}

	public void setDateApplied(Date dateApplied) {
		this.dateApplied = dateApplied;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public Date getFirstInterview() {
		return firstInterview;
	}

	public void setFirstInterview(Date firstInterview) {
		this.firstInterview = firstInterview;
	}

	public String getInterviewer() {
		return interviewer;
	}

	public void setInterviewer(String interviewer) {
		this.interviewer = interviewer;
	}

	public Date getDateFollowup() {
		return dateFollowup;
	}

	public void setDateFollowup(Date dateFollowup) {
		this.dateFollowup = dateFollowup;
	}

	public Date getDateNext() {
		return dateNext;
	}

	public void setDateNext(Date dateNext) {
		this.dateNext = dateNext;
	}

	public Boolean getPositionOffered() {
		return positionOffered;
	}

	public void setPositionOffered(Boolean positionOffered) {
		this.positionOffered = positionOffered;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public Jobs() {
		super();
	}

	@Override
	public String toString() {
		return "Jobs [id=" + id + ", company=" + company + ", dateApplied=" + dateApplied + ", position=" + position
				+ ", firstInterview=" + firstInterview + ", interviewer=" + interviewer + ", dateFollowup="
				+ dateFollowup + ", dateNext=" + dateNext + ", positionOffered=" + positionOffered + ", salary="
				+ salary + "]";
	}

	
}
