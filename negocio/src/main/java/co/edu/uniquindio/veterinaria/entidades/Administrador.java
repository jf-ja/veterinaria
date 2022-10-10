package co.edu.uniquindio.veterinaria.entidades;

import lombok.*;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.List;

@Entity
@ToString
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Administrador extends Persona implements Serializable {

    @ElementCollection
    private List<String> telefonos;

    public Administrador(Integer cedula, String nombre, String correo, String password, List<String> telefonos) {
        super(cedula, nombre, correo, password);
        this.telefonos = telefonos;
    }
}
