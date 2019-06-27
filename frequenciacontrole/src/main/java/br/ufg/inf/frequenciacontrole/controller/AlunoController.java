package br.ufg.inf.frequenciacontrole.controller;

import br.ufg.inf.frequenciacontrole.model.Aluno;
import br.ufg.inf.frequenciacontrole.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController("/aluno")
public class AlunoController {
    @Autowired
    private AlunoRepository repository;

    @GetMapping(produces = "application/json")
    public @ResponseBody Iterable<Aluno> obtenhaAlunos() {
        Iterable<Aluno> listaAlunos = repository.findAll();
        return listaAlunos;
    }

    @PostMapping
    public Aluno salveAluno(@RequestBody Aluno aluno) {
        return repository.save(aluno);
    }
}
