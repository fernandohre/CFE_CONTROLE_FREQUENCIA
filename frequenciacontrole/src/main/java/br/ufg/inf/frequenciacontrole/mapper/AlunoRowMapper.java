package br.ufg.inf.frequenciacontrole.mapper;

import br.ufg.inf.frequenciacontrole.model.Aluno;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AlunoRowMapper implements RowMapper<Aluno> {
    @Override
    public Aluno mapRow(ResultSet resultSet, int i) throws SQLException {
        return new Aluno(resultSet.getLong("id"), resultSet.getString("nome"));
    }
}
