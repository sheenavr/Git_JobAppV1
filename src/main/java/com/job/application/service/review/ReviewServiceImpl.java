package com.job.application.service.review;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.job.application.model.company.Company;
import com.job.application.model.review.Review;
import com.job.application.repository.review.ReviewRepository;
import com.job.application.service.company.CompanyService;

@Service
public class ReviewServiceImpl implements ReviewService {
	
	private final ReviewRepository reviewrepository;
	private final CompanyService companyService;

	public ReviewServiceImpl(ReviewRepository reviewrepository, CompanyService companyService) {
		super();
		this.reviewrepository = reviewrepository;
		this.companyService = companyService;
	}

	@Override
	public List<Review> findAll() {

		return reviewrepository.findAll();
	}

	public List<Review> getReviewByCompanyId(Long companyId) {
		List<Review> reviews = reviewrepository.findByCompanyId(companyId);
		return reviews;
	}

	@Override
	public void deleteById(Long id) {
		reviewrepository.deleteById(id);

	}

	@Override
	public void updateReview(Review review) {
		reviewrepository.save(review);

	}

	@Override
	public boolean createReview(Long companyId, Review review) {
		Company company = companyService.getCompanyById(companyId);
		if (company != null) {
			review.setCompany(company);
			reviewrepository.save(review);
			return true;
		}
		else
			return false;
	}

}
