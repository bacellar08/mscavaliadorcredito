package io.github.bacellar08.msavaliadorcredito.webclient;

import io.github.bacellar08.msavaliadorcredito.model.DadosCliente;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "msclients", path = "/clients")
public interface DadosClienteWebClient {

    @GetMapping(params = "cpf")
    ResponseEntity<DadosCliente> getClientByCPF(@RequestParam("cpf") String cpf);
}
