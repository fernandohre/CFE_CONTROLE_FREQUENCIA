package Model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = true)
    private String nome;

    @ManyToMany(mappedBy = "Aluno", fetch = FetchType.EAGER)
    private List<Turma> turmas;

    public Aluno(String nome, Long id) {
        this.nome = nome;
        this.id = id;
    }


    public List<Turma> getTurmas() {
        return turmas;
    }

    public void setTurmas(List<Turma> turmas) {
        this.turmas = turmas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
