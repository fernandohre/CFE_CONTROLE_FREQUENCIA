package Repositorio;

import Model.Aluno;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@Configuration
public class RepositorioDeAluno implements RepositorioGenerico<Aluno> {
    @Override
    public List<Aluno> obtenhaTodos() {

        List<Aluno> lista = new ArrayList<Aluno>();
        lista.add(new Aluno("Fernando", 1L));
        lista.add(new Aluno("Gabriel", 2L));
        lista.add(new Aluno("Basílio", 3L));
        return lista;
    }
}
