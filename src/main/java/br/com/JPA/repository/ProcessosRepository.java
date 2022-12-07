package br.com.JPA.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.JPA.entity.ProcessosEntity;

@Repository
public interface ProcessosRepository extends JpaRepository<ProcessosEntity,Integer>{

}
