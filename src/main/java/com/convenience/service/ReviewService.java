package com.convenience.service;

import com.convenience.domain.Review;
import com.convenience.domain.repository.ReviewRepository;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;

    public ReviewService (ReviewRepository reviewRepository){
        this.reviewRepository = reviewRepository;
    }

    /**
     * 리뷰작성
     */
    public Long create(Review review){

        reviewRepository.save(review);

        return review.getId();
    }

}
