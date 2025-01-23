package br.com.gestao_eventos.gestao_eventos.modules.empresa.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gestao_eventos.gestao_eventos.modules.empresa.entities.EventEntity;
import br.com.gestao_eventos.gestao_eventos.modules.empresa.repositories.EventRepository;

@Service
public class CreateEventUseCase {
    
    @Autowired
    private EventRepository eventRepository;

    public EventEntity execute(EventEntity eventEntity){
        return this.eventRepository.save(eventEntity);
    }
}
