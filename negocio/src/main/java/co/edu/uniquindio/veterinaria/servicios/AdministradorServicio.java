package co.edu.uniquindio.veterinaria.servicios;

import co.edu.uniquindio.veterinaria.entidades.Producto;
import org.springframework.stereotype.Service;

import java.util.List;


public interface AdministradorServicio {

    public Producto crearProducto(Producto producto) throws Exception;

    public Producto actualizarProducto(Producto producto) throws Exception;

    public void eliminarProducto(Integer codigo) throws Exception;

    public List<Producto> listarProducto();
}
