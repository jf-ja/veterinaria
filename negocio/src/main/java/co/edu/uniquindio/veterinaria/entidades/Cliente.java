package co.edu.uniquindio.veterinaria.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@ToString
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Cliente extends Persona implements Serializable {


    @ToString.Exclude
    @OneToMany(mappedBy = "cliente")
    private List<Pqrs> pqrsList ;

    @Column(nullable = false, unique = true)
    private String username;

    @ToString.Exclude
    @OneToMany(mappedBy = "cliente")
    private List<Mascota> mascotas ;

    //Aplicamos la relacion uno a muchos entre Usuario y Comentario

    @OneToMany(mappedBy = "usuario",cascade = CascadeType.REMOVE)
    @ToString.Exclude
    private List<Comentario> comentarios;

    @OneToMany(mappedBy = "usuario",cascade = CascadeType.REMOVE)
    @ToString.Exclude
    private List<Producto> productos;

    @ToString.Exclude
    @OneToMany(mappedBy = "usuario")
    private List<Compra> compras;

    public Cliente(String cedula, String nombre, String correo, String password, String username) {
        super(cedula, nombre, correo, password);

        this.username = username;


    }
}
