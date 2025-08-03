package com.ng.api.gestao.bancaria.dto;

import com.ng.api.gestao.bancaria.enums.FormaPagamento;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TransacaoDto {
    private Integer numero_conta;
    private float valor;
    private float saldo;
    private FormaPagamento forma_pagamento;
}
