package br.com.JPA.Model;

import java.util.List;

import br.com.JPA.entity.FuncionarioEntity;
import br.com.JPA.entity.ProcessosEntity;
import lombok.Data;

@Data
public class FuncionarioModel {

	private String nome;
	private String nome_completo;
	
	List<ProcessosEntity> listproc;
	

	public FuncionarioModel(FuncionarioEntity fe) {
		this.nome = fe.getNome();
		this.nome_completo = fe.getNomeCompleto();
		this.listproc = fe.getProcessos();

	}
	
	public FuncionarioModel(FuncionarioEntity fe, List<ProcessosEntity> procs) {
		this.nome = fe.getNome();
		this.nome_completo = fe.getNomeCompleto();

	}
	
	public FuncionarioModel() {
		
	}
}
