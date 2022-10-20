package co.edu.uniquindio.veterinaria.bean;

import co.edu.uniquindio.veterinaria.entidades.Categoria;
import co.edu.uniquindio.veterinaria.entidades.Cliente;
import co.edu.uniquindio.veterinaria.entidades.Producto;
import co.edu.uniquindio.veterinaria.servicios.ClienteServicio;
import co.edu.uniquindio.veterinaria.servicios.ProductoServicio;
import lombok.Getter;
import lombok.Setter;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.file.UploadedFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
@ViewScoped
public class ProductoBean implements Serializable {

    @Getter
    @Setter
    private Producto producto;

    @Autowired
    private ProductoServicio productoServicio;


    @Autowired
    private ClienteServicio usuarioServicio;



    private ArrayList<String> imagenes;

    @Value("src/main/webapp/uploads")
    private String urlUploads;

    @Getter @Setter
    private List<Categoria> categorias;

    @Value("#{seguridadBean.usuarioSesion}")
    private Cliente usuarioSesion;

    @PostConstruct
    public void inicializar(){
        producto = new Producto();
        this.imagenes= new ArrayList<>();
        categorias = productoServicio.listarCategoria();


    }

    public void crearProducto(){
        try {

                if (!imagenes.isEmpty()) {

                    producto.setImagenes(imagenes);
                    productoServicio.publicarProducto(producto);

                    FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta", "Producto creado exitosamente");
                    FacesContext.getCurrentInstance().addMessage("msj-bean", msg);

                } else {
                    FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Alerta", "Es necesario subir al menos una imagen");
                    FacesContext.getCurrentInstance().addMessage("msj-bean", msg);

                }

        } catch (Exception e) {
            e.printStackTrace();
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Alerta",e.getMessage());
            FacesContext.getCurrentInstance().addMessage("msj-bean",msg);
        }

    }

    public void subirImagenes(FileUploadEvent event){
        UploadedFile imagen = event.getFile();

        String nombreImagen = subirImagen(imagen);
        if(nombreImagen!=null){
            imagenes.add(nombreImagen);
        }
    }

    public String subirImagen(UploadedFile imagen){
        try {
            File file = new File(urlUploads + "/" + imagen.getFileName());
            OutputStream outputStream = new FileOutputStream(file);
            IOUtils.copy(imagen.getInputStream(), outputStream);
            return imagen.getFileName();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }


}
