package co.edu.uniquindio.veterinaria.test;

import co.edu.uniquindio.veterinaria.repo.HistorialRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class HistorialTest {
    @Autowired
    private HistorialRepo historialRepo;
}
