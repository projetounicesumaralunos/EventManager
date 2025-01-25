package br.com.gestao_eventos.layers.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthCompanyDTO {

    private String password;
    private String cnpj;
    private String email;
    
    
}
