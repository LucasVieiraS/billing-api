package br.etec.com.lucas.exerciciopw2.repository;

import br.etec.com.lucas.exerciciopw2.model.Cliente;
import br.etec.com.lucas.exerciciopw2.repository.cliente.ClienteRepositoryQuery;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>, ClienteRepositoryQuery {

}
