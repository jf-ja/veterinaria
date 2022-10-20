package co.edu.uniquindio.veterinaria.servicios;

import co.edu.uniquindio.veterinaria.entidades.Administrador;
import co.edu.uniquindio.veterinaria.entidades.Producto;
import org.springframework.stereotype.Service;

import java.util.List;


public interface AdministradorServicio {

    Administrador logInAdmin(String codigo, String password) throws Exception;
}
