package br.com.gestao_eventos.gestao_eventos.modules.cliente.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gestao_eventos.gestao_eventos.exceptions.UserFoundException;
import br.com.gestao_eventos.gestao_eventos.modules.cliente.entities.ClientEntity;
import br.com.gestao_eventos.gestao_eventos.modules.cliente.repositories.ClientRepository;

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
