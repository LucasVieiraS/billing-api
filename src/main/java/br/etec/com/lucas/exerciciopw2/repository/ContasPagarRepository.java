package br.etec.com.lucas.exerciciopw2.repository;

import br.etec.com.lucas.exerciciopw2.model.ContasPagar;
import br.etec.com.lucas.exerciciopw2.repository.contaspagar.ContasPagarRepositoryQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContasPagarRepository extends JpaRepository<ContasPagar, Long>, ContasPagarRepositoryQuery {

}
