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

import com.projeto.Gerenciador.de.Gado.dto.DadosAtualizarLote;
import com.projeto.Gerenciador.de.Gado.dto.DadosCadastroLote;
import com.projeto.Gerenciador.de.Gado.dto.DadosDetalharLote;
import com.projeto.Gerenciador.de.Gado.dto.DadosListarFiltradorLote;
import com.projeto.Gerenciador.de.Gado.dto.DadosListarLote;
import com.projeto.Gerenciador.de.Gado.entity.Lote;
import com.projeto.Gerenciador.de.Gado.service.LoteService;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/lote")
public class LoteController {
	
	@Autowired
	private LoteService loteService;
	
	@PostMapping("/cadastrar")
	@Transactional
	public ResponseEntity<DadosDetalharLote> cadastrarLote(@RequestBody @Valid DadosCadastroLote dados, UriComponentsBuilder uriBuilder) {
		Lote lote = new Lote(dados);
		return loteService.cadastrarLote(lote, uriBuilder);
	}
	
	@PutMapping("/atualizar")
	@Transactional
	public ResponseEntity<DadosDetalharLote> atualizarLote(@RequestBody @Valid DadosAtualizarLote dados) {
		return loteService.atualizarLote(dados);
	}
	
	@DeleteMapping("/inativar/{id}")
	@Transactional
	public ResponseEntity<Void> inativarLote(@PathVariable Integer id) {
		return loteService.inativarLote(id);
	}
	
	@PutMapping("/reativar/{id}")
	@Transactional
	public ResponseEntity<Void> reativarLote(@PathVariable Integer id) {
		return loteService.reativarLote(id);
	}
	
	@GetMapping("/listar")
	public ResponseEntity<List<DadosListarLote>> listarLote() {
	    return loteService.listarLote();
	}
	
	@GetMapping("/listar/ativos")
	public ResponseEntity<List<DadosListarLote>> listarLoteAtivos() {
	    return loteService.listarLoteAtivos();
	}
	
	@GetMapping("/detalhar/{id}")
	public ResponseEntity<DadosDetalharLote> detalharLote(@PathVariable Integer id) {
	    return loteService.detalharLote(id);
	}
	
	@GetMapping("/listar/filtrador")
	public ResponseEntity<List<DadosListarLote>> listarFiltradorLote(@RequestBody @Valid DadosListarFiltradorLote dados) {
		Lote lote = new Lote(dados);
	    return loteService.listarFiltradorLote(lote);
	}
}
