package br.com.gestao_eventos.layers.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.gestao_eventos.layers.domain.ClientEntity;
import br.com.gestao_eventos.layers.dto.ProfileClientResponseDTO;
import br.com.gestao_eventos.layers.repositories.ClientRepository;

@Service
public class ProfileClientUseCase {
    
    @Autowired
    private ClientRepository clientRepository;

    public ClientEntity execute(UUID idClient) {
        var client = this.clientRepository.findById(idClient)
        .orElseThrow(() -> {
            throw new UsernameNotFoundException("User not found");
        });
        var clientDTO = ProfileClientResponseDTO.builder()
        .name(client.getName())
        .cpf(client.getCpf())
        .email(client.getEmail())
        .phone(client.getPhone())
        .id(client.getId())
        .build();
        return client;
    }
}
