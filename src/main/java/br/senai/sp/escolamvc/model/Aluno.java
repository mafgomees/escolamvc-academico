package br.senai.sp.escolamvc.model;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
;

@Data
@DiscriminatorValue(value = "A")
@Entity
public class Aluno extends Pessoa {

    @NotEmpty(message = "Campo obrigatorio!")
    private String matricula;


}

