package com.job.application.service.job;

import java.util.List;
import java.util.Optional;

import com.job.application.model.job.Job;

public interface JobService {
	public List<Job> findAll();

	public void createJob(Job job);

	public Optional<Job> getJobById(Long id);

	public void deleteById(Long id);

	public void updateJob(Job job);

}
