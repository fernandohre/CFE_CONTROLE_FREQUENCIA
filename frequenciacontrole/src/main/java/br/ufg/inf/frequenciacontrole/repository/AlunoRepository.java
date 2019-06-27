package br.ufg.inf.frequenciacontrole.repository;

import br.ufg.inf.frequenciacontrole.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, String> {
}
