package com.ng.api.gestao.bancaria.factory.calculartaxa.com.ng.gestao.bancaria.api.calculataxa;

import com.ng.api.gestao.bancaria.enums.FormaPagamento;
import com.ng.api.gestao.bancaria.exception.GestaoBancariaException;

public class CalcularTaxaTransacaoFactory {
    public static ICalcularTaxaTransacao criarCalculoTaxaTransacao(FormaPagamento formaPagamento) {
        switch (formaPagamento) {
            case PIX:
                return new CalcularTaxaTransacaoPix();
            case CARTAO_DEBITO:
                return new CalcularTaxaTransacaoDebito();
            case CARTAO_CREDITO:
                return new CalcularTaxaTransacaoCredito();
            default:
                throw new GestaoBancariaException("Forma de pagamento não suportada");
        }
    }
}
