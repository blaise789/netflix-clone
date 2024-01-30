package dev.blaise.movies_application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/reviews")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Review createReviewMethod(@RequestBody Map<String,String> payload){
        return  reviewService.createReview(payload.get("reviewBody"),payload.get("imdbId"));
    }

}
