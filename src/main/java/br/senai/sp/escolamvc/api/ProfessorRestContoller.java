package br.senai.sp.escolamvc.api;

import br.senai.sp.escolamvc.model.Professor;
import br.senai.sp.escolamvc.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequestMapping("/api/professor")
public class ProfessorRestContoller {
    @Autowired

    private ProfessorRepository professorRepository;

    //@GetMapping
    @GetMapping("/listar")
    public List<Professor> listar() {
        return professorRepository.findAll();
    }

    @PostMapping("/inserir")
    public void inserir(@RequestBody Professor professor) {
        professorRepository.save(professor);
    }

    @PutMapping("/alterar")
    public void alterar(@RequestBody Professor professor) {
        professorRepository.save(professor);
    }

    @DeleteMapping("/deletar")
    public void deletar(@RequestBody Professor professor) {
        professorRepository.delete(professor);
    }

}
