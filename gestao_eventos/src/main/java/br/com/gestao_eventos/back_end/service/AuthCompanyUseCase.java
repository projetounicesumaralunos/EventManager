package br.com.gestao_eventos.back_end.service;

import javax.naming.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import br.com.gestao_eventos.back_end.dto.AuthCompanyDTO;
import br.com.gestao_eventos.back_end.repository.CompanyRepository;

@Service
public class AuthCompanyUseCase {

    // @Value("${security.token.secret}")
    // private String secretKey;
    
    @Autowired
    private CompanyRepository companyRepository;
    
    @Autowired
    private PasswordEncoder passwordEncoder;

    public void execute(AuthCompanyDTO authCompanyDTO) throws AuthenticationException {
        var company = this.companyRepository.findByCnpj(authCompanyDTO.getCnpj()).orElseThrow(
            () -> {
                throw new UsernameNotFoundException("Cnpj não encontrado");
            });

        var passwordMatches = this.passwordEncoder.matches(authCompanyDTO.getPassword(), company.getPassword());

        if(!passwordMatches){
            throw new AuthenticationException();
        }

        Algorithm algorithm = Algorithm.HMAC256("");
        JWT.create().withIssuer("eventmanager")
        .withSubject(company.getId().toString());

    }
}
