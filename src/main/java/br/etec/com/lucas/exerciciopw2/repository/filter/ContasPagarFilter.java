package br.etec.com.lucas.exerciciopw2.repository.filter;

import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;

@Getter
@Setter
public class ContasPagarFilter {
  private String nomecliente;
  private BigDecimal valor;

  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private LocalDate datacriacao;

  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private LocalDate datavencimento;

}
