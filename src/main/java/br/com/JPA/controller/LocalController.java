package br.com.JPA.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.JPA.entity.LocalEntity;
import br.com.JPA.repository.LocalRepository;
import br.com.JPA.service.LocaisService;

@RestController
public class LocalController {

	@Autowired
	private LocalRepository localrepository;
	
	@Autowired
	private LocaisService localservice;
	@GetMapping("/locais")
	public List<LocalEntity> todosLocais(){
		List<LocalEntity> locais = localrepository.findAll();
		return locais;
	}
	
	@PostMapping("/locais")
	public void novoLocal(@RequestBody @Validated LocalEntity le ) {
		localrepository.save(le);
	}
	
	@DeleteMapping("/locais/{id}")
	public ResponseEntity<Optional<LocalEntity>> deletelocal(@PathVariable Integer id){
		return localrepository.findById(id).map(local -> ResponseEntity.status(HttpStatus.OK).body(localservice.deleteid(id)))
				.orElse(ResponseEntity.notFound().build());
		
	}
	
	@PutMapping("/local")
	public ResponseEntity<LocalEntity> alteralocal(@RequestBody LocalEntity le){
		return localservice.alteraid(le).map(local -> ResponseEntity.status(HttpStatus.OK).body(local))
				.orElse(ResponseEntity.notFound().build());
	}
	
}
