package co.edu.uniquindio.veterinaria.test;

import co.edu.uniquindio.veterinaria.entidades.Administrador;
import co.edu.uniquindio.veterinaria.entidades.Cliente;
import co.edu.uniquindio.veterinaria.repo.AdministradorRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.ArrayList;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class AdministradorTest {
    @Autowired
    private AdministradorRepo administradorRepo;

    @Test
    @Sql("classpath:dataset.sql" )
    public void registrar(){
        ArrayList<String>telefonos = new ArrayList<>();
        telefonos.add("310238212");
        Administrador administrador = new Administrador();


    }
    @Test
    @Sql("classpath:dataset.sql" )
    public void eliminar(){

    }
    @Test
    @Sql("classpath:dataset.sql" )
    public void actualizar(){

    }
    @Test
    @Sql("classpath:dataset.sql" )
    public void obtener(){

    }









}
