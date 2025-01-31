package br.com.gestao_eventos.layers.dto;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProfileClientResponseDTO {
    
    private String name;
    private String cpf;
    private String email;
    private String phone;
    private UUID id;
    
}
