package com.project.findtutoronline.model;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "lectures")
public class Lecture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String timeFrom;

    @NotNull
    private String timeTo;

    @NotNull
    private Float price;

    @NotNull
    private String url;

    private String dateCreated;

    @NotNull
    @Column(name = "minStudents")
    private Integer minNumberStudents;

    private Boolean active;

    @NotNull
    @Column(name = "maxStudents")
    private Integer maxNumberStudents;

    @ManyToMany
    @JoinTable(
            name = "students_lecture",
            joinColumns = @JoinColumn(name = "lecture_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id")
    )
    private List<Student> students;

    @ManyToOne
    @JoinColumn(name = "professor_id")
    private Professor professor;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    public Lecture() {
        this.students = new ArrayList<>();
    }

    public Lecture(String timeFrom,
                   String timeTo,
                   Float price,
                   Professor professor,
                   Course course,
                   String url,
                   Integer minNumberStudents,
                   Integer maxNumberStudents,
                   String dateCreated) {
        this.timeFrom = timeFrom;
        this.timeTo = timeTo;
        this.price = price;
        this.professor = professor;
        this.url = url;
        this.course = course;
        this.minNumberStudents = minNumberStudents;
        this.maxNumberStudents = maxNumberStudents;
        this.dateCreated = dateCreated;
        this.students = new ArrayList<>();
    }
}
