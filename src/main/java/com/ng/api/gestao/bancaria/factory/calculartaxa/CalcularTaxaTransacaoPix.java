package com.ng.api.gestao.bancaria.factory.calculartaxa;

public class CalcularTaxaTransacaoPix implements ICalcularTaxaTransacao {

    @Override
    public float calcular(float valor) {
        float percentualTaxa = 0f;
        return valor + (valor * percentualTaxa);
    }
}
