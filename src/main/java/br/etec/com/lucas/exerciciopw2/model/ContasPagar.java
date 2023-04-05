package br.etec.com.lucas.exerciciopw2.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name="contaspagar")
public class ContasPagar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate data;
    private LocalDate datavencimento;
    private BigDecimal valor;

    @ManyToOne
    @JoinColumn(name="idcliente")
    private Cliente cliente;

    public Long getId() {
      return id;
    }

    public void setId(Long id) {
      this.id = id;
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

    public BigDecimal getValor() {
      return valor;
    }

    public void setValor(BigDecimal valor) {
      this.valor = valor;
    }

    public Cliente getCliente() {
      return cliente;
    }

    public void setCliente(Cliente cliente) {
      this.cliente = cliente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContasPagar that = (ContasPagar) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
