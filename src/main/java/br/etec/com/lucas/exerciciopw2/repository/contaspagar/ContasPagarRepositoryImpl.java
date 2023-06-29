package br.etec.com.lucas.exerciciopw2.repository.contaspagar;

import br.etec.com.lucas.exerciciopw2.model.ContasPagar;
import br.etec.com.lucas.exerciciopw2.repository.dto.ContasPagarDTO;
import br.etec.com.lucas.exerciciopw2.repository.filter.ContasPagarFilter;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ContasPagarRepositoryImpl implements ContasPagarRepositoryQuery {
  @PersistenceContext
  private EntityManager manager;

  @Override
  public Page<ContasPagarDTO> filter(ContasPagarFilter contasPagarFilter, Pageable pageable) {
    CriteriaBuilder builder = manager.getCriteriaBuilder();
    CriteriaQuery<ContasPagarDTO> criteria = builder.createQuery(ContasPagarDTO.class);
    Root<ContasPagar> root = criteria.from(ContasPagar.class);

    criteria.select(
            builder.construct(ContasPagarDTO.class,
                    root.get("id"),
                    root.get("cliente").get("nome"),
                    root.get("datavencimento"),
                    root.get("datacriacao"),
                    root.get("valor")
            )
    );

    Predicate[] predicates = createRestrictions(contasPagarFilter, builder, root);
    criteria.where(predicates);
    criteria.orderBy(builder.asc(root.get("cliente").get("nome")));

    TypedQuery<ContasPagarDTO> query = manager.createQuery(criteria);
    addPaginationRestrictions(query, pageable);

    return new PageImpl<ContasPagarDTO>(query.getResultList(), pageable, getTotal(contasPagarFilter));
  }

  private Predicate[] createRestrictions(ContasPagarFilter contasPagarFilter, CriteriaBuilder builder, Root<ContasPagar> root) {
    List<Predicate> predicates = new ArrayList<>();

    Path<String> clienteNome = root.get("cliente").get("nome");
    String nomeCliente = contasPagarFilter.getNomecliente();

    if (!StringUtils.isEmpty(nomeCliente)) {
      predicates.add(
        builder.like(
          builder.lower(clienteNome),
          "%" + nomeCliente.toLowerCase() + '%'
        )
      );
    }

    if (contasPagarFilter.getValor() != null) {
      predicates.add(
              builder.lessThanOrEqualTo(
                      root.get("valor"),
                      contasPagarFilter.getValor()
              )
      );
    }

    if (contasPagarFilter.getDatacriacao() != null) {
      predicates.add(
        builder.equal(
          root.get("datacriacao"),
          contasPagarFilter.getDatacriacao()
        )
      );
    }

    if (contasPagarFilter.getDatavencimento() != null) {
      predicates.add(
        builder.equal(
          root.get("datavencimento"),
          contasPagarFilter.getDatavencimento()
        )
      );
    }

    return predicates.toArray((new Predicate[predicates.size()]));
  }

  private void addPaginationRestrictions(TypedQuery<?> query, Pageable pageable) {
    int currentPage = pageable.getPageNumber();
    int totalRegistersPerPage = pageable.getPageSize();
    int firstPageRegister = currentPage * totalRegistersPerPage;

    query.setFirstResult(firstPageRegister);
    query.setMaxResults(totalRegistersPerPage);
  }

  private Long getTotal(ContasPagarFilter contasPagarFilter) {
    CriteriaBuilder builder = manager.getCriteriaBuilder();
    CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
    Root<ContasPagar> root = criteria.from(ContasPagar.class);

    Predicate[] predicates = createRestrictions(contasPagarFilter, builder, root);
    criteria.where(predicates);
    criteria.orderBy(builder.asc(root.get("cliente").get("nome")));

    criteria.select(builder.count(root));

    return manager.createQuery(criteria).getSingleResult();
  }
}
