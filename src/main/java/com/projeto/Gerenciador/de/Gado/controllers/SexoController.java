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

import com.projeto.Gerenciador.de.Gado.dto.DadosAtualizarSexo;
import com.projeto.Gerenciador.de.Gado.dto.DadosCadastroSexo;
import com.projeto.Gerenciador.de.Gado.dto.DadosListarSexo;
import com.projeto.Gerenciador.de.Gado.entity.Sexo;
import com.projeto.Gerenciador.de.Gado.service.SexoService;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/sexo")
public class SexoController {
	
	@Autowired
	private SexoService sexoService;
	
	@PostMapping("/cadastrar")
	@Transactional
	public void cadastrarSexo(@RequestBody @Valid DadosCadastroSexo dados) {
		Sexo sexo = new Sexo(dados);
		sexoService.cadastrarSexo(sexo);
	}
	
	@PutMapping("/atualizar")
	@Transactional
	public void atualizarSexo(@RequestBody @Valid DadosAtualizarSexo dados) {
		sexoService.atualizarSexo(dados);
	}
	
	@DeleteMapping("/deletar/{id}")
	@Transactional
	public void deletarSexo(@PathVariable Integer id) {
		sexoService.deletarSexo(id);
	}
	
	@GetMapping("/listar")
	public ResponseEntity<List<DadosListarSexo>> listarSexo() {
	    return sexoService.listarSexo();
	}
}
