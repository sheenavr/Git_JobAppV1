package com.job.application.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.job.application.model.Job;
@RestController
@RequestMapping("/api/v1/jobs")
public class JobAppController2 {
	private List<Job> jobs=new ArrayList<>();
	@GetMapping("/allJobs")
	public List<Job> findAll(){
		return jobs;
	}
	@PostMapping("/addJob")
	public String addJob(@RequestBody Job job) {
		jobs.add(job);
		return "Jod Details Added successfully";
	}

}