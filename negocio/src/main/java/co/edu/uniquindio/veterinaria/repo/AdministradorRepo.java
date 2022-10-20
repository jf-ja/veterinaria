package co.edu.uniquindio.veterinaria.repo;

import co.edu.uniquindio.veterinaria.entidades.Administrador;
import co.edu.uniquindio.veterinaria.entidades.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AdministradorRepo extends JpaRepository<Administrador,Integer> {

    //Busca una lista de Usuarios por nombre, y nos devuelve un listado de los que contengan ese nombre
    List<Cliente> findAllByNombreContains(String nombre);


    // METODO PARA HACER EN EL NUEVO MODULO
    //@Override
    //public Usuario login(String email, String password) throws Exception {
    //    return usuarioRepo.finByEmailAndPassword(email,password).orElseThrow( ()-> new Exception("Los datos de autenticacion son incorrectos"));
    //}

    //Loguearse
    Optional<Administrador> findByEmailAndPassword(String email, String clave);
//    Page<Administrador> findAll(Pageable paginador);
}
