package io.github.bacellar08.msavaliadorcredito.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class SituacaoCliente {

    private DadosCliente cliente;
    private List<CartaoCliente> cartoes;


}
