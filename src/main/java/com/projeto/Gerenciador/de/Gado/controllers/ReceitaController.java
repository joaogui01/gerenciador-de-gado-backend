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
import org.springframework.web.util.UriComponentsBuilder;

import com.projeto.Gerenciador.de.Gado.dto.DadosAtualizarReceita;
import com.projeto.Gerenciador.de.Gado.dto.DadosCadastroReceita;
import com.projeto.Gerenciador.de.Gado.dto.DadosDetalharReceita;
import com.projeto.Gerenciador.de.Gado.dto.DadosIntervaloReceita;
import com.projeto.Gerenciador.de.Gado.dto.DadosListarFiltradorReceita;
import com.projeto.Gerenciador.de.Gado.dto.DadosListarReceita;
import com.projeto.Gerenciador.de.Gado.entity.Receita;
import com.projeto.Gerenciador.de.Gado.service.ReceitaService;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/receita")
public class ReceitaController {
	
	@Autowired
	private ReceitaService receitaService;
	
	@PostMapping("/cadastrar")
	@Transactional
	public ResponseEntity<DadosDetalharReceita> cadastrarReceita(@RequestBody @Valid DadosCadastroReceita dados, UriComponentsBuilder uriBuilder) {
		Receita receita = new Receita(dados);
		return receitaService.cadastrarReceita(receita, uriBuilder);
	}
	
	@PutMapping("/atualizar")
	@Transactional
	public ResponseEntity<DadosDetalharReceita> atualizarReceita(@RequestBody @Valid DadosAtualizarReceita dados) {
		return receitaService.atualizarReceita(dados);
	}
	
	@DeleteMapping("/deletar/{id}")
	@Transactional
	public ResponseEntity<Void> deletarReceita(@PathVariable Integer id) {
		return receitaService.deletarReceita(id);
	}
	
	@GetMapping("/listar")
	public ResponseEntity<List<DadosListarReceita>> listarReceita() {
	    return receitaService.listarReceita();
	}
	
	@GetMapping("/detalhar/{id}")
	public ResponseEntity<DadosDetalharReceita> detalharReceita(@PathVariable Integer id) {
	    return receitaService.detalharReceita(id);
	}
	
	@GetMapping("/listar/filtrador")
	public ResponseEntity<List<DadosListarReceita>> listarFiltradorReceita(@RequestBody @Valid DadosListarFiltradorReceita dados) {
		Receita receita = new Receita(dados);
	    return receitaService.listarFiltradorReceita(receita);
	}
	@GetMapping("/listar/intervalo")
	public ResponseEntity<List<DadosListarReceita>> listarIntervaloReceita(@RequestBody @Valid DadosIntervaloReceita dados) {
		Receita receita1 = new Receita(dados.inicio());
		Receita receita2 = new Receita(dados.fim());
	    return receitaService.listarIntervaloReceita(receita1, receita2);
	}
}
