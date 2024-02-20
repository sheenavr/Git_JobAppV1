package com.job.application.controller.review;

import java.util.List;
import java.util.Optional;
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
import com.job.application.model.review.Review;
import com.job.application.service.review.ReviewService;

@RestController
@RequestMapping("/api/v1/companies")
public class ReviewController {

	private final ReviewService reviewService;

	public ReviewController(ReviewService reviewService) {
		this.reviewService = reviewService;
	}

	// Get all Review Details
	@GetMapping("/allReviewDetails")
	public ResponseEntity<List<Review>> findAll() {
		return ResponseEntity.ok(reviewService.findAll());
	}

	// Get Review Details by company Id
	@GetMapping("/{companyId}/reviews")
	public ResponseEntity<List<Review>> getReviewByCompanyId(@PathVariable Long companyId) {
		List<Review> review = reviewService.getReviewByCompanyId(companyId);
		if (review != null) {
			return ResponseEntity.ok().body(review);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

	// Get Review Details by review ID

	@GetMapping("/review/{reviewId}")

	public ResponseEntity<Review> getJobById(@PathVariable Long reviewId) {
		Optional<Review> reviewOptional = reviewService.getReviewById(reviewId);
		return reviewOptional.map(review -> ResponseEntity.ok().body(review))
				.orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}

	// Add Review details
	@PostMapping("/{companyId}/addreview")
	public ResponseEntity<String> addReview(@PathVariable Long companyId, @RequestBody Review review) {
		boolean reviewSaved = reviewService.createReview(companyId, review);
		if (reviewSaved)
			return new ResponseEntity<>("Review Details Added successfully", HttpStatus.CREATED);
		else
			return new ResponseEntity<>("Review Details not saved", HttpStatus.NOT_FOUND);
	}

	// Update Review Details by Id

	@PutMapping("/review/{reviewId}")
	public ResponseEntity<String> updateReview(@PathVariable Long reviewId, 
			@RequestBody Review newReview) {
		Optional<Review> updateReview = reviewService.getReviewById(reviewId);
		if (updateReview.isPresent()) {
			Review review = updateReview.get();
			review.setTitle(newReview.getTitle());
			review.setDescription(newReview.getDescription());
			review.setRating(newReview.getRating());

			reviewService.updateReview(review);
			return new ResponseEntity<>("Review Details updated successfully", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Review Details not found", HttpStatus.NOT_FOUND);
		}
	}
	// Delete Review Details by Id

	@DeleteMapping("/review/{reviewId}")
	public ResponseEntity<String> deleteReview(@PathVariable Long reviewId) {
		Optional<Review> deleteReview = reviewService.getReviewById(reviewId);
		if (deleteReview.isPresent()) {
			reviewService.deleteById(reviewId);
			return new ResponseEntity<>("Review Details deleted successfully", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Review Details not found", HttpStatus.NOT_FOUND);
		}
	}
}
