package API;

import Model.Aluno;
import Repositorio.RepositorioDeAluno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aluno")
public class AlunoAPI {
    @Autowired
    private RepositorioDeAluno repositorio;

    private AlunoAPI() {

    }
    @GetMapping(produces = "application/json")
    @RequestMapping(value="/listar", method= RequestMethod.GET)
    public @ResponseBody
    List<Aluno> obtenhaTodos() {
        return repositorio.obtenhaTodos();
    }
}
