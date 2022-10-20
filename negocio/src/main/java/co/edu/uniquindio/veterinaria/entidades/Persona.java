package co.edu.uniquindio.veterinaria.entidades;

import lombok.*;

import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@MappedSuperclass
@ToString
@Getter
@Setter
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Persona implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    private String codigo;

    private String nombre;

    private String email;

    private String password;

    public Persona(String cedula, String nombre, String correo, String password) {
        this.codigo = cedula;
        this.nombre = nombre;
        this.email = correo;
        this.password = password;
    }
}
