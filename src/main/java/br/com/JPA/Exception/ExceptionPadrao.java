package br.com.JPA.Exception;

import java.time.OffsetDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
public class ExceptionPadrao {
	
	
		
		private String message;
		private OffsetDateTime data;
			
		
		}
