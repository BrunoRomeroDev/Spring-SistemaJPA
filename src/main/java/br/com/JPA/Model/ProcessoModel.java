package br.com.JPA.Model;

import br.com.JPA.entity.ProcessosEntity;
import lombok.Data;

@Data
public class ProcessoModel {
	
	
	private Integer id;	
	private Integer numero_processo;
	private String descricao;
	private String conteudo_processo;
	private Integer origem_tramitacao;	
	private Integer destino_tramitacao;
	private FuncionarioModel funcionario;
	
	public ProcessoModel() {
		
	}
	
	public ProcessoModel(ProcessosEntity pe) {
		this.id = pe.getId();
		this.numero_processo = pe.getNumero_processo();
		this.descricao = pe.getDescricao();
		this.conteudo_processo = pe.getConteudo_processo();
		this.origem_tramitacao = pe.getOrigem_tramitacao();
		this.destino_tramitacao = pe.getDestino_tramitacao();
		
	}
	
	public ProcessoModel(ProcessosEntity pe, FuncionarioModel fe) {
		this.id = pe.getId();
		this.numero_processo = pe.getNumero_processo();
		this.descricao = pe.getDescricao();
		this.conteudo_processo = pe.getConteudo_processo();
		this.origem_tramitacao = pe.getOrigem_tramitacao();
		this.destino_tramitacao = pe.getDestino_tramitacao();
		
		this.funcionario = fe;
		
	}

}
