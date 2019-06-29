package br.ufg.inf.frequenciacontrole.controller;

import br.ufg.inf.frequenciacontrole.model.Professor;
import br.ufg.inf.frequenciacontrole.repository.Professores;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController("/professores")
public class ProfessoresController {

    @Autowired
    private Professores professores;

    @GetMapping(produces = "application/json")
    public @ResponseBody Iterable<Professor> obtenhaProfessores() {
        Iterable<Professor> listaProfessores = professores.findAll();
        return listaProfessores;
    }

    @PostMapping
    public Professor saveProfessor(@RequestBody Professor professor) {
        return professores.save(professor);
    }
}
