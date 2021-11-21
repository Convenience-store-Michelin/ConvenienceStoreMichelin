package com.convenience.review;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/review")
@Controller
public class ReviewController {

    @GetMapping("/write")
    public String writeView(Model model) {
        return "writeView";
    }

}
