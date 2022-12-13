package br.com.JPA.entity;

import lombok.Data;

@Data
public class FuncionarioUpdate {

	private Integer id;
	private String cpf;
	private String rg;
	private String nomecompleto;
	private String nome;
	private Contato contato;
	private Contratacao contrato;
	
}
