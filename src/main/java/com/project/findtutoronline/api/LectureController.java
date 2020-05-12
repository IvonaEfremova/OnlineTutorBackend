package com.project.findtutoronline.api;

import com.project.findtutoronline.model.Lecture;
import com.project.findtutoronline.model.Professor;
import com.project.findtutoronline.model.Student;
import com.project.findtutoronline.service.LectureService;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/lectures")
public class LectureController {

    private LectureService lectureService;

    public LectureController(LectureService lectureService) {
        this.lectureService = lectureService;
    }

    @GetMapping()
    public List<Lecture> getLectures() throws ParseException {
        return lectureService.getLectures();
    }

    @PostMapping()
    public Lecture saveLecture(@RequestBody Lecture lecture) {
        return lectureService.saveLecture(lecture);
    }

    @PutMapping("/update/{id}")
    public Lecture updateCourse(@PathVariable("id") Long id, @RequestBody Lecture lecture) {
        return lectureService.updateLecture(id, lecture);
    }

    @GetMapping("/{id}")
    public Optional<Lecture> getLectureById(@PathVariable("id") Long id) {
        return lectureService.getLectureById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteLecture(@PathVariable("id") Long id) {
        lectureService.deleteLecture(id);
    }

    @GetMapping("/professor/{id}")
    public List<Lecture> getLecturesByProfessorId(@PathVariable("id") Long professorId) {
        return lectureService.getLecturesByProfessorId(professorId);
    }

    @GetMapping("/search/{term}")
    public List<Lecture> getLecturesByTerm(@PathVariable("term") String term) {
        return lectureService.getLecturesByTerm(term);
    }


    @GetMapping("/{id}/students")
    public List<Student> getProfessorsByCourse(@PathVariable("id") Long id) {
        return lectureService.getStudentsByLecture(id);
    }
}
