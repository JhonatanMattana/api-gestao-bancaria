package com.ng.api.gestao.bancaria.repository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@AllArgsConstructor
@Repository
public class TransacaoRepository {
    private final ITransacaoJpaRepository transacaoRepository;
    private final IContaJpaRepository contaRepository;
}
