package br.etec.com.lucas.exerciciopw2.resource;

import br.etec.com.lucas.exerciciopw2.model.Cliente;
import br.etec.com.lucas.exerciciopw2.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("cliente")
public class ClienteResource {
    @Autowired
    public ClienteRepository clienteRepository;

    @RequestMapping("/todos")
    public List<Cliente> listarTodosClientes() {
        return clienteRepository.findAll();
    }
}