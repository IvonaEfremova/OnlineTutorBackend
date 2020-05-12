package com.project.findtutoronline.api;

import com.project.findtutoronline.model.Review;
import com.project.findtutoronline.service.ReviewService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {
    private ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping()
    public List<Review> getReviews() {
        return reviewService.getAllReviews();
    }

    @PostMapping("/new")
    public Review saveReview(@RequestBody Review review) {
        return reviewService.saveReview(review);
    }

    @PutMapping("/update/{id}")
    public Review updateReview(@PathVariable("id") Long id, @RequestBody Review review) {
        return reviewService.updateReview(id, review);
    }

    @GetMapping("/{id}")
    public Optional<Review> getReviewById(@PathVariable("id") Long id) {
        return reviewService.getReviewById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deletePReview(@PathVariable("id") Long id) {
        reviewService.deleteReview(id);
    }

    @GetMapping("/professor/{professorId}")
    public List<Review> getReviewsByProfessorId(@PathVariable("professorId") Long professorId) {
        return reviewService.getReviewByProfessorId(professorId);
    }

    @GetMapping("/professor/{professorId}/best")
    public List<Review> getBestReviewsByProfessorId(@PathVariable("professorId") Long professorId) {
        return reviewService.getBestReviewsByProfessorId(professorId);
    }

    @GetMapping("/professor/{professorId}/bad")
    public List<Review> getBadReviewsByProfessorId(@PathVariable("professorId") Long professorId) {
        return reviewService.getBadReviewsByProfessorId(professorId);
    }

    @GetMapping("/professor/{professorId}/good")
    public List<Review> getGoodReviewsByProfessorId(@PathVariable("professorId") Long professorId) {
        return reviewService.getGoodReviewsByProfessorId(professorId);
    }

}
