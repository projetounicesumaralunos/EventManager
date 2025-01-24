package br.com.gestao_eventos.gestao_eventos.modules.empresa.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.gestao_eventos.gestao_eventos.exceptions.UserFoundException;
import br.com.gestao_eventos.gestao_eventos.modules.empresa.entities.CompanyEntity;
import br.com.gestao_eventos.gestao_eventos.modules.empresa.repositories.CompanyRepository;

@Service
public class CreateCompanyUseCase {

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public CompanyEntity execute(CompanyEntity companyEntity) {
        this.companyRepository
                .findByCnpjOrEmail(companyEntity.getCnpj(), companyEntity.getEmail())
                .ifPresent(user -> {
                    throw new UserFoundException();
                });

        var password = passwordEncoder.encode(companyEntity.getPassword());
        companyEntity.setPassword(password);

        return this.companyRepository.save(companyEntity);
    }

}
