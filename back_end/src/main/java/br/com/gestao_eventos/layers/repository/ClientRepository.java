package br.com.gestao_eventos.layers.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gestao_eventos.layers.domain.ClientEntity;

public interface ClientRepository extends JpaRepository<ClientEntity, UUID> {
    Optional<ClientEntity> findByCpfOrEmail(String cpf, String email);
}
