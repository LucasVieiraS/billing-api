package br.etec.com.lucas.exerciciopw2.repository.dto;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class ContasPagarDTO {
  @NonNull private Long id;
  private String nomecliente;
  private LocalDate datavencimento;
  private LocalDate datacriacao;
  @NonNull private BigDecimal valor;

  public ContasPagarDTO(@NonNull Long id, String nomecliente, LocalDate datavencimento, LocalDate datacriacao, @NonNull BigDecimal valor) {
    this.id = id;
    this.nomecliente = nomecliente;
    this.datavencimento = datavencimento;
    this.datacriacao = datacriacao;
    this.valor = valor;
  }
}
