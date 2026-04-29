package com.projeto.Gerenciador.de.Gado.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import com.projeto.Gerenciador.de.Gado.dto.DadosAtualizarAnimal;
import com.projeto.Gerenciador.de.Gado.dto.DadosDetalharAnimal;
import com.projeto.Gerenciador.de.Gado.dto.DadosListarAnimal;
import com.projeto.Gerenciador.de.Gado.entity.Animal;
import com.projeto.Gerenciador.de.Gado.entity.Lote;
import com.projeto.Gerenciador.de.Gado.exception.RegraNegocioException;
import com.projeto.Gerenciador.de.Gado.repository.AnimalRepository;
import com.projeto.Gerenciador.de.Gado.repository.LoteRepository;

@Service
public class AnimalService {
	
	@Autowired
	private AnimalRepository animalRepository;
	
	@Autowired
	private LoteRepository loteRepository;

	public ResponseEntity<DadosDetalharAnimal> cadastrarAnimal(Animal animal, UriComponentsBuilder uriBuilder) {
		Lote lote = loteRepository.getReferenceById(animal.getId_lote());
		List<Animal> animais = animalRepository.findAll();
		
		if (animal.getData_nascimento().isAfter(animal.getData_entrada())) {
			throw new RegraNegocioException("data_entrada", "'data_nascimento' não pode ser definida antes da 'data_entrada'.");
		}
		
		if (lote.getData_criacao().isAfter(animal.getData_entrada())) {
			throw new RegraNegocioException("data_entrada", "'data_criacao' não pode ser definida antes da 'data_entrada'.");
		}
		
		for (Animal a : animais) {
			if (a.getBrinco().equals(animal.getBrinco()) && a.getId_lote().equals(animal.getId_lote())) {
				throw new RegraNegocioException("brinco","'brinco' já existente no Lote.");
			}
		}
		
		animalRepository.save(animal);
		var uri = uriBuilder.path("/animal/detalhar/{id}").buildAndExpand(animal.getId_animal()).toUri();
		
		return ResponseEntity.created(uri).body(new DadosDetalharAnimal(animal));
	}
	
	public ResponseEntity<DadosDetalharAnimal> atualizarAnimal(DadosAtualizarAnimal dados) {
		Animal animal = animalRepository.getReferenceById(dados.id_animal());
		Lote lote = loteRepository.getReferenceById(animal.getId_lote());
		List<Animal> animais = animalRepository.findAll();
		
		if (animal.getData_nascimento().isAfter(animal.getData_entrada())) {
			throw new RegraNegocioException("data_entrada", "'data_nascimento' não pode ser definida antes da 'data_entrada'.");
		}
		
		if (lote.getData_criacao().isAfter(animal.getData_entrada())) {
			throw new RegraNegocioException("data_entrada", "'data_criaca' não pode ser definida antes da 'data_entrada'.");
		}
		
		for (Animal a : animais) {
			if (a.getBrinco().equals(animal.getBrinco()) && a.getId_lote().equals(animal.getId_lote())) {
				throw new RegraNegocioException("brinco", "'brinco' já existente nesse 'id_lote'.");
			}
		}
		
		animal.atualizarInformacoes(dados);
		
		return ResponseEntity.ok(new DadosDetalharAnimal(animal));
	}
	
	public ResponseEntity<Void> inativarAnimal(Integer id) {
		Animal animal = animalRepository.getReferenceById(id);
		animal.inativar();
		
		return ResponseEntity.noContent().build();
	}
	
	public ResponseEntity<Void> reativarAnimal(Integer id) {
		Animal animal = animalRepository.getReferenceById(id);
		animal.reativar();
		
		return ResponseEntity.ok(null);
	}
	
	public ResponseEntity<List<DadosListarAnimal>> listarAnimal() {
	    List<Animal> animal = animalRepository.findAll();
	    List<DadosListarAnimal> lista = new ArrayList<>();

	    for (Animal a : animal) {
	        DadosListarAnimal dados = new DadosListarAnimal(a);
	        lista.add(dados);
	    }

	    return ResponseEntity.ok(lista);
	}
	
