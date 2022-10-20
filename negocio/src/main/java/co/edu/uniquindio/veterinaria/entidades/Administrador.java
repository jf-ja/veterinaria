package co.edu.uniquindio.veterinaria.entidades;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.List;

@Entity
@ToString
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Administrador extends Persona implements Serializable {
    //Indica que este es la llave primaria


    public Administrador(String cedula, String nombre, String correo, String password) {
        super(cedula, nombre, correo, password);


    }
}
