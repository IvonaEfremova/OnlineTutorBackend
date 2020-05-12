package com.project.findtutoronline.service;

import com.project.findtutoronline.model.Category;
import com.project.findtutoronline.model.Course;
import com.project.findtutoronline.model.Professor;
import com.project.findtutoronline.repository.CategoryRepository;
import com.project.findtutoronline.repository.CourseRepository;
import com.project.findtutoronline.repository.ProfessorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    private CourseRepository courseRepository;
    private ProfessorRepository professorRepository;

    public CourseService(CourseRepository courseRepository, ProfessorRepository professorRepository) {
        this.courseRepository = courseRepository;
        this.professorRepository = professorRepository;
    }

    public List<Course> getAllCourses() {

        return this.courseRepository.findAll();
    }

    public Optional<Course> getCourseById(Long id) {
        return courseRepository.findById(id);
    }

    public Course saveCourse(Course course) {
        return courseRepository.save(course);
    }

    // CHECK THIS!!!
    public Course updateCourse(Long id, Course course) {
        course.setId(id);
        return courseRepository.save(course);
    }

    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }

    public List<Course> findCourseByTerm(String term) {
        return courseRepository.findByTitleContainingIgnoreCase(term);
    }

    public List<Course> getCourseByCategoryId(Long categoryId) {
        return courseRepository.findByCategory_Id(categoryId);
    }

    public List<Course> getCoursesByProfessorId(Long professorId) {
        Professor professor = professorRepository.getById(professorId);
        return courseRepository.findByProfessors(professor);
    }
}
