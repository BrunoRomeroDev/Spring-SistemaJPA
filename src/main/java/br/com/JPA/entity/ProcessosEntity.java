package br.com.JPA.entity;




import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
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
	
	private Integer id_funcionario_tramitacao;
	

}
