package br.etec.com.lucas.exerciciopw2.resource;

import br.etec.com.lucas.exerciciopw2.model.Cliente;
import br.etec.com.lucas.exerciciopw2.repository.ClienteRepository;
import br.etec.com.lucas.exerciciopw2.repository.dto.ContasPagarDTO;
import br.etec.com.lucas.exerciciopw2.repository.filter.ClienteFilter;
import br.etec.com.lucas.exerciciopw2.repository.filter.ContasPagarFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("clientes")
public class ClienteResource {
    @Autowired
    public ClienteRepository clienteRepository;

    @GetMapping("/todos")
    public List<Cliente> listAllClientes() {
        return clienteRepository.findAll();
    }

    @GetMapping()
    public Page<Cliente> filterCliente(ClienteFilter clienteFilter, Pageable pageable) {
        return clienteRepository.filter(clienteFilter, pageable);
    }
}
