package com.ng.api.gestao.bancaria.service;

import com.ng.api.gestao.bancaria.controller.dto.TransacaoDto;
import com.ng.api.gestao.bancaria.model.Conta;
import com.ng.api.gestao.bancaria.repository.ContaRepository;
import com.ng.api.gestao.bancaria.repository.TransacaoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TransacaoService {
    private final TransacaoRepository transacaoRepository;
    private final ContaRepository contaRepository;

    public TransacaoDto criarTransacao(TransacaoDto dto) {
        Conta contaTransacao = contaRepository.getContaByNumero(dto.getNumero_conta());

        dto.setSaldo(dto.getSaldo());
        contaTransacao.setSaldo(dto.getSaldo());

        transacaoRepository.salvarNovaTransacao(dto, contaTransacao);
        return dto;
    }
}
