package br.com.gestao_eventos.layers.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.gestao_eventos.layers.domain.ClientEntity;
import br.com.gestao_eventos.layers.exceptions.UserFoundException;
import br.com.gestao_eventos.layers.repositories.ClientRepository;

@Service
public class CreateClientUseCase {
    
    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public ClientEntity execute(ClientEntity clientEntity) {
        this.clientRepository.findByCpfOrEmail(clientEntity.getCpf(), clientEntity.getEmail())
                .ifPresent((user) -> {
                    throw new UserFoundException();
                });

        var password = passwordEncoder.encode(clientEntity.getPassword());  
        clientEntity.setPassword(password);

        return this.clientRepository.save(clientEntity);
    }

}
