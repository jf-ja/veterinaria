package co.edu.uniquindio.veterinaria.test;

import co.edu.uniquindio.veterinaria.entidades.Cliente;
import co.edu.uniquindio.veterinaria.repo.ClienteRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.ArrayList;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ClienteTest {
    @Autowired
    private ClienteRepo clienteRepo;

    @Test
    @Sql("classpath:dataset.sql" )
    public void registrar(){
        ArrayList<String> telefonos = new ArrayList<>();
        telefonos.add("310238212");
        Cliente cliente = new Cliente();

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
