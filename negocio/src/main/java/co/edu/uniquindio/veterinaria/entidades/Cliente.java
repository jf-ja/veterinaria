package co.edu.uniquindio.veterinaria.entidades;

import lombok.*;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.List;

@Entity
@ToString
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Cliente extends Persona implements Serializable {

    @ElementCollection
    private List<String> telefonos;
    @ToString.Exclude
    @OneToMany(mappedBy = "cliente")
    private List<Pqrs> pqrsList ;

    @ToString.Exclude
    @OneToMany(mappedBy = "cliente")
    private List<Mascota> mascotas ;

    @ToString.Exclude
    @OneToMany(mappedBy = "cliente")
    private List<Compra> compras;

    public Cliente(Integer cedula, String nombre, String correo, String password, List<String> telefonos) {
        super(cedula, nombre, correo, password);
        this.telefonos = telefonos;
    }
}
