package br.ufg.inf.frequenciacontrole.controller;

import br.ufg.inf.frequenciacontrole.model.Presenca;
import br.ufg.inf.frequenciacontrole.repository.Presencas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/presencas")
public class PresencasController {

    @Autowired
    private Presencas presencas;

    @GetMapping(produces = "application/json")
    public @ResponseBody Iterable<Presenca> obtenhaPresenca() {
        Iterable<Presenca> listaPresencas = presencas.findAll();
        return listaPresencas;
    }

    @PostMapping
    public Presenca salvePresenca(@RequestBody Presenca presenca) {
        return presencas.save(presenca);
    }
}
