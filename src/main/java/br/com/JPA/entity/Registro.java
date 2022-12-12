package br.com.JPA.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "tb_registro")
public class Registro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotBlank
	private Integer id;
	
	@OneToOne
	@JoinColumn(name = "id",referencedColumnName = "objregistroid")
	private FuncionarioEntity numero_registro;

	
}
