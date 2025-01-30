package br.com.gestao_eventos.layers.dto;

import java.sql.Date;
import java.time.LocalDateTime;
import java.time.LocalTime;

import lombok.Data;

@Data
public class CreateEventDTO {

    private String description;
    private String eventType;
    private String buffetType;
    private String location;
    private Date date;
    private LocalTime time;
    
    
}
