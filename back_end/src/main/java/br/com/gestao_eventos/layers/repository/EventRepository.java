package br.com.gestao_eventos.layers.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gestao_eventos.layers.domain.EventEntity;

public interface EventRepository extends JpaRepository<EventEntity, UUID>{
    
}
