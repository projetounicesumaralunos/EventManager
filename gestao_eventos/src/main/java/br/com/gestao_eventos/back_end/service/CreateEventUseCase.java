package br.com.gestao_eventos.back_end.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gestao_eventos.back_end.domain.EventEntity;
import br.com.gestao_eventos.back_end.repository.EventRepository;

@Service
public class CreateEventUseCase {
    
    @Autowired
    private EventRepository eventRepository;

    public EventEntity execute(EventEntity eventEntity){
        return this.eventRepository.save(eventEntity);
    }
}
