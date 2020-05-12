package com.project.findtutoronline.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "reviews")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "professor_id")
    private Professor professor;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    private String comment;
    private Integer rating;
    private String dateOfReview;

    public Review() {}

    public Review(Professor professor, Student student, String comment, Integer rating, String dateOfReview) {
        this.professor = professor;
        this.student = student;
        this.comment = comment;
        this.rating = rating;
    }
}
