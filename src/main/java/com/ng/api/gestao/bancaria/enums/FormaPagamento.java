package com.ng.api.gestao.bancaria.enums;

import lombok.Getter;

public enum FormaPagamento {
    PIX("P", "PIX"),
    CARTAO_CREDITO("C", "Cartão de Crédito"),
    CARTAO_DEBITO("D", "Cartão de Débito");

    @Getter
    private String codigo;
    @Getter
    private String descricao;

    FormaPagamento(String codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }
}
