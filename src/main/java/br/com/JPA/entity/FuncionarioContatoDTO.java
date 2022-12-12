package br.com.JPA.entity;

import lombok.Data;

@Data
public class FuncionarioContatoDTO {
	private FuncionarioEntity fe;
	private Contato co;

}
