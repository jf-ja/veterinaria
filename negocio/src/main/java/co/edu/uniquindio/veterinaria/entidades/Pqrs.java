package co.edu.uniquindio.veterinaria.entidades;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@ToString
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Pqrs implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    private Integer codigo;

    private String asunto;

    private String descripcion;

    private LocalDateTime fecha;

    @ManyToOne
    private Cliente cliente;

    public Pqrs(Integer codigo, String asunto, String descripcion, LocalDateTime fecha) {
        this.codigo = codigo;
        this.asunto = asunto;
        this.descripcion = descripcion;
        this.fecha = fecha;
    }

}
