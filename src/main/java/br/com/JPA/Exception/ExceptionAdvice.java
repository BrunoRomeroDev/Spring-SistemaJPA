package br.com.JPA.Exception;

import java.sql.SQLIntegrityConstraintViolationException;
import java.time.OffsetDateTime;
import java.util.NoSuchElementException;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;



@ControllerAdvice
public class ExceptionAdvice extends ResponseEntityExceptionHandler {
	
		
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<ExceptionPadrao> argumentoInvalido(){
		ExceptionPadrao ed = new ExceptionPadrao("Argumento Inválido",OffsetDateTime.now());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ed);

	}
	
	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	public ResponseEntity<ExceptionPadrao> argumentoInvalidox(){
		ExceptionPadrao ed = new ExceptionPadrao("Tipo do Argumento Invalido",OffsetDateTime.now());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ed);
		
	}
	
	@ExceptionHandler(NullPointerException.class)
	public ResponseEntity<ExceptionPadrao> argumentoInexistente(){
		ExceptionPadrao ed = new ExceptionPadrao("Valor inexistente",OffsetDateTime.now());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ed);
		
	}
	
	@ExceptionHandler(ExceptionExist.class)
	public ResponseEntity<ExceptionPadrao> argumentoJaexistente(){
		ExceptionPadrao ed = new ExceptionPadrao("Valor Já existente",OffsetDateTime.now());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ed);
		
	}
	
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<ExceptionPadrao> argumentoNaoEncontrado(){
		ExceptionPadrao ed = new ExceptionPadrao("Valor não existe",OffsetDateTime.now());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ed);
		
	}
	
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<ExceptionPadrao> violacaointegridade(){
		ExceptionPadrao ed = new ExceptionPadrao("Dados invalidos ",OffsetDateTime.now());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ed);
		
	}
	
	@ExceptionHandler(SQLIntegrityConstraintViolationException.class)
	public ResponseEntity<ExceptionPadrao> violacaointegridadesql(){
		ExceptionPadrao ed = new ExceptionPadrao("Erro de gravacao no banco. dados errados",OffsetDateTime.now());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ed);
		
	}

}
