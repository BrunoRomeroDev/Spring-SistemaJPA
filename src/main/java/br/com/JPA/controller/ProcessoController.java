package br.com.JPA.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.JPA.entity.ProcessosEntity;
import br.com.JPA.repository.ProcessosRepository;
import br.com.JPA.service.ProcessosService;


@RestController
public class ProcessoController {
	
	@Autowired
	private ProcessosRepository processorepository;
	@Autowired
	private ProcessosService processosservice;
	
	@GetMapping("/api/processos")
	public List<ProcessosEntity> listarProcessos(){
		return processorepository.findAll();
	}
	
	@GetMapping("/api/processos/{id}")
	public ResponseEntity<ProcessosEntity> processoId(@PathVariable Integer id){
		return processorepository.findById(id).map(processo -> ResponseEntity.ok(processo))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping("/api/processos")
	public ResponseEntity<ProcessosEntity> novoProcesso(@RequestBody ProcessosEntity pe) {
		if(processorepository.save(pe) == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ProcessosEntity() );
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(pe);
	}

	@DeleteMapping("/api/processos/{id}")
	public ResponseEntity<ProcessosEntity> deleteprocessoid(@PathVariable Integer id){
		return processorepository.findById(id)
				.map(proc -> ResponseEntity.status(HttpStatus.OK)
						.body(processosservice.deleteid(id))).orElse(ResponseEntity.notFound().build());
	}
	
	@PutMapping("/api/processos")
	public ResponseEntity<ProcessosEntity> atualizaprocesso(@RequestBody ProcessosEntity pe){
		return processorepository.findById(pe.getId())
				.map(proc -> ResponseEntity.status(HttpStatus.OK).body(processosservice.atualizaid(proc.getId(),proc)))
				.orElse(ResponseEntity.notFound().build());
	}
		
}
