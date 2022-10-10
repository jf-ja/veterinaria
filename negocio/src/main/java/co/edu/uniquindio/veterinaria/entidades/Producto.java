package co.edu.uniquindio.veterinaria.entidades;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.io.Serializable;
import java.util.List;

@Entity
@ToString
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Producto implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    private Integer codigo;

    private String nombre;

    private Double precio;

    private Integer unidades;

    private Categoria categoria;

    @ManyToMany(mappedBy = "productos")
    private List<Compra> compras;

    public Producto(Integer codigo, String nombre, Double precio, Integer unidades, Categoria categoria) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.unidades = unidades;
        this.categoria = categoria;
    }
}
