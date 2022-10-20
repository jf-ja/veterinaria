package co.edu.uniquindio.veterinaria.bean;

import co.edu.uniquindio.veterinaria.entidades.Producto;
import co.edu.uniquindio.veterinaria.servicios.ProductoServicio;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.List;

@Component
@ViewScoped
public class InicioBean implements Serializable {

    @Autowired
    private ProductoServicio productoServicio;

    @Getter @Setter
    private List<Producto> productos;

    @PostConstruct
    public void inicializat(){
        this.productos = productoServicio.listarTodosProductos();
    }

    public String irADetalle(String id){
        return "/detalleProducto?faces-redirect=true&amp;producto="+id;
    }
}

