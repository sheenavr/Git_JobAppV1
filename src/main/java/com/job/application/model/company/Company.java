package com.job.application.model.company;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.job.application.model.job.Job;
import com.job.application.model.review.Review;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
@Entity
@Table
public class Company {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="name")
	private String name;
	@Column(name="description")
	private String description;
	
	
	@OneToMany(mappedBy = "company")
	private List<Job> jobs;
	
	
	@OneToMany(mappedBy = "company")
	private List<Review> review;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<Job> getJobs() {
		return jobs;
	}
	public void setJobs(List<Job> jobs) {
		this.jobs = jobs;
	}
	public Company(Long id, String name, String description, List<Job> jobs) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.jobs = jobs;
	}
	public Company() {
		
	}
	public List<Review> getReview() {
		return review;
	}
	public void setReview(List<Review> review) {
		this.review = review;
	}
	
	
	
	

}
