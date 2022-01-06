package com.convenience.web;

import com.convenience.domain.Review;
import com.convenience.service.ReviewService;
import com.convenience.web.dto.ReviewDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
public class ReviewController {
    private final ReviewService reviewService;
    @Autowired
    public ReviewController(ReviewService reviewService){
        this.reviewService = reviewService;
    }

    @GetMapping("/review/list")
    public String reviewList(Model model){
        model.addAttribute("reviews", reviewService.findAll());
        return "index";
    }

    @GetMapping("/review/view")
    public String reviewView(Model model, @RequestParam(value ="id") Long id){
        model.addAttribute("review", reviewService.findById(id).orElseThrow(IllegalAccessError::new));
        return "view";
    }

    @GetMapping("/review/new")
    public String createForm(){
        return "write";
    }

    @PostMapping("/review/new")
    public String create(@Valid ReviewDto reviewDto){
        reviewService.create(reviewDto);
        return "index";
    }
}

