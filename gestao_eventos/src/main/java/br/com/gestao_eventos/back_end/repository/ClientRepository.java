package br.com.gestao_eventos.back_end.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gestao_eventos.back_end.domain.ClientEntity;

public interface ClientRepository extends JpaRepository<ClientEntity, UUID> {
    Optional<ClientEntity> findByCpfOrEmail(String cpf, String email);
}
