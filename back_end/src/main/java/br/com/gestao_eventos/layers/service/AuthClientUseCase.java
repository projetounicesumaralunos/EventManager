package br.com.gestao_eventos.layers.service;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import br.com.gestao_eventos.layers.dto.AuthClientRequestDTO;
import br.com.gestao_eventos.layers.dto.AuthClientResponseDTO;
import br.com.gestao_eventos.layers.exceptions.UserFoundException;
import br.com.gestao_eventos.layers.repositories.ClientRepository;

@Service
public class AuthClientUseCase {

    @Value("${security.token.secret.client}")
    private String secretKey;
    
    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public AuthClientResponseDTO execute(AuthClientRequestDTO AuthClientRequestDTO) {
        var client = this.clientRepository.findByEmail(AuthClientRequestDTO.email())
            .orElseThrow(() -> {
                throw new UsernameNotFoundException("Email/password incorrect");
            });

        var passwordMatches = this.passwordEncoder.matches(AuthClientRequestDTO.password(), client.getPassword());

        if(!passwordMatches){
            throw new UsernameNotFoundException("Email/password incorrect");
        }

        Algorithm algorithm = Algorithm.HMAC256(secretKey);
        var token = JWT.create()
        .withIssuer("Techmdl")
        .withSubject(client.getId().toString())
        .withExpiresAt(Instant.now().plus(Duration.ofMinutes(10)))
        .withClaim("roles", Arrays.asList("client"))
        .sign(algorithm);

        var authClientResponse = AuthClientResponseDTO.builder()
        .access_token(token)
        .build();

        return authClientResponse;
    }
}
