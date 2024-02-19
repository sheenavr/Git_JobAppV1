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
@RequestMapping("/api/v1/reviews")
public class ReviewController {

	private ReviewService reviewservice;

	public ReviewController(ReviewService reviewService) {

		this.reviewservice = reviewService;
	}
// Get all Review Details

	@GetMapping("/allDetails")
	public ResponseEntity<List<Review>> findAll() {
		return ResponseEntity.ok(reviewservice.findAll());
	}
//Get Review Details by Id

	@GetMapping("/{id}")
	public ResponseEntity<Review> getById(@PathVariable Long id) {
		Optional<Review> reviewOptional = reviewservice.getReviewById(id);
		return reviewOptional.map(review -> ResponseEntity.ok().body(review))
				.orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}

//Add Review details	
	@PostMapping("/addreview")
	public ResponseEntity<String> addReview(@RequestBody Review review) {
		reviewservice.createReview(review);
		return new ResponseEntity<>("Review Details Added successfully", HttpStatus.CREATED);

	}
// Update Review Details by Id

	@PutMapping("/{id}")
	public ResponseEntity<String> updateReview(@PathVariable Long id, @RequestBody Review newReview) {
		Optional<Review> updateReview = reviewservice.getReviewById(id);
		if (updateReview.isPresent()) {
			Review review = updateReview.get();
			review.setTitle(newReview.getTitle());
			review.setDescription(newReview.getDescription());
			review.setRating(newReview.getRating());
			reviewservice.updateReview(review);
			return new ResponseEntity<>("Review Details updated successfully", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Review Details not found", HttpStatus.NOT_FOUND);
		}
	}
// Delete Review Details by Id

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteReview(@PathVariable Long id) {
		Optional<Review> deleteReview= reviewservice.getReviewById(id);
		if (deleteReview.isPresent()) {
			reviewservice.deleteById(id);
			return new ResponseEntity<>("Review Details deleted successfully", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Review Details not found", HttpStatus.NOT_FOUND);
		}
	}

}