package br.ufg.inf.frequenciacontrole.repository;

import br.ufg.inf.frequenciacontrole.model.Frequencia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class FrequenciaRepository {
    @Autowired
    private JdbcTemplate servico;

    public void registreFrequencia(Frequencia f) {
        StringBuilder insert = new StringBuilder();
        insert.append("insert into frequencia values(");
        insert.append(f.getIdAluno() + ", ");
        insert.append(f.getIdTurma() + ")");
        servico.execute(insert.toString());
    }
}
