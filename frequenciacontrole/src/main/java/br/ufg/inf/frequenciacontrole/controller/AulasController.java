package br.ufg.inf.frequenciacontrole.controller;

import br.ufg.inf.frequenciacontrole.model.Aula;
import br.ufg.inf.frequenciacontrole.repository.Aulas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController("/aulas")
public class AulasController {

    @Autowired
    private Aulas aulas;

    @GetMapping(produces = "application/json")
    public @ResponseBody Iterable<Aula> obtenhaAulas() {
        Iterable<Aula> listaAulas = aulas.findAll();
        return listaAulas;
    }

    @PostMapping
    public Aula salveAula(@RequestBody Aula aula) {
        return aulas.save(aula);
    }
}
