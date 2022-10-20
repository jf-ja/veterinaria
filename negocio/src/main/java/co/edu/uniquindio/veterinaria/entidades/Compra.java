package co.edu.uniquindio.veterinaria.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Compra implements Serializable {

    //Indica que este es la llave primaria
    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;

    // Column ayuda a definir anotaciones en los atributos. No puede ir vacia
    @Column(nullable = false)
    private LocalDate fechaCompra;

    // Column ayuda a definir anotaciones en los atributos. No puede ir vacia
    @Column(nullable = false)
    private String medioPago;

    //Aplicamos la relacion muchos a uno entre Compra y Usuario
    @ManyToOne
    private Cliente usuario;

    //Aplicamos la relacion uno a muchos entre Comentario y DetalleCompra
    @OneToMany(mappedBy = "compra",cascade = CascadeType.REMOVE)
    @ToString.Exclude
    private List<DetalleCompra> detallesCompras;
}
