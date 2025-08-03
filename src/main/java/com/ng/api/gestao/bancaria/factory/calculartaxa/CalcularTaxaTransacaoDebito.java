package com.ng.api.gestao.bancaria.factory.calculartaxa;

public class CalcularTaxaTransacaoDebito implements ICalcularTaxaTransacao {

    @Override
    public float calcular(float valor) {
        float percentualTaxa = 0.03f;
        return valor + (valor * percentualTaxa);
    }
}
