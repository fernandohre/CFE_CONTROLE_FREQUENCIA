package br.ufg.inf.frequenciacontrole.mapper;

import br.ufg.inf.frequenciacontrole.model.Turma;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TurmaRowMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        Turma turma = new Turma(resultSet.getLong("id"),
                                resultSet.getString("descricao"));
        return turma;
    }
}
