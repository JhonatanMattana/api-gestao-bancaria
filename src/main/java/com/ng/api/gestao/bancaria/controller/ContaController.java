package com.ng.api.gestao.bancaria.controller;

import com.ng.api.gestao.bancaria.controller.dto.ContaDto;
import com.ng.api.gestao.bancaria.service.ContaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/conta")
public class ContaController {

    private final ContaService service;

    public ContaController(ContaService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ContaDto> criarConta(@RequestBody ContaDto dto) {
        ContaDto contaCriada = this.service.criarConta(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(contaCriada);
    }

}
