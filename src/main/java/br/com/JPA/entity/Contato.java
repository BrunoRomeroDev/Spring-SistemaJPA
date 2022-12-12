package br.com.JPA.entity;

import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class Contato {

	private String email;
	private Integer telefone;
	
}
