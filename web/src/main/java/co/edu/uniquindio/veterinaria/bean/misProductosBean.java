package co.edu.uniquindio.veterinaria.bean;

import co.edu.uniquindio.veterinaria.entidades.Cliente;
import co.edu.uniquindio.veterinaria.entidades.Producto;
import co.edu.uniquindio.veterinaria.servicios.ProductoServicio;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.List;

@Component
@ViewScoped
public class misProductosBean implements Serializable {



    @Getter
    @Setter
    private List<Producto> productos;

    @Autowired
    private ProductoServicio productoServicio;

    @PostConstruct
    public void inicializar(){

        try {
            productos= productoServicio.listarTodosProductos();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void eliminarProducto(Integer id){
        try {
            productoServicio.eliminarProducto(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public String irADetalle(String id){
        return "/detalleProducto?faces-redirect=true&amp;producto="+id;
    }
}
