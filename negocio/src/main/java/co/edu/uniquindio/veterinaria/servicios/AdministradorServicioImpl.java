package co.edu.uniquindio.veterinaria.servicios;

import co.edu.uniquindio.veterinaria.entidades.Administrador;
import co.edu.uniquindio.veterinaria.entidades.Producto;
import co.edu.uniquindio.veterinaria.repo.AdministradorRepo;
import co.edu.uniquindio.veterinaria.repo.ProductoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdministradorServicioImpl implements AdministradorServicio{

    @Autowired
    private AdministradorRepo administradorRepo;

    @Override
    public Administrador logInAdmin(String codigo, String password) throws Exception {
        return administradorRepo.findByEmailAndPassword(codigo,password).orElseThrow( ()-> new Exception("Los datos de autenticacion son incorrectos"));
    }
}
