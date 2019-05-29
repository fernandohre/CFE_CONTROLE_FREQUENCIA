package Model;


import javax.persistence.GeneratedValue;

public class Aluno {
    private Long id;
    private String nome;

    public Aluno(String nome, Long id) {
        this.nome = nome;
        this.id = id;
    }
}
