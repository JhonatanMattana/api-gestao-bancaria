package com.ng.api.gestao.bancaria.factory.calculartaxa;

public class CalcularTaxaTransacaoCredito implements ICalcularTaxaTransacao {

    @Override
    public float calcular(float valor) {
        float percentualTaxa = 0.05f;
        return valor + (valor * percentualTaxa);
    }

}
