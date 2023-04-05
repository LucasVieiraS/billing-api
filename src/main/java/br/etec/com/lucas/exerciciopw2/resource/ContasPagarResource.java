package br.etec.com.lucas.exerciciopw2.resource;

import br.etec.com.lucas.exerciciopw2.model.ContasPagar;
import br.etec.com.lucas.exerciciopw2.repository.ContasPagarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("contaspagar")
public class ContasPagarResource {
    @Autowired
    public ContasPagarRepository contasPagarRepository;

    @RequestMapping("/todos")
    public List<ContasPagar> listarTodasContasPagar() {
        return contasPagarRepository.findAll();
    }
}
