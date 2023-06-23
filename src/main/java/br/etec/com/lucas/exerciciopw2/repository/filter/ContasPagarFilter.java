package br.etec.com.lucas.exerciciopw2.repository.filter;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ContasPagarFilter {
  private String nomecliente;
  private BigDecimal valor;
  private LocalDate data;
  private LocalDate datavencimento;

  public String getNomecliente() {
    return nomecliente;
  }

  public void setNomecliente(String nomecliente) {
    this.nomecliente = nomecliente;
  }

  public BigDecimal getValor() {
    return valor;
  }

  public void setValor(BigDecimal valor) {
    this.valor = valor;
  }

  public LocalDate getData() {
    return data;
  }

  public void setData(LocalDate data) {
    this.data = data;
  }

  public LocalDate getDatavencimento() {
    return datavencimento;
  }

  public void setDatavencimento(LocalDate datavencimento) {
    this.datavencimento = datavencimento;
  }
}
