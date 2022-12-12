package br.com.JPA.entity;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
	
	@Column(name = "contrato", nullable = false)
	@Enumerated(EnumType.STRING)
	private Contratacao contrato;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "funcionario", targetEntity = ProcessosEntity.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<ProcessosEntity> processos;
	
	@OneToOne
	@JoinColumn(name = "registroid",referencedColumnName = "Id",insertable = false, updatable = false)
	private Registro objregistroid; 
	
	private Integer registroid;
	
	@Embedded
	private Contato contato;

}

