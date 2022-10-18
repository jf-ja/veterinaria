package co.edu.uniquindio.veterinaria.repo;

import co.edu.uniquindio.veterinaria.entidades.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepo extends JpaRepository<Producto,Integer> {
    @Query("select prod from Producto prod where prod.nombre = :nombre")
    Producto obtenerProductoPorNombre(String nombre);

}
