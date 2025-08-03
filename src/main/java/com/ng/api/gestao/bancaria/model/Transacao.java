package com.ng.api.gestao.bancaria.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "TRANSACAO")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode( of = "id" )
public class Transacao {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "ID_CONTA", foreignKey = @ForeignKey(name = "FkTransacao_Conta"))
    private Conta conta;

    @Column(name = "VALOR", columnDefinition = "DECIMAL(10,2)")
    private float valor;

}
