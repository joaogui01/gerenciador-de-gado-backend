package com.projeto.Gerenciador.de.Gado.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import com.projeto.Gerenciador.de.Gado.dto.DadosAtualizarLote;
import com.projeto.Gerenciador.de.Gado.dto.DadosDetalharLote;
import com.projeto.Gerenciador.de.Gado.dto.DadosListarLote;
import com.projeto.Gerenciador.de.Gado.entity.Animal;
import com.projeto.Gerenciador.de.Gado.entity.Lote;
import com.projeto.Gerenciador.de.Gado.exception.RegraNegocioException;
import com.projeto.Gerenciador.de.Gado.repository.AnimalRepository;
import com.projeto.Gerenciador.de.Gado.repository.LoteRepository;

@Service
public class LoteService {
	
	@Autowired
	private AnimalRepository animalRepository;
	
	@Autowired
	private LoteRepository loteRepository;
	
	public ResponseEntity<DadosDetalharLote> cadastrarLote(Lote lote, UriComponentsBuilder uriBuilder) {
		List<Animal> animais = animalRepository.findAll();
		List<Lote> lotes = loteRepository.findAll();
		
		for (Animal a : animais) {
			if (lote.getData_criacao().isAfter(a.getData_entrada())) {
				throw new RegraNegocioException("data_criacao", "'data_criacao' não pode ser definida depois da 'data_entrada'.");
			}
		}
		
		for (Lote l : lotes) {
			if (
					l.getData_criacao().equals(lote.getData_criacao()) &&
					l.getIdStatus().equals(lote.getIdStatus()) &&
					l.getNome_lote().equals(lote.getNome_lote()) &&
					l.getObs_lote().equals(lote.getObs_lote())) {
				throw new RegraNegocioException("id_lote", "'lote' já existente.");
			}
		}
		
		loteRepository.save(lote);
		var uri = uriBuilder.path("/detalhar/{id}").buildAndExpand(lote.getId_lote()).toUri();
		
		return ResponseEntity.created(uri).body(new DadosDetalharLote(lote));
	}
	
	public ResponseEntity<DadosDetalharLote> atualizarLote(DadosAtualizarLote dados) {
		Lote lote = loteRepository.getReferenceById(dados.id_lote());
		List<Animal> animais = animalRepository.findAll();
		List<Lote> lotes = loteRepository.findAll();
		
		for (Animal a : animais) {
			if (lote.getData_criacao().isAfter(a.getData_entrada())) {
				throw new RegraNegocioException("data_criacao", "'data_criacao' não pode ser definida depois da 'data_entrada'.");
			}
		}
		
		for (Lote l : lotes) {
			if (
					l.getData_criacao().equals(lote.getData_criacao()) &&
					l.getIdStatus().equals(lote.getIdStatus()) &&
					l.getNome_lote().equals(lote.getNome_lote()) &&
					l.getObs_lote().equals(lote.getObs_lote())) {
				throw new RegraNegocioException("id_lote", "'lote' já existente.");
			}
		}
		
		lote.atualizarInformacoes(dados);
		
		return ResponseEntity.ok(new DadosDetalharLote(lote));
	}
	
	public ResponseEntity<Void> inativarLote(Integer id) {
		Lote lote = loteRepository.getReferenceById(id);
		lote.inativar();
		List<Animal> animais = animalRepository.findAll();
		
		for (Animal a : animais) {
			if (a.getId_lote().equals(lote.getId_lote())) {
				throw new RegraNegocioException("id_lote", "Existe 'id_animal' com esse 'id_lote'.");
			}
		}
		
		return ResponseEntity.noContent().build();
	}
	
	public ResponseEntity<Void> reativarLote(Integer id) {
		Lote lote = loteRepository.getReferenceById(id);
		lote.reativar();
		
		return ResponseEntity.ok(null);
	}
	
	public ResponseEntity<List<DadosListarLote>> listarLote() {
	    List<Lote> lote = loteRepository.findAll();
	    List<DadosListarLote> lista = new ArrayList<>();

	    for (Lote l : lote) {
	        DadosListarLote dados = new DadosListarLote(l);
	        lista.add(dados);
	    }

	    return ResponseEntity.ok(lista);
	}
	
	public ResponseEntity<List<DadosListarLote>> listarLoteAtivos() {
	    List<Lote> lote = loteRepository.findAllByIdStatus(1);
	    List<DadosListarLote> lista = new ArrayList<>();

	    for (Lote l : lote) {
	        DadosListarLote dados = new DadosListarLote(l);
	        lista.add(dados);
	    }

	    return ResponseEntity.ok(lista);
	}
	
	public ResponseEntity<DadosDetalharLote> detalharLote(Integer id) {
	    Lote lote = loteRepository.getReferenceById(id);
	    
	    return ResponseEntity.ok(new DadosDetalharLote(lote));
	}
	
	public ResponseEntity<List<DadosListarLote>> listarFiltradorLote(Lote lote) {
	    List<Lote> lotes = loteRepository.findAll();
	    List<DadosListarLote> lista = new ArrayList<>();

	    for (Lote l : lotes) {
	    	if (lote.getId_lote() != null) {
	    		if (!l.getId_lote().equals(lote.getId_lote())) {
	    			continue;
	    		}
	    	}
	    	
	    	if (lote.getNome_lote() != null) {
	    		if (!l.getNome_lote().equals(lote.getNome_lote())) {
	    			continue;
	    		}
	    	}
	    	
	    	if (lote.getData_criacao() != null) {
	    		if (!l.getData_criacao().equals(lote.getData_criacao())) {
	    			continue;
	    		}
	    	}
	    	
	    	if (lote.getObs_lote() != null) {
	    		if (!l.getObs_lote().equals(lote.getObs_lote())) {
	    			continue;
	    		}
	    	}
	    	
	    	if (lote.getIdStatus() != null) {
	    		if (!l.getIdStatus().equals(lote.getIdStatus())) {
	    			continue;
	    		}
	    	}
	    	
	        DadosListarLote dados = new DadosListarLote(l);
	        lista.add(dados);
	    }

	    return ResponseEntity.ok(lista);
	}
}
