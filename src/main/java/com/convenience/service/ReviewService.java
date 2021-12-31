package com.convenience.service;

import com.convenience.domain.Review;
import com.convenience.domain.repository.ReviewRepository;
import com.convenience.web.dto.ReviewDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReviewService {
    private final ReviewRepository reviewRepository;
    public ReviewService (ReviewRepository reviewRepository){
        this.reviewRepository = reviewRepository;
    }
    /**
     * 리뷰작성
     */
    @Transactional
    public Long create(ReviewDto reviewDto){ return reviewRepository.save(reviewDto.toEntity()).getId();}
}