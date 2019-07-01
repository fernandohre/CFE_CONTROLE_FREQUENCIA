package br.ufg.inf.frequenciacontrole.controller;

import br.ufg.inf.frequenciacontrole.model.Aluno;
import br.ufg.inf.frequenciacontrole.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alunos")
@CrossOrigin
public class AlunoController {
    @Autowired
    private AlunoRepository repository;

    @PostMapping
    public @ResponseBody Aluno cadastreAluno(@RequestBody Aluno aluno) {
        return repository.cadastreAluno(aluno);
    }

    @GetMapping(produces = "application/json")
    public @ResponseBody Iterable<Aluno> obtenhaTurmas() {
        List<Aluno> listaAlunos = repository.obtenhaAlunos();
        return listaAlunos;
    }
}
