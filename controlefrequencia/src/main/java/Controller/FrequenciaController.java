package Controller;

import Model.Aluno;
import Model.Servicos.ServicoDeAluno;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/")
public class FrequenciaController {

    private ServicoDeAluno servico;
    private FrequenciaController() {
        servico = new ServicoDeAluno();
    }

    @RequestMapping(value = "frequenciaAlunos", method = RequestMethod.GET)
    public List<Aluno> exibeAlunos() {
        return servico.obtenhaTodos();
    }
}
