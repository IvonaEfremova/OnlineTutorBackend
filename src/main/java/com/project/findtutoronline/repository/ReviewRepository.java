package com.project.findtutoronline.repository;

import com.project.findtutoronline.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

    List<Review> findAllByProfessorId(Long id);

    List<Review> findAllByProfessorIdAndRatingGreaterThan(Long professorId, Integer rating);

    List<Review> findAllByProfessorIdAndRatingLessThan(Long professorId, Integer rating);

    List<Review> findAllByProfessorIdAndRatingBetween(Long professorId, Integer from, Integer to);
}
