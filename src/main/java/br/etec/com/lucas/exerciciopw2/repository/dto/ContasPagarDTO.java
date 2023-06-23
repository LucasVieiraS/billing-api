package br.etec.com.lucas.exerciciopw2.repository.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ContasPagarDTO {
  private Long id;
  private String nomecliente;

  private LocalDate datavencimento;
  private LocalDate data;

  public ContasPagarDTO(Long id, String nomecliente, LocalDate datavencimento, LocalDate data) {
    this.id = id;
    this.nomecliente = nomecliente;
    this.datavencimento = datavencimento;
    this.data = data;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNomecliente() {
    return nomecliente;
  }

  public void setNomecliente(String nomecliente) {
    this.nomecliente = nomecliente;
  }
}
