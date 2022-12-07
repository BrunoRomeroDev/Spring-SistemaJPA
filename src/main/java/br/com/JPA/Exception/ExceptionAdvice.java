package br.com.JPA.Exception;

import java.time.OffsetDateTime;

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
		ExceptionPadrao ed = new ExceptionPadrao("Argumento Invalido",OffsetDateTime.now());
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
	

}
