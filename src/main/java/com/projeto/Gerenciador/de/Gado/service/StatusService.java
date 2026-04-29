package com.projeto.Gerenciador.de.Gado.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.projeto.Gerenciador.de.Gado.dto.DadosAtualizarStatus;
import com.projeto.Gerenciador.de.Gado.dto.DadosListarStatus;
import com.projeto.Gerenciador.de.Gado.entity.Animal;
import com.projeto.Gerenciador.de.Gado.entity.Lote;
import com.projeto.Gerenciador.de.Gado.entity.Status;
import com.projeto.Gerenciador.de.Gado.exception.RegraNegocioException;
import com.projeto.Gerenciador.de.Gado.repository.AnimalRepository;
import com.projeto.Gerenciador.de.Gado.repository.LoteRepository;
import com.projeto.Gerenciador.de.Gado.repository.StatusRepository;


@Service
public class StatusService {
	
	@Autowired
	public StatusRepository statusRepository;
	
	@Autowired
	private AnimalRepository animalRepository;
	
	@Autowired
	private LoteRepository loteRepository;
	
	public void cadastrarStatus(Status status) {
		List<Status> statuss = statusRepository.findAll();
		
		for (Status s : statuss) {
			if (s.getDescricao().equals(status.getDescricao())) {
				throw new RegraNegocioException("descricao", "'status' já existente.");
			}
		}
		
		statusRepository.save(status);
	}
	
	public void atualizarStatus(DadosAtualizarStatus dados) {
		Status status = statusRepository.getReferenceById(dados.id_status());
		List<Status> statuss = statusRepository.findAll();
		
		for (Status s : statuss) {
			if (s.getDescricao().equals(status.getDescricao())) {
				throw new RegraNegocioException("descricao", "'status' já existente.");
			}
		}
		
		status.AtualizarInformacoes(dados);
	}
	
	public void deletarStatus(Integer id) {
		List<Animal> animais = animalRepository.findAll();
		List<Lote> lotes = loteRepository.findAll();
		
		for (Animal a : animais) {
			if (a.getIdStatus().equals(id)) {
				throw new RegraNegocioException("id_status", "Existe 'id_animal' com esse 'id_status'.");
			}
		}
		
		for (Lote l : lotes) {
			if (l.getIdStatus().equals(id)) {
				throw new RegraNegocioException("id_status", "Existe 'id_lote' com esse 'id_status.");
			}
		}
		
		statusRepository.deleteById(id);
	}
	
	public ResponseEntity<List<DadosListarStatus>> listarStatus() {
	    List<Status> status = statusRepository.findAll();
	    List<DadosListarStatus> lista = new ArrayList<>();

	    for (Status s : status) {
	        DadosListarStatus dados = new DadosListarStatus(s);
	        lista.add(dados);
	    }

	    return ResponseEntity.ok(lista);
	}
}
