package es.santander.ascender.ejerc002.repository;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import es.santander.ascender.ejerc002.model.Columna;

@SpringBootTest
public class ColumnaArquitectonicaRepositoryTest {

    @Autowired
    private ColumnaArquitectonicaRepository repository;

    @Test
    public void testCreate(){
        Columna columnaArquitectonica = new Columna();
        columnaArquitectonica.setA2(5l);

        repository.save(columnaArquitectonica);


        assertTrue(
            repository.
                findById(columnaArquitectonica.getId())
                .isPresent());
    }

}
