package br.com.JPA.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.JPA.entity.LocalEntity;

@Repository
public interface LocalRepository extends JpaRepository<LocalEntity,Integer>{

}
