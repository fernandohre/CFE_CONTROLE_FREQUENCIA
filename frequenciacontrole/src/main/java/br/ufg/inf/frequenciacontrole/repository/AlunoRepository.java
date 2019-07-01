package br.ufg.inf.frequenciacontrole.repository;

import br.ufg.inf.frequenciacontrole.mapper.AlunoRowMapper;
import br.ufg.inf.frequenciacontrole.model.Aluno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AlunoRepository {
    @Autowired
    private JdbcTemplate servico;

    public Aluno cadastreAluno(Aluno aluno) {
        String sqlUltimoId = "select id from aluno where id in (select max(id) from aluno)";
        String insert = "insert into aluno(nome) values('" + aluno.getNome() + "')";
        servico.execute(insert);
        Long idAluno = (Long)servico.queryForObject(sqlUltimoId, Long.class);
        aluno.setId(idAluno);
        return aluno;
    }

    public List<Aluno> obtenhaAlunos() {
        List<Aluno> alunos = new ArrayList<Aluno>();

        String sqlConsulta = "select id, nome from aluno";

        alunos = servico.query(sqlConsulta, new AlunoRowMapper());

        return alunos;
    }
}
