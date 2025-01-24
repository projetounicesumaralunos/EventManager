package br.com.gestao_eventos.back_end.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gestao_eventos.back_end.domain.EventEntity;

public interface EventRepository extends JpaRepository<EventEntity, UUID>{
    
}
