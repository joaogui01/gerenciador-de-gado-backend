package com.projeto.Gerenciador.de.Gado.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.projeto.Gerenciador.de.Gado.dto.DadosAtualizarRaca;
import com.projeto.Gerenciador.de.Gado.dto.DadosListarRaca;
import com.projeto.Gerenciador.de.Gado.entity.Animal;
import com.projeto.Gerenciador.de.Gado.entity.Raca;
import com.projeto.Gerenciador.de.Gado.exception.RegraNegocioException;
import com.projeto.Gerenciador.de.Gado.repository.AnimalRepository;
import com.projeto.Gerenciador.de.Gado.repository.RacaRepository;

@Service
public class RacaService {
	
	@Autowired
	private RacaRepository racaRepository;
	
	@Autowired
	private AnimalRepository animalRepository;
	
	public void cadastrarRaca(Raca raca) {
		List<Raca> racas = racaRepository.findAll();
		
		for (Raca r : racas) {
			if (r.getNome_raca().equals(raca.getNome_raca()) || r.getSigla().equals(raca.getSigla())) {
				throw new RegraNegocioException("id_raca", "'raca' já existente.");
			}
		}
		
		racaRepository.save(raca);
	}
	
	public void atualizarRaca(DadosAtualizarRaca dados) {
		Raca raca = racaRepository.getReferenceById(dados.id_raca());
		List<Raca> racas = racaRepository.findAll();
		
		for (Raca r : racas) {
			if (r.getNome_raca().equals(raca.getNome_raca()) || r.getSigla().equals(raca.getSigla())) {
				throw new RegraNegocioException("id_raca", "'raca' já existente.");
			}
		}
		raca.atualizarInformacoes(dados);
	}
	
	public void deletarRaca(Integer id) {
		List<Animal> animais = animalRepository.findAll();
		
		for (Animal a : animais) {
			if (a.getId_raca().equals(id)) {
				throw new RegraNegocioException("id_raca", "Existe 'id_animal' com esse 'id_raca'.");
			}
		}
		
		racaRepository.deleteById(id);
	}
	
	public ResponseEntity<List<DadosListarRaca>> listarRaca() {
	    List<Raca> raca = racaRepository.findAll();
	    List<DadosListarRaca> lista = new ArrayList<>();

	    for (Raca r : raca) {
	        DadosListarRaca dados = new DadosListarRaca(r);
	        lista.add(dados);
	    }

	    return ResponseEntity.ok(lista);
	}
}
