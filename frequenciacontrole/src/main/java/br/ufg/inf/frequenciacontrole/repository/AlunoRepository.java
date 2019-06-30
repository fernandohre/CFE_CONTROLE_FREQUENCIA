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

    public void cadastreAluno(Aluno aluno) {
        String insert = "insert into aluno(nome) values('" + aluno.getNome() + "')";
        servico.execute(insert);
    }

    public List<Aluno> obtenhaAlunos() {
        List<Aluno> alunos = new ArrayList<Aluno>();

        String sqlConsulta = "select id, nome from aluno";

        alunos = servico.query(sqlConsulta, new AlunoRowMapper());

        return alunos;
    }
}
