package com.ng.api.gestao.bancaria.service;

import com.ng.api.gestao.bancaria.controller.dto.ContaDto;
import com.ng.api.gestao.bancaria.model.Conta;
import com.ng.api.gestao.bancaria.repository.ContaRepository;
import com.ng.api.gestao.bancaria.validator.ContaServiceValidator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ContaService {
    private final ContaRepository repository;
    private final ContaServiceValidator validator;

    public ContaDto criarConta(ContaDto dto) {
        validator.validarCriarConta(dto);
        Conta conta = repository.salvar(dto);
        return new ContaDto(conta.getNumero(), conta.getSaldo());
    }

    public ContaDto getContaPorNumero(Integer numeroConta) {
        validator.validarExistConta(numeroConta);
        Conta conta = repository.getContaByNumero(numeroConta);
        return new ContaDto(conta.getNumero(), conta.getSaldo());
    }
}
