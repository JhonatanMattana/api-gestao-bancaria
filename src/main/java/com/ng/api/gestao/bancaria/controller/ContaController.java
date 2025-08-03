package com.ng.api.gestao.bancaria.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/conta")
public class ContaController {

    @GetMapping
    public String teste() {
        return "aplicação esta funcionando";
    }

}
