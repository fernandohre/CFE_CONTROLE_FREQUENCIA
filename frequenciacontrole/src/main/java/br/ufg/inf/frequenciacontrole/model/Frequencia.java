package br.ufg.inf.frequenciacontrole.model;

import javax.persistence.*;

@Entity
public class Frequencia {

    @OneToOne
    private Turma turma;

    @OneToOne
    private Aluno aluno;

    private boolean estaPresente;

    public boolean getEstaPresente() {
        return estaPresente;
    }

    public void getEstaPresente(boolean estaPresente) {
        this.estaPresente = estaPresente;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }
}
