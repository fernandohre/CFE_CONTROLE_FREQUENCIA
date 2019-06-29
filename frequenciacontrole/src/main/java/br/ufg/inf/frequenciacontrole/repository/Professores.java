package br.ufg.inf.frequenciacontrole.repository;

import br.ufg.inf.frequenciacontrole.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Professores extends JpaRepository<Professor, Long> {
}
