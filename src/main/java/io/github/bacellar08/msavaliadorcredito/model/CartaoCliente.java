package io.github.bacellar08.msavaliadorcredito.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CartaoCliente {

    private String nome;
    private String bandeira;
    private BigDecimal limiteBasico;
}
