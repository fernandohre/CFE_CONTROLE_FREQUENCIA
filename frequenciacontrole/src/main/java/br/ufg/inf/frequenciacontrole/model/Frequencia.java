package br.ufg.inf.frequenciacontrole.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Frequencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean estaPresente;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean getEstaPresente() {
        return estaPresente;
    }

    public void getEstaPresente(boolean estaPresente) {
        this.estaPresente = estaPresente;
    }
}
