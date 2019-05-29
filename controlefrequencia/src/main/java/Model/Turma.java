package Model;

import java.util.List;

/**
 * Created by aluno on 29/05/19.
 */
public class Turma {
    private String descricao;
    private List<Aluno> alunos;

    public Turma(List<Aluno> lista) {
        this.alunos = lista;
    }

    public List<Aluno> obtenhaAlunos() {
        return this.alunos;
    }

    public String obtenhaDescricao() {
        return this.descricao;
    }
}
