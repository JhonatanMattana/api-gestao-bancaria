package com.ng.api.gestao.bancaria.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

public class GestaoBancariaException extends RuntimeException {

    private static final long serialVersionUID = -919613333877425950L;

    @Getter
    private HttpStatus httpStatus;

    public GestaoBancariaException(String mensagem) {
        super(mensagem);
        this.httpStatus = HttpStatus.NOT_FOUND;
    }
}
