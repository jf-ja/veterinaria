package co.edu.uniquindio.veterinaria.servicios;

import co.edu.uniquindio.veterinaria.entidades.Cliente;

import java.util.List;

public interface ClienteServicio {

    public Cliente registrarCliente(Cliente cliente) throws Exception;

    public List<Cliente> listarClientes();
}
