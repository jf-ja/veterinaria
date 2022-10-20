package co.edu.uniquindio.veterinaria.servicios;

import co.edu.uniquindio.veterinaria.dto.ProductoCarrito;
import co.edu.uniquindio.veterinaria.entidades.*;

import java.util.ArrayList;
import java.util.List;

public interface ProductoServicio {




    Producto publicarProducto(Producto p) throws Exception;

    void actualizarProducto(Producto producto)throws Exception;


    void eliminarProducto(Integer codigo) throws Exception;

    Producto obtenerProducto(Integer codigo) throws Exception;



    List<Producto> listarTodosProductos();

    void comentarProducto(Comentario comentario) throws Exception;



    List<Producto> listarProductos(Categoria categoria) throws Exception;

    void comentarProducto(String mensaje, Integer calificacion, Cliente usuario, Producto producto) throws Exception;






    void comprarProductos(Compra compra) throws Exception;

    List<Producto> buscarProductos(String nombreProducto, String[] filtros);

    List<Producto> listarProductos(String codigoUsuario) throws Exception;


    List<Categoria> listarCategoria();




    Integer obtenerPromedioCalificaciones(Integer codigo);

    Compra comprarProductos(Cliente usuario, ArrayList<ProductoCarrito> productos, String medioPago) throws Exception;


}
