package com.job.application.service.company;

import java.util.List;
import java.util.Optional;
import com.job.application.model.company.Company;

public interface CompanyService {
	public Company createCompany(Company company);
	public List<Company> findAll();
	public Company getCompanyById(Long id);
	public Company updateCompany(Company company);
	public void deleteById(Long id);
	 

}

