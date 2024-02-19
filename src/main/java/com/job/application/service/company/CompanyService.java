package com.job.application.service.company;

import java.util.List;
import java.util.Optional;
import com.job.application.model.company.Company;

public interface CompanyService {
	public List<Company> findAll();

	public void createCompany(Company company);

	public Optional<Company> getCompanyById(Long id);

	public void deleteById(Long id);

	public void updateCompany(Company company);

}
