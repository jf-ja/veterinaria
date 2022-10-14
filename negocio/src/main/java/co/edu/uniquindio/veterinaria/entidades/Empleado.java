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

    @ElementCollection
    private List<String> telefonos;

    @ToString.Exclude
    @OneToMany(mappedBy = "empleado")
    private List<Consulta> consultas;

    @ToString.Exclude
    @OneToMany(mappedBy = "empleado")
    private List<Compra> compras;

    public Empleado(Integer cedula, String nombre, String correo, String password, List<String> telefonos) {
        super(cedula, nombre, correo, password);
        this.telefonos = telefonos;
    }
}
