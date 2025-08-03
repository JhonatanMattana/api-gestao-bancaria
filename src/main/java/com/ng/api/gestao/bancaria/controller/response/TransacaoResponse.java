package com.ng.api.gestao.bancaria.controller.response;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.ng.api.gestao.bancaria.util.Float2CasasSerializer;

public record TransacaoResponse(Integer numero_conta, @JsonSerialize(using = Float2CasasSerializer.class) float saldo) {
}
