package br.com.JPA.entity;


import java.util.List;


import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
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

