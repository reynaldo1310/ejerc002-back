package es.santander.ascender.ejerc002.repository;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.ListPagingAndSortingRepository;

import es.santander.ascender.ejerc002.model.ColumnaArquitectonica;

public interface ColumnaArquitectonicaRepository extends ListCrudRepository<ColumnaArquitectonica, Long>, ListPagingAndSortingRepository<ColumnaArquitectonica, Long> {

}
