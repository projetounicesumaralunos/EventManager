package br.com.gestao_eventos.layers.domain;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity(name = "event")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EventEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String description;

    @NotBlank(message = "O campo [eventType] não pode ser vazio")
    private String eventType;

    @NotBlank(message = "O campo [BuffetType] não pode ser vazio")
    public String buffetType;

    @NotBlank(message = "O campo [location] não pode ser vazio")
    private String location;

    @NotNull(message = "O campo [date] não pode ser vazio")
    private Date date;

    @NotNull(message = "O campo [time] não pode ser vazio")
    @JsonFormat(pattern = "HH:mm")
    private LocalTime time;

    @ManyToOne()
    @JoinColumn(name = "company_id", insertable = false, updatable = false) 
    private CompanyEntity companyEntity;

    @Column(name = "company_id")
    private UUID companyId;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

}
