package br.ufg.inf.frequenciacontrole.model;


import java.util.List;


public class Turma {


    private Long id;

    private String descricao;

    public Turma(Long id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String desc) {
        this.descricao = desc;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
