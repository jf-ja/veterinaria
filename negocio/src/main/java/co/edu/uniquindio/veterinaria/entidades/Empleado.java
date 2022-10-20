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
public class Empleado extends Persona implements Serializable {



    @ToString.Exclude
    @OneToMany(mappedBy = "empleado")
    private List<Consulta> consultas;

//    @ToString.Exclude
//    @OneToMany(mappedBy = "empleado")
//    private List<Compra> compras;

    public Empleado(String cedula, String nombre, String correo, String password) {
        super(cedula, nombre, correo, password);

    }
}
