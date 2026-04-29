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

import com.projeto.Gerenciador.de.Gado.dto.DadosAtualizarStatus;
import com.projeto.Gerenciador.de.Gado.dto.DadosCadastroStatus;
import com.projeto.Gerenciador.de.Gado.dto.DadosListarStatus;
import com.projeto.Gerenciador.de.Gado.entity.Status;
import com.projeto.Gerenciador.de.Gado.service.StatusService;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/status")
public class StatusController {
	
	@Autowired
	private StatusService statusService;
	
	@PostMapping("/cadastrar")
	@Transactional
	public void cadastrarStatus(@RequestBody @Valid DadosCadastroStatus dados) {
		Status status = new Status(dados);
		statusService.cadastrarStatus(status);
	}
	
	@PutMapping("/atualizar")
	@Transactional
	public void atualizarStatus(@RequestBody @Valid DadosAtualizarStatus dados) {
		statusService.atualizarStatus(dados);
	}
	
	@DeleteMapping("/deletar/{id}")
	@Transactional
	public void deletarStatus(@PathVariable Integer id) {
		statusService.deletarStatus(id);
	}
	
	@GetMapping("/listar")
	public ResponseEntity<List<DadosListarStatus>> listarStatus() {
	    return statusService.listarStatus();
	}
}
