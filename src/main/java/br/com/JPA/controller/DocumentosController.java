package br.com.JPA.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.JPA.entity.Documentos;
import br.com.JPA.repository.DocumentosRepository;

@RestController
public class DocumentosController {

	@Autowired
	private DocumentosRepository docrep;
	
	@GetMapping("/api/documentos")
	public List<Documentos> listardoc() {
		return docrep.findAll();
	}
	
}
