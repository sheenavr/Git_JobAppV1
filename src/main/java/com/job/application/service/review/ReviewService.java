package com.job.application.service.review;

import java.util.List;
import java.util.Optional;
import com.job.application.model.review.Review;

public interface ReviewService {
	public List<Review> findAll();

	public void createReview(Review review);

	public Optional<Review> getReviewById(Long id);

	public void deleteById(Long id);

	public void updateReview(Review review);

}
