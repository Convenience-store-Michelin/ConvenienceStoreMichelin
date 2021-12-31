package com.convenience.web;

import com.convenience.domain.Review;
import com.convenience.service.ReviewService;
import com.convenience.web.dto.ReviewDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class ReviewController {
    private final ReviewService reviewService;
    @Autowired
    public ReviewController(ReviewService reviewService){
        this.reviewService = reviewService;
    }

    @GetMapping("/reviews/list")
    public String reviewList(){
        return "index";
    }

    @GetMapping("/reviews/new")
    public String createForm(){
        return "write";
    }

    @PostMapping("/reviews/new")
    public String create(@Valid ReviewDto reviewDto){
        reviewService.create(reviewDto);
        return "index";
    }
}