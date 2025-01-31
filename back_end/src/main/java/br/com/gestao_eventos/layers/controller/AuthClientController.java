package br.com.gestao_eventos.layers.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gestao_eventos.layers.dto.AuthClientRequestDTO;
import br.com.gestao_eventos.layers.service.AuthClientUseCase;

@RestController
@RequestMapping("/auth")
public class AuthClientController {
    
    @Autowired
    private AuthClientUseCase  authClientUseCase;
    
    @PostMapping("/client")
    public ResponseEntity<Object> auth(@RequestBody AuthClientRequestDTO authClientRequestDTO){

        try {

            var token = this.authClientUseCase.execute(authClientRequestDTO);
            return ResponseEntity.ok().body(token);
            
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage()); 
        }
    }
}
