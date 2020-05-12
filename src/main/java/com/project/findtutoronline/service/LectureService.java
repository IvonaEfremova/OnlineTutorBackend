package com.project.findtutoronline.service;

import com.project.findtutoronline.model.Lecture;
import com.project.findtutoronline.model.Student;
import com.project.findtutoronline.repository.LectureRepository;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
public class LectureService {

    private LectureRepository lectureRepository;

    public LectureService(LectureRepository lectureRepository) {
        this.lectureRepository = lectureRepository;
    }

    public List<Lecture> getLectures() throws ParseException {
        this.checkDate();
        return lectureRepository.findAllByActiveTrue();
    }

    public Optional<Lecture> getLectureById(Long id) {
        return lectureRepository.findById(id);
    }

    public Lecture saveLecture(Lecture lecture) {
        return lectureRepository.save(lecture);
    }

    //CHECK THIS!!!
    public Lecture updateLecture(Long id, Lecture lecture) {
        lecture.setId(id);
        return lectureRepository.save(lecture);
    }

    public void deleteLecture(Long id) {
        lectureRepository.deleteById(id);
    }

    public List<Lecture> getLecturesByProfessorId(Long professorId) {
        return lectureRepository.findByProfessor_IdAndActive(professorId, true);
    }

    public List<Lecture> getLecturesByTerm(String term) {
        return lectureRepository.findByCourse_TitleContainingIgnoreCase(term);
    }

    public void checkDate() {
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("H:m:s");
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("M/d/yyyy");
        List<Lecture> newList = lectureRepository.findAll();
        for (Lecture l : newList) {
            LocalDate parsedDate = LocalDate.parse(l.getDateCreated(), dateFormatter);
            LocalTime parsedTime = LocalTime.parse(l.getTimeTo(), timeFormatter);
            if(parsedDate.equals(LocalDate.now()) && parsedTime.isBefore(LocalTime.now())){
                    l.setActive(false);
            }
            else if(parsedDate.isBefore(LocalDate.now())) {
                    l.setActive(false);
            }
            lectureRepository.save(l);
        }
    }

    public List<Student> getStudentsByLecture(Long lectureId) {
        Lecture lecture = lectureRepository.findById(lectureId).orElseThrow();
        return lecture.getStudents();
    }
}
