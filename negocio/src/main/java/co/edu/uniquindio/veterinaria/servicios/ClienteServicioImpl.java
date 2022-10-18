package co.edu.uniquindio.veterinaria.servicios;

import co.edu.uniquindio.veterinaria.entidades.Cliente;
import co.edu.uniquindio.veterinaria.repo.ClienteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServicioImpl implements ClienteServicio{

    @Autowired
    private ClienteRepo clienteRepo;

    public ClienteServicioImpl(ClienteRepo clienteRepo) {
        this.clienteRepo = clienteRepo;
    }

    @Override
    public Cliente registrarCliente(Cliente cliente) throws Exception {

            boolean correoExiste = esRepetido(cliente.getCorreo());
            if(correoExiste){
                throw new Exception("El Correo ya esta en Uso");
            }
            return clienteRepo.save(cliente);
    }
    private boolean esRepetido(String correo){
        return clienteRepo.findByCorreo(correo).orElse(null) != null;
    }

    @Override
    public List<Cliente> listarClientes() {
        return clienteRepo.findAll();
    }

}
