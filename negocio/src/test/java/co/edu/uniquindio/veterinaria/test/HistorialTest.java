package co.edu.uniquindio.veterinaria.test;

import co.edu.uniquindio.veterinaria.entidades.Compra;
import co.edu.uniquindio.veterinaria.entidades.Historial;
import co.edu.uniquindio.veterinaria.repo.HistorialRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class HistorialTest {
    @Autowired
    private HistorialRepo historialRepo;

    @Test
    @Sql("classpath:dataset.sql" )
    public void registrar(){

        Historial historial = new Historial();

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
    }}
