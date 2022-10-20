package co.edu.uniquindio.veterinaria.entidades;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.io.Serializable;
import java.util.List;

@Entity
@ToString
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Historial implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    private Integer codigo;

    @ToString.Exclude
    @OneToOne
    private Mascota mascota;

    @ToString.Exclude
    @OneToMany(mappedBy = "historial")
    private List<Consulta> consultas;

    public Historial(Integer codigo) {
        this.codigo = codigo;
    }
}
