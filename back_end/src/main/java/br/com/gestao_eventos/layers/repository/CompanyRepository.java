package br.com.gestao_eventos.layers.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gestao_eventos.layers.domain.CompanyEntity;

public interface CompanyRepository extends JpaRepository<CompanyEntity, UUID>{
    Optional<CompanyEntity> findByCnpjOrEmail(String cnpj, String email);
    Optional<CompanyEntity> findByCnpj(String cnpj);
    Optional<CompanyEntity> findByEmail(String email);
    
}
    