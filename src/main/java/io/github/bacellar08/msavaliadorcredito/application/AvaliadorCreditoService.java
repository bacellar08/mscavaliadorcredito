package io.github.bacellar08.msavaliadorcredito.application;

import io.github.bacellar08.msavaliadorcredito.model.CartaoCliente;
import io.github.bacellar08.msavaliadorcredito.model.DadosCliente;
import io.github.bacellar08.msavaliadorcredito.model.SituacaoCliente;
import io.github.bacellar08.msavaliadorcredito.webclient.CartaoClienteWebClient;
import io.github.bacellar08.msavaliadorcredito.webclient.DadosClienteWebClient;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AvaliadorCreditoService {

    private final DadosClienteWebClient dadosClienteWebClient;
    private final CartaoClienteWebClient cartaoClienteWebClient;

    public SituacaoCliente obterSituacaoCliente(String cpf) {

        ResponseEntity<DadosCliente> dadosClienteResponse = dadosClienteWebClient.getClientByCPF(cpf);
        ResponseEntity<List<CartaoCliente>> cartoesClienteResponse = cartaoClienteWebClient.getCartoesByCliente(cpf);

        return SituacaoCliente.builder()
                .cliente(dadosClienteResponse.getBody())
                .cartoes(cartoesClienteResponse.getBody())
                .build();

    }
}
