package com.ng.api.gestao.bancaria.factory.calculartaxa.com.ng.gestao.bancaria.api.calculataxa;

public class CalcularTaxaTransacaoPix implements ICalcularTaxaTransacao {

    @Override
    public float calcular(float valor) {
        float percentualTaxa = 0f;
        return valor + (valor * percentualTaxa);
    }
}
