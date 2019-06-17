package Model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Turma {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = true)
    private String descricao;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "turma_aluno",
                joinColumns = @JoinColumn(name = "aluno_id",
                                          referencedColumnName = "id"),
                                          inverseJoinColumns = @JoinColumn(name = "turma_id",
                                                                           referencedColumnName = "id"))
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
