package com.job.application.repository.review;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.job.application.model.review.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

}
