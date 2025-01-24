package br.com.gestao_eventos.gestao_eventos.security;

import org.hibernate.validator.constraints.br.CNPJ;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
public class SecurityConfig {
    
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http)throws Exception
    {
        http.csrf(csrf -> csrf.disable())
        .authorizeHttpRequests(auth -> {
            auth
            .requestMatchers("/client/").permitAll()
            .requestMatchers("/company/").permitAll();
            auth.anyRequest().authenticated();
            
        })        
        ;
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
