package br.ufg.inf.frequenciacontrole.controller;

import br.ufg.inf.frequenciacontrole.model.Frequencia;
import br.ufg.inf.frequenciacontrole.repository.Frequencias;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/frequencias")
public class FrequenciaController {

    @Autowired
    private Frequencias frequencias;

    @GetMapping(produces = "application/json")
    public @ResponseBody Iterable<Frequencia> obtenhaFrequencias() {
        Iterable<Frequencia> listaFrequencias = frequencias.findAll();
        return listaFrequencias;
    }

    @PostMapping
    public Frequencia salveFrequencia(@RequestBody Frequencia frequencia) {
        return frequencias.save(frequencia);
    }
}
