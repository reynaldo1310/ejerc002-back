package es.santander.ascender.ejerc002.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.santander.ascender.ejerc002.model.Dato;

public interface DatoRepository extends JpaRepository<Dato, Long> {

}
