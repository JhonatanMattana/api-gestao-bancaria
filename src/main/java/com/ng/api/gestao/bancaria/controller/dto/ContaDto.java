package com.ng.api.gestao.bancaria.controller.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode( of = "numero_conta")
public class ContaDto {
    @NotNull(message = "Obrigatório informar o número da Conta")
    Integer numero_conta;
    @NotNull(message = "Obrigatório informar o Saldo da Conta")
    float saldo;
}
