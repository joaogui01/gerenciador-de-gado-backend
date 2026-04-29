package com.projeto.Gerenciador.de.Gado.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import com.projeto.Gerenciador.de.Gado.dto.DadosAtualizarReceita;
import com.projeto.Gerenciador.de.Gado.dto.DadosDetalharReceita;
import com.projeto.Gerenciador.de.Gado.dto.DadosListarReceita;
import com.projeto.Gerenciador.de.Gado.entity.Animal;
import com.projeto.Gerenciador.de.Gado.entity.Receita;
import com.projeto.Gerenciador.de.Gado.exception.RegraNegocioException;
import com.projeto.Gerenciador.de.Gado.repository.AnimalRepository;
import com.projeto.Gerenciador.de.Gado.repository.ReceitaRepository;

@Service
public class ReceitaService {
	
	@Autowired
	private ReceitaRepository receitaRepository;
	
	@Autowired
	private AnimalRepository animalRepository;
	
	public ResponseEntity<DadosDetalharReceita> cadastrarReceita(Receita receita, UriComponentsBuilder uriBuilder) {
		Animal animal = animalRepository.getReferenceById(receita.getId_animal());
		
		if (animal.getData_nascimento().isAfter(receita.getData_receita())) {
			throw new RegraNegocioException("data_receita", "'data_nascimento' não pode ser definida depois da 'data_receita'.");
		}
		
		receitaRepository.save(receita);
		var uri = uriBuilder.path("/detalhar/{id}").buildAndExpand(receita.getId_receita()).toUri();
		
		return ResponseEntity.created(uri).body(new DadosDetalharReceita(receita));
	}
	
	public ResponseEntity<DadosDetalharReceita> atualizarReceita(DadosAtualizarReceita dados) {
		Receita receita = receitaRepository.getReferenceById(dados.id_receita());
		Animal animal = animalRepository.getReferenceById(receita.getId_animal());
		
		if (animal.getData_nascimento().isAfter(receita.getData_receita())) {
			throw new RegraNegocioException("data_receita", "'data_nascimento' não pode ser definida depois da 'data_receita'.");
		}
		
		receita.atualizarInformacoes(dados);
		
		return ResponseEntity.ok(new DadosDetalharReceita(receita));
	}
	

	public ResponseEntity<Void> deletarReceita(Integer id) {
		receitaRepository.deleteById(id);
		
		return ResponseEntity.noContent().build();
	}
	
	public ResponseEntity<List<DadosListarReceita>> listarReceita() {
	    List<Receita> receita = receitaRepository.findAll();
	    List<DadosListarReceita> lista = new ArrayList<>();

	    for (Receita r : receita) {
	        DadosListarReceita dados = new DadosListarReceita(r);
	        lista.add(dados);
	    }

	    return ResponseEntity.ok(lista);
	}
	
	public ResponseEntity<DadosDetalharReceita> detalharReceita(Integer id) {
	    Receita receita = receitaRepository.getReferenceById(id);
	    
	    return ResponseEntity.ok(new DadosDetalharReceita(receita));
	}
	
	public ResponseEntity<List<DadosListarReceita>> listarFiltradorReceita(Receita receita) {
	    List<Receita> receitas = receitaRepository.findAll();
	    List<DadosListarReceita> lista = new ArrayList<>();

	    for (Receita r : receitas) {
	    	if (receita.getId_receita() != null) {
	    		if (!r.getId_receita().equals(receita.getId_receita())) {
	    			continue;
	    		}
	    	}
	    	
	    	if (receita.getData_receita() != null) {
	    		if (!r.getData_receita().equals(receita.getData_receita())) {
	    			continue;
	    		}
	    	}
	    	
	    	if (receita.getId_tipo_receita() != null) {
	    		if (!r.getId_tipo_receita().equals(receita.getId_tipo_receita())) {
	    			continue;
	    		}
	    	}
	    	
	    	if (receita.getValor() != null) {
	    		if (!r.getValor().equals(receita.getValor())) {
	    			continue;
	    		}
	    	}
	    	
	    	if (receita.getId_animal() != null) {
	    		if (!r.getId_animal().equals(receita.getId_animal())) {
	    			continue;
	    		}
	    	}
	    	
	        DadosListarReceita dados = new DadosListarReceita(r);
	        lista.add(dados);
	    }

	    return ResponseEntity.ok(lista);
	}
	    
	public ResponseEntity<List<DadosListarReceita>> listarIntervaloReceita(Receita receita1, Receita receita2) {
		List<Receita> receitas = receitaRepository.findAll();
		List<DadosListarReceita> lista = new ArrayList<>();

		for (Receita r : receitas) {
			if (receita1.getData_receita() != null && receita1.getData_receita() != null) {
		    	if (receita1.getData_receita().isAfter(receita2.getData_receita())) {
		    		LocalDate troca = receita1.getData_receita();
		    		receita1.setData_receita(receita2.getData_receita());
		    		receita2.setData_receita(troca);
		    	}
		    	if (!r.getData_receita().isAfter(receita1.getData_receita())) {
		    		continue;
		    	}
		    	if (!r.getData_receita().isBefore(receita2.getData_receita())) {
		    		continue;
		    	}
		    }
		    if (receita1.getValor() != null && receita2.getValor() != null) {
		    	if (receita1.getValor().compareTo(receita2.getValor()) == 1) {
		    		BigDecimal troca = receita1.getValor();
		    		receita1.setValor(receita2.getValor());
		    		receita2.setValor(troca);
		    	}
		    	if (!(r.getValor().compareTo(receita1.getValor()) >= 0)) {
		    		continue;
		    	}
		    	if (!(r.getValor().compareTo(receita2.getValor()) <= 0)) {
		    		continue;
		    	}
		    }
		    	
		    DadosListarReceita dados = new DadosListarReceita(r);
		    lista.add(dados);
		}

	    return ResponseEntity.ok(lista);
	}
}
