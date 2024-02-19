package com.job.application.service;

import java.util.List;
import java.util.Optional;

import com.job.application.model.Job;

public interface JobService {
	public List<Job> findAll();
	public void createJob(Job job);
	public Optional<Job> getJobById(Long id);
	public boolean existsById(Long id);
	public void deleteById(Long id);
	

}
