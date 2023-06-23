package br.etec.com.lucas.exerciciopw2.repository.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ContasPagarDTO {
  private Long id;
  private String nomecliente;

  public ContasPagarDTO(Long id, String nomecliente) {
    this.id = id;
    this.nomecliente = nomecliente;
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
