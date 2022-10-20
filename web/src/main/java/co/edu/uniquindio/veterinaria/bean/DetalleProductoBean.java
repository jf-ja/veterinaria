package co.edu.uniquindio.veterinaria.bean;

import co.edu.uniquindio.veterinaria.entidades.Cliente;
import co.edu.uniquindio.veterinaria.entidades.Comentario;
import co.edu.uniquindio.veterinaria.entidades.Producto;
import co.edu.uniquindio.veterinaria.servicios.ClienteServicio;
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
public class DetalleProductoBean implements Serializable {

    @Autowired
    private ProductoServicio productoServicio;

    @Autowired
    private ClienteServicio usuarioServicio;

    @Value("#{param['producto']}")
    private String codigoProducto;

    @Getter
    @Setter
    private Producto producto;

    @Getter @Setter
    private Comentario nuevoComentario;

    @Getter @Setter
    private Integer calificacionPromedio;

    @Getter @Setter
    private List<Comentario> comentarios;

    @Value("#{seguridadBean.usuarioSesion}")
    private Cliente usuarioSesion;

    @PostConstruct
    public void inicializar(){
        nuevoComentario= new Comentario();
        if(codigoProducto!=null && !codigoProducto.isEmpty()){
            try{
                Integer codigo = Integer.parseInt(codigoProducto);
                producto = productoServicio.obtenerProducto(codigo);
                this.comentarios = producto.getComentarios();
                calificacionPromedio = productoServicio.obtenerPromedioCalificaciones(codigo);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void crearComentario(){

        try {
            if(usuarioSesion!=null) {
                nuevoComentario.setProducto(producto);
                nuevoComentario.setUsuario(usuarioSesion);
                productoServicio.comentarProducto(nuevoComentario);
                this.comentarios.add(nuevoComentario);
                nuevoComentario = new Comentario();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}

