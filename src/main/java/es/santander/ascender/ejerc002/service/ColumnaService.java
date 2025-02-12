package es.santander.ascender.ejerc002.service;

import es.santander.ascender.ejerc002.model.Columna;
import es.santander.ascender.ejerc002.repository.ColumnaArquitectonicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import java.util.List;

@Service
public class ColumnaService {
    @Autowired
    private ColumnaArquitectonicaRepository columnaRepository;

    public List<Columna> findAll() {
        return columnaRepository.findAll();
    }

    public Columna findById(Long id) {
        return columnaRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Columna not found"));
    }

    public Columna save(Columna columna) {
        return columnaRepository.save(columna);
    }

    public void deleteById(Long id) {
        if (!columnaRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Columna not found");
        }
        columnaRepository.deleteById(id);
    }
}



