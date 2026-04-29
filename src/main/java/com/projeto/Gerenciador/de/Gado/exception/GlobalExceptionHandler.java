package com.projeto.Gerenciador.de.Gado.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.persistence.EntityNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<?> exception404() {
		return ResponseEntity.notFound().build();
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> exception400(MethodArgumentNotValidException ex) {

	    List<DadosErros> erros = new ArrayList<>();

	    for (var erro : ex.getFieldErrors()) {
	        erros.add(new DadosErros(erro));
	    }

	    return ResponseEntity.badRequest().body(erros);
	}
	
	@ExceptionHandler(RegraNegocioException.class)
	public ResponseEntity<?> exception400(RegraNegocioException ex) {
		return ResponseEntity.badRequest().body(ex.getMessage());
	}
	
	public record DadosErros(String campo, String messagem) {
		public DadosErros(FieldError erro) {
			this(erro.getField(), erro.getDefaultMessage());
		}
	}
}
