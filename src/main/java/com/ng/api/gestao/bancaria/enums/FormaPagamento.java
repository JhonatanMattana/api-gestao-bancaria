package com.ng.api.gestao.bancaria.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

public enum FormaPagamento {
    PIX("P", "PIX"),
    CARTAO_CREDITO("C", "Cartão de Crédito"),
    CARTAO_DEBITO("D", "Cartão de Débito");

    private String codigo;
    @Getter
    private String descricao;

    FormaPagamento(String codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    @JsonValue
    public String getCodigo() {
        return codigo;
    }

    @JsonCreator
    public static FormaPagamento fromCodigo(String codigo) {
        for (FormaPagamento forma : FormaPagamento.values()) {
            if (forma.codigo.equalsIgnoreCase(codigo)) {
                return forma;
            }
        }
        throw new IllegalArgumentException("Forma de pagamento inválida: " + codigo);
    }
}
