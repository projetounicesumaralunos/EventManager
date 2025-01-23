package br.com.gestao_eventos.gestao_eventos.modules.evento.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gestao_eventos.gestao_eventos.modules.evento.EventoEntity;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/evento")
public class EventoController {
      @PostMapping("/")
      public void create(@Valid @RequestBody EventoEntity eventoEntity) {
            System.out.println("evento");
      }
}
