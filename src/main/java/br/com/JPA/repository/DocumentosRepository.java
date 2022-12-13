package br.com.JPA.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.JPA.entity.Documentos;

@Repository
public interface DocumentosRepository extends JpaRepository<Documentos, Integer> {

}
