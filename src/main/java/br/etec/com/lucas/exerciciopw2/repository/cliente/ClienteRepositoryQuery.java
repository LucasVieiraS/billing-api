package br.etec.com.lucas.exerciciopw2.repository.cliente;

import br.etec.com.lucas.exerciciopw2.model.Cliente;
import br.etec.com.lucas.exerciciopw2.repository.filter.ClienteFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ClienteRepositoryQuery {
  public Page<Cliente> filter(ClienteFilter clienteFilter, Pageable pageable);
}
