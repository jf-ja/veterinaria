package co.edu.uniquindio.veterinaria.repo;

import co.edu.uniquindio.veterinaria.entidades.Cliente;
import co.edu.uniquindio.veterinaria.entidades.Producto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClienteRepo extends JpaRepository<Cliente,String> {

    List<Cliente> findAllByNombreContains(String nombre);

    Optional<Cliente> findByEmail(String email);

    Optional<Cliente> findByEmailAndPassword(String email, String password);




    Page<Cliente> findAll(Pageable paginador);

    Optional<Cliente> findByUsername(String username);

//    @Query("select p from Usuario u , IN (u.productosFavoritos) p where u.email = :email")
//    List<Producto> obtenerProductosFavoritos(String email);

//    @Query("select new co.edu.uniquindio.proyecto.dto.UsuarioYProducto(u.email, u.nombre, p) from Usuario u left join u.productos p")
//    List<UsuarioYProducto> listarUsuariosYProductos();






//
//    @Query("Select u from Usuario u where u.email = :email and u.password = :clave")
//    Optional<Usuario> verificarAutenticacion(String email, String clave);





//    FALTA PONER productosVenta (video 7 min 39:25)
//    Traer el usuario (se trrae el email)  y los productos en venta por cada usuario
//    @Query("select u.email, p from Usuario u join u.productosVenta p")
//    List<Object[]> listarUsuariosYProductos();
}
