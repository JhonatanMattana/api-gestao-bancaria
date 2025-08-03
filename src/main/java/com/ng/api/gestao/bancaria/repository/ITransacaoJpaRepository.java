package com.ng.api.gestao.bancaria.repository;

import com.ng.api.gestao.bancaria.model.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ITransacaoJpaRepository extends JpaRepository<Transacao, UUID> {
}
