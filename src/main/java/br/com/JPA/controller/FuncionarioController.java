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

import br.com.JPA.Exception.ExceptionExist;
import br.com.JPA.Model.FuncionarioModel;
import br.com.JPA.entity.FuncionarioContatoDTO;
import br.com.JPA.entity.FuncionarioEntity;
import br.com.JPA.entity.FuncionarioUpdate;
import br.com.JPA.repository.FuncionarioRepository;
import br.com.JPA.service.FuncionarioService;

@RestController
public class FuncionarioController {
	
	@Autowired
	private FuncionarioRepository funcionariorepository;

	@Autowired
	private FuncionarioService funcionarioservice;
	
	@GetMapping("/api/funcionarios")
	public List<FuncionarioEntity> todosFuncionarios(){
		List<FuncionarioEntity> func = funcionariorepository.findAll();
		return func;
	}
	
	@GetMapping("/api/funcionariosmodel")
	public List<FuncionarioModel> todosFuncionariosModel(){
		List<FuncionarioModel> func = funcionarioservice.convertlistfunc(funcionariorepository.findAll()) ;
		return func;
	}
	
	@GetMapping("/api/funcionarios/{id}")
	public FuncionarioEntity FuncionariosId(@PathVariable Integer id){
		FuncionarioEntity func = funcionariorepository.findById(id).get();
		return func;
	}
	
	@PostMapping("/api/funcionarios")
	public ResponseEntity<FuncionarioEntity>  novoFuncionarios(@RequestBody FuncionarioContatoDTO fcdto) throws ExceptionExist{
		Optional<FuncionarioEntity> opt = Optional.of(funcionarioservice.novofunc(fcdto.getFe(),fcdto.getCo()));
		return opt
				.map(func -> ResponseEntity.status(HttpStatus.OK).body(func))
					.orElse(ResponseEntity.status(HttpStatus.BAD_REQUEST).build());
		}
	
	@PutMapping("/api/funcionarios")
	public ResponseEntity<FuncionarioEntity>  alteraFuncionarios(@RequestBody @Validated FuncionarioEntity fe){
		return funcionarioservice.alteraid(fe)
				.map(func -> ResponseEntity.status(HttpStatus.OK).body(func))
					.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}
	
	@PutMapping("/api/funcionariosmodel")
	public ResponseEntity<FuncionarioEntity>  alteraFuncionariosmodel(@RequestBody FuncionarioUpdate fu){
		return funcionarioservice.alteraidmodel(fu)
				.map(func -> ResponseEntity.status(HttpStatus.OK).body(func))
					.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}
	
	@DeleteMapping("/api/funcionario/{id}")
	public ResponseEntity<FuncionarioEntity> deleteid(@PathVariable Integer id){
		return funcionarioservice.deleteid(id)
					.map(func -> ResponseEntity.status(HttpStatus.OK).body(func))
						.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}
}
