package com.job.application.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.job.application.model.Job;
import com.job.application.repository.JobRepository;

@Service
public class JobServiceImpl implements JobService {
	@Autowired
	private JobRepository jobrepository;

	@Override
	public List<Job> findAll() {

		return jobrepository.findAll();
	}

	@Override
	public void createJob(Job job) {

		jobrepository.save(job);

	}

}
