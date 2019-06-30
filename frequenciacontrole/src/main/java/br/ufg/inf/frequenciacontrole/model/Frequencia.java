package br.ufg.inf.frequenciacontrole.model;

public class Frequencia {
    private Long aluno;
    private Long turma;
    private boolean estaPresente;

    public Frequencia(Long aluno, Long turma, boolean estaPresente) {
        this.aluno = aluno;
        this.turma = turma;
        this.estaPresente = estaPresente;
    }

    public Long getIdTurma() {
        return turma;
    }

    public Long getIdAluno() {
        return aluno;
    }

    public boolean estaPresente() {
        return estaPresente;
    }
}
