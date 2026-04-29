package com.projeto.Gerenciador.de.Gado.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.Gerenciador.de.Gado.dto.DadosAtualizarRaca;
import com.projeto.Gerenciador.de.Gado.dto.DadosCadastroRaca;
import com.projeto.Gerenciador.de.Gado.dto.DadosListarRaca;
import com.projeto.Gerenciador.de.Gado.entity.Raca;
import com.projeto.Gerenciador.de.Gado.service.RacaService;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/raca")
public class RacaController {
	
	@Autowired
	private RacaService racaService;
	
	@PostMapping("/cadastrar")
	@Transactional
	public void cadastrarRaca(@RequestBody @Valid DadosCadastroRaca dados) {
		Raca raca = new Raca(dados);
		racaService.cadastrarRaca(raca);
	}
	
	@PutMapping("/atualizar")
	@Transactional
	public void atualizarRaca(@RequestBody @Valid DadosAtualizarRaca dados) {
		racaService.atualizarRaca(dados);
	}
	
	@DeleteMapping("/deletar/{id}")
	@Transactional
	public void deletarRaca(@PathVariable Integer id) {
		racaService.deletarRaca(id);
	}
	
	@GetMapping("/listar")
	public ResponseEntity<List<DadosListarRaca>> listarRaca() {
	    return racaService.listarRaca();
	}
}