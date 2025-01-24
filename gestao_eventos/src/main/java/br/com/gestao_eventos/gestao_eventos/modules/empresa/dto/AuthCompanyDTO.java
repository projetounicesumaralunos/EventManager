package br.com.gestao_eventos.gestao_eventos.modules.empresa.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthCompanyDTO {

    private String password;
    private String cnpj;
    
}
