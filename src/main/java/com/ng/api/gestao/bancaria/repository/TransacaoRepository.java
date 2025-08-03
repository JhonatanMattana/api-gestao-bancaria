package com.ng.api.gestao.bancaria.repository;

import com.ng.api.gestao.bancaria.controller.dto.TransacaoDto;
import com.ng.api.gestao.bancaria.model.Conta;
import com.ng.api.gestao.bancaria.model.Transacao;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@AllArgsConstructor
@Repository
public class TransacaoRepository {
    private final ITransacaoJpaRepository transacaoRepository;
    private final IContaJpaRepository contaRepository;

    public Transacao salvarNovaTransacao(TransacaoDto dto, Conta conta) {
        Transacao transacao = new Transacao();
        transacao.setFormaPagamento(dto.getForma_pagamento());
        transacao.setValor(dto.getValor());
        conta = contaRepository.save(conta);
        transacao.setConta(conta);
        return transacaoRepository.save(transacao);
    }
}
