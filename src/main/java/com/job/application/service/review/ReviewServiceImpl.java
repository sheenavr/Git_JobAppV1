package com.job.application.service.review;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.job.application.model.review.Review;
import com.job.application.repository.review.ReviewRepository;

@Service
public class ReviewServiceImpl implements ReviewService {
	@Autowired
	private ReviewRepository reviewrepository;

	@Override
	public List<Review> findAll() {

		return reviewrepository.findAll();
	}

	@Override
	public void createReview(Review review) {

		reviewrepository.save(review);

	}

	public Optional<Review> getReviewById(Long id) {
		return reviewrepository.findById(id);
	}

	@Override
	public void deleteById(Long id) {
		reviewrepository.deleteById(id);

	}

	@Override
	public void updateReview(Review review) {
		reviewrepository.save(review);

	}

}
