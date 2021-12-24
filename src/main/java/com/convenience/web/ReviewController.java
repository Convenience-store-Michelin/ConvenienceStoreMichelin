package com.convenience.web;

import com.convenience.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
    public String create(){

        return "";
    }

}
