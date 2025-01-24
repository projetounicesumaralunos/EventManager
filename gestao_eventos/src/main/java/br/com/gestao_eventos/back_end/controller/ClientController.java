package br.com.gestao_eventos.back_end.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gestao_eventos.back_end.domain.ClientEntity;
import br.com.gestao_eventos.back_end.service.CreateClientUseCase;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private CreateClientUseCase createClientUseCase;

    @PostMapping("/")
    public ResponseEntity<Object> create(@Valid @RequestBody ClientEntity clientEntity) {
        try {
            var result = this.createClientUseCase.execute(clientEntity);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
