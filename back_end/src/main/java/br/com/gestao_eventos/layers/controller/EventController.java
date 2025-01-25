package br.com.gestao_eventos.layers.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gestao_eventos.layers.domain.EventEntity;
import br.com.gestao_eventos.layers.service.CreateEventUseCase;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/event")
public class EventController {

      @Autowired
      private CreateEventUseCase createEventUseCase;

      @PostMapping("/")
      public EventEntity create(@Valid @RequestBody EventEntity eventEntity, HttpServletRequest request) {
            var company_id = request.getAttribute("company_id");
            eventEntity.setCompanyId(UUID.fromString(company_id.toString()));
            return this.createEventUseCase.execute(eventEntity);
      }
}
