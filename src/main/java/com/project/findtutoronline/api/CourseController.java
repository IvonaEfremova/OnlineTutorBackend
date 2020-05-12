package com.project.findtutoronline.api;

import com.project.findtutoronline.model.Category;
import com.project.findtutoronline.model.Course;
import com.project.findtutoronline.service.CourseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/courses")
public class CourseController {
    private CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping()
    public List<Course> getCourses() {

        return courseService.getAllCourses();
    }

    @PostMapping()
    public Course saveCategory(@RequestBody Course course) {
        return courseService.saveCourse(course);
    }

    @PutMapping("/update/{id}")
    public Course updateCourse(@PathVariable("id") Long id, @RequestBody  Course course) {
        return courseService.updateCourse(id, course);
    }

    @GetMapping("/{id}")
    public Optional<Course> getCourseById(@PathVariable("id") Long id) {
        return courseService.getCourseById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCourse(@PathVariable("id") Long id) {
        courseService.deleteCourse(id);
    }

    @GetMapping("/search/{term}")
    public List<Course> getCoursesByTerm(@PathVariable("term") String term) {
        return courseService.findCourseByTerm(term);
    }

    @GetMapping("/{id}/category")
    public List<Course> getCoursesByCategoryId(@PathVariable("id") Long categoryId) {
        return courseService.getCourseByCategoryId(categoryId);
    }

    @GetMapping("/professor/{id}")
    public List<Course> getCoursesByProfessorId(@PathVariable("id") Long id) {
        return courseService.getCoursesByProfessorId(id);
    }

}
