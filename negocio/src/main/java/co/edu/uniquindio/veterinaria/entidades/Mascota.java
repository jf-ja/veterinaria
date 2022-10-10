package co.edu.uniquindio.veterinaria.entidades;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.io.Serializable;

@Entity
@ToString
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Mascota implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    private Integer codigo;

    private String nombre;

    private String edad;

    private String peso;

    private String raza;

    @ManyToOne
    private Cliente cliente ;

    @OneToOne(mappedBy = "mascota")
    private Historial historial;


    public Mascota(Integer codigo, String nombre, String edad, String peso, String raza) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.edad = edad;
        this.peso = peso;
        this.raza = raza;
    }
}
