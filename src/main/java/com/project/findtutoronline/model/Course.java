package com.project.findtutoronline.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String title;

    @ManyToMany(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinTable(
            name = "professor_course",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "professor_id")
    )
    private List<Professor> professors;

    @ManyToOne
    @JoinColumn(name = "categoryId")
    private Category category;

    public Course() {
        this.professors = new ArrayList<>();
    }

    public Course(String title, Category category) {
        this.title = title;
        this.category = category;
        this.professors = new ArrayList<>();
    }

    public Course(Long id, String title, Category category) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.professors = new ArrayList<>();
    }
}
