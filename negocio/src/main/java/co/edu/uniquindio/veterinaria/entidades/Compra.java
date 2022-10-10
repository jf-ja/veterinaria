package co.edu.uniquindio.veterinaria.entidades;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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
public class Compra implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    private Integer codigo;

    private LocalDateTime fecha;

    private Double total;

    @ManyToMany
    private List<Producto> productos;

    @ManyToOne
    private Cliente cliente;

    @ManyToOne
    private Empleado empleado;

    public Compra(Integer codigo, LocalDateTime fecha, Double total) {
        this.codigo = codigo;
        this.fecha = fecha;
        this.total = total;
    }
}
