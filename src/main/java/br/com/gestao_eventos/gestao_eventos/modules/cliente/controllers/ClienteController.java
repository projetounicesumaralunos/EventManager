package br.com.gestao_eventos.gestao_eventos.modules.cliente.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gestao_eventos.gestao_eventos.modules.cliente.ClienteEntity;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
    
    @PostMapping("/")
    public void create(@Valid @RequestBody ClienteEntity clienteEntity){
        System.out.println("cliente");
        System.out.println(clienteEntity.getEmail());
    }
}
