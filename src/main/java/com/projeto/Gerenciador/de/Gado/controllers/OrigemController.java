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

import com.projeto.Gerenciador.de.Gado.dto.DadosAtualizarOrigem;
import com.projeto.Gerenciador.de.Gado.dto.DadosCadastroOrigem;
import com.projeto.Gerenciador.de.Gado.dto.DadosListarOrigem;
import com.projeto.Gerenciador.de.Gado.entity.Origem;
import com.projeto.Gerenciador.de.Gado.service.OrigemService;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/origem")
public class OrigemController {
	
	@Autowired
	private OrigemService origemService;
	
	@PostMapping("/cadastrar")
	@Transactional
	public void cadastrarOrigem(@RequestBody @Valid DadosCadastroOrigem dados) {
		Origem origem = new Origem(dados);
		origemService.cadastrarOrigem(origem);
	}
	
	@PutMapping("/atualizar")
	@Transactional
	public void atualizarOrigem(@RequestBody @Valid DadosAtualizarOrigem dados) {
		origemService.atualizarOrigem(dados);
	}
	
	@DeleteMapping("/deletar/{id}")
	@Transactional
	public void deletarOrigem(@PathVariable Integer id) {
		origemService.deletarOrigem(id);
	}
	
	@GetMapping("/listar")
	public ResponseEntity<List<DadosListarOrigem>> listarOrigem() {
	    return origemService.listarOrigem();
	}
}
