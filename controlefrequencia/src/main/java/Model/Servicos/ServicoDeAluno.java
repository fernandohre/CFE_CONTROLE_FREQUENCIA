package Model.Servicos;


import Model.Aluno;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ServicoDeAluno {
    private static Map<Long, Aluno> dados = new HashMap<Long, Aluno>();

    static {
        Aluno a = new Aluno("Maria", 1L);
        Aluno b = new Aluno("Pedro", 2L);
        Aluno c = new Aluno("Marcos", 3L);

        dados.put(1L, a);
        dados.put(2L, b);
        dados.put(3L, c);
    }

    public List<Aluno> obtenhaTodos() {
        return dados.values().stream().collect(Collectors.toList());
    }
}
