package com.project.findtutoronline.repository;

import com.project.findtutoronline.model.Course;
import com.project.findtutoronline.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    Course getById(Long id);

    List<Course> findByTitleContainingIgnoreCase(String term);

    List<Course> findByCategory_Id(Long id);

    List<Course> findByProfessors(Professor professor);
}
