package com.ng.api.gestao.bancaria.validator;

import com.ng.api.gestao.bancaria.controller.dto.ContaDto;
import com.ng.api.gestao.bancaria.exception.GestaoBancariaException;
import com.ng.api.gestao.bancaria.model.Conta;
import com.ng.api.gestao.bancaria.repository.ContaRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ContaServiceValidatorTest {

    @Mock
    private ContaRepository repository;

    @InjectMocks
    private ContaServiceValidator validator;

    @Test
    void deveLancarExcecao_QuandoContaJaExiste() {
        ContaDto dto = new ContaDto();
        dto.setNumero_conta(123);
        dto.setSaldo(100);

        when(repository.existsByNumero(123)).thenReturn(true);

        GestaoBancariaException exception = assertThrows(
                GestaoBancariaException.class,
                () -> validator.validarCriarConta(dto)
        );

        assertEquals("Conta (123) já cadastrada.", exception.getMessage());
    }

    @Test
    void deveLancarExcecao_QuandoSaldoForNegativo() {
        ContaDto dto = new ContaDto();
        dto.setNumero_conta(123);
        dto.setSaldo(-50);

        when(repository.existsByNumero(123)).thenReturn(false);

        GestaoBancariaException exception = assertThrows(
                GestaoBancariaException.class,
                () -> validator.validarCriarConta(dto)
        );

        assertEquals("Não é permitido criar Conta com saldo negativo", exception.getMessage());
    }

    @Test
    void naoDeveLancarExcecao_QuandoContaForValida() {
        ContaDto dto = new ContaDto();
        dto.setNumero_conta(123);
        dto.setSaldo(500);

        when(repository.existsByNumero(123)).thenReturn(false);

        assertDoesNotThrow(() -> validator.validarCriarConta(dto));
    }

    @Test
    void deveLancarExcecao_QuandoContaNaoExiste() {
        when(repository.getContaByNumero(999)).thenReturn(null);

        GestaoBancariaException exception = assertThrows(
                GestaoBancariaException.class,
                () -> validator.validarExistConta(999)
        );

        assertEquals("Não foi encontrato Conta com o Número 999", exception.getMessage());
    }

    @Test
    void naoDeveLancarExcecao_QuandoContaExiste() {
        Conta conta = new Conta();
        when(repository.getContaByNumero(888)).thenReturn(conta);

        assertDoesNotThrow(() -> validator.validarExistConta(888));
    }
}