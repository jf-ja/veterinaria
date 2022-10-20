package co.edu.uniquindio.veterinaria.test;

import co.edu.uniquindio.veterinaria.repo.PqrsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class PqrsTest {
    @Autowired
    private PqrsRepo pqrsRepo;
}
