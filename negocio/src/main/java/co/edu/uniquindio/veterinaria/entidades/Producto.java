package co.edu.uniquindio.veterinaria.entidades;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@ToString
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Producto implements Serializable {

    //Indica que este es la llave primaria
    @Id
    //Identificacion de Codigo (unica)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;

    // Column ayuda a definir anotaciones en los atributos. No puede ir vacio y Length le da tamaño al codigo
    @Column(nullable = false, length = 80)
    private String nombre;

    // Column ayuda a definir anotaciones en los atributos. No puede ir vacio
    @Column(nullable = false)
    @PositiveOrZero
    private Integer unidades;

    // Column ayuda a definir anotaciones en los atributos. No puede ir vacio
    @Lob
    @NotBlank
    @Column(nullable = false)
    private String descripcion;

    @Column(nullable = false)
    private String nombrePublicacion;

    // Column ayuda a definir anotaciones en los atributos. No puede ir vacio
    @Column(nullable = false)
    @Positive
    private Double precio;







    @ElementCollection
    // Column ayuda a definir anotaciones en los atributos. No puede ir vacio
    private List<String> imagenes ;

    @ElementCollection
    private List<Categoria> categorias;





    //Aplicamos la relacion muchos a uno entre Producto y Usuario

    @ManyToOne
    private Cliente usuario;

    //Aplicamos la relacion uno a muchos entre Producto y DetalleCompra

    @OneToMany(mappedBy = "producto" ,cascade = CascadeType.REMOVE)
    @ToString.Exclude
    private List<DetalleCompra> detalleCompras;

    //Aplicamos la relacion uno a muchos entre Comentario y Producto

    @OneToMany(mappedBy = "producto" ,cascade = CascadeType.REMOVE)
    @ToString.Exclude
    private List<Comentario> comentarios;












    public Producto( String nombre, Integer unidades, String descripcion, Double precio, LocalDate fechaLimite, Double descuento, Cliente usuario) {

        this.nombre = nombre;
        this.unidades = unidades;
        this.descripcion = descripcion;
        this.precio = precio;

        this.usuario = usuario;
    }

    public String getImagenPrincipal(){
        if(imagenes !=null && !imagenes.isEmpty()){
            return imagenes.get(0);
        }
        return "default.jfif";
    }
}
