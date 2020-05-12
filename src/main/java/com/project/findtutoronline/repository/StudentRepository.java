package com.project.findtutoronline.repository;

import com.project.findtutoronline.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    Student getById(Long id);
}
