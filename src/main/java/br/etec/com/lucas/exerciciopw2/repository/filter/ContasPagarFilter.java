package br.etec.com.lucas.exerciciopw2.repository.filter;

import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ContasPagarFilter {
  private String nomecliente;

  private BigDecimal valor;

  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private LocalDate data;

  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private LocalDate datavencimento;

  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private LocalDate datavencimentoantes;

  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private LocalDate datavencimentodepois;

  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private LocalDate dataantes;

  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private LocalDate datadepois;

  public LocalDate getDatavencimentoantes() {
    return datavencimentoantes;
  }

  public void setDatavencimentoantes(LocalDate datavencimentoantes) {
    this.datavencimentoantes = datavencimentoantes;
  }

  public LocalDate getDatavencimentodepois() {
    return datavencimentodepois;
  }

  public void setDatavencimentodepois(LocalDate datavencimentodepois) {
    this.datavencimentodepois = datavencimentodepois;
  }

  public LocalDate getDataantes() {
    return dataantes;
  }

  public void setDataantes(LocalDate dataantes) {
    this.dataantes = dataantes;
  }

  public LocalDate getDatadepois() {
    return datadepois;
  }

  public void setDatadepois(LocalDate datadepois) {
    this.datadepois = datadepois;
  }

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
