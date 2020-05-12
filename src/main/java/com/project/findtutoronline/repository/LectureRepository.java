package com.project.findtutoronline.repository;

import com.project.findtutoronline.model.Lecture;
import com.project.findtutoronline.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface LectureRepository extends JpaRepository<Lecture, Long> {

    List<Lecture>  findByProfessor_IdAndActive(Long professorId, Boolean active);

    List<Lecture> findAllByActiveTrue();

    List<Lecture> findByCourse_TitleContainingIgnoreCase(String term);

}
