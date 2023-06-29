package br.etec.com.lucas.exerciciopw2.resource;

import br.etec.com.lucas.exerciciopw2.model.ContasPagar;
import br.etec.com.lucas.exerciciopw2.repository.ContasPagarRepository;
import br.etec.com.lucas.exerciciopw2.repository.dto.ContasPagarDTO;
import br.etec.com.lucas.exerciciopw2.repository.filter.ContasPagarFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import java.util.List;

@RestController
@RequestMapping("contaspagar")
public class ContasPagarResource {
    @Autowired
    public ContasPagarRepository contasPagarRepository;

    @GetMapping("/todos")
    public List<ContasPagar> listAllContasPagar() {
        return contasPagarRepository.findAll();
    }

    @GetMapping()
    public Page<ContasPagarDTO> filterContasPagar(ContasPagarFilter contasPagarFilter, Pageable pageable) {
      return contasPagarRepository.filter(contasPagarFilter, pageable);
    }
}
