package com.ng.api.gestao.bancaria.factory.calculartaxa.com.ng.gestao.bancaria.api.calculataxa;

public class CalcularTaxaTransacaoDebito implements ICalcularTaxaTransacao {

    @Override
    public float calcular(float valor) {
        float percentualTaxa = 0.03f;
        return valor + (valor * percentualTaxa);
    }
}
