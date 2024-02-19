package com.job.application.service.company;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.job.application.model.company.Company;
import com.job.application.model.job.Job;
import com.job.application.repository.company.CompanyRepository;
import com.job.application.repository.job.JobRepository;

@Service
public class CompanyServiceImpl implements CompanyService {
	@Autowired
	private CompanyRepository companyrepository;

	@Override
	public List<Company> findAll() {

		return companyrepository.findAll();
	}

	@Override
	public void createCompany(Company company) {

		companyrepository.save(company);

	}

	public Optional<Company> getCompanyById(Long id) {
		return companyrepository.findById(id);
	}

	@Override
	public void deleteById(Long id) {
		companyrepository.deleteById(id);

	}

	@Override
	public void updateCompany(Company company) {
		companyrepository.save(company);

	}

	

}
