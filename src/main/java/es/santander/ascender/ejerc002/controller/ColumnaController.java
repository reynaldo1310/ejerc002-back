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

import es.santander.ascender.ejerc002.model.Columna;
import es.santander.ascender.ejerc002.service.ColumnaService;

@RestController
@RequestMapping("/api/columnas")
public class ColumnaController {
   @Autowired
    private ColumnaService columnaService;

    @GetMapping
    public List<Columna> getAllColumnas() {
        return columnaService.findAll();
    }

    @GetMapping("/{id}")
    public Columna getColumnaById(@PathVariable Long id) {
        return columnaService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Columna createColumna(@RequestBody Columna columna) {
        return columnaService.save(columna);
    }

    @PutMapping("/{id}")
    public Columna updateColumna(@PathVariable Long id, @RequestBody Columna columna) {
        columna.setId(id); // Asegura que el ID es el que se quiere actualizar
        return columnaService.save(columna);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteColumna(@PathVariable Long id) {
        columnaService.deleteById(id);
    }
}
