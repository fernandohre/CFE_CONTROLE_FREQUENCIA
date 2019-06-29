package br.ufg.inf.frequenciacontrole.repository;

import br.ufg.inf.frequenciacontrole.model.Frequencia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Frequencias extends  JpaRepository<Frequencia, Long> {
}
