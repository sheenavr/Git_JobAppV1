package com.job.application.service.job;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.job.application.model.job.Job;
import com.job.application.repository.job.JobRepository;

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

	public Optional<Job> getJobById(Long id) {
		return jobrepository.findById(id);
	}

	@Override
	public void deleteById(Long id) {
		jobrepository.deleteById(id);

	}

	@Override
	public void updateJob(Job job) {
		jobrepository.save(job);

	}

}
