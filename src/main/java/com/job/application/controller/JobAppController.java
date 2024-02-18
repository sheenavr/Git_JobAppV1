package com.job.application.controller;


import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.job.application.model.Job;
import com.job.application.service.JobService;
@RestController
@RequestMapping("/api/v1/jobs")
public class JobAppController {
	
	private JobService jobservice;
	
	
	public JobAppController(JobService jobservice) {
		
		this.jobservice = jobservice;
	}


	@GetMapping("/allJobs")
	public List<Job> findAll(){
		return jobservice.findAll();
	}
	
		
	/*
	 * @GetMapping("/jobs/{id}") public Job getJobById(@PathVariable Long id){ Job
	 * job=jobservice.getJobById(id); return job; }
	 */
//add job details	
	@PostMapping("/addJob")
	public String addJob(@RequestBody Job job) {
		jobservice.createJob(job);
		return "Jod Details Added successfully";
		
	}
	
}