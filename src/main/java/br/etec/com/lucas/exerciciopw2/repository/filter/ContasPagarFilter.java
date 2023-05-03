package br.etec.com.lucas.exerciciopw2.repository.filter;

import java.math.BigDecimal;

public class ContasPagarFilter {
  private BigDecimal valor;

  public BigDecimal getValor() {
    return valor;
  }

  public void setValor(BigDecimal valor) {
    this.valor = valor;
  }
}
