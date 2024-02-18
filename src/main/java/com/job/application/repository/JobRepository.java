package com.job.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.job.application.model.Job;
@Repository
public interface JobRepository extends JpaRepository<Job, Long>{
	

}
