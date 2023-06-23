package br.etec.com.lucas.exerciciopw2.repository.contaspagar;

import br.etec.com.lucas.exerciciopw2.repository.dto.ContasPagarDTO;
import br.etec.com.lucas.exerciciopw2.repository.filter.ContasPagarFilter;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;

public interface ContasPagarRepositoryQuery {
  public Page<ContasPagarDTO> filter(ContasPagarFilter contasPagarFilter, Pageable pageable);
}
