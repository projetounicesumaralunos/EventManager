package br.com.gestao_eventos.layers.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gestao_eventos.layers.domain.ClientEntity;
import br.com.gestao_eventos.layers.exceptions.UserFoundException;
import br.com.gestao_eventos.layers.repository.ClientRepository;

@Service
public class CreateClientUseCase {
    @Autowired
    private ClientRepository clientRepository;

    public ClientEntity execute(ClientEntity clientEntity) {
        this.clientRepository.findByCpfOrEmail(clientEntity.getCpf(), clientEntity.getEmail())
                .ifPresent((user) -> {
                    throw new UserFoundException();
                });
        return this.clientRepository.save(clientEntity);
    }

}
