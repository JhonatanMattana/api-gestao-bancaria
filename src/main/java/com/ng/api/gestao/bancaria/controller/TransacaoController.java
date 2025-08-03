package com.ng.api.gestao.bancaria.controller;

import com.ng.api.gestao.bancaria.controller.dto.TransacaoDto;
import com.ng.api.gestao.bancaria.controller.response.TransacaoResponse;
import com.ng.api.gestao.bancaria.service.TransacaoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transacao")
public class TransacaoController {
    private final TransacaoService service;

    public TransacaoController(TransacaoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<TransacaoResponse> criarTransacao(@RequestBody TransacaoDto dto) {
        dto = this.service.criarTransacao(dto);
        TransacaoResponse response = new TransacaoResponse(dto.getNumero_conta(), dto.getSaldo());
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
