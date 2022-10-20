package co.edu.uniquindio.veterinaria.servicios;

import co.edu.uniquindio.veterinaria.entidades.Cliente;
import co.edu.uniquindio.veterinaria.entidades.Producto;
import co.edu.uniquindio.veterinaria.repo.ClienteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServicioImpl implements ClienteServicio{

    @Autowired
    private ClienteRepo usuarioRepo;
    @Autowired
    private EmailService emailService;


    @Override
    public Cliente registrarUsuario(Cliente u) throws Exception {

        return getUsuario(u);
    }

    @Override
    public Cliente actualizarUsuario(Cliente u) throws Exception {
        return usuarioRepo.save(u);
    }

    private Cliente getUsuario(Cliente u) throws Exception {
        Optional<Cliente> buscado = usuarioRepo.findById(u.getCodigo());
        if(buscado.isPresent()){
            throw new Exception("El codigo del usuario ya existe");
        }
        buscado = buscarPorEmail(u.getEmail());
        if(buscado.isPresent()){
            throw new Exception("El email del usuario ya existe");
        }

        buscado = usuarioRepo.findByUsername(u.getUsername());
        if(buscado.isPresent()){
            throw new Exception("El username del usuario ya existe");
        }
        return usuarioRepo.save(u);
    }

    private Optional<Cliente> buscarPorEmail(String email){
        return usuarioRepo.findByEmail(email);
    }

    @Override
    public void eliminarUsuario(String codigo) throws Exception {

        Optional<Cliente> buscado = usuarioRepo.findById(codigo);
        if(buscado.isEmpty()){
            throw new Exception("El codigo del usuario no existe");
        }

        usuarioRepo.deleteById(codigo);

    }

    @Override
    public List<Cliente> listarUsuario() {

        return usuarioRepo.findAll();
    }

//    @Override
//    public List<Producto> listarFavoritos(String email) throws Exception{
//
//        Optional<Cliente> buscado = buscarPorEmail(email);
//        if(buscado.isEmpty()){
//            throw new Exception("El email del usuario no existe");
//        }
//
//        return usuarioRepo.obtenerProductosFavoritos(email);
//    }

    @Override
    public Cliente obtenerUsuario(String codigo) throws Exception {
        Optional<Cliente> buscado = usuarioRepo.findById(codigo);
        if(buscado.isEmpty()){
            throw new Exception("El usuario no existe");
        }
        return buscado.get();
    }

    @Override
    public Cliente login(String email, String password) throws Exception {

        return usuarioRepo.findByEmailAndPassword(email,password).orElseThrow( ()-> new Exception("Los datos de autenticacion son incorrectos"));


    }

    @Override
    public Cliente obtenerPorEmail(String email) throws Exception {

        return usuarioRepo.findByEmail(email).orElseThrow( ()-> new Exception("El correo ingresado no existe"));

    }

//    @Override
//    public void recuperarContrasena(Usuario usuario) {
//
//        SendEmail sendEmail = new SendEmail();
//        sendEmail.setToEmail(usuario.getEmail());
//        sendEmail.setSubject("Detalle compra");
//        sendEmail.setBody("<!DOCTYPE html>\n" +
//                "<html lang=\"en\">\n" +
//                "<head>\n" +
//                "    <meta charset=\"UTF-8\">\n" +
//                "<title> Recuperacion de contrasena </ title>\n" +
//                "</head>\n" +
//                "<body>\n" +
//                "<h2> Ingrese al siguiente enlace para recuperar la contrasena </ h2> \n" +
//                "<a href=\"http://localhost:8080/cambiarContrasena.xhtml?faces-redirect=true&amp;usuario=7777\">Enlace</a>\n" +
//                "</body>\n" +
//                "</html>");
//        sendEmail.setFrom("migue.2556242@gmail.com");
//
//        System.out.println(emailService.sendEmail(sendEmail));
//
//    }
}
