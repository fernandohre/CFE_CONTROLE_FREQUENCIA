package Model;

import java.util.List;

/**
 * Created by aluno on 29/05/19.
 */
public class Frequencia {
    private List<Aluno> alunos;
    private Turma atual;

    public Frequencia(Turma turma) {
        this.atual = turma;
    }
}
