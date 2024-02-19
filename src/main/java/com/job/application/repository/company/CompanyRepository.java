package com.job.application.repository.company;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.job.application.model.company.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

}
