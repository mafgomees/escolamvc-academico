package br.senai.sp.escolamvc.api;

import br.senai.sp.escolamvc.model.Aluno;
import br.senai.sp.escolamvc.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequestMapping("/api/aluno")
public class AlunoRestContoller {
    @Autowired

    private AlunoRepository alunoRepository;

    //@GetMapping
    @GetMapping("/listar")
    public List<Aluno> listar() {
        return alunoRepository.findAll();
    }

    @PostMapping("/inserir")
    public void inserir(@RequestBody Aluno aluno) {
        alunoRepository.save(aluno);
    }

    @PutMapping("/alterar")
    public void alterar(@RequestBody Aluno aluno) {
        alunoRepository.save(aluno);
    }

    @DeleteMapping("/deletar")
    public void deletar(@RequestBody Aluno aluno) {
        alunoRepository.delete(aluno);
    }

    //inserir  varios
    @PostMapping("/inserir-varios")
    public void inserirVarios(@RequestBody List<Aluno> alunos) {
        alunoRepository.saveAll(alunos);
    }

    //buscar id
    @GetMapping("/buscar/{id}")
    public Aluno buscarPorId(@PathVariable Long id) {
        return alunoRepository.findById(id).get();
    }

    //buscar por nome

    @GetMapping("/buscar-por-nome/{nome}")
    public List<Aluno> buscarporNome(@PathVariable String nome) {
        return alunoRepository.findAlunosByNomeContaining(nome);
    }

    @GetMapping("/buscar-por-cpf/{cpf}")
    public Aluno buscarPorCpf(@PathVariable String cpf) {
        return alunoRepository.findAlunosByCpf(cpf);
    }

    @GetMapping("/buscar-por-nome-ou-cpf/{nome}/{cpf}")
    public List<Aluno> buscarPorOuCpf(
            @PathVariable String nome,
            @PathVariable String cpf
    ) {
        return alunoRepository
                .findAlunosByContainingCpfOrCpfContainingIgnoreCase(nome, cpf);
    }

}