	public ResponseEntity<List<DadosListarAnimal>> listarAnimalAtivos() {
	    List<Animal> animal = animalRepository.findAllByIdStatus(1);
	    List<DadosListarAnimal> lista = new ArrayList<>();

	    for (Animal a : animal) {
	        DadosListarAnimal dados = new DadosListarAnimal(a);
	        lista.add(dados);
	    }

	    return ResponseEntity.ok(lista);
	}
	
	public ResponseEntity<DadosDetalharAnimal> detalharAnimal(Integer id) {
	    Animal animal = animalRepository.getReferenceById(id);
	    
	    return ResponseEntity.ok(new DadosDetalharAnimal(animal));
	}
	
	public ResponseEntity<List<DadosListarAnimal>> listarFiltradorAnimal(Animal animal) {
	    List<Animal> animais = animalRepository.findAll();
	    List<DadosListarAnimal> lista = new ArrayList<>();

	    for (Animal a : animais) {
	    	if (animal.getId_animal() != null) {
	    		if(!a.getId_animal().equals(animal.getId_animal())) {
	    			continue;
	    		}
	    	}
	    	
	    	if (animal.getBrinco() != null) {
	    		if(!a.getBrinco().equals(animal.getBrinco())) {
	    			continue;
	    		}
	    	}
	    	
	    	if (animal.getData_nascimento() != null) {
	    		if(!a.getData_nascimento().equals(animal.getData_nascimento())) {
	    			continue;
	    		}
	    	}
	    	
	    	if (animal.getId_sexo() != null) {
	    		if(!a.getId_sexo().equals(animal.getId_sexo())) {
	    			continue;
	    		}
	    	}
	    	
	    	if (animal.getId_raca() != null) {
	    		if(!a.getId_raca().equals(animal.getId_raca())) {
	    			continue;
	    		}
	    	}
	    	
	    	if (animal.getPeso_entrada() != null) {
	    		if(!a.getPeso_entrada().equals(animal.getPeso_entrada())) {
	    			continue;
	    		}
	    	}
	    	
	    	if (animal.getData_entrada() != null) {
	    		if(!a.getData_entrada().equals(animal.getData_entrada())) {
	    			continue;
	    		}
	    	}
	    	
	    	if (animal.getId_origem() != null) {
	    		if(!a.getId_origem().equals(animal.getId_origem())) {
	    			continue;
	    		}
	    	}
	    	
	    	if (animal.getValor_compra() != null) {
	    		if(!a.getValor_compra().equals(animal.getValor_compra())) {
	    			continue;
	    		}
	    	}
	    	
	    	if (animal.getIdStatus() != null) {
	    		if(!a.getIdStatus().equals(animal.getIdStatus())) {
	    			continue;
	    		}
	    	}
	    	
	    	if (animal.getPeso_atual() != null) {
	    		if(!a.getPeso_atual().equals(animal.getPeso_atual())) {
	    			continue;
	    		}
	    	}
	    	
	    	if (animal.getValor_atual() != null) {
	    		if(!a.getValor_atual().equals(animal.getValor_atual())) {
	    			continue;
	    		}
	    	}
	    	
	    	if (animal.getId_lote() != null) {
	    		if(!a.getId_lote().equals(animal.getId_lote())) {
	    			continue;
	    		}
	    	}
	    	
	    	DadosListarAnimal dados = new DadosListarAnimal(a);
	        lista.add(dados);
	    }

	    return ResponseEntity.ok(lista);
	}
	
