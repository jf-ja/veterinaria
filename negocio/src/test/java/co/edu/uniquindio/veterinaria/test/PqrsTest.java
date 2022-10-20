package co.edu.uniquindio.veterinaria.test;

import co.edu.uniquindio.veterinaria.entidades.Compra;
import co.edu.uniquindio.veterinaria.entidades.Pqrs;
import co.edu.uniquindio.veterinaria.repo.PqrsRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class PqrsTest {
    @Autowired
    private PqrsRepo pqrsRepo;

    @Test
    @Sql("classpath:dataset.sql" )
    public void registrar(){
       Pqrs pqrs = new Pqrs();
    }

    @Test
    @Sql("classpath:dataset.sql" )
    public void obtener(){}
}
