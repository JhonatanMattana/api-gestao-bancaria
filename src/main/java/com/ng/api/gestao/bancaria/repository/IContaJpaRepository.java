package com.ng.api.gestao.bancaria.repository;

import com.ng.api.gestao.bancaria.model.Conta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IContaJpaRepository extends JpaRepository<Conta, UUID> {
    Conta getContaByNumero(Integer numeroConta);
    Boolean existsByNumero(Integer numeroConta);
}