	public ResponseEntity<List<DadosListarAnimal>> listarIntervaloAnimal(Animal animal1, Animal animal2) {
	    List<Animal> animais = animalRepository.findAll();
	    List<DadosListarAnimal> lista = new ArrayList<>();

	    for (Animal a : animais) {
	    	if (animal1.getData_nascimento() != null && animal2.getData_nascimento() != null) {
	    		if(animal1.getData_nascimento().isAfter(animal2.getData_nascimento())) {
	    			LocalDate troca = animal1.getData_nascimento();
	    			animal1.setData_nascimento(animal2.getData_nascimento());
	    			animal2.setData_nascimento(troca);
	    		}
	    		if(!a.getData_nascimento().isAfter(animal1.getData_nascimento())) {
	    			continue;
	    		}
	    		if(!a.getData_nascimento().isBefore(animal2.getData_nascimento())) {
	    			continue;
	    		}
	    	}
	    	
	    	if (animal1.getPeso_entrada() != null && animal2.getPeso_entrada() != null) {
	    		if(animal1.getPeso_entrada().compareTo(animal2.getPeso_entrada()) == 1) {
	    			BigDecimal troca = animal1.getPeso_entrada();
	    			animal1.setPeso_entrada(animal2.getPeso_entrada());
	    			animal2.setPeso_entrada(troca);
	    		}
	    		if(!(a.getPeso_entrada().compareTo(animal1.getPeso_entrada()) >= 0)) {
	    			continue;
	    		}
	    		if(!(a.getPeso_entrada().compareTo(animal2.getPeso_entrada()) <= 0)) {
	    			continue;
	    		}
	    	}
	    	
	    	if (animal1.getData_entrada() != null && animal2.getData_entrada() != null) {
	    		if(animal1.getData_entrada().isAfter(animal2.getData_entrada())) {
	    			LocalDate troca = animal1.getData_entrada();
	    			animal1.setData_entrada(animal2.getData_entrada());
	    			animal2.setData_entrada(troca);
	    		}
	    		if(!a.getData_entrada().isAfter(animal1.getData_entrada())) {
	    			continue;
	    		}
	    		if(!a.getData_entrada().isBefore(animal2.getData_entrada())) {
	    			continue;
	    		}
	    	}
	    	
	    	if (animal1.getValor_compra() != null && animal2.getValor_compra() != null) {
	    		if(animal1.getValor_compra().compareTo(animal2.getValor_compra()) == 1) {
	    			BigDecimal troca = animal1.getValor_compra();
	    			animal1.setValor_compra(animal2.getValor_compra());
	    			animal2.setValor_compra(troca);
	    		}
	    		if(!(a.getValor_compra().compareTo(animal1.getValor_compra()) >= 0)) {
	    			continue;
	    		}
	    		if(!(a.getValor_compra().compareTo(animal2.getValor_compra()) <= 0)) {
	    			continue;
	    		}
	    	}
	    	
	    	if (animal1.getIdStatus() != null && animal2.getIdStatus() != null) {
	    		if(!a.getIdStatus().equals(animal1.getIdStatus())) {
	    			continue;
	    		}
	    		if(!a.getIdStatus().equals(animal2.getIdStatus())) {
	    			continue;
	    		}
	    	}
	    	
	    	if (animal1.getPeso_atual() != null && animal2.getPeso_atual() != null) {
	    		if(animal1.getPeso_atual().compareTo(animal2.getPeso_atual()) == 1) {
	    			BigDecimal troca = animal1.getPeso_atual();
	    			animal1.setPeso_atual(animal2.getPeso_atual());
	    			animal2.setPeso_atual(troca);
	    		}
	    		if(!(a.getPeso_atual().compareTo(animal1.getPeso_atual()) >= 0)) {
	    			continue;
	    		}
	    		if(!(a.getPeso_atual().compareTo(animal2.getPeso_atual()) <= 0)) {
	    			continue;
	    		}
	    	}
	    	
	    	if (animal1.getValor_atual() != null && animal2.getValor_atual() != null) {
	    		if(animal1.getValor_atual().compareTo(animal2.getValor_atual()) == 1) {
	    			BigDecimal troca = animal1.getValor_atual();
	    			animal1.setValor_atual(animal2.getValor_atual());
	    			animal2.setValor_atual(troca);
	    		}
	    		if(!(a.getValor_atual().compareTo(animal1.getValor_atual()) >= 0)) {
	    			continue;
	    		}
	    		if(!(a.getValor_atual().compareTo(animal2.getValor_atual()) <= 0)) {
	    			continue;
	    		}
	    	}
	    	
	    	DadosListarAnimal dados = new DadosListarAnimal(a);
	        lista.add(dados);
	    }

	    return ResponseEntity.ok(lista);
	}
}
