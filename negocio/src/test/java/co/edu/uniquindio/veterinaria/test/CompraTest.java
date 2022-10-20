package co.edu.uniquindio.veterinaria.test;

import co.edu.uniquindio.veterinaria.entidades.Cliente;
import co.edu.uniquindio.veterinaria.entidades.Compra;
import co.edu.uniquindio.veterinaria.repo.CompraRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.ArrayList;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CompraTest {
    @Autowired
    private CompraRepo compraRepo;

    @Test
    @Sql("classpath:dataset.sql" )
    public void registrar(){

        Compra compra = new Compra();

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
