package com.ng.api.gestao.bancaria.validator;

import com.ng.api.gestao.bancaria.controller.dto.TransacaoDto;
import com.ng.api.gestao.bancaria.exception.GestaoBancariaException;
import com.ng.api.gestao.bancaria.model.Conta;
import com.ng.api.gestao.bancaria.repository.ContaRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TransacaoServiceValidatorTest {

    @Mock
    private ContaRepository contaRepository;

    @InjectMocks
    private TransacaoServiceValidator validator;

    @Test
    public void deveLancarExcecao_QuandoContaNaoExiste_validarTransacao() {
        TransacaoDto dto = new TransacaoDto();
        dto.setNumero_conta(123);

        when(contaRepository.getContaByNumero(123)).thenReturn(null);

        assertThrows(GestaoBancariaException.class, () -> validator.validarTransacao(dto));
    }

    @Test
    public void deveLancarExcecao_QuandoContaNaoExiste_validarExistConta() {
        TransacaoDto dto = new TransacaoDto();
        dto.setNumero_conta(456);

        when(contaRepository.existsByNumero(456)).thenReturn(false);

        assertThrows(GestaoBancariaException.class, () -> validator.validarExistConta(dto));
    }

    @Test
    public void deveLancarExcecao_QuandoSaldoForInsuficiente() {
        Conta conta = new Conta();
        conta.setSaldo(50.0f);

        float valorComTaxa = 60.0f;

        assertThrows(GestaoBancariaException.class, () -> validator.validarSaldoSuficiente(conta, valorComTaxa));
    }

    @Test
    public void naoDeveLancarExcecao_QuandoSaldoForSuficiente() {
        Conta conta = new Conta();
        conta.setSaldo(100.0f);

        float valorComTaxa = 80.0f;

        assertDoesNotThrow(() -> validator.validarSaldoSuficiente(conta, valorComTaxa));
    }
}

