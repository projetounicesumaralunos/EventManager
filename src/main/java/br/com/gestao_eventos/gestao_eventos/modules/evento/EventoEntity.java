package br.com.gestao_eventos.gestao_eventos.modules.evento;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name = "evento")
public class EventoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    // definindo tipos de eventos
    public enum EventType {
        CASAMENTO,
        ANIVERSARIO,
        NOIVADO,
        CHURRASCO,
        FESTA_FORMATURA,
        HAPPY_HOUR
    }

    private EventType[] eventCategories = { EventType.CASAMENTO, EventType.ANIVERSARIO, EventType.NOIVADO,
            EventType.CHURRASCO, EventType.FESTA_FORMATURA, EventType.HAPPY_HOUR };

    public enum BuffetType {
        CHURRASCO,
        PIZZAS,
        BEBIDAS_ALCOOLICAS,
        BEBIDAS_NAO_ALCOOLICAS,
        HAMBURGUERES,
        SUSHI,
        SORVETES,
        FRIOS,
        COMPLETO
    }

    private BuffetType[] buffetCategories = { BuffetType.CHURRASCO, BuffetType.PIZZAS, BuffetType.BEBIDAS_ALCOOLICAS,
            BuffetType.BEBIDAS_NAO_ALCOOLICAS, BuffetType.HAMBURGUERES, BuffetType.SUSHI, BuffetType.SORVETES,
            BuffetType.FRIOS, BuffetType.COMPLETO };

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;
}
