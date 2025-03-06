package br.senai.sp.escolamvc.repository;

import br.senai.sp.escolamvc.model.Aluno;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.data.jpa.domain.AbstractPersistable_;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
    List<Aluno> findAlunosByNomeContaining(String nome);

    Long id(Long id);


    AbstractPersistable_ findByNome(@NotEmpty(message = "Campo obrigatorio!") String nome);

    List<Aluno> findAlunosByNomeContainingIgnoreCase(String nome);
    Aluno findAlunosByCpf(String cpf);

    List<Aluno> findAlunosByContainingCpfOrCpfContainingIgnoreCase(
            String nome,
            String cpf);
}

