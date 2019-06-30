package br.ufg.inf.frequenciacontrole.controller;

import br.ufg.inf.frequenciacontrole.model.Frequencia;
import br.ufg.inf.frequenciacontrole.repository.FrequenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/frequencias")
public class FrequenciaController {
    @Autowired
    private FrequenciaRepository repository;
    @PostMapping
    public void registreFrequencia(@RequestBody Frequencia f) {
        repository.registreFrequencia(f);
    }
}
