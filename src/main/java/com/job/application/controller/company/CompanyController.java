package com.job.application.controller.company;

import java.util.List;

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

import com.job.application.model.company.Company;
import com.job.application.service.company.CompanyService;

@RestController
@RequestMapping("/api/v1/companies")
public class CompanyController {

	private CompanyService companyservice;

	public CompanyController(CompanyService companyservice) {

		this.companyservice = companyservice;
	}

    // Get all Company Details
    @GetMapping("/allDetails")
    public ResponseEntity<List<Company>> findAll() {
        List<Company> companies = companyservice.findAll();
        return ResponseEntity.ok(companies);
    }

    // Get Company Details by Id
    @GetMapping("/{id}")
    public ResponseEntity<Company> getCompanyById(@PathVariable Long id) {
        Company company = companyservice.getCompanyById(id);
        if (company != null) {
            return ResponseEntity.ok(company);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    // Add Company details
    @PostMapping("/addCompany")
    public ResponseEntity<String> addCompany(@RequestBody Company company) {
        companyservice.createCompany(company);
        return new ResponseEntity<>("Company Details Added successfully", HttpStatus.CREATED);
    }

    // Update Company Details by Id
    @PutMapping("/{id}")
    public ResponseEntity<String> updateCompany(@PathVariable Long id, @RequestBody Company newCompany) {
        Company existingCompany = companyservice.getCompanyById(id);
        if (existingCompany != null) {
            existingCompany.setName(newCompany.getName());
            existingCompany.setDescription(newCompany.getDescription());
            existingCompany.setJobs(newCompany.getJobs());
            companyservice.updateCompany(existingCompany);
            return new ResponseEntity<>("Company Details updated successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Company Details not found", HttpStatus.NOT_FOUND);
        }
    }

    // Delete Company Details by Id
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCompany(@PathVariable Long id) {
        Company existingCompany = companyservice.getCompanyById(id);
        if (existingCompany != null) {
            companyservice.deleteById(id);
            return new ResponseEntity<>("Company Details deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Company Details not found", HttpStatus.NOT_FOUND);
        }
    }

}
