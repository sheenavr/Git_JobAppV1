package com.job.application.service.company;

import com.job.application.model.company.Company;
import com.job.application.repository.company.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl  implements CompanyService{


   

    private final CompanyRepository companyRepository;
    
    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
        
    }
    

    // Create a new company
    public Company createCompany(Company company) {
        return companyRepository.save(company);
    }

    // Retrieve all companies
    public List<Company> findAll() {
        return companyRepository.findAll();
    }

    // Retrieve a company by ID
    public Company getCompanyById(Long id) {
        return companyRepository.findById(id).orElse(null);
    }

    // Update a company
    public Company updateCompany(Company company) {
        return companyRepository.save(company);
    }

    // Delete a company by ID
    public void deleteById(Long id) {
        companyRepository.deleteById(id);
    }
}
