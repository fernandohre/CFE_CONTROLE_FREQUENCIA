package br.ufg.inf.frequenciacontrole.controller;

import br.ufg.inf.frequenciacontrole.model.Turma;
import br.ufg.inf.frequenciacontrole.repository.Turmas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController("/turmas")
public class TurmasController {

    @Autowired
    private Turmas turmas;

    @GetMapping(produces = "application/json")
    public @ResponseBody Iterable<Turma> obtenhaTurmas() {
        Iterable<Turma> listaTurmas = turmas.findAll();
        return listaTurmas;
    }

    @PostMapping
    public Turma salveTurma(@RequestBody Turma turma) {
        return turmas.save(turma);
    }

}
