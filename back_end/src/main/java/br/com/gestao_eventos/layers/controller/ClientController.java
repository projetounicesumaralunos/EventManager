package br.com.gestao_eventos.layers.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gestao_eventos.layers.domain.ClientEntity;
import br.com.gestao_eventos.layers.service.CreateClientUseCase;
import br.com.gestao_eventos.layers.service.ProfileClientUseCase;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private CreateClientUseCase createClientUseCase;

    @Autowired
    private ProfileClientUseCase profileClientUseCase;

    @PostMapping("/")
    public ResponseEntity<Object> create(@Valid @RequestBody ClientEntity clientEntity) {
        try {
            var result = this.createClientUseCase.execute(clientEntity);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/")
    public ResponseEntity<Object> get(HttpServletRequest request) {

        var idClient = request.getAttribute("client_id");
        try {
            var profile = this.profileClientUseCase.execute(UUID.fromString(idClient.toString()));
            return ResponseEntity.ok().body(profile);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage()); 
        }
    }
}
