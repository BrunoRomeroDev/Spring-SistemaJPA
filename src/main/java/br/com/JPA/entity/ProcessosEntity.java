package br.com.JPA.entity;




import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "tb_processos")
public class ProcessosEntity {
	
	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private Integer numero_processo;
	@Size(max=255)
	private String descricao;
	@Size(max=255)
	private String conteudo_processo;

	private Integer origem_tramitacao;
	
	private Integer destino_tramitacao;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "id_funcionario_tramitacao", insertable = false,updatable = false)
	private FuncionarioEntity funcionario;
	
	@JsonIgnore
	private Integer id_funcionario_tramitacao;
	

}
