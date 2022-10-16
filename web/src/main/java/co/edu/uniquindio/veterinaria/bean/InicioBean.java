package co.edu.uniquindio.veterinaria.bean;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.faces.view.ViewScoped;
import java.io.Serializable;

@Component
@ViewScoped
@Getter
@Setter
public class InicioBean implements Serializable {

    String mensaje = "Pagina para la veterinaria";
}
