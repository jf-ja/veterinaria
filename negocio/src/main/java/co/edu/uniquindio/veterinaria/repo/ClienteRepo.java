package co.edu.uniquindio.veterinaria.repo;

import co.edu.uniquindio.veterinaria.entidades.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepo extends JpaRepository<Cliente,Integer> {

    @Query("select cli from Cliente cli where cli.correo = :correo")
    Optional<Cliente> findByCorreo(String correo);
}
