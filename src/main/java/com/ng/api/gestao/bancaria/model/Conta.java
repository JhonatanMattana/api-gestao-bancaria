package com.ng.api.gestao.bancaria.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "CONTA")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode( of = "id" )
public class Conta {
    public Conta(Integer numero, float saldo) {
        this.numero = numero;
        this.saldo = saldo;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "NUMERO", nullable = false)
    private Integer numero;

    @Column(name = "SALDO", nullable = false, columnDefinition = "DECIMAL(10,2)")
    private float saldo;
}
