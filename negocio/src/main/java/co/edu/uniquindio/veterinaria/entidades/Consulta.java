package co.edu.uniquindio.veterinaria.entidades;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@ToString
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Consulta implements Serializable {

    @Id
    private Integer codigo;

    private String tipo_consulta;

    private LocalDateTime fecha;

    private String descripcion;

    private double precio;

    private MetodoPago metodoPago;

    @ToString.Exclude
    @ManyToOne
    private Historial historial;

    @ToString.Exclude
    @ManyToOne
    private Empleado empleado;

    public Consulta(Integer codigo, String tipo_consulta, LocalDateTime fecha, String descripcion, double precio, MetodoPago metodoPago) {
        this.codigo = codigo;
        this.tipo_consulta = tipo_consulta;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.precio = precio;
        this.metodoPago = metodoPago;
    }
}
