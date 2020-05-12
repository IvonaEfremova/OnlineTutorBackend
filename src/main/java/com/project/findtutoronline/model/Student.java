package com.project.findtutoronline.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    @Email
    private String email;

    @ManyToMany
    @JsonIgnore
    @JoinTable(
            name = "students_lecture",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "lecture_id")
    )
    private List<Lecture> lectures;

    public Student() {
        this.lectures = new ArrayList<>();
    }

    public Student(String firstName, String lastName, String email) {
        this.lectures = new ArrayList<>();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
}
