package com.project.findtutoronline.service;

import com.project.findtutoronline.model.Professor;
import com.project.findtutoronline.model.Review;
import com.project.findtutoronline.model.Student;
import com.project.findtutoronline.repository.ProfessorRepository;
import com.project.findtutoronline.repository.ReviewRepository;
import com.project.findtutoronline.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {

    private ReviewRepository reviewRepository;

    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public List<Review> getAllReviews() {
        return this.reviewRepository.findAll();
    }

    public Optional<Review> getReviewById(Long id) {
        return reviewRepository.findById(id);
    }

    public Review saveReview(Review review) {
        return reviewRepository.save(review);
    }

//     CHECK THIS!!!
    public Review updateReview(Long id, Review review) {
        review.setId(id);
        return reviewRepository.save(review);
    }

    public void deleteReview(Long id) {
        reviewRepository.deleteById(id);
    }

    public List<Review> getReviewByProfessorId(Long professorId) {
        return reviewRepository.findAllByProfessorId(professorId);
    }

    public List<Review> getBestReviewsByProfessorId(Long professorId) {
        return this.reviewRepository.findAllByProfessorIdAndRatingGreaterThan(professorId, 7);
    }

    public List<Review> getBadReviewsByProfessorId(Long professorId) {
        return this.reviewRepository.findAllByProfessorIdAndRatingLessThan(professorId, 4);
    }

    public List<Review> getGoodReviewsByProfessorId(Long professorId) {
        return reviewRepository.findAllByProfessorIdAndRatingBetween(professorId, 4, 7);
    }
}
