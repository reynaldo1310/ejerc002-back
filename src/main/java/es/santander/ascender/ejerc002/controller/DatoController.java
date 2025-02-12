package es.santander.ascender.ejerc002.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import es.santander.ascender.ejerc002.model.Dato;
import es.santander.ascender.ejerc002.service.DatoService;

@RestController
@RequestMapping("/api/datos")
public class DatoController {

     @Autowired
    private DatoService datoService;

    @GetMapping
    public List<Dato> getAllDatos() {
        return datoService.findAll();
    }

    @GetMapping("/{id}")
    public Dato getDatoById(@PathVariable Long id) {
        return datoService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Dato createDato(@RequestBody Dato dato) {
        return datoService.save(dato);
    }

    @PutMapping("/{id}")
    public Dato updateDato(@PathVariable Long id, @RequestBody Dato dato) {
        dato.setId(id); // Asegura que el ID es el que se quiere actualizar
        return datoService.save(dato);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteDato(@PathVariable Long id) {
        datoService.deleteById(id);
    }
}
