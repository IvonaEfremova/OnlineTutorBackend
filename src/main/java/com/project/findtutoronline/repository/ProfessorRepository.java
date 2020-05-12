package com.project.findtutoronline.repository;

import com.project.findtutoronline.model.Course;
import com.project.findtutoronline.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long> {
    Professor getById(Long id);

    boolean existsById(Long id);

    List<Professor> findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(String term, String term2);

    List<Professor> findAllByCourses(Course course);
}
