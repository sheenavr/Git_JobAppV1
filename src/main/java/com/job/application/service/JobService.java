package com.job.application.service;

import java.util.List;

import com.job.application.model.Job;

public interface JobService {
	public List<Job> findAll();
	public void createJob(Job job);
	

}