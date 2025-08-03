package com.ng.api.gestao.bancaria.validator;

import com.ng.api.gestao.bancaria.controller.dto.TransacaoDto;
import com.ng.api.gestao.bancaria.exception.GestaoBancariaException;
import com.ng.api.gestao.bancaria.model.Conta;
import com.ng.api.gestao.bancaria.repository.ContaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class TransacaoServiceValidator {
    private final ContaRepository contaRepository;

    public void validarTransacao(TransacaoDto dto) {
        Conta conta = contaRepository.getContaByNumero(dto.getNumero_conta());
        if (conta == null) {
            throw new GestaoBancariaException("Erro interno: conta retornou nula.");
        }
    }

    public void validarExistConta(TransacaoDto dto) {
        boolean exists = contaRepository.existsByNumero(dto.getNumero_conta());
        if (!exists) {
            throw new GestaoBancariaException(String.format("Conta (%s) não encontrada.", dto.getNumero_conta()));
        }
    }

    public void validarSaldoSuficiente(Conta conta, float valorComTaxa) {
        float saldoFinal = conta.getSaldo() - valorComTaxa;
        if (saldoFinal < 0) {
            throw new GestaoBancariaException("Não há saldo suficiente para realizar a transação.");
        }
    }
}
