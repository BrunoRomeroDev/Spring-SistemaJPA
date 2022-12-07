package br.com.JPA.Exception;

import java.time.OffsetDateTime;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class ExceptionExist extends Exception {
	private static final long serialVersionUID = 1L;

	private String message;
	private OffsetDateTime offsetdatetime;

}
