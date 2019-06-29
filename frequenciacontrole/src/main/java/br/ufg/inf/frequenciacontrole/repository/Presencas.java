package br.ufg.inf.frequenciacontrole.repository;

import br.ufg.inf.frequenciacontrole.model.Presenca;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Presencas extends JpaRepository<Presenca, Long> {
}
