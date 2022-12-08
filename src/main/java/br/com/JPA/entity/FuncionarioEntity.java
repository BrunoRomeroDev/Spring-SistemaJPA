package br.com.JPA.entity;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode
@Table(name = "tb_funcionario")
public class FuncionarioEntity {
	
	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotBlank
	@Size(max=20)
	private String nome;
	@Size(max=100)
	@Column(name = "nome_completo")
	private String nomeCompleto;
	@NotBlank
	private String cpf;
	@NotBlank
	private String rg;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "funcionario", targetEntity = ProcessosEntity.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<ProcessosEntity> processos;

}

