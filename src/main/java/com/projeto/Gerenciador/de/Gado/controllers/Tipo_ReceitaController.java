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

import com.projeto.Gerenciador.de.Gado.dto.DadosAtualizarTipo_Receita;
import com.projeto.Gerenciador.de.Gado.dto.DadosCadastroTipo_Receita;
import com.projeto.Gerenciador.de.Gado.dto.DadosListarTipo_Receita;
import com.projeto.Gerenciador.de.Gado.entity.Tipo_Receita;
import com.projeto.Gerenciador.de.Gado.service.Tipo_ReceitaService;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/tipo_receita")
public class Tipo_ReceitaController {
	
	@Autowired
	private Tipo_ReceitaService tipo_ReceitaService;
	
	@PostMapping("/cadastrar")
	@Transactional
	public void cadastrarTipo_Receita(@RequestBody @Valid DadosCadastroTipo_Receita dados) {
		Tipo_Receita tipo_Receita = new Tipo_Receita(dados);
		tipo_ReceitaService.cadastrarTipo_Receita(tipo_Receita);
	}
	
	@PutMapping("/atualizar")
	@Transactional
	public void atualizarTipo_Receita(@RequestBody @Valid DadosAtualizarTipo_Receita dados) {
		tipo_ReceitaService.atualizarTipo_Receita(dados);
	}
	
	@DeleteMapping("/deletar/{id}")
	@Transactional
	public void deletarTipo_Receita(@PathVariable Integer id) {
		tipo_ReceitaService.deletarTipo_Receita(id);
	}
	
	@GetMapping("/listar")
	public ResponseEntity<List<DadosListarTipo_Receita>> listarTipo_Receita() {
	    return tipo_ReceitaService.listarTipo_Receita();
	}
}
