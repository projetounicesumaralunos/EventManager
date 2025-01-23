package br.com.gestao_eventos.gestao_eventos.modules.empresa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gestao_eventos.gestao_eventos.modules.empresa.entities.EventEntity;
import br.com.gestao_eventos.gestao_eventos.modules.empresa.useCases.CreateEventUseCase;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/event")
public class EventController {

      @Autowired
      private CreateEventUseCase createEventUseCase;

      @PostMapping("/")
      public EventEntity create(@Valid @RequestBody EventEntity eventEntity) {
            return this.createEventUseCase.execute(eventEntity);
      }
}
