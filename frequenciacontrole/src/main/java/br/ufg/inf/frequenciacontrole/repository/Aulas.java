package br.ufg.inf.frequenciacontrole.repository;

import br.ufg.inf.frequenciacontrole.model.Aula;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Aulas extends JpaRepository<Aula, Long> {
}
