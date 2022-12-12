package br.com.JPA.entity;




import java.util.Date;
import java.util.Random;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
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
	@Lob
	private String conteudo_processo;
	private Integer origem_tramitacao;	
	private Integer destino_tramitacao;	
	@Temporal(TemporalType.DATE)
	@Column(name = "dataprocesso")
	public Date data;	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "id_funcionario_tramitacao", insertable = false,updatable = false)
	private FuncionarioEntity funcionario;	
	private Integer id_funcionario_tramitacao;
	@Transient
	private Random  codigohash = new Random();
	@JsonIgnore
	private Date dataalteracao = new Date(); 
	
	

}
