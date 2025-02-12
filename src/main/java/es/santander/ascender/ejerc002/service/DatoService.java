package es.santander.ascender.ejerc002.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import es.santander.ascender.ejerc002.model.Dato;
import es.santander.ascender.ejerc002.repository.DatoRepository;

@Service
public class DatoService {
    @Autowired
    private DatoRepository datoRepository;

    public List<Dato> findAll() {
        return datoRepository.findAll();
    }

    public Dato findById(Long id) {
        return datoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Dato not found"));
    }

    public Dato save(Dato dato) {
        return datoRepository.save(dato);
    }

    public void deleteById(Long id) {
        if (!datoRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Dato not found");
        }
        datoRepository.deleteById(id);
    }
}