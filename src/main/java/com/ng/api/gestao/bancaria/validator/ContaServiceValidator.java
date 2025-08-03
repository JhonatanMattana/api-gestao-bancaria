package com.ng.api.gestao.bancaria.validator;

import com.ng.api.gestao.bancaria.controller.dto.ContaDto;
import com.ng.api.gestao.bancaria.exception.GestaoBancariaException;
import com.ng.api.gestao.bancaria.model.Conta;
import com.ng.api.gestao.bancaria.repository.ContaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ContaServiceValidator {
    private final ContaRepository repository;

    public void validarCriarConta(ContaDto dto) {
        if (repository.existsByNumero(dto.getNumero_conta())) {
            throw new GestaoBancariaException(String.format("Conta (%s) já cadastrada.", dto.getNumero_conta()));
        }

        if (dto.getSaldo() < 0) {
            throw new GestaoBancariaException("Não é permitido criar Conta com saldo negativo");
        }
    }

    public void validarExistConta(Integer numeroConta) {
        Conta conta = repository.getContaByNumero(numeroConta);
        if (conta == null) {
            throw new GestaoBancariaException("Não foi encontrato Conta com o Número " + numeroConta);
        }
    }
}
