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
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
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

    criteria.select(builder.construct(ContasPagarDTO.class,
      root.get("id"),
      root.get("cliente").get("nome")
    ));

    Predicate[] predicates = createRestrictions(contasPagarFilter, builder, root);
    criteria.where(predicates);
    criteria.orderBy(builder.asc(root.get("cliente").get("nome")));

    TypedQuery<ContasPagarDTO> query = manager.createQuery(criteria);
    addPaginationRestrictions(query, pageable);

    return new PageImpl<ContasPagarDTO>(query.getResultList(), pageable, getTotal(contasPagarFilter));
  }

  private Predicate[] createRestrictions(ContasPagarFilter contasPagarFilter, CriteriaBuilder builder, Root<ContasPagar> root) {
    List<Predicate> predicates = new ArrayList<>();

    if (!StringUtils.isEmpty(contasPagarFilter.getNomecliente())) {
      System.out.println(root.get("cliente").get("nome"));
      predicates.add(
        builder.like(
          builder.lower(root.get("cliente").get("nome")),
          "%" + contasPagarFilter.getNomecliente().toLowerCase() + '%'
        )
      );
    }

    /*
    if (!StringUtils.isEmpty(contasPagarFilter.getData().toString())) {
      predicates.add(
        builder.like(
          builder.lower(root.get("data")),
          "%" + contasPagarFilter.getData().toString().toLowerCase() + '%'
        )
      );
    }

    if (!StringUtils.isEmpty(contasPagarFilter.getDatavencimento().toString())) {
      predicates.add(
        builder.like(
          builder.lower(root.get("datavencimento")),
          "%" + contasPagarFilter.getDatavencimento().toString().toLowerCase() + '%'
        )
      );
    }
    * */

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
