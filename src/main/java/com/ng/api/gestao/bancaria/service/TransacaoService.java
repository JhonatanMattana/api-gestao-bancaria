package com.ng.api.gestao.bancaria.service;

import com.ng.api.gestao.bancaria.controller.dto.TransacaoDto;
import com.ng.api.gestao.bancaria.factory.calculartaxa.CalcularTaxaTransacaoFactory;
import com.ng.api.gestao.bancaria.factory.calculartaxa.ICalcularTaxaTransacao;
import com.ng.api.gestao.bancaria.model.Conta;
import com.ng.api.gestao.bancaria.repository.ContaRepository;
import com.ng.api.gestao.bancaria.repository.TransacaoRepository;
import com.ng.api.gestao.bancaria.validator.TransacaoServiceValidator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TransacaoService {
    private final TransacaoRepository transacaoRepository;
    private final ContaRepository contaRepository;
    private final TransacaoServiceValidator validator;

    public TransacaoDto criarTransacao(TransacaoDto dto) {
        validator.validarExistConta(dto);
        validator.validarTransacao(dto);
        Conta contaTransacao = contaRepository.getContaByNumero(dto.getNumero_conta());

        float valorComTaxaCalculada = getValorTaxaCalculada(dto);
        validator.validarSaldoSuficiente(contaTransacao, valorComTaxaCalculada);

        float saldoFinal = contaTransacao.getSaldo() - valorComTaxaCalculada;
        dto.setSaldo(saldoFinal);
        contaTransacao.setSaldo(saldoFinal);

        transacaoRepository.salvarNovaTransacao(dto, contaTransacao);
        return dto;
    }

    private float getValorTaxaCalculada(TransacaoDto dto) {
        ICalcularTaxaTransacao calcularTaxa = CalcularTaxaTransacaoFactory
                .criarCalculoTaxaTransacao(dto.getForma_pagamento());
        return calcularTaxa.calcular(dto.getValor());
    }

}
