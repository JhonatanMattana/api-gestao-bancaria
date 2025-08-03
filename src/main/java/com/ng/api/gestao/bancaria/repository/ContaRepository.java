package com.ng.api.gestao.bancaria.repository;

import com.ng.api.gestao.bancaria.controller.dto.ContaDto;
import com.ng.api.gestao.bancaria.model.Conta;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@AllArgsConstructor
@Repository
public class ContaRepository {
    private final IContaJpaRepository jpaRepository;

    @Transactional
    public Conta salvar(ContaDto dto) {
        Conta conta = new Conta();
        conta.setNumero(dto.getNumero_conta());
        conta.setSaldo(dto.getSaldo());
        return this.jpaRepository.save(conta);
    }
}
