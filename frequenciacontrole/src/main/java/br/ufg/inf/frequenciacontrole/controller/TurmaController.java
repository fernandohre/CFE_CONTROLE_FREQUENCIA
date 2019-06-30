package br.ufg.inf.frequenciacontrole.controller;

import br.ufg.inf.frequenciacontrole.model.Turma;
import br.ufg.inf.frequenciacontrole.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/turmas")
public class TurmaController {

    @Autowired
    private TurmaRepository turmaRepository;

    @GetMapping(produces = "application/json")
    public @ResponseBody Iterable<Turma> obtenhaTurmas() {
        List<Turma> listaTurmas = turmaRepository.obtenhaTurmas();
        return listaTurmas;
    }

    @GetMapping("/{id}")
    public @ResponseBody Turma obtenhaPorId(@PathVariable(value = "id") Long id) {
        return turmaRepository.obtenhaPorId(id);
    }

}
