package com.projeto.Gerenciador.de.Gado.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.projeto.Gerenciador.de.Gado.dto.DadosAtualizarAnimal;
import com.projeto.Gerenciador.de.Gado.dto.DadosCadastroAnimal;
import com.projeto.Gerenciador.de.Gado.dto.DadosDetalharAnimal;
import com.projeto.Gerenciador.de.Gado.dto.DadosIntervaloAnimal;
import com.projeto.Gerenciador.de.Gado.dto.DadosListarAnimal;
import com.projeto.Gerenciador.de.Gado.dto.DadosListarFiltradorAnimal;
import com.projeto.Gerenciador.de.Gado.entity.Animal;
import com.projeto.Gerenciador.de.Gado.service.AnimalService;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/animal")
public class AnimalController {

	@Autowired
	private AnimalService animalService;
	
	@PostMapping("/cadastrar")
	@Transactional
	public ResponseEntity<DadosDetalharAnimal> cadastrarAnimal(@RequestBody @Valid DadosCadastroAnimal dados, UriComponentsBuilder uriBuilder) {
		Animal animal = new Animal(dados);
		
		return animalService.cadastrarAnimal(animal, uriBuilder);
	}
	
	@PutMapping("/atualizar")
	@Transactional
	public ResponseEntity<DadosDetalharAnimal> atualizarAnimal(@RequestBody @Valid DadosAtualizarAnimal dados) {
		return animalService.atualizarAnimal(dados);
	}
	
	@DeleteMapping("/inativar/{id}")
	@Transactional
	public ResponseEntity<Void> inativarAnimal(@PathVariable Integer id) {
		return animalService.inativarAnimal(id);
	}
	
	@PutMapping("/reativar/{id}")
	@Transactional
	public ResponseEntity<Void> reativarAnimal(@PathVariable Integer id) {
		return animalService.reativarAnimal(id);
	}
	
	@GetMapping("/listar")
	public ResponseEntity<List<DadosListarAnimal>> listarAnimal() {
	    return animalService.listarAnimal();
	}
	
	@GetMapping("/listar/ativos")
	public ResponseEntity<List<DadosListarAnimal>> listarAnimalAtivos() {
	    return animalService.listarAnimalAtivos();
	}
	
	@GetMapping("/detalhar/{id}")
	public ResponseEntity<DadosDetalharAnimal> detalharAnimal(@PathVariable Integer id) {
	    return animalService.detalharAnimal(id);
	}
	
	@GetMapping("/listar/filtrador")
	public ResponseEntity<List<DadosListarAnimal>> listarFiltradorAnimal(@RequestBody @Valid DadosListarFiltradorAnimal dados) {
		Animal animal = new Animal(dados);
	    return animalService.listarFiltradorAnimal(animal);
	}
	
	@GetMapping("/listar/intervalo")
	public ResponseEntity<List<DadosListarAnimal>> listarIntervaloAnimal(@RequestBody @Valid DadosIntervaloAnimal dados) {
		Animal animal1 = new Animal(dados.inicio());
		Animal animal2 = new Animal(dados.fim());
	    return animalService.listarIntervaloAnimal(animal1, animal2);
	}
}
