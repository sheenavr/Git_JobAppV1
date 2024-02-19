package com.job.application.repository.job;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.job.application.model.job.Job;

@Repository
public interface JobRepository extends JpaRepository<Job, Long> {

}
