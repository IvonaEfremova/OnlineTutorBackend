package com.project.findtutoronline.service;

import com.project.findtutoronline.model.Course;
import com.project.findtutoronline.model.Professor;
import com.project.findtutoronline.repository.CourseRepository;
import com.project.findtutoronline.repository.ProfessorRepository;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

@Service
public class ProfessorService {
    private ProfessorRepository professorRepository;
    private CourseRepository courseRepository;

    public ProfessorService(ProfessorRepository professorRepository,
                            CourseRepository courseRepository) {
        this.professorRepository = professorRepository;
        this.courseRepository = courseRepository;
    }

    public List<Professor> getAllProfessors() {
        return this.professorRepository.findAll();
    }

    public Optional<Professor> getProfessorById(Long id) {
        return professorRepository.findById(id);
    }

    public Professor saveProfessor(Professor professor) {
        return professorRepository.save(professor);
    }

    public Professor updateProfessor(Long id, @NotNull Professor professor) {
        professor.setId(id);
        return professorRepository.save(professor);
    }

    public void deleteProfessor(Long id) {
        professorRepository.deleteById(id);
    }

    public List<Professor> findProfessorsByTerm(String term) {
        return professorRepository.findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(term, term);
    }

    public List<Professor> findProfessorsByCourse(Long courseId) {
        Course c =  courseRepository.findById(courseId).orElseThrow();
        return this.professorRepository.findAllByCourses(c);
    }
}
