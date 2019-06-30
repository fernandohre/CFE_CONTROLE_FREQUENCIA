package br.ufg.inf.frequenciacontrole.repository;


import br.ufg.inf.frequenciacontrole.mapper.AlunoRowMapper;
import br.ufg.inf.frequenciacontrole.mapper.TurmaRowMapper;
import br.ufg.inf.frequenciacontrole.model.Aluno;
import br.ufg.inf.frequenciacontrole.model.Turma;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class TurmaRepository {
    @Autowired
    private JdbcTemplate servico;

    public List<Turma> obtenhaTurmas() {
        List<Turma> turmas = new ArrayList<Turma>();

        String sqlConsulta = "select id, descricao from turma";

        turmas = servico.query(sqlConsulta, new TurmaRowMapper());

        return turmas;
    }

    public Turma obtenhaPorId(Long id) {
        String sqlConsulta = "select id, descricao from turma where id = ?";

        Map map = servico.queryForMap(sqlConsulta, id);
        return new Turma((Long)map.get("id"), (String)map.get("descricao"));
    }

    public List<Aluno> obtenhaAlunosDaTurma(Long idTurma) {
        String sqlConsulta = "select aluno.id, aluno.nome from aluno join frequencia join turma " +
                "on aluno.id = frequencia.id_aluno and frequencia.id_turma = turma.id and turma.id = ?";
        List<Aluno> alunos = new ArrayList<Aluno>();
        alunos = servico.query(sqlConsulta, new AlunoRowMapper());
        return alunos;
    }
}
