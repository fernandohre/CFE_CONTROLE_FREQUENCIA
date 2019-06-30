package br.ufg.inf.frequenciacontrole.controller;

import br.ufg.inf.frequenciacontrole.model.Aluno;
import br.ufg.inf.frequenciacontrole.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/alunos")
public class AlunoController {
    @Autowired
    private AlunoRepository repository;

    @PostMapping
    public void cadastreAluno(@RequestBody Aluno aluno) {
        repository.cadastreAluno(aluno);
    }
}
