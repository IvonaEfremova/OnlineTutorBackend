package com.project.findtutoronline.api;

import com.project.findtutoronline.model.Professor;
import com.project.findtutoronline.service.ProfessorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/professors")
public class ProfessorController {
    private ProfessorService professorService;

    public ProfessorController(ProfessorService professorService) {
        this.professorService = professorService;
    }

    @GetMapping()
    public List<Professor> getProfessors() {
        return professorService.getAllProfessors();
    }

    @PostMapping()
    public Professor saveProfessor(@RequestBody Professor professor) {
        return professorService.saveProfessor(professor);
    }

    @PutMapping("/update/{id}")
    public Professor updateProfessor(@PathVariable("id") Long id, @RequestBody Professor professor) {
        return professorService.updateProfessor(id, professor);
    }

    @GetMapping("/{id}")
    public Optional<Professor> getProfessorById(@PathVariable("id") Long id) {
        return professorService.getProfessorById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteProfessor(@PathVariable("id") Long id) {
        professorService.deleteProfessor(id);
    }

    @GetMapping("/search/{term}")
    public List<Professor> getProfessorsByTerm(@PathVariable("term") String term) {
        return professorService.findProfessorsByTerm(term);
    }

    @GetMapping("/course/{id}")
    public List<Professor> getProfessorsByCourse(@PathVariable("id") Long id) {
        return professorService.findProfessorsByCourse(id);
    }
}
