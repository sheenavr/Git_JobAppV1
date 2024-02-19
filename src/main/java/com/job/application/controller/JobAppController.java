package com.job.application.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
// Get all Job Details

	@GetMapping("/allJobs")
	public ResponseEntity<List<Job>> findAll() {
		return ResponseEntity.ok(jobservice.findAll());
	}
//Get Job Details by Id

	@GetMapping("/{id}")
	public ResponseEntity<Job> getJobById(@PathVariable Long id) {
		Optional<Job> jobOptional = jobservice.getJobById(id);
		return jobOptional.map(job -> ResponseEntity.ok().body(job))
				.orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}

//Add job details	
	@PostMapping("/addJob")
	public ResponseEntity<String> addJob(@RequestBody Job job) {
		jobservice.createJob(job);
		return new ResponseEntity<>("Job Details Added successfully", HttpStatus.CREATED);

	}
// Update Job Details by Id

	@PutMapping("/{id}")
    public ResponseEntity<String>  updateJob(@PathVariable Long id, @RequestBody Job newJob) {
        Optional<Job> updateJob = jobservice.getJobById(id);
        if (updateJob.isPresent()) 
        {
        	Job job = updateJob.get();
            job.setTitle(newJob.getTitle());
            job.setDescription(newJob.getDescription());
            job.setMaxSalary(newJob.getMaxSalary());
            job.setMinSalary(newJob.getMinSalary());
            job.setLocation(newJob.getLocation());
            
        	jobservice.createJob(job);
    		return new ResponseEntity<>
    		("Job Details updated successfully", HttpStatus.OK);
        } else {
        	return new ResponseEntity<>
    		("Job Details not found", HttpStatus.NOT_FOUND);
        }
    }
// Delete Job Details by Id

	 @DeleteMapping("/{id}")
	    public ResponseEntity<String> deleteJob(@PathVariable Long id) {
		 Optional<Job> deleteJob = jobservice.getJobById(id);  
		 if (deleteJob.isPresent()) {
	        	jobservice.deleteById(id);
	        	return new ResponseEntity<>
	    		("Jod Details deleted successfully", HttpStatus.OK);	
	        } 
		 else
		 {
		 return new ResponseEntity<>
 		("Job Details not found", HttpStatus.NOT_FOUND);
	    }
	 }

}