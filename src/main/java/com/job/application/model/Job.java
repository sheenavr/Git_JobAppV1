package com.job.application.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table
public class Job {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="title")
	private String title;
	@Column(name="description")
	private String description;
	@Column(name="minSalary")
	private Long minSalary;
	@Column(name="maxSalary")
	private Long maxSalary;
	@Column(name="location")
	private String location;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Long getMinSalary() {
		return minSalary;
	}
	public void setMinSalary(Long minSalary) {
		this.minSalary = minSalary;
	}
	public Long getMaxSalary() {
		return maxSalary;
	}
	public void setMaxSalary(Long maxSalary) {
		this.maxSalary = maxSalary;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Job(Long id, String title, String description, Long minSalary, Long maxSalary, String location) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.minSalary = minSalary;
		this.maxSalary = maxSalary;
		this.location = location;
	}
	public Job() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
