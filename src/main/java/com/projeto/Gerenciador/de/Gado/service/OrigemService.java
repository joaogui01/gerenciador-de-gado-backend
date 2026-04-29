package com.projeto.Gerenciador.de.Gado.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.projeto.Gerenciador.de.Gado.dto.DadosAtualizarOrigem;
import com.projeto.Gerenciador.de.Gado.dto.DadosListarOrigem;
import com.projeto.Gerenciador.de.Gado.entity.Animal;
import com.projeto.Gerenciador.de.Gado.entity.Origem;
import com.projeto.Gerenciador.de.Gado.exception.RegraNegocioException;
import com.projeto.Gerenciador.de.Gado.repository.AnimalRepository;
import com.projeto.Gerenciador.de.Gado.repository.OrigemRepository;

@Service
public class OrigemService {
	
	@Autowired
	private OrigemRepository origemRepository;
	
	@Autowired
	private AnimalRepository animalRepository;
	
	public void cadastrarOrigem(Origem origem) {
		List<Origem> origens = origemRepository.findAll();
		
		for (Origem o : origens) {
			if (o.getNome_origem().equals(origem.getNome_origem())) {
				throw new RegraNegocioException("nome_origem", "'nome_origem' já existente.");
			}
		}
		
		origemRepository.save(origem);
	}
	
	public void atualizarOrigem(DadosAtualizarOrigem dados) {
		Origem origem = origemRepository.getReferenceById(dados.id_origem());
		List<Origem> origens = origemRepository.findAll();
		
		for (Origem o : origens) {
			if (o.getNome_origem().equals(origem.getNome_origem())) {
				throw new RegraNegocioException("nome_origem", "'nome_origem' já existente.");
			}
		}
		
		origem.atualizarInfomacoes(dados);
	}
	
	public void deletarOrigem(Integer id) {
		List<Animal> animais = animalRepository.findAll();
		
		for (Animal a : animais) {
			if (a.getId_origem().equals(id)) {
				throw new RegraNegocioException("id_origem", "Existe 'id_animal' com esse 'id_origem'.");
			}
		}
		
		origemRepository.deleteById(id);
	}
	
	public ResponseEntity<List<DadosListarOrigem>> listarOrigem() {
	    List<Origem> origem = origemRepository.findAll();
	    List<DadosListarOrigem> lista = new ArrayList<>();

	    for (Origem o : origem) {
	        DadosListarOrigem dados = new DadosListarOrigem(o);
	        lista.add(dados);
	    }

	    return ResponseEntity.ok(lista);
	}
}
