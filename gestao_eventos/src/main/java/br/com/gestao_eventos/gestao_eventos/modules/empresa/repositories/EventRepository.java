package br.com.gestao_eventos.gestao_eventos.modules.empresa.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gestao_eventos.gestao_eventos.modules.empresa.entities.EventEntity;

public interface EventRepository extends JpaRepository<EventEntity, UUID>{
    
}
