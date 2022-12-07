package br.com.JPA.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.JPA.entity.FuncionarioEntity;


public interface FuncionarioRepository extends JpaRepository<FuncionarioEntity,Integer> {

	Optional<FuncionarioEntity> findByNomeCompleto(String nome);

}